package com.jatin.popcornTime.services;

import com.jatin.popcornTime.models.Movie;
import com.jatin.popcornTime.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> listMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> searchMovies(String movieName) {
        return movieRepository.findByName(movieName);
    }

}