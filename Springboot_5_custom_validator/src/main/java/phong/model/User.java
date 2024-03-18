package phong.model;

import lombok.Data;
import phong.annotation.ValidId;

@Data
public class User {
    @ValidId
    private String validId;
}
