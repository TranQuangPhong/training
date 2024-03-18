//package org.example.repository;
//
//import org.example.dao.FavouriteMoviesDao;
//import org.example.dao.MovieDao;
//import org.example.dao.RatingDao;
//import org.example.dao.UserDao;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//import java.util.stream.StreamSupport;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class MovieRepositoryTest {
//
//    @Mock
//    MovieRepository movieRepository;
//
//    private static final List<UserDao> users = new ArrayList<>();
//    private static final List<MovieDao> movies = new ArrayList<>();
//    private static Set<FavouriteMoviesDao> favouriteMovies = new HashSet<>();
//    private static final Set<RatingDao> ratings = new HashSet<>();
//
//    @Before
//    public void setupBeforeTest() {
//        users.add(new UserDao(1, "user 1"));
//        movies.add(new MovieDao(1, "movie 1"));
//        favouriteMovies.add(new FavouriteMoviesDao(1, 1));
////        ratings.add(new RatingDao(1, 1, 1.0));
//
//        when(movieRepository.getMovies()).thenReturn((Iterable<MovieDao>) movies);
//
//        when(movieRepository.likeMovie(1, 1))
//                .then(invocationOnMock -> favouriteMovies.add(new FavouriteMoviesDao(1, 3)))
//                .thenReturn(true);
//        when(movieRepository.likeMovie(1, 2)).thenReturn(false); //movie not exist
//
//        when(movieRepository.rateMovie(1, 1, 5.5))
//                .then(invocationOnMock -> ratings.add(new RatingDao(1, 1, 5.5)))
//                .thenReturn(true);
//        when(movieRepository.rateMovie(2, 1, 5.5)).thenReturn(false); //user not exist
//
//        when(movieRepository.deleteFavouriteMovie(1, 1))
//                .then(invocationOnMock -> favouriteMovies.remove(new FavouriteMoviesDao(1, 1)))
//                .thenReturn(false);
//        when(movieRepository.deleteFavouriteMovie(1, 2)).thenReturn(false);//movie not exist
//    }
//
//    @Test
//    public void test_getMovies_return_all_movies() {
//        List<?> movies = StreamSupport.stream(movieRepository.getMovies().spliterator(), false).collect(Collectors.toList());
//        assertEquals(1, movies.size());
//    }
//
//    @Test
//    public void test_likeMovie_valid_return_true() {
//        boolean isSuccess = movieRepository.likeMovie(1, 1);
//        assertTrue(isSuccess);
//        assertEquals(favouriteMovies.size(), 2);
//    }
//
//    @Test
//    public void test_likeMovie_invalid_return_false() {
//        boolean isSuccess = movieRepository.likeMovie(1, 2);
//        assertFalse(isSuccess);
//
//    }
//
//    @Test
//    public void test_rateMovie_valid_return_true() {
//        boolean isSuccess = movieRepository.rateMovie(1, 1, 5.5);
//        assertTrue(isSuccess);
//        assertEquals(ratings.size(), 1);
//    }
//
//    @Test
//    public void test_rateMovie_invalid_return_false() {
//        boolean isSuccess = movieRepository.rateMovie(2, 1, 5.5);
//        assertFalse(isSuccess);
//    }
//
//    @Test
//    public void test_deleteFavouriteMovie_invalid_return_false() {
//        boolean isSuccess = movieRepository.deleteFavouriteMovie(1, 1);
//        assertTrue(isSuccess);
//        assertEquals(favouriteMovies.size(), 0);
//    }
//
//    @Test
//    public void test_deleteFavouriteMovie_valid_return_true() {
//        boolean isSuccess = movieRepository.deleteFavouriteMovie(1, 2);
//        assertFalse(isSuccess);
//    }
//}
