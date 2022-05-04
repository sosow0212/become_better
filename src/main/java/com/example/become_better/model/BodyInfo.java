package com.example.become_better.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BodyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnoreProperties({"bodyInfo"})
    @OneToOne
    private User user;

    private double height;
    private double weight;
    private double bmi;
}
