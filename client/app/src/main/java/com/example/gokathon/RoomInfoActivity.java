package com.example.gokathon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RoomInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roominfo);
        TextView Review = (TextView)findViewById(R.id.viewReviews);
        TextView ReviewNum = (TextView)findViewById(R.id.reviewNum);
        TextView ReviewText = (TextView)findViewById(R.id.reviewText);
        TextView Follow = (TextView)findViewById(R.id.followbutton);
        TextView rateDobby = (TextView)findViewById(R.id.ratethisdobby2);

        Review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(RoomInfoActivity.this, CostActivity.class);
                startActivity(newIntent);
            }
        });
        ReviewNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(RoomInfoActivity.this, CostActivity.class);
                startActivity(newIntent);
            }
        });
        ReviewText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(RoomInfoActivity.this, CostActivity.class);
                startActivity(newIntent);
            }
        });
        rateDobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(RoomInfoActivity.this, HomeActivity.class);
                startActivity(newIntent);
                Toast.makeText(getBaseContext(), "도비 출동 신청을 하셨습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }




}
