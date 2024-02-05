package edu.cibertec.proyecto.config;

import edu.cibertec.proyecto.security.RestAuthenticationEntryPoint;
import edu.cibertec.proyecto.security.TokenAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors ->
                        cors.configurationSource(request -> {
                            var c = new CorsConfiguration();
                            c.setAllowedOrigins(List.of("*"));
                            c.setAllowedMethods(List.of(HttpMethod.GET.name(),
                                    HttpMethod.POST.name(), HttpMethod.PUT.name(),
                                    HttpMethod.DELETE.name()));
                            c.setAllowedHeaders(List.of("*"));
                            return c;
                        })
                )
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authRequest ->
                        authRequest.requestMatchers("/auth/**")
                                .permitAll()
                                .anyRequest().authenticated()
                )
        //        .formLogin(Customizer.withDefaults())
        ;
        http.httpBasic(httpBasic -> httpBasic.authenticationEntryPoint(new RestAuthenticationEntryPoint()));
        http.addFilterBefore(createTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public TokenAuthenticationFilter createTokenAuthenticationFilter() {
        return new TokenAuthenticationFilter();
    }
}
