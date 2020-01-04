package com.example.gokathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class HomeActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener,
        HouseFragment.OnFragmentInteractionListener,
        DobbyFragment.OnFragmentInteractionListener,
        MyPageFragment.OnFragmentInteractionListener {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentTransaction transaction = fragmentManager.beginTransaction();
    private HomeFragment homeFragment = new HomeFragment();
    private HouseFragment houseFragment = new HouseFragment();
    private DobbyFragment dobbyFragment = new DobbyFragment();
    private MyPageFragment myPageFragment = new MyPageFragment();

    private PopupWindow window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Log.d("여기는 한번만", "실행");
        transaction.replace(R.id.frameLayout, homeFragment).commitAllowingStateLoss();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction = fragmentManager.beginTransaction();
                    if(!homeFragment.isAdded()) {
                        Log.d("tab1", "!@#");
                        transaction.replace(R.id.frameLayout, homeFragment).commitNowAllowingStateLoss();
                    }
                    break;
                case R.id.navigation_dashboard:
                    ShowPopupWindow();
                    break;
                case R.id.navigation_notifications:
                    transaction = fragmentManager.beginTransaction();
                    if(!myPageFragment.isAdded()) transaction.replace(R.id.frameLayout, myPageFragment).commitNowAllowingStateLoss();
                    MyPageFragment.index++;
                    Log.d("index", String.valueOf(MyPageFragment.index));
                    break;
            }
            return true;
        }
    };


    private void ShowPopupWindow(){
        try {
            ImageView house, dobby;

            LayoutInflater inflater = (LayoutInflater) HomeActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.popupwindow, null);
            window = new PopupWindow(layout, 1300, 800, true);

            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setOutsideTouchable(true);
            window.showAtLocation(layout, Gravity.CENTER, 40, 60);
            //  window.showAtLocation(layout, 17, 100, 100);

            house = (ImageView) layout.findViewById(R.id.house);
            dobby = (ImageView) layout.findViewById(R.id.dob);

            transaction = fragmentManager.beginTransaction();

            house.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    window.dismiss();
                    //if(!houseFragment.isAdded()) transaction.replace(R.id.frameLayout, houseFragment).commitNowAllowingStateLoss();

                    Intent mainIntent = new Intent(HomeActivity.this, HouseActivity.class);
                    startActivity(mainIntent);
                    finish();

                }
            });

            dobby.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    window.dismiss();
                    if(!dobbyFragment.isAdded()) transaction.replace(R.id.frameLayout, dobbyFragment).commitNowAllowingStateLoss();
                }

            });


        }catch (Exception e){

        }
    }

    private static long back_pressed;

    @Override
    public void onBackPressed()
    {
        if (back_pressed + 2000 > System.currentTimeMillis()) super.onBackPressed();
        else Toast.makeText(getBaseContext(), "한번 더 누르시면 앱이 종료됩니다.", Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
