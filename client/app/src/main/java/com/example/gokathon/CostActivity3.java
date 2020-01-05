package com.example.gokathon;


import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CostActivity3 extends AppCompatActivity {
    private ListView listView;
    ArrayList<History> history_list;
    HistoryAdapter myadapter;
    History my1, my2, my3;
    int unicode = 0x1F9E6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost3);
        listView = (ListView)findViewById(R.id.listView);
        my1 = new History("책장 정리정돈", "15,000원", "무거운 책이 꽤 많아요. 부탁합니다 ", BitmapFactory.decodeResource(getResources(), R.drawable.dirtyhouse2));
        my2 = new History("방 닦기", "15,000원", "바닥 넓데 금방 닦으실은거에요 ㅜㅜ", BitmapFactory.decodeResource(getResources(), R.drawable.gollum1));
        history_list = new ArrayList<History>();
        history_list.add(my1);
        history_list.add(my2);
        myadapter = new HistoryAdapter(getApplicationContext(), R.layout.my_history,history_list);
        listView.setAdapter(myadapter);

    }
}
