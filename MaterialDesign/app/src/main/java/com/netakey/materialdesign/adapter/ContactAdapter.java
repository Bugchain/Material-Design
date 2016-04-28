package com.netakey.materialdesign.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.netakey.materialdesign.R;
import com.netakey.materialdesign.model.Contact;

import java.util.List;

/**
 * Created by POSEIDON on 26/12/2558.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>{

    private List<Contact> list;

    public ContactAdapter(List<Contact> list){
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_item_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Contact item = list.get(position);
        holder.textTitle.setText(item.getTitle());
        holder.icon.setImageResource(item.getIcon());

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = holder.item.getContext();
                Intent intent;

                if(position == 0){
                    try {
                        intent = new Intent(Intent.ACTION_SEND);
                        intent.setData(Uri.parse("mailto:"));
                        intent.setType("plain/text");
                        context.startActivity(intent);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getLink()));
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textTitle;
        public ImageView icon;
        public ImageView item;

        public ViewHolder(View itemView) {
            super(itemView);
            textTitle = (TextView)itemView.findViewById(R.id.textTitle);
            icon = (ImageView)itemView.findViewById(R.id.icon);
            item = (ImageView)itemView.findViewById(R.id.item);
        }
    }
}
