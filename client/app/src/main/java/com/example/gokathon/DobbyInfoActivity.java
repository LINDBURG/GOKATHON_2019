package com.example.gokathon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class DobbyInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dobbyinfo);
        TextView Review = (TextView)findViewById(R.id.viewReviews);
        TextView ReviewNum = (TextView)findViewById(R.id.reviewNum);
        TextView ReviewText = (TextView)findViewById(R.id.reviewText);
        TextView Follow = (TextView)findViewById(R.id.followbutton);
        TextView rateDobby = (TextView)findViewById(R.id.ratethisdobby2);
        Review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(DobbyInfoActivity.this, ReviewActivity.class);
                startActivity(newIntent);
            }
        });
        ReviewNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(DobbyInfoActivity.this, ReviewActivity.class);
                startActivity(newIntent);
            }
        });
        ReviewText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(DobbyInfoActivity.this, ReviewActivity.class);
                startActivity(newIntent);
            }
        });
        Follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(DobbyInfoActivity.this, HomeActivity.class);
                startActivity(newIntent);
                Toast.makeText(getBaseContext(), "'안암도비98' 님을 팔로우 하셨습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        rateDobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(DobbyInfoActivity.this, starDobbyActivity.class);
                startActivity(newIntent);
                Toast.makeText(getBaseContext(), "과연 양말을 몇개나?!", Toast.LENGTH_SHORT).show();
            }
        });
    }




}
