package edu.niu.cs.z1731074.chocolatedesserts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Assignment No: 2
 * File Name: Recipe.java
 * zid: z1731074
 * Created by Naga Praveen Kumar Pendyala on 3/2/2016.
 */

public class Recipe extends AppCompatActivity {

    // Data members
    private TextView dishTV, recipeTV;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        // connect to the screen
        dishTV = (TextView)findViewById(R.id.dishTextView);
        recipeTV = (TextView)findViewById(R.id.recipeTextView);

        // get the position of the dish from the intent
        id = getIntent().getIntExtra("dishNo",0);

        // set the dish name and recipe
        dishTV.setText(DishInfo.names[id]);
        recipeTV.setText(DishInfo.recipes[id]);
    }

    // finish this activity and go back to main activity
    public void goBack(View view)
    {
        finish();;
    }
}
