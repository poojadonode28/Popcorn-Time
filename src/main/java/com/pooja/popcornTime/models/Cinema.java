package com.jatin.popcornTime.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Cinema extends BaseModel{

    private String name;
    private String address;

    @OneToMany(mappedBy = "cinema")
    private List<CinemaHall> halls = new ArrayList<>();
}
