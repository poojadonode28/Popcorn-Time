package com.jatin.popcornTime.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class City extends BaseModel{

    private String name;

    @OneToMany
    private List<Cinema> cinemas = new ArrayList<>();
}
