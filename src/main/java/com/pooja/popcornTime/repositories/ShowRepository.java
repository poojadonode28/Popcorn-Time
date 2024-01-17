package com.jatin.popcornTime.repositories;

import com.jatin.popcornTime.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long> {
}