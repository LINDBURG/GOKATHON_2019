package com.example.gokathon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CurrentRoomStateActivity extends AppCompatActivity {
    private RatingBar ratingbar;
    private RatingBar ratingbar_indicator;
    private RatingBar ratingbar_small;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cstate);
        ratingbar_indicator = findViewById(R.id.ratingBarInficator);

        ratingbar_indicator.setOnRatingBarChangeListener(new Listener());
    }

    class Listener implements RatingBar.OnRatingBarChangeListener
    {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            ratingbar_indicator.setRating(rating);
        }
    }

}
