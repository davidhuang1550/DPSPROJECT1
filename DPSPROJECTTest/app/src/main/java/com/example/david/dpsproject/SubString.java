package com.example.david.dpsproject;

import java.util.ArrayList;

/**
 * Created by david on 2016-11-16.
 */
public class SubString {
    String SubName;
    ArrayList<String> posts;
    SubString(){
        posts= new ArrayList<String>();
    }
    SubString(ArrayList<String> p, String s){
        posts=p;
        SubName=s;
    }
    public ArrayList<String> getPosts() {
        return posts;
    }
    public void addPost(String P){
        posts.add(P);
    }
    public void setPosts(ArrayList<String> posts) {
        this.posts = posts;
    }
    public String getSubName() {
        return SubName;
    }

    public void setSubName(String subName) {
        SubName = subName;
    }

}
