package org.example.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserMovieRatingKey implements Serializable {
    @Column(name = "user_id")
    Long userId;

    @Column(name = "movie_id")
    Long movieId;
}
