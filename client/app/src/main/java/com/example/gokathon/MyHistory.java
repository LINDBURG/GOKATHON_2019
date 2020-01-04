package com.example.gokathon;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MyHistory extends AppCompatActivity {
    private ListView listView;
    ArrayList<History> history_list;
    HistoryAdapter myadapter;
    History my1, my2, my3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myhistory);
        listView = (ListView)findViewById(R.id.listView);
        my1 = new History("주인님1", "정말조와용", "별점 5개", BitmapFactory.decodeResource(getResources(), R.drawable.gollum1));
        my2 = new History("주인님2", "약간조와용", "별점 4개", BitmapFactory.decodeResource(getResources(), R.drawable.gollum2));
        my3 = new History("주인님3", "별로조와용", "별점 3개", BitmapFactory.decodeResource(getResources(), R.drawable.gollum3));
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
