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
public class Movie extends BaseModel{

    private String name;
    private Integer durationMinutes;

    @OneToMany(mappedBy = "movie")
    private List<Show> shows = new ArrayList<>();
}
