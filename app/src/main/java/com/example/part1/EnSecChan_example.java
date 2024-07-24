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

public class EnSecChan_example extends AppCompatActivity {
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


        AlgoNameTv.setText("Enhanced Second Chance real-world scenario: ");
        ContentTv.setText("Enhanced Second Chance page replacement algorithm is an improvement over the Second Chance algorithm that aims to reduce the number of page faults by giving priority to pages that are likely to be reused in the future. A real-world analogy for this algorithm can be a restaurant that has a limited number of tables and receives customers throughout the day. In this scenario, each table in the restaurant is like a frame in the memory, and each customer is like a page that enters the memory. The Enhanced Second Chance algorithm can be used to manage the tables and ensure that the most valuable customers are given priority for seating, while less valuable customers are kept waiting or turned away.\n" +
                "\n" +
                "For example, if a new customer arrives at the restaurant, and all the tables are occupied, the Enhanced Second Chance algorithm can be used to identify which customer is most likely to return in the future and give them priority for seating. The algorithm considers various factors such as the customer's past visits, the amount of money spent, and the time spent at the restaurant to determine their value to the business. In this way, the Enhanced Second Chance algorithm helps the restaurant to manage the tables efficiently and ensure that the most valuable customers are always given priority for seating, while less valuable customers are kept waiting or turned away. ");
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