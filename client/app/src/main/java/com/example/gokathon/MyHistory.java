package com.example.gokathon;

import android.graphics.Bitmap;

public class MyHistory {
    public String name;
    public String gender;
    public String age;
    public Bitmap image;

    MyHistory(String name, String gender, String age, Bitmap image){
        this.image = image;
        this.name =name;
        this.gender = gender;
        this.age = age;
    }
}