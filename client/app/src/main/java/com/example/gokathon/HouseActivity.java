package com.example.gokathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HouseActivity extends AppCompatActivity {
    private Button registeration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);

        registeration = (Button) findViewById(R.id.registerButton);
        registeration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(HouseActivity.this, HomeActivity.class);
                startActivity(mainIntent);
                finish();
            }
        });
    }
}
