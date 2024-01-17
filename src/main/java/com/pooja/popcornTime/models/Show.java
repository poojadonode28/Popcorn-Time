package com.jatin.popcornTime.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "SHOWS")
public class Show extends BaseModel{

    private Date startTime;
    private Date endTime;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private CinemaHall cinemaHall;
    private boolean cancelled;

    @OneToMany(mappedBy = "show")
    private List<Booking> bookings = new ArrayList<>();

    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeats = new ArrayList<>();

    public boolean isShowPending() {
        return !cancelled && endTime.after(new Date());
    }
}
