package org.example.repository;


import org.example.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<MovieEntity, Integer> {
//    List<MovieEntity> findAll();

//    boolean likeMovie(Integer userId, Integer movieId);

//    boolean rateMovie(Integer userId, Integer movieId, Double rating);

//    boolean deleteFavouriteMovie(Integer userId, Integer movieId);
}
