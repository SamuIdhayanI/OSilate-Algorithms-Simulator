package com.example.part1;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class SecChanActivity extends AppCompatActivity {

    private EditText numFramesEditText;
    private EditText referenceEditText;
    private Button simulateButton;
    private TextView hitsTextView;
    private TextView faultsTextView, go_to_content;
    private TableLayout memoryTable;
    private int numFrames;
    private int hitCount;
    private int faultCount;
    private LinkedList<Integer> memoryList;
    private Map<Integer, Boolean> secondChanceMap;
    private ImageView imageView3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_chan);

        numFramesEditText = findViewById(R.id.num_frames_edit_text);
        referenceEditText = findViewById(R.id.reference_edit_text);
        simulateButton = findViewById(R.id.simulate_button);
        hitsTextView = findViewById(R.id.hits_text_view);
        faultsTextView = findViewById(R.id.faults_text_view);
        memoryTable = findViewById(R.id.memory_table);
        go_to_content = findViewById(R.id.go_to_content);

        imageView3 = findViewById(R.id.imageView3);

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog();

            }
        });

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.appicon);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        go_to_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecChanActivity.this, SecChan_example.class);
                startActivity(intent);
            }
        });

        simulateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numFramesStr = numFramesEditText.getText().toString();
                String referenceStr = referenceEditText.getText().toString();
                if (numFramesStr.isEmpty() || referenceStr.isEmpty()) {
                    return;
                }
                numFrames = Integer.parseInt(numFramesStr);
                hitCount = 0;
                faultCount = 0;
                memoryList = new LinkedList<>();
                secondChanceMap = new HashMap<>();
                memoryTable.removeAllViews();

                String[] references = referenceStr.split("\\s+");
                int delayMillis = 500; // Delay between rows in milliseconds
                Handler handler = new Handler();
                for (int i = 0; i < references.length; i++) {
                    final int index = i;
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            String reference = references[index];
                            int page = Integer.parseInt(reference);
                            boolean hit = false;
                            if (memoryList.contains(page)) {
                                hit = true;
                                hitCount++;
                                secondChanceMap.put(page, true);
                            } else {
                                faultCount++;

                                if (memoryList.size() < numFrames) {
                                    memoryList.add(page);
                                } else {
                                    boolean replaced = false;
                                    while (!replaced) {
                                        int firstPage = memoryList.peekFirst();
                                        if (secondChanceMap.get(firstPage) != null && secondChanceMap.get(firstPage)) {
                                            secondChanceMap.put(firstPage, false);
                                            memoryList.removeFirst();
                                            memoryList.add(firstPage);
                                        } else {
                                            memoryList.pollFirst();
                                            memoryList.add(page);
                                            replaced = true;
                                        }
                                    }
                                }
                                secondChanceMap.put(page, false);
                            }

                            TableRow row = new TableRow(SecChanActivity.this);
                            TextView referenceTextView = new TextView(SecChanActivity.this);
                            referenceTextView.setText(reference);
                            referenceTextView.setPadding(16, 16, 16, 16);
                            row.addView(referenceTextView);

                            for (int i = 0; i < numFrames; i++) {
                                TextView frameTextView = new TextView(SecChanActivity.this);
                                int frame = i < memoryList.size() ? memoryList.get(i) : -1;
                                frameTextView.setText(String.valueOf(frame));
                                frameTextView.setPadding(16, 16, 16, 16);
                                frameTextView.setTextColor(Color.BLACK); // Set text color to black
                                int backgroundColor = hit && frame == page ? 0xff66ff66 : (!hit && frame == -1 ? 0xffcccccc : 0xffff6666);
                                frameTextView.setBackgroundColor(backgroundColor);
                                frameTextView.setTypeface(null, Typeface.BOLD); // Set text style to bold
                                row.addView(frameTextView);
                            }

                            memoryTable.addView(row);
                            memoryTable.setVisibility(View.VISIBLE);

                            hitsTextView.setText("Hits: " + hitCount);
                            faultsTextView.setText("Faults: " + faultCount);
                        }
                    }, i * delayMillis); // Delay each iteration by i * delayMillis milliseconds
                }
            }
        });

        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.toolbar_color)));


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu. other_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.help) {
            Intent intent = new Intent(this, HelpActivity.class);
            startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_sheet_layout);
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }
}