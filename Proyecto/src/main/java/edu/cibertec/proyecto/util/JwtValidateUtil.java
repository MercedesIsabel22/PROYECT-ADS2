package edu.cibertec.proyecto.util;

import edu.cibertec.proyecto.exceptions.ValidateServiceException;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JwtValidateUtil {
    @Value("${config.security.keySecret}")
    private String keySecret;

    public String getUsernameFromToken(String jwt) {
        try {
            return Jwts.parser().setSigningKey(keySecret.getBytes())
                    .parseClaimsJws(jwt)
                    .getBody().getSubject();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ValidateServiceException("Invalid Token");
        }
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(keySecret.getBytes()).parseClaimsJws(token);
            return true;
        } catch (UnsupportedJwtException e) {
            log.error("JWT in a particular format/configuration that does not match the format expected");
        } catch (MalformedJwtException e) {
            log.error("JWT was not correctly constructed and should be rejected");
        } catch (SignatureException e) {
            log.error("Signature or verifying an existing signature of a JWT failed");
        } catch (ExpiredJwtException e) {
            log.error("JWT was accepted after it expired and must be rejected");
        }
        return false;
    }
}
