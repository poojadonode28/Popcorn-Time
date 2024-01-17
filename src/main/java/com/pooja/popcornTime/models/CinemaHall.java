package com.jatin.popcornTime.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class CinemaHall extends BaseModel{

    private String hallNumber;
    private Integer seatCount;

    @ManyToOne
    private Cinema cinema;

    @OneToMany(mappedBy = "cinemaHall")
    private List<HallSeat> hallSeats = new ArrayList<>();

    @OneToMany(mappedBy = "cinemaHall")
    private List<Show> shows = new ArrayList<>();
}
