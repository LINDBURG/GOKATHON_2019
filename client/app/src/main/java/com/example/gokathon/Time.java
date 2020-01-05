package com.example.gokathon;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Time extends AppCompatActivity {
    private ListView listView;
    ArrayList<History> history_list;
    HistoryAdapter myadapter;
    History my1, my2, my3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        listView = (ListView)findViewById(R.id.listView);
        my1 = new History("정성준", "2020/01/02", "22,000원", BitmapFactory.decodeResource(getResources(), R.drawable.gollum1));
        my2 = new History("유혁", "2020/01/01", "15,000원 ", BitmapFactory.decodeResource(getResources(), R.drawable.gollum2));
        my3 = new History("트럼프", "2019/12/25", "9,000원", BitmapFactory.decodeResource(getResources(), R.drawable.gollum3));
        history_list = new ArrayList<History>();
        history_list.add(my1);
        history_list.add(my2);
        history_list.add(my3);

        myadapter = new HistoryAdapter(getApplicationContext(), R.layout.my_history,history_list);
        listView.setAdapter(myadapter);

    }
}
