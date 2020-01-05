package com.example.gokathon;

import android.graphics.Bitmap;

public class House {
    public String title;
    public String whattodo;
    public String cost;
    public Bitmap image;

    House(String title, String whattodo, String cost, Bitmap image){
        this.image = image;
        this.title =title;
        this.whattodo = whattodo;
        this.cost = cost;
    }
}