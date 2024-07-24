package com.example.part1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;


public class FIFOActivity extends AppCompatActivity {

    private EditText numFramesEditText;
    private EditText referenceEditText;
    private Button simulateButton;
    private TextView hitsTextView, go_to_content;
    private TextView faultsTextView;
    private TableLayout memoryTable;
    private int numFrames;
    private int hitCount;
    private int faultCount;
    private Queue<Integer> frameQueue;
    private LinkedList<Integer> memoryList;
    private ImageView imageView3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifoactivity);

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
                Intent intent = new Intent(FIFOActivity.this, FIFO_example.class);
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
                frameQueue = new LinkedList<>();
                memoryList = new LinkedList<>();
                memoryTable.removeAllViews();

                String[] references = referenceStr.split("\\s+");
                int delayMillis = 500;
                for (int i = 0; i < references.length; i++) {
                    String reference = references[i];
                    int page = Integer.parseInt(reference);
                    boolean hit = false;
                    if (memoryList.contains(page)) {
                        hit = true;
                        hitCount++;
                    } else {
                        faultCount++;

                        memoryList.add(page);
                        frameQueue.offer(page);

                        if (memoryList.size() > numFrames) {
                            int removedPage = frameQueue.poll();
                            memoryList.removeFirstOccurrence(removedPage);
                        }
                    }

                    final TableRow row = new TableRow(FIFOActivity.this);
                    TextView referenceTextView = new TextView(FIFOActivity.this);
                    referenceTextView.setText(reference);
                    referenceTextView.setPadding(16, 16, 16, 16);
                    row.addView(referenceTextView);

                    for (int j = 0; j < numFrames; j++) {
                        TextView frameTextView = new TextView(FIFOActivity.this);
                        int frame = j < memoryList.size() ? memoryList.get(j) : -1;
                        frameTextView.setText(String.valueOf(frame));
                        frameTextView.setPadding(16, 16, 16, 16);
                        frameTextView.setTextColor(Color.BLACK); // Set text color to black
                        int backgroundColor = hit && frame == page ? 0xff66ff66 : (!hit && frame == -1 ? 0xffcccccc : 0xffff6666);
                        frameTextView.setBackgroundColor(backgroundColor);
                        frameTextView.setTypeface(null, Typeface.BOLD); // Set text style to bold
                        row.addView(frameTextView);
                    }

                    memoryTable.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            memoryTable.addView(row);
                            memoryTable.setVisibility(View.VISIBLE);
                        }
                    }, i * delayMillis);
                }

                hitsTextView.setText("Hits: " + hitCount);
                faultsTextView.setText("Faults: " + faultCount);
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