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

public class ContactsListAdapter extends RecyclerView.Adapter<ContactsListAdapter.ContactViewHolder> {

    class ContactViewHolder extends RecyclerView.ViewHolder{
        private final TextView tvContactName;
        private final TextView tvLastMessage;
        private final TextView tvTime;

        private ContactViewHolder(View itemView){
            super(itemView);
            tvContactName = itemView.findViewById(R.id.contact_name);
            tvLastMessage = itemView.findViewById(R.id.last_massage);
            tvTime = itemView.findViewById(R.id.time);
        }
    }

    private final LayoutInflater mInflater;
    private List<Contact> contacts;
    private ItemClickListener mItemListener;

    public ContactsListAdapter(Context context, ItemClickListener itemClickListener) {
        mInflater = LayoutInflater.from(context);
        this.mItemListener = itemClickListener;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.costume_list_item, parent, false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position){
        if(contacts!= null) {
            final Contact current = contacts.get(position);
            holder.tvContactName.setText(current.getName());
            holder.tvLastMessage.setText(current.getLast());
            holder.tvTime.setText(current.getLastDate());

            holder.itemView.setOnClickListener(view -> {
                mItemListener.onItemClick(contacts.get(position));
            });
        }
    }

    @Override
    public int getItemCount() {
        if (contacts!=null){
            return contacts.size();
        }
        else return 0;
    }

    public interface ItemClickListener{
        void onItemClick(Contact contact);
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }



}
