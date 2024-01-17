package com.jatin.popcornTime.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class HallSeat extends BaseModel{

    private String seatLocation;
    private String seatType;
    private boolean isUnderMaintenance;

    @ManyToOne
    private CinemaHall cinemaHall;

    @OneToMany(mappedBy = "hallSeat")
    private List<ShowSeat> showSeats = new ArrayList<>();
}
