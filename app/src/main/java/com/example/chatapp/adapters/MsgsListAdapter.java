package com.example.chatapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapp.R;
import com.example.chatapp.objects.Msg;

import java.util.List;

public class MsgsListAdapter  extends RecyclerView.Adapter<MsgsListAdapter.MsgViewHolder> {

    class MsgViewHolder extends RecyclerView.ViewHolder{
        private final TextView tvContent;

        private MsgViewHolder(View itemView){
            super(itemView);
            tvContent = itemView.findViewById(R.id.txt_sent_message);
        }
    }

    private final LayoutInflater mInflater;
    private List<Msg> msgs;

    public MsgsListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public MsgViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.sent_message, parent, false);
        return new MsgViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MsgViewHolder holder, int position){
        if(msgs!= null) {
            final Msg current = msgs.get(position);
            holder.tvContent.setText(current.getContent());
        }
    }

    @Override
    public int getItemCount() {
        if (msgs!=null){
            return msgs.size();
        }
        else return 0;
    }

    public List<Msg> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<Msg> msgs) {
        this.msgs = msgs;
        notifyDataSetChanged();
    }

}
