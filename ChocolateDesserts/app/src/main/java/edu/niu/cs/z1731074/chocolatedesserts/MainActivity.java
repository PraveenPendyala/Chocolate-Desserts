package edu.niu.cs.z1731074.chocolatedesserts;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

/**
 * Assignment No: 2
 * File Name: MainActivity.java
 * zid: z1731074
 * Created by Naga Praveen Kumar Pendyala on 3/2/2016.
 */

public class MainActivity extends Activity {

    // Data Members
    private Spinner dishSpin;
    private ImageView dishImage;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect to the screen
        dishSpin = (Spinner)findViewById(R.id.dishSpinner);
        dishImage = (ImageView)findViewById(R.id.dishImageView);

        // Add dish names to the spinner
        ArrayAdapter<String> dishAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,DishInfo.names);

        dishSpin.setAdapter(dishAdapter);

        dishSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            // when a item is selected in the spinner change the image and save the array position
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    dishImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(),DishInfo.images[position],null));
                    pos = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    // pass the array position to the Recipe activity
    public void gotoRecipe(View view)
    {
        Intent recipeIntent = new Intent(MainActivity.this,Recipe.class);
        recipeIntent.putExtra("dishNo",pos);
        startActivity(recipeIntent);
    }
}
