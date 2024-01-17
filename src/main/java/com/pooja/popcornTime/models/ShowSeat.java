package com.jatin.popcornTime.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{

    @ManyToOne
    private HallSeat hallSeat;

    @ManyToOne
    private Show show;

    @ManyToOne
    private Booking booking;

    private boolean occupied;
}
