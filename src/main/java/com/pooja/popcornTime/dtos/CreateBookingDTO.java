package com.jatin.popcornTime.dtos;

import com.jatin.popcornTime.models.Show;
import com.jatin.popcornTime.models.ShowSeat;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateBookingDTO {
    private Long customerId;
    private Show show;
    private List<ShowSeat> showSeats = new ArrayList<>();
}