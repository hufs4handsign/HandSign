package com.example.handsign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private SignTrans signTrans;
    private VoiceTrans voiceTrans;
    private Home home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.start_main);

        signTrans = new SignTrans();
        voiceTrans = new VoiceTrans();
        home = new Home();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomMenu);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, home).commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        switch (item.getItemId()) {
                            case R.id.signTrans:
                                //페이지 이동
                                transaction.replace(R.id.frame_layout, signTrans).commitAllowingStateLoss();
                                break;
                            case R.id.return_home:
                                //페이지 이동
                                transaction.replace(R.id.frame_layout, home).commitAllowingStateLoss();
                                break;
                            case R.id.voiceTrans:
                                //페이지 이동
                                transaction.replace(R.id.frame_layout, voiceTrans).commitAllowingStateLoss();
                                break;
                        }
                        return false;
                    }
                });
        };
}