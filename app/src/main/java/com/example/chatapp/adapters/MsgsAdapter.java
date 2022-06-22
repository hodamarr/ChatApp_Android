package com.example.chatapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.chatapp.R;
import com.example.chatapp.room.Msg;

import java.util.List;

public class MsgsAdapter extends ArrayAdapter<Msg> {

    private LayoutInflater inflater;
    private Context context;
    private List<Msg> lst;

    public MsgsAdapter(Context context, List<Msg> lst) {
        super(context, R.layout.sent_message, lst);
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.lst = lst;
    }

    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        Msg message = getItem(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.sent_message, parent, false);
        }
        TextView content = convertView.findViewById(R.id.txt_sent_message);
        content.setText(message.getContent());
        return convertView;
    }
}