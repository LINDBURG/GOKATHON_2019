package com.example.gokathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class HomeActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener,
        DobbyFragment.OnFragmentInteractionListener,
        MyPageFragment.OnFragmentInteractionListener {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentTransaction transaction = fragmentManager.beginTransaction();
    private HomeFragment homeFragment = new HomeFragment();
    private DobbyFragment dobbyFragment = new DobbyFragment();
    private MyPageFragment myPageFragment = new MyPageFragment();
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
                    transaction = fragmentManager.beginTransaction();
                    if(!dobbyFragment.isAdded()) transaction.replace(R.id.frameLayout, dobbyFragment).commitNowAllowingStateLoss();
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

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
