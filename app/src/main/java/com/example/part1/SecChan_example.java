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

public class SecChan_example extends AppCompatActivity {
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


        AlgoNameTv.setText("Second Chance real-world scenario");
        ContentTv.setText("A real-world analogy of the Second Chance page replacement algorithm can be a parking lot with limited spaces where cars are continuously coming and going.\n" +
                "\n" +
                "In this scenario, each car that enters the parking lot is like a page that enters the memory, and each parking space is like a frame in the memory. The Second Chance algorithm can be used to manage the parking lot and ensure that the most recently used cars are kept in the lot, while older, less frequently used cars are removed to make room for new cars.\n" +
                "\n" +
                "For example, if a car enters the parking lot and all the parking spaces are full, the Second Chance algorithm can be used to identify which car has not been used recently and remove it from the lot to make space for the new car. However, before removing the car, the algorithm gives it a \"second chance\" by checking if it has been used recently. If the car has been used recently, it is given another chance to stay in the lot. In this way, the Second Chance algorithm helps to manage the parking lot efficiently and ensure that the most recently used cars are always available, while older, less frequently used cars are removed to make room for new ones. The algorithm is particularly useful in scenarios where the parking lot has limited spaces, and cars are continuously coming and going.");
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