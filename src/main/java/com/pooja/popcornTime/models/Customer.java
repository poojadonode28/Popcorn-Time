package com.jatin.popcornTime.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
public class Customer extends BaseModel {

    private String fullName;
    private String phone;
    private String city;
    private String email;

    @OneToMany(mappedBy = "customer")
    @Builder.Default
    private List<Booking> bookings = new ArrayList<>();

    @OneToOne
    private User user;

    public Customer() {

    }
}
