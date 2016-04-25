package com.netakey.materialdesign.model;

import com.netakey.materialdesign.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by POSEIDON on 9/4/2559.
 */
public class Place implements Serializable{

    private String title;
    private String description;
    private int imageId;

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    private void setImageId(int imageId) {
        this.imageId = imageId;
    }

    private Place set(String title,String description,int imageId){
        Place place = new Place();
        place.setTitle(title);
        place.setDescription(description);
        place.setImageId(imageId);
        return place;
    }

    public List<Place> setup(){
        List<Place> list = new ArrayList<>();

        String description = "Once you have a place_id or a reference from a Place Search, you can request more details about a particular establishment or point of interest by initiating a Place Details request. A Place Details request returns more comprehensive information about the indicated place such as its complete address, phone number, user rating and reviews." +
                "  Once you have a place_id or a reference from a Place Search, you can request more details about a particular establishment or point of interest by initiating a Place Details request. A Place Details request returns more comprehensive information about the indicated place such as its complete address, phone number, user rating and reviews." +
                "  Once you have a place_id or a reference from a Place Search, you can request more details about a particular establishment or point of interest by initiating a Place Details request. A Place Details request returns more comprehensive information about the indicated place such as its complete address, phone number, user rating and reviews.";

        list.add(set("Some place 1",description , R.drawable.place1));
        list.add(set("Some place 2",description, R.drawable.place2));
        list.add(set("Some place 3",description, R.drawable.place3));
        list.add(set("Some place 4",description, R.drawable.place4));
        list.add(set("Some place 5",description, R.drawable.place5));
        list.add(set("Some place 6",description, R.drawable.place6));
        list.add(set("Some place 7",description, R.drawable.place7));
        list.add(set("Some place 8",description, R.drawable.place8));
        list.add(set("Some place 9",description, R.drawable.place1));
        list.add(set("Some place 10",description, R.drawable.place2));
        list.add(set("Some place 11",description, R.drawable.place3));
        list.add(set("Some place 12",description, R.drawable.place4));
        list.add(set("Some place 13",description, R.drawable.place5));
        list.add(set("Some place 14",description, R.drawable.place6));
        list.add(set("Some place 15",description, R.drawable.place7));

        return list;
    }
}
