package com.example.gokathon;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CurrentRoomStateActivity extends AppCompatActivity {
    private RatingBar ratingbar;
    private RatingBar ratingbar_indicator;
    private RatingBar ratingbar_small;

    private ListView listView;
    ArrayList<History> history_list;
    HistoryAdapter myadapter;
    History my1, my2, my3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cstate);


        TextView loadingtext = (TextView) findViewById(R.id.loadingtext);
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(100);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        loadingtext.startAnimation(anim);
        listView = (ListView)findViewById(R.id.listView);
        my1 = new History("주인님1", "정말조와용", "양말 5개", BitmapFactory.decodeResource(getResources(), R.drawable.gollum1));
        my2 = new History("주인님2", "약간조와용", "양말 4개", BitmapFactory.decodeResource(getResources(), R.drawable.gollum2));
        my3 = new History("주인님3", "별로조와용", "양말 3개", BitmapFactory.decodeResource(getResources(), R.drawable.gollum3));
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
