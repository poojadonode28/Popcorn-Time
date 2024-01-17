package com.jatin.popcornTime.repositories;

import com.jatin.popcornTime.models.CinemaHall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository extends JpaRepository<CinemaHall, Long> {
}