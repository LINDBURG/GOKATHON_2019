package com.example.gokathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class starDobbyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_dobby);

        final ImageView red1 = findViewById(R.id.red1);
        final ImageView white1 = findViewById(R.id.white1);
        final ImageView red2 = findViewById(R.id.red2);
        final ImageView white2 = findViewById(R.id.white2);
        final ImageView red3 = findViewById(R.id.red3);
        final ImageView white3 = findViewById(R.id.white3);
        final ImageView red4 = findViewById(R.id.red4);
        final ImageView white4 = findViewById(R.id.white4);
        final ImageView red5 = findViewById(R.id.red5);
        final ImageView white5 = findViewById(R.id.white5);
        final ImageView socks1 = findViewById(R.id.socks1);
        final ImageView socks2 = findViewById(R.id.socks2);
        final ImageView socks3 = findViewById(R.id.socks3);
        final ImageView socks4 = findViewById(R.id.socks4);
        final ImageView socks5 = findViewById(R.id.socks5);

        red1.setVisibility(View.GONE);
        red2.setVisibility(View.GONE);
        red3.setVisibility(View.GONE);
        red4.setVisibility(View.GONE);
        red5.setVisibility(View.GONE);
        white1.setVisibility(View.VISIBLE);
        white2.setVisibility(View.VISIBLE);
        white3.setVisibility(View.VISIBLE);
        white4.setVisibility(View.VISIBLE);
        white5.setVisibility(View.VISIBLE);
        socks1.setVisibility(View.GONE);
        socks2.setVisibility(View.GONE);
        socks3.setVisibility(View.VISIBLE);
        socks4.setVisibility(View.GONE);
        socks5.setVisibility(View.GONE);

        white1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                red1.setVisibility(View.VISIBLE);
                red2.setVisibility(View.GONE);
                red3.setVisibility(View.GONE);
                red4.setVisibility(View.GONE);
                red5.setVisibility(View.GONE);
                white1.setVisibility(View.GONE);
                white2.setVisibility(View.VISIBLE);
                white3.setVisibility(View.VISIBLE);
                white4.setVisibility(View.VISIBLE);
                white5.setVisibility(View.VISIBLE);
                socks1.setVisibility(View.VISIBLE);
                socks2.setVisibility(View.GONE);
                socks3.setVisibility(View.GONE);
                socks4.setVisibility(View.GONE);
                socks5.setVisibility(View.GONE);
            }
        });
        red1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                red1.setVisibility(View.VISIBLE);
                red2.setVisibility(View.GONE);
                red3.setVisibility(View.GONE);
                red4.setVisibility(View.GONE);
                red5.setVisibility(View.GONE);
                white1.setVisibility(View.GONE);
                white2.setVisibility(View.VISIBLE);
                white3.setVisibility(View.VISIBLE);
                white4.setVisibility(View.VISIBLE);
                white5.setVisibility(View.VISIBLE);
                socks1.setVisibility(View.VISIBLE);
                socks2.setVisibility(View.GONE);
                socks3.setVisibility(View.GONE);
                socks4.setVisibility(View.GONE);
                socks5.setVisibility(View.GONE);
            }
        });

        white2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                red1.setVisibility(View.VISIBLE);
                red2.setVisibility(View.VISIBLE);
                red3.setVisibility(View.GONE);
                red4.setVisibility(View.GONE);
                red5.setVisibility(View.GONE);
                white1.setVisibility(View.GONE);
                white2.setVisibility(View.GONE);
                white3.setVisibility(View.VISIBLE);
                white4.setVisibility(View.VISIBLE);
                white5.setVisibility(View.VISIBLE);
                socks1.setVisibility(View.GONE);
                socks2.setVisibility(View.VISIBLE);
                socks3.setVisibility(View.GONE);
                socks4.setVisibility(View.GONE);
                socks5.setVisibility(View.GONE);
            }
        });
        red2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                red1.setVisibility(View.VISIBLE);
                red2.setVisibility(View.VISIBLE);
                red3.setVisibility(View.GONE);
                red4.setVisibility(View.GONE);
                red5.setVisibility(View.GONE);
                white1.setVisibility(View.GONE);
                white2.setVisibility(View.GONE);
                white3.setVisibility(View.VISIBLE);
                white4.setVisibility(View.VISIBLE);
                white5.setVisibility(View.VISIBLE);
                socks1.setVisibility(View.GONE);
                socks2.setVisibility(View.VISIBLE);
                socks3.setVisibility(View.GONE);
                socks4.setVisibility(View.GONE);
                socks5.setVisibility(View.GONE);
            }
        });

        white3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                red1.setVisibility(View.VISIBLE);
                red2.setVisibility(View.VISIBLE);
                red3.setVisibility(View.VISIBLE);
                red4.setVisibility(View.GONE);
                red5.setVisibility(View.GONE);
                white1.setVisibility(View.GONE);
                white2.setVisibility(View.GONE);
                white3.setVisibility(View.GONE);
                white4.setVisibility(View.VISIBLE);
                white5.setVisibility(View.VISIBLE);
                socks1.setVisibility(View.GONE);
                socks2.setVisibility(View.GONE);
                socks3.setVisibility(View.VISIBLE);
                socks4.setVisibility(View.GONE);
                socks5.setVisibility(View.GONE);
            }
        });
        red3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                red1.setVisibility(View.VISIBLE);
                red2.setVisibility(View.VISIBLE);
                red3.setVisibility(View.VISIBLE);
                red4.setVisibility(View.GONE);
                red5.setVisibility(View.GONE);
                white1.setVisibility(View.GONE);
                white2.setVisibility(View.GONE);
                white3.setVisibility(View.GONE);
                white4.setVisibility(View.VISIBLE);
                white5.setVisibility(View.VISIBLE);
                socks1.setVisibility(View.GONE);
                socks2.setVisibility(View.GONE);
                socks3.setVisibility(View.VISIBLE);
                socks4.setVisibility(View.GONE);
                socks5.setVisibility(View.GONE);
            }
        });

        white4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                red1.setVisibility(View.VISIBLE);
                red2.setVisibility(View.VISIBLE);
                red3.setVisibility(View.VISIBLE);
                red4.setVisibility(View.VISIBLE);
                red5.setVisibility(View.GONE);
                white1.setVisibility(View.GONE);
                white2.setVisibility(View.GONE);
                white3.setVisibility(View.GONE);
                white4.setVisibility(View.GONE);
                white5.setVisibility(View.VISIBLE);
                socks1.setVisibility(View.GONE);
                socks2.setVisibility(View.GONE);
                socks3.setVisibility(View.GONE);
                socks4.setVisibility(View.VISIBLE);
                socks5.setVisibility(View.GONE);
            }
        });
        red4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                red1.setVisibility(View.VISIBLE);
                red2.setVisibility(View.VISIBLE);
                red3.setVisibility(View.VISIBLE);
                red4.setVisibility(View.VISIBLE);
                red5.setVisibility(View.GONE);
                white1.setVisibility(View.GONE);
                white2.setVisibility(View.GONE);
                white3.setVisibility(View.GONE);
                white4.setVisibility(View.GONE);
                white5.setVisibility(View.VISIBLE);
                socks1.setVisibility(View.GONE);
                socks2.setVisibility(View.GONE);
                socks3.setVisibility(View.GONE);
                socks4.setVisibility(View.VISIBLE);
                socks5.setVisibility(View.GONE);
            }
        });

        white5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                red1.setVisibility(View.VISIBLE);
                red2.setVisibility(View.VISIBLE);
                red3.setVisibility(View.VISIBLE);
                red4.setVisibility(View.VISIBLE);
                red5.setVisibility(View.VISIBLE);
                white1.setVisibility(View.GONE);
                white2.setVisibility(View.GONE);
                white3.setVisibility(View.GONE);
                white4.setVisibility(View.GONE);
                white5.setVisibility(View.GONE);
                socks1.setVisibility(View.GONE);
                socks2.setVisibility(View.GONE);
                socks3.setVisibility(View.GONE);
                socks4.setVisibility(View.GONE);
                socks5.setVisibility(View.VISIBLE);
            }
        });
        red5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                red1.setVisibility(View.VISIBLE);
                red2.setVisibility(View.VISIBLE);
                red3.setVisibility(View.VISIBLE);
                red4.setVisibility(View.VISIBLE);
                red5.setVisibility(View.VISIBLE);
                white1.setVisibility(View.GONE);
                white2.setVisibility(View.GONE);
                white3.setVisibility(View.GONE);
                white4.setVisibility(View.GONE);
                white5.setVisibility(View.GONE);
                socks1.setVisibility(View.GONE);
                socks2.setVisibility(View.GONE);
                socks3.setVisibility(View.GONE);
                socks4.setVisibility(View.GONE);
                socks5.setVisibility(View.VISIBLE);
            }
        });


        Button endButton = findViewById(R.id.evalend);
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "도비의 평가를 완료하였습니다 :)", Toast.LENGTH_LONG).show();
                Intent mainIntent = new Intent(starDobbyActivity.this, HomeActivity.class);
                startActivity(mainIntent);
                finish();
            }
        });

    }
}
