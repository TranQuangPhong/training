package phong.auth.account;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtAuthenticationResponse {
    private String token;
    private String type = "Bearer";

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }
}
