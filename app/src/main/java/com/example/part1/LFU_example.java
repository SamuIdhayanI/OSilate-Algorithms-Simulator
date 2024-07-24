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

public class LFU_example extends AppCompatActivity {
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


        AlgoNameTv.setText("LFU real-world scenario");
        ContentTv.setText("A real-world analogy of LFU page replacement algorithm can be a library that keeps track of the popularity of its books. The library has a limited amount of shelf space, and when new books arrive, the library needs to make room by removing less popular books.\n" +
                "\n" +
                "The library can use an LFU algorithm to determine which books to remove. The algorithm keeps track of how many times each book has been borrowed. When the shelf space is full, the algorithm evicts the least frequently borrowed book to make room for the new arrivals.\n" +
                "\n" +
                "For example, if a popular new novel arrives at the library, the algorithm may evict a less popular book that has only been borrowed a few times to make room for it. The algorithm ensures that the most frequently borrowed books remain on the shelves, making it easier for patrons to find and borrow them.\n" +
                "\n" +
                "In this way, the LFU algorithm helps the library to manage its limited shelf space efficiently and ensure that the most popular books are always available to patrons.");
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