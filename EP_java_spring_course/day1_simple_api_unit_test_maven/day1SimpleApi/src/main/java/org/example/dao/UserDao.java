package org.example.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDao {
    Integer id;
    String name;

    public UserDao(Integer id) {
        
    }

    @Override
    public boolean equals(Object user) {
        return user != null && Objects.equals(this.id, ((UserDao) user).id);
    }
}
