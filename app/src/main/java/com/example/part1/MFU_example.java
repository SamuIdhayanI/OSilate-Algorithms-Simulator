package com.example.part1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Objects;

public class MFU_example extends AppCompatActivity {
    private TextView AlgoNameTv, ContentTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_analogy_page);
        AlgoNameTv = findViewById(R.id.AlgoNameTv);
        ContentTv = findViewById(R.id.ContentTv);
        AlgoNameTv.setText("MFU real-world scenario");
        ContentTv.setText("A real-world analogy of the MFU (Most Frequently Used) page replacement algorithm can be a library that manages a collection of books. The library has limited shelf space, and when new books are acquired, some of the older books may need to be removed to make room for the new ones.\n" +
                "\n" +
                "In this scenario, the MFU algorithm can be used to manage the shelf space and ensure that the most frequently borrowed books are kept on the shelves, while less frequently borrowed books are removed to make room for new ones. The algorithm keeps track of which books are borrowed most frequently and removes the least frequently borrowed books to make room for new ones.\n" +
                "\n" +
                "For example, if a particular book is borrowed more frequently than other books in the library, the MFU algorithm will ensure that the book is always available on the shelves. When the shelf space is running low, the library can remove the least frequently borrowed books to make room for more copies of the popular book.\n" +
                "In this way, the MFU algorithm helps the library to manage the shelf space efficiently and ensure that the most frequently borrowed books are always available to the patrons, while less frequently borrowed books are removed to make room for new ones.\n");
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.toolbar_color)));

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.appicon);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

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