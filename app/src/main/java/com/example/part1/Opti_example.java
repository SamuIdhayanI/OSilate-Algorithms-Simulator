package com.example.part1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Objects;

public class Opti_example extends AppCompatActivity {
    private TextView AlgoNameTv, ContentTv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_analogy_page);
        AlgoNameTv = findViewById(R.id.AlgoNameTv);
        ContentTv = findViewById(R.id.ContentTv);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.appicon);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        AlgoNameTv.setText("Optimal real-world scenario");
        ContentTv.setText("A real-world analogy of optimal page replacement algorithm can be a restaurant manager who is responsible for managing the inventory of ingredients in the kitchen. The manager wants to ensure that there is enough of each ingredient to prepare the dishes that customers are likely to order, while also minimizing the waste of unused ingredients.\n" +
                "\n" +
                "The optimal page replacement algorithm can be used in this scenario to determine which ingredients to keep in stock. The algorithm predicts which dishes will be ordered based on historical data and the current menu. It then calculates the exact amount of each ingredient that will be needed to prepare those dishes and keeps only those ingredients in stock.\n" +
                "\n" +
                "For example, if the restaurant's menu includes a popular pasta dish that requires a specific type of sauce, the algorithm will ensure that there is enough of that sauce in stock to meet the expected demand for the dish. If a less popular dish requires a different sauce that is not expected to be ordered frequently, the algorithm may choose to keep only a small amount of that sauce in stock to minimize waste.");
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.toolbar_color)));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu. help_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}