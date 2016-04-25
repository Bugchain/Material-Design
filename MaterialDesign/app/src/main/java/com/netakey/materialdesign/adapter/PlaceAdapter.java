package com.netakey.materialdesign.adapter;


import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.netakey.materialdesign.R;
import com.netakey.materialdesign.activity.PlaceDetailActivity;
import com.netakey.materialdesign.model.Place;
import com.netakey.materialdesign.tools.Const;
import com.netakey.materialdesign.tools.Utils;

import java.util.List;


/**
 * Created by POSEIDON on 8/4/2559.
 */
public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder>{

    private List<Place> list;

    public PlaceAdapter(List<Place> list){
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.place_item_view_holder,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Place place = list.get(position);
        holder.icon.setImageResource(place.getImageId());
        holder.textTitle.setText(place.getTitle());
        holder.textDescription.setText(place.getDescription());
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(holder.item.getContext(),PlaceDetailActivity.class);
                intent.putExtra(Const.EXTRA_OBJECT,place);

                if(Utils.isAndroidVersionAboveLollipop()){
                    ActivityOptionsCompat option = ActivityOptionsCompat.makeSceneTransitionAnimation(
                            ((Activity)holder.icon.getContext()),
                            holder.icon,
                            Const.SHARE_ELEMENT
                    );
                    ActivityCompat.startActivity((Activity) holder.icon.getContext(), intent, option.toBundle());
                }else {
                    holder.item.getContext().startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView icon;
        public TextView textTitle;
        public ImageView item;
        public TextView textDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView)itemView.findViewById(R.id.image);
            textTitle = (TextView)itemView.findViewById(R.id.textTitle);
            item = (ImageView)itemView.findViewById(R.id.item);
            textDescription = (TextView)itemView.findViewById(R.id.textDescription);
        }
    }
}
