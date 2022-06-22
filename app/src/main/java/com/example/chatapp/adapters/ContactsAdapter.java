package com.example.chatapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.chatapp.R;
import com.example.chatapp.room.Contact;

import java.util.List;

public class ContactsAdapter extends ArrayAdapter<Contact> {

    private LayoutInflater inflater;
    private Context context;
    private List<Contact> lst;

    public ContactsAdapter(Context context, List<Contact> lst) {
        super(context,R.layout.costume_list_item, lst);
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.lst=lst;
    }

    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent){
        Contact contact = getItem(position);
        if(convertView == null){
            convertView = inflater.inflate(R.layout.costume_list_item, parent, false);
        }

        TextView contactName = convertView.findViewById(R.id.contact_name);
        TextView lastMessage = convertView.findViewById(R.id.last_massage);
        TextView time = convertView.findViewById(R.id.time);

        contactName.setText(contact.getName());
        lastMessage.setText(contact.getLast());
        time.setText(contact.getLastDate());

        return convertView;

    }

//    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = inflater.inflate(R.layout.costume_list_item, parent, false);
//        MyViewHolder holder = new MyViewHolder(view);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(MyViewHolder holder, int position) {
//        if(lst != null){
//        holder.lstMsg.setText(lst.get(position).getLast());
//        holder.nameUsr.setText(lst.get(position).getUserName());
//        }
//    }

//    @Override
//    public int getItemCount() {
//        return lst.size();
//    }
//
//    class MyViewHolder extends RecyclerView.ViewHolder
//    {
//        private TextView nameUsr;
//        private TextView lstMsg;
//        // pic
//
//
//        public MyViewHolder(View itemView) {
//            super(itemView);
//            nameUsr = itemView.findViewById(R.id.contact_name);
//            lstMsg = itemView.findViewById(R.id.last_massage);
//        }
//    }
}