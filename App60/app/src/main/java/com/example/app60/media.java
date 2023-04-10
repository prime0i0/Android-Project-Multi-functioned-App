package com.example.app60;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class media extends AppCompatActivity {

    Button b2;
    MediaPlayer mp , mp2 , mp3 , mp4 , mp5 , mp6 , mp7 , mp8 , mp9 ;
    ImageButton ib1,ib2,ib3,ib4,ib5,ib6,ib7,ib8,ib9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Music");

        b2 = (Button) findViewById(R.id.button2);
        ib1 = (ImageButton) findViewById(R.id.imageButton8);
        ib2 = (ImageButton) findViewById(R.id.imageButton9);
        ib3 = (ImageButton) findViewById(R.id.imageButton11);
        ib4 = (ImageButton) findViewById(R.id.imageButton7);
        ib5 = (ImageButton) findViewById(R.id.imageButton10);
        ib6 = (ImageButton) findViewById(R.id.imageButton13);
        ib7 = (ImageButton) findViewById(R.id.imageButton14);
        ib8 = (ImageButton) findViewById(R.id.imageButton15);
        ib9= (ImageButton) findViewById(R.id.imageButton16);




        mp = MediaPlayer.create(this,R.raw.tandav);
        mp2 = MediaPlayer.create(this,R.raw.han);
        mp3 = MediaPlayer.create(this,R.raw.sii);
        mp4 = MediaPlayer.create(this,R.raw.hara);
        mp5 = MediaPlayer.create(this,R.raw.bolo);
        mp6 = MediaPlayer.create(this,R.raw.bhaaang);
        mp7 = MediaPlayer.create(this,R.raw.miyiyi);
        mp8 = MediaPlayer.create(this,R.raw.durga);
        mp9 = MediaPlayer.create(this,R.raw.rama);





        ib1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp2.start();
            }
        });
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp3.start();
            }
        });
        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp4.start();
            }
        });
        ib5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp5.start();
            }
        });
        ib6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp6.start();
            }
        });
        ib7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp7.start();
            }
        });
        ib8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp8.start();
            }
        });
        ib9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp9.start();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
                mp2.pause();
                mp3.pause();
                mp4.pause();
                mp5.pause();
                mp6.pause();
                mp7.pause();
                mp8.pause();
                mp9.pause();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}