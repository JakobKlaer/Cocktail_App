package com.example.CocktailDB;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;


public class CocktailDB extends SQLiteOpenHelper {
    //information of database
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "cocktails.db";

    private ArrayList<Cocktail> allCocktails = null;

    //initialize the database
    public CocktailDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_base_alcohol = "CREATE TABLE BaseAlcohol (" +
                "id INTEGER PRIMARY KEY," +
                "name TEXT NOT NULL UNIQUE" +
        ")";

        String create_ingredients = "CREATE TABLE Ingredient (" +
                "id INTEGER PRIMARY KEY," +
                "name TEXT NOT NULL UNIQUE" +
        ")";

        String create_base_alcohol_and_cocktail = "CREATE TABLE BaseAlcoholAndCocktail (" +
                "idCocktail INTEGER," +
                "idBaseAlcohol INTEGER," +
                "PRIMARY KEY (idCocktail, idBaseAlcohol)" +
        ")";

        String create_ingredient_and_cocktail = "CREATE TABLE IngredientAndCocktail (" +
                "idCocktail INTEGER," +
                "idIngredient INTEGER," +
                "PRIMARY KEY (idCocktail, idIngredient)" +
        ")";

        String create_cocktails_alcohol = "CREATE TABLE Cocktail (" +
                "id INTEGER PRIMARY KEY," +
                "name TEXT NOT NULL UNIQUE," +
                "description TEXT NOT NULL," +
                "picturePath TEXT NOT NULL" +
        ")";

        db.execSQL(create_base_alcohol);
        db.execSQL(create_ingredients);
        db.execSQL(create_base_alcohol_and_cocktail);
        db.execSQL(create_ingredient_and_cocktail);
        db.execSQL(create_cocktails_alcohol);

        db.execSQL("INSERT INTO BaseAlcohol (id, name) VALUES (1, 'Vodka')");
        db.execSQL("INSERT INTO BaseAlcohol (id, name) VALUES (2, 'Rum')");
        db.execSQL("INSERT INTO Ingredient (id, name) VALUES (1, 'Zitrone')");
        db.execSQL("INSERT INTO Cocktail (id, name, description, picturePath) VALUES (1, 'Vodka Zitrone', 'Bester Cocktaile ever', '')");

        db.execSQL("INSERT INTO BaseAlcoholAndCocktail (idCocktail, idBaseAlcohol) VALUES (1, 1)");
        db.execSQL("INSERT INTO IngredientAndCocktail (idCocktail, idIngredient) VALUES (1, 1)");


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}

    public ArrayList<Cocktail> getCocktails() {
        if (allCocktails != null) {
            return allCocktails;
        }

        String query = "Select * FROM BaseAlcohol";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ArrayList<BaseAlcohol> baseAlcohols = new ArrayList<BaseAlcohol>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            baseAlcohols.add(new BaseAlcohol(id, name));
        }
        cursor.close();

        query = "Select * FROM Ingredient";
        cursor = db.rawQuery(query, null);
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            ingredients.add(new Ingredient(id, name));
        }
        cursor.close();

        query = "Select * FROM Cocktail";
        cursor = db.rawQuery(query, null);
        ArrayList<Cocktail> cocktails = new ArrayList<Cocktail>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String description = cursor.getString(2);
            String picturePath = cursor.getString(3);
            cocktails.add(new Cocktail(id, name, description, new ArrayList<BaseAlcohol>(), new ArrayList<Ingredient>(), picturePath));
        }
        cursor.close();

        query = "Select * FROM BaseAlcoholAndCocktail";
        cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int idCocktail = cursor.getInt(0);
            int idBaseAlcohol = cursor.getInt(1);
            cocktails.get(idCocktail - 1).addBaseAlcohol(baseAlcohols.get(idBaseAlcohol - 1));
        }
        cursor.close();

        query = "Select * FROM IngredientAndCocktail";
        cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int idCocktail = cursor.getInt(0);
            int idIngredient = cursor.getInt(1);
            cocktails.get(idCocktail - 1).addIngredient(ingredients.get(idIngredient - 1));
        }
        cursor.close();

        allCocktails = cocktails;
        return cocktails;
    }
}
