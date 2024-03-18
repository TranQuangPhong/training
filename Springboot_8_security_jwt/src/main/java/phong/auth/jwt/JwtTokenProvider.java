package phong.auth.jwt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import phong.auth.account.CustomUserDetails;

import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {

    private final String TOKEN_SECRET = "jwt token secret key";
//    private final long TOKEN_EXPIRE = 1000L;
    private final long TOKEN_EXPIRE = 604800000L;

    public String generateToken(CustomUserDetails userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + TOKEN_EXPIRE);
        String token = Jwts.builder()
                .setSubject(Long.toString(userDetails.getAccount().getId()))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, TOKEN_SECRET)
                .compact();
        return token;
    }

    public Long getAccountIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(TOKEN_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token");
            throw new MalformedJwtException(e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException e) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException e) {
            log.error("JWT claims is empty");
        } catch (SignatureException e) {
            log.error("Invalid JWT signature -> Message: {} ", e);
        } catch (Exception e) {
            log.error("Unknown error. Failed to validate jwt token");
        }
        return false;
    }
}
