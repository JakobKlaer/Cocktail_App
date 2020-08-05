package com.example.CocktailDB;

import java.util.ArrayList;

public class Cocktail {

    // fields
    private int id;
    private String name;
    private String description;
    private ArrayList<BaseAlcohol> baseAlcohols;
    private ArrayList<Ingredient> ingredients;
    private String picturePath;

    public Cocktail(int id, String name, String description, ArrayList<BaseAlcohol> baseAlcohols, ArrayList<Ingredient> ingredients, String picturePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.baseAlcohols = baseAlcohols;
        this.ingredients = ingredients;
        this.picturePath = picturePath;
    }

    public void addBaseAlcohol(BaseAlcohol baseAlcohol) {
        baseAlcohols.add(baseAlcohol);
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<BaseAlcohol> getBaseAlcohols() {
        return baseAlcohols;
    }

    public void setBaseAlcohols(ArrayList<BaseAlcohol> baseAlcohols) {
        this.baseAlcohols = baseAlcohols;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
}
