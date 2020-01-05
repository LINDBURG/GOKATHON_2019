package com.example.gokathon;


import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CostActivity2 extends AppCompatActivity {
    private ListView listView;
    ArrayList<History> history_list;
    HistoryAdapter myadapter;
    History my1, my2, my3;
    int unicode = 0x1F9E6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost2);
        listView = (ListView)findViewById(R.id.listView);
        my1 = new History("옷장 정리", "20,000원", "언니가 보고 이쁜옷도 남으면 줄게요", BitmapFactory.decodeResource(getResources(), R.drawable.dirtyhouse2));
        history_list = new ArrayList<History>();
        history_list.add(my1);
        myadapter = new HistoryAdapter(getApplicationContext(), R.layout.my_history,history_list);
        listView.setAdapter(myadapter);

    }
}
