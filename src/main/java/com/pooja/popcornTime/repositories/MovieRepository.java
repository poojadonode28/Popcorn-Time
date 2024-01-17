package com.jatin.popcornTime.repositories;

import com.jatin.popcornTime.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByName(String movieName);
}
