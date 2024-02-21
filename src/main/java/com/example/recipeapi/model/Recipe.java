package com.example.recipeapi.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table
public class Recipe {
    private final static AtomicInteger idGenerator =
            new AtomicInteger(0);
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredient_id")
    private List<Ingredient> ingredientList;
    public Recipe(){id = idGenerator.incrementAndGet(); }

    public int getId() {return id; }
    public void setId(int id) { this.id = id; }
    public List<Ingredient> getIngredientList() { return ingredientList; }
    public void setIngredientList(List<Ingredient> ingredientList) { this.ingredientList = ingredientList; }
}
