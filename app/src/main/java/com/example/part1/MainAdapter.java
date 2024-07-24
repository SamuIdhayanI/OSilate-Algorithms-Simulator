package com.example.part1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    String data1[];
    int images[];
    Class[] pages = {FIFOActivity.class, OptiActivity.class, LRUActivity.class, MRUActivity.class, LFUActivity.class, MFUActivity.class, SecChanActivity.class, EnSecChanActivity.class};

    Context context;

    public MainAdapter(Context ct, String s1[], int img[]){
        context = ct;
        data1 = s1;
        images = img;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.main_page_row, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myText1.setText(data1[position]);
        holder.myImage.setImageResource(images[position]);
        holder.mainSellLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Class pageClass = pages[position];
                Intent intent = new Intent(context, pageClass);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("myImage", images[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView myText1, myText2;
        ImageView myImage;
        ConstraintLayout mainSellLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.items);
            myImage = itemView.findViewById(R.id.myImageView);
            mainSellLayout = itemView.findViewById(R.id.main_page_row);
        }
    }
}
