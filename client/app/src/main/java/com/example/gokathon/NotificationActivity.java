package com.example.gokathon;


import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity {
    private ListView listView;
    ArrayList<History> history_list;
    HistoryAdapter2 myadapter;
    History my1, my2, my3,my4,my5;
    int unicode = 0x1F9E6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        listView = (ListView)findViewById(R.id.listView);

        my1 = new History("안암도비98", "2020.02.01. 10시 ", "안암도비 98님이 대리청소 신청을 하셨습니다.", BitmapFactory.decodeResource(getResources(), R.drawable.image1));
        my2 = new History("해리코털", "2019.12.25", "'해리코털'님이 청소를 완료하였습니다. ", BitmapFactory.decodeResource(getResources(), R.drawable.cleaningdone));
        my3 = new History("고카톤피자", "2019.12.24", "'고카톤피자'님이 청소를 완료하였습니다.", BitmapFactory.decodeResource(getResources(), R.drawable.image3));
        my4 = new History("안암도비98", "2020.01.16. 3시 ", "'안암도비 98'님이 대리청소 신청을 하셨습니다.", BitmapFactory.decodeResource(getResources(), R.drawable.image1));
        my5 = new History("설쌈존맛", "2020.01.16. 3시 ", "'설쌈존맛'님이 대리청소 신청을 하셨습니다.", BitmapFactory.decodeResource(getResources(), R.drawable.nickiminaj));
        history_list = new ArrayList<History>();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Intent myIntent = new Intent(NotificationActivity.this, DobbyInfoActivity.class);
                        startActivity(myIntent);
                    }
                });

        history_list.add(my1);
        history_list.add(my2);
        history_list.add(my3);
        history_list.add(my4);
        history_list.add(my5);
        history_list.add(my1);
        history_list.add(my2);
        history_list.add(my3);
        history_list.add(my4);
        history_list.add(my5);
        myadapter = new HistoryAdapter2(getApplicationContext(), R.layout.my_history,history_list);
        listView.setAdapter(myadapter);


    }
}
