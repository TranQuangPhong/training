package org.example.controller;

import org.example.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/movies")
public class MovieController {
    @Autowired
    IMovieService movieService;

    @GetMapping("/")
    public ResponseEntity<?> getMovies() {
        return ResponseEntity.ok().body(movieService.getMovies());
    }

//    @PutMapping("/{userId}/{movieId}/")
//    public ResponseEntity<?> likeMovie(@PathVariable Integer userId, @PathVariable Integer movieId) {
//
//        return ResponseEntity.ok().body(movieService.likeMovie(userId, movieId));
//    }
//
//    @PutMapping("/{userId}/{movieId}")
//    public ResponseEntity<?> rateMovie(@PathVariable Integer userId, @PathVariable Integer movieId, @RequestParam Double rating) {
//
//        return ResponseEntity.ok().body(movieService.rateMovie(userId, movieId, rating));
//    }
//
//    @DeleteMapping("/{userId}/{movieId}")
//    public ResponseEntity<?> deleteFavouriteMovie(@PathVariable Integer userId, @PathVariable Integer movieId) {
//
//        return ResponseEntity.ok().body(movieService.deleteFavouriteMovie(userId, movieId));
//    }

}
