package phong.mongodb.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("user")
@Data
public class UserEntity {
    @Id
//    @Field("_id") //Wrong config - must be removed
    String id;

    @Field("first_name")
    @NotEmpty(message = "firstName can not be empty")
    String firstName;

    @Field("last_name")
    @NotEmpty(message = "firstName can not be empty")
    String lastName;

    @NotEmpty(message = "firstName can not be empty")
    String email;

    @NotEmpty(message = "firstName can not be empty")
    String gender;

    @Field("ip_address")
    String ipAddress;

    @NotNull(message = "age can not be null")
    Short age;
}
