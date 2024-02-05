package edu.cibertec.proyecto.security;

import edu.cibertec.proyecto.entity.CapsulaUsuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class AuthProvider {
    @Value("${config.security.keySecret}")
    private String keySecret;

    public String createToken(CapsulaUsuario authUser) {
        Map<String, Object> claims = Jwts.claims().setSubject(authUser.getUsuario());
        claims.put("id", authUser.getIdusuario());
        claims.put("fullName", authUser.getNombre());
        claims.put("username", authUser.getUsuario());
        //claims.put("authorities", authUser.getRol());
        Date now = new Date();
        Date exp = new Date(now.getTime() + (1000 * 60 * 60 * 24 * 7));

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(authUser.getIdusuario().toString())
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS512, keySecret.getBytes())
                .compact();
    }

    public boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey(keySecret.getBytes()).parseClaimsJwt(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        try {
            return Jwts.parser().setSigningKey(keySecret.getBytes()).parseClaimsJwt(token)
                    .getBody()
                    .getSubject();
        } catch (Exception e) {
            return String.format("Bad token: %s", e.getMessage());
        }
    }
}
