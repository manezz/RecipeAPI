package com.example.recipeapi.model;

import jakarta.persistence.*;

import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table
public class Ingredient {
    private final static AtomicInteger idGenerator =
            new AtomicInteger(0);
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private double amount;
    @Column(nullable = false)
    private MeasurementType measurementType;
    public Ingredient(){id = idGenerator.incrementAndGet(); }

    public int getId() {return id; }
    public void setId(int id) { this.id = id; }
    public Double getAmount() {return amount;}
    public void  setAmount(double amount) {this.amount = amount;}
    public MeasurementType getMeasurementType() {return measurementType;}
    public void setMeasurementType(MeasurementType measurementType) {this.measurementType = measurementType;}

    enum MeasurementType {
        g, mL
    }

}