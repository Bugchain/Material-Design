package com.netakey.materialdesign.model;

import android.content.res.Resources;

import com.netakey.materialdesign.Contextor;
import com.netakey.materialdesign.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by POSEIDON on 15/3/2559.
 */
public class Contact implements Serializable{

    private String title;
    private String link;
    private int icon;

    private void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    private void setLink(String link){
        this.link = link;
    }
    public String getLink(){
        return link;
    }
    private void setIcon(int icon){
        this.icon = icon;
    }
    public int getIcon(){
        return icon;
    }

    private Contact set(String title,String link,int icon){
        Contact contact = new Contact();
        contact.setTitle(title);
        contact.setLink(link);
        contact.setIcon(icon);
        return contact;
    }

    public List<Contact> setup(){
        List<Contact> list = new ArrayList<>();
        Resources res = Contextor.getInstance().getContext().getResources();

        list.add(set(res.getString(R.string.email_address_title),res.getString(R.string.email_address_link),R.drawable.ic_social_media_email));
        list.add(set(res.getString(R.string.facebook_title),res.getString(R.string.facebook_link),R.drawable.ic_social_media_facebook));
        list.add(set(res.getString(R.string.google_plus_title),res.getString(R.string.google_plus_link),R.drawable.ic_social_media_g_plus));

        return list;
    }

}
