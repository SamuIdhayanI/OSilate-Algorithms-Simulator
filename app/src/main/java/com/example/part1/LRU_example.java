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

public class LRU_example extends AppCompatActivity {
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


        AlgoNameTv.setText("LRU real-world scenario");
        ContentTv.setText("A real-world analogy of LRU (Least Recently Used) page replacement algorithm can be a house with limited storage space. The homeowner needs to store various items in the house, but there is not enough storage space to keep everything.\n" +
                "\n" +
                "The LRU algorithm can be used to manage the storage space and ensure that the most recently used items are kept in the house, while older, less frequently used items are removed to make room for new items.\n" +
                "\n" +
                "For example, if the homeowner needs to store seasonal clothing items such as winter coats, they will likely use them only during a specific time of the year. When the season ends, the coats will not be used frequently, and the homeowner may need to store them to make room for other items.\n" +
                "\n" +
                "In this scenario, the LRU algorithm can be used to identify which items have not been used recently and remove them from storage. The algorithm keeps track of when each item was last used and removes the least recently used item to make room for new items.\n" +
                "\n");
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