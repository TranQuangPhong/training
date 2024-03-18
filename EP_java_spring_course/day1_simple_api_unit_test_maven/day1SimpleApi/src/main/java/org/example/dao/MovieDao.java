package org.example.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDao {
    Integer id;
    String name;

    public MovieDao(Integer id) {

    }

    @Override
    public boolean equals(Object movie) {
        return movie != null && Objects.equals(this.id, ((MovieDao) movie).id);
    }
}
