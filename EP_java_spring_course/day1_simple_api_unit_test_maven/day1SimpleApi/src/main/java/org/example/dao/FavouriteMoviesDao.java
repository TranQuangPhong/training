package org.example.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavouriteMoviesDao {
    Integer userId;
    Integer movieId;

    @Override
    public int hashCode() {
        return this.userId + this.movieId;
    }

    @Override
    public boolean equals(Object favouriteMovie) {
        return favouriteMovie != null
                && Objects.equals(this.userId, ((FavouriteMoviesDao) favouriteMovie).userId)
                && Objects.equals(this.movieId, ((FavouriteMoviesDao) favouriteMovie).movieId);
    }
}
