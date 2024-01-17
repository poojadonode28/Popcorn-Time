package com.jatin.popcornTime.models;

import com.jatin.popcornTime.enums.BookingStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Show show;
    private BookingStatus status;

    @OneToMany(mappedBy = "booking")
    List<ShowSeat> seatsBooked = new ArrayList<>();

    public Booking(Customer customer, Show show) {
        this.customer = customer;
        this.show = show;
        this.status = BookingStatus.PAYMENT_PENDING;
    }

    public Booking() {

    }
}
