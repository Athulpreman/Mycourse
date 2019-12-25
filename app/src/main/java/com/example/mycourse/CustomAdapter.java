package com.example.mycourse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    List<Add> myList;
    Context context;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final  Add add=myList.get(position);
        holder.t1.setText(add.getCt1());
        holder.t2.setText(add.getCd1());
        holder.t3.setText(add.getCdu1());
        holder.t4.setText(add.getCv1());
        holder.t5.setText(add.getCda1());


    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public CustomAdapter(List<Add> myList, Context context) {
        this.myList = myList;
        this.context = context;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder

    {

        TextView t1,t2,t3,t4,t5;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.id1);
            t2=itemView.findViewById(R.id.id2);
            t3=itemView.findViewById(R.id.id3);
            t4=itemView.findViewById(R.id.id4);
            t5=itemView.findViewById(R.id.id5);
        }
    }
}
