package com.example.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAddepter extends RecyclerView.Adapter<CustomAddepter.MyViewHolder> {
    private Context context;
    private ArrayList fname,lname,number;

    public CustomAddepter(Context context, ArrayList fname, ArrayList lname, ArrayList number) {
        this.context = context;
        this.fname = fname;
        this.lname = lname;
        this.number = number;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.singlerow,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.fname.setText(String.valueOf(position));
        holder.lname.setText(String.valueOf(position));
        holder.number.setText(String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return fname.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView fname,lname,number;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            fname = itemView.findViewById(R.id.txtfirstname);
            lname = itemView.findViewById(R.id.txtlastname);
            number = itemView.findViewById(R.id.txtnumber);
        }
    }
}
