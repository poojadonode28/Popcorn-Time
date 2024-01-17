package com.jatin.popcornTime.services;

import com.jatin.popcornTime.models.ShowSeat;
import org.springframework.stereotype.Service;

@Service
public class ShowSeatService {

    public boolean isOccupied(ShowSeat showSeat) {
        return false;
    }

    public void save(ShowSeat showSeat) {
    }

}