package com.example.gokathon;


import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ReviewActivity extends AppCompatActivity {
    private ListView listView;
    ArrayList<History> history_list;
    HistoryAdapter myadapter;
    History my1, my2, my3;
    int unicode = 0x1F9E6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        listView = (ListView)findViewById(R.id.listView);
        my1 = new History("청소싫다", "★★★★★", "진짜 너무 꺠끗히 하고 가셨어요 ㅠㅠ감사해요", BitmapFactory.decodeResource(getResources(), R.drawable.gollum1));
        my2 = new History("니키 미나즈", "★★★★", "빠르게 하고 가셨네요 감사합니", BitmapFactory.decodeResource(getResources(), R.drawable.nickiminaj));
        my3 = new History("춘자의 아들", "★★★★★", "잘생기시고 청소까지 잘", BitmapFactory.decodeResource(getResources(), R.drawable.gollum3));
        history_list = new ArrayList<History>();
        history_list.add(my1);
        history_list.add(my2);
        history_list.add(my3);
        history_list.add(my1);
        history_list.add(my2);
        history_list.add(my3);
        history_list.add(my1);
        history_list.add(my2);
        history_list.add(my3);
        myadapter = new HistoryAdapter(getApplicationContext(), R.layout.my_history,history_list);
        listView.setAdapter(myadapter);

    }
}
