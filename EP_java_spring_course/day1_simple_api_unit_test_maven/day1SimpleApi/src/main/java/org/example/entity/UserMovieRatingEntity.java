package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "user_movie_rating")
public class UserMovieRatingEntity {

    // Use composite key
//    @EmbeddedId
//    UserMovieRatingKey id;

//    @ManyToOne
//    @MapsId("userId")
//    @JoinColumn(name = "user_id")
//    UserEntity user;
//
//    @ManyToOne
//    @MapsId("movieId")
//    @JoinColumn(name = "movie_id")
//    MovieEntity movie;

    //Use dedicated ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    MovieEntity movie;

    Double rating;
}
