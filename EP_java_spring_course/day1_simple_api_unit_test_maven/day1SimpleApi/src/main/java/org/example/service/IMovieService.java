package org.example.service;

import org.example.entity.MovieEntity;

import java.util.List;

public interface IMovieService {
    List<MovieEntity> getMovies();

//    boolean likeMovie(Integer userId, Integer movieId);
//
//    boolean rateMovie(Integer userId, Integer movieId, Double rating);
//
//    boolean deleteFavouriteMovie(Integer userId, Integer movieId);
}
