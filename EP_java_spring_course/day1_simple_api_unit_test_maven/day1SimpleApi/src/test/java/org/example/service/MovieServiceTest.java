//package org.example.service;
//
//import org.example.dao.MovieDao;
//import org.example.dao.UserDao;
//import org.example.service.impl.MovieService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.StreamSupport;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class MovieServiceTest {
//
//    @InjectMocks //Auto-inject MovieRepository
//    MovieService movieService;// = mock(MovieService.class);
//    @Mock
//    MovieRepository movieRepository;
//
//    private static final List<UserDao> users = new ArrayList<>();
//    private static final List<MovieDao> movies = new ArrayList<>();
//
//    @Before
//    public void setupBeforeTest() {
//        users.add(new UserDao(1, "user 1"));
//        movies.add(new MovieDao(1, "movie 1"));
//
//        when(movieRepository.getMovies()).thenReturn((Iterable<MovieDao>) movies);
//
//        when(movieRepository.likeMovie(1, 1)).thenReturn(true);
//        when(movieRepository.likeMovie(1, 2)).thenReturn(false); //movie not exist
//
//        when(movieRepository.rateMovie(1, 1, 5.5)).thenReturn(true);
//        when(movieRepository.rateMovie(2, 1, 5.5)).thenReturn(false); //user not exist
//
//        when(movieRepository.deleteFavouriteMovie(1, 1)).thenReturn(true);
//        when(movieRepository.deleteFavouriteMovie(1, 2)).thenReturn(false);//movie not exist
//    }
//
//    @Test
//    public void test_getMovies_return_all_movies() {
//        List<?> movies = StreamSupport.stream(movieService.getMovies().spliterator(), false).collect(Collectors.toList());
//        assertEquals(1, movies.size());
//    }
//
//    @Test
//    public void test_likeMovie_valid_return_true() {
//        boolean isSuccess = movieService.likeMovie(1, 1);
//        assertTrue(isSuccess);
//    }
//
//    @Test
//    public void test_likeMovie_invalid_return_false() {
//        boolean isSuccess = movieService.likeMovie(1, 2);
//        assertFalse(isSuccess);
//    }
//
//    @Test
//    public void test_rateMovie_valid_return_true() {
//        boolean isSuccess = movieService.rateMovie(1, 1, 5.5);
//        assertTrue(isSuccess);
//    }
//
//    @Test
//    public void test_rateMovie_invalid_return_false() {
//        boolean isSuccess = movieService.rateMovie(2, 1, 5.5);
//        assertFalse(isSuccess);
//    }
//
//    @Test
//    public void test_deleteFavouriteMovie_invalid_return_false() {
//        boolean isSuccess = movieService.deleteFavouriteMovie(1, 1);
//        assertTrue(isSuccess);
//    }
//
//    @Test
//    public void test_deleteFavouriteMovie_valid_return_true() {
//        boolean isSuccess = movieService.deleteFavouriteMovie(1, 2);
//        assertFalse(isSuccess);
//    }
//
//}
