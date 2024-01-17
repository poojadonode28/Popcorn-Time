package com.jatin.popcornTime.repositories;

import com.jatin.popcornTime.models.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {

}
