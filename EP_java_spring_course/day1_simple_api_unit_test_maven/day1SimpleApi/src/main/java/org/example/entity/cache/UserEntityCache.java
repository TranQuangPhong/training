package org.example.entity.cache;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("users-movies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntityCache implements Serializable {

    private static final long serialVersionUID = -7817224776021728682L;

    Integer id;
    String name;
}
