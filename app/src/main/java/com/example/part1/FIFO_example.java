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

public class FIFO_example extends AppCompatActivity {
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


        AlgoNameTv.setText("FIFO real-world scenario");
        ContentTv.setText("A real-world analogy of FIFO (First-In-First-Out) page replacement algorithm can be a queue at a ticket counter, where customers line up in order of their arrival time. The ticket counter has a limited capacity, and when it reaches its limit, new customers cannot join the queue until some of the existing customers have been served and left the queue.\n" +
                "\n" +
                "In this scenario, the FIFO algorithm can be used to manage the queue and ensure that customers are served in the order of their arrival time. As new customers arrive, they are added to the end of the queue, and when the ticket counter is ready to serve a customer, the first customer in the queue is served and removed from the queue.\n" +
                "\n" +
                "For example, if the queue has a capacity of 10 customers and there are already 10 customers waiting in the queue, a new customer will have to wait until one of the existing customers has been served and left the queue before they can join the queue.");
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