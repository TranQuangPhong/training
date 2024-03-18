package org.example.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingDao {
    Integer userId;
    Integer movieId;
    Double rating;

    public RatingDao rate(double rating) {
        this.rating = rating;
        return this;
    }

    @Override
    public int hashCode() {
        return this.userId + this.movieId;
    }

    @Override
    public boolean equals(Object ratingDao) {
        return ratingDao != null
                && Objects.equals(this.userId, ((RatingDao) ratingDao).userId)
                && Objects.equals(this.movieId, ((RatingDao) ratingDao).movieId);
    }
}
