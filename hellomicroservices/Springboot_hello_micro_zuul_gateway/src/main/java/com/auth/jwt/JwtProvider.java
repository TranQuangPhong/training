package com.auth.jwt;

import com.auth.model.CustomUserDetails;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@PropertySource("classpath:others.properties")
@Slf4j
public class JwtProvider {

    @Value("${jwt.secret}")
    private String jwtSecretKey;

    @Value("${jwt.expiration}")
    private Long jwtExpiration;

    public String generateJwt(CustomUserDetails userDetails) {

        Date now = new Date();
        Date expireDate = new Date(now.getTime() + jwtExpiration);

        return Jwts.builder()
                .setExpiration(expireDate)
                .setIssuedAt(now)
                .setSubject(userDetails.getUsername())
                .signWith(SignatureAlgorithm.HS512, jwtSecretKey)
                .compact();
    }

    public boolean validateJwt(String jwt) {
        try {
            Jwts.parser()
                    .setSigningKey(jwtSecretKey)
                    .parseClaimsJws(jwt);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        } catch (SignatureException ex) {
            log.error("JWT signature validation failed.");
        }
        return false;

    }

    public String getUsernameFromJwt(String jwt) {

        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecretKey)
                .parseClaimsJws(jwt)
                .getBody();
        return claims.getSubject();
    }
}
