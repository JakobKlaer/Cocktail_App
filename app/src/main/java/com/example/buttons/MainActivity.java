package com.example.buttons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.CocktailDB.BaseAlcohol;
import com.example.CocktailDB.Cocktail;
import com.example.CocktailDB.CocktailDB;

import android.content.Context;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    private Button button1;
    private Button button2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inactivity1 = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(inactivity1);

//                CocktailDB db = new CocktailDB(getApplicationContext());
//                ArrayList<Cocktail> myCocktails = db.getCocktails();
//
//                System.out.println(myCocktails.get(0).getName());
//                System.out.println(myCocktails.get(0).getIngredients().get(0).getName());
//
//
//                String a = "Vodka";
//                ArrayList<Cocktail> ergebnisse = new ArrayList();
//                for (int i = 0; i < myCocktails.size(); i++) {
//                    Cocktail cocktail = myCocktails.get(i);
//
//                    for (int j = 0; j < cocktail.getBaseAlcohols().size(); j++) {
//                        BaseAlcohol baseAlcohol = cocktail.getBaseAlcohols().get(j);
//
//                        if (baseAlcohol.getName() == a) {
//                            ergebnisse.add(myCocktails.get(i));
//                        }
//                    }
//                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inactivity2 = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(inactivity2);

            }
        });










    }
}


    // Ereignislistener-Klasse mit Behandlungscode

