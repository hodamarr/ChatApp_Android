package com.example.chatapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapp.R;
import com.example.chatapp.room.Contact;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    private LayoutInflater inflater;
    private Context context;
    private List<Contact> lst;

    public CustomAdapter(Context context, List<Contact> lst) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.lst=lst;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.costume_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if(lst != null){
        holder.lstMsg.setText(lst.get(position).getLast());
        holder.nameUsr.setText(lst.get(position).getUserName());
        }
    }

    @Override
    public int getItemCount() {
        return lst.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView nameUsr;
        private TextView lstMsg;
        // pic


        public MyViewHolder(View itemView) {
            super(itemView);
            nameUsr = itemView.findViewById(R.id.contact_name);
            lstMsg = itemView.findViewById(R.id.last_massage);
        }
    }
}