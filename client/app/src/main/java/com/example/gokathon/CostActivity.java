package com.example.gokathon;


import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CostActivity extends AppCompatActivity {
    private ListView listView;
    ArrayList<History> history_list;
    HistoryAdapter myadapter;
    History my1, my2, my3;
    int unicode = 0x1F9E6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost);
        listView = (ListView)findViewById(R.id.listView);
        my1 = new History("설거지", "5,000원", "설거지 이틀쨰 못했어요 ㅜㅜ 부탁합니다", BitmapFactory.decodeResource(getResources(), R.drawable.dirtyhouse2));
        my2 = new History("방 닦기", "5,200원", "바닥 좁은데 금방 닦으실거에요 ㅜㅜ", BitmapFactory.decodeResource(getResources(), R.drawable.gollum1));
        history_list = new ArrayList<History>();
        history_list.add(my1);
        history_list.add(my2);
        myadapter = new HistoryAdapter(getApplicationContext(), R.layout.my_history,history_list);
        listView.setAdapter(myadapter);

    }
}
