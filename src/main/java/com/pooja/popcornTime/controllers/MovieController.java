package com.jatin.popcornTime.controllers;

import com.jatin.popcornTime.models.Movie;
import com.jatin.popcornTime.services.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public List<Movie> requestMethodName() {
        return movieService.listMovies();
    }

    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    public List<Movie> requestMethodName(@RequestParam(value = "movieName", required = true) String movieName) {
        return movieService.searchMovies(movieName);
    }

}
