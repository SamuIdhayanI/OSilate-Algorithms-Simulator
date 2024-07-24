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

public class MRU_example extends AppCompatActivity {
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


        AlgoNameTv.setText("MRU real-world scenario");
        ContentTv.setText("A real-world analogy of MRU (Most Recently Used) page replacement algorithm can be a vending machine that dispenses different products. The vending machine has a limited number of slots, and when it is out of a particular product, the machine needs to refill the slot with a new product.\n" +
                "\n" +
                "In this scenario, the MRU algorithm can be used to manage the product slots and ensure that the most recently sold products are given priority for refilling. The algorithm keeps track of which products were sold most recently and refills the slot with the most recently sold product first.\n" +
                "\n" +
                "For example, if the vending machine runs out of a popular snack such as potato chips, the MRU algorithm will refill the slot with potato chips first, even if other slots are empty or have less frequently sold products.\n" +
                "\n" +
                "In this way, the MRU algorithm helps the vending machine to manage the product slots efficiently and ensure that the most popular products are always available to customers, while less popular products are given a lower priority.");
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