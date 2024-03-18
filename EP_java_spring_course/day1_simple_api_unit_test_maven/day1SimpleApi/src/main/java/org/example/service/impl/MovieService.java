package org.example.service.impl;

import org.example.entity.MovieEntity;
import org.example.repository.IMovieRepository;
import org.example.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {
    @Autowired
    IMovieRepository movieRepository;

    @Override
    public List<MovieEntity> getMovies() {
        return movieRepository.findAll();
    }

//    @Override
//    public boolean likeMovie(Integer userId, Integer movieId) {
//        return movieRepository.likeMovie(userId, movieId);
//    }
//
//    @Override
//    public boolean rateMovie(Integer userId, Integer movieId, Double rating) {
//        return movieRepository.rateMovie(userId, movieId, rating);
//    }
//
//    @Override
//    public boolean deleteFavouriteMovie(Integer userId, Integer movieId) {
//        return movieRepository.deleteFavouriteMovie(userId, movieId);
//    }

}
