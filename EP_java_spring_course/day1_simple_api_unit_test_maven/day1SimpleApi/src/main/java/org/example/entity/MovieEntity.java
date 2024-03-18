package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Integer id;

    @Column
    String name;

    @ManyToMany(mappedBy = "likedMovies")
    Set<UserEntity> likedUsers;

    @OneToMany(mappedBy = "movie")
    Set<UserMovieRatingEntity> ratings;
}
