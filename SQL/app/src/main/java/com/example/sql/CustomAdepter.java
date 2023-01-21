package com.example.sql;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdepter extends RecyclerView.Adapter<CustomAdepter.MyViewHolder> {
    private Context context;
    private ArrayList fname, lname, email, number;
    CustomAdepter(Context context, ArrayList fname, ArrayList lname, ArrayList email, ArrayList number){
        this.context = context;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.number = number;
    }
    @NonNull
    @Override
    public CustomAdepter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdepter.MyViewHolder holder, int position) {
        holder.fname.setText(String.valueOf(fname.get(position)));
        holder.lname.setText(String.valueOf(lname.get(position)));
        holder.email.setText(String.valueOf(email.get(position)));
        holder.number.setText(String.valueOf(number.get(position)));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView fname, lname, email, number;
         public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            fname = itemView.findViewById(R.id.fname);
            lname = itemView.findViewById(R.id.lname);
            email = itemView.findViewById(R.id.email);
            number = itemView.findViewById(R.id.number);
        }
    }
}
