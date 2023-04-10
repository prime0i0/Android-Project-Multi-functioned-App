package com.example.app60;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;



public class tools extends AppCompatActivity {

    ImageButton ib1,ib2,ib3,ib4,ib5,ib6,ib7,ib8,ib9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tools");
        ib1=(ImageButton) findViewById(R.id.imageButton5);
        ib2=(ImageButton) findViewById(R.id.imageButton6);
        ib3=(ImageButton) findViewById(R.id.imageButton22);
        ib4=(ImageButton) findViewById(R.id.imageButton23);
        ib5=(ImageButton) findViewById(R.id.imageButton18);
        ib6=(ImageButton) findViewById(R.id.imageButton20);
        ib7=(ImageButton) findViewById(R.id.imageButton25);
        ib8=(ImageButton) findViewById(R.id.imageButton);
        ib9=(ImageButton) findViewById(R.id.imageButton27);


        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(tools.this,cal.class);
                startActivity(i);
                //finish();
            }
        });

        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(tools.this,media.class);
                startActivity(i);
                //finish();
            }
        });
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(tools.this,tts.class);
                startActivity(i);
                //finish();
            }
        });
        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(tools.this,wifi.class);
                startActivity(i);
                //finish();
            }
        });
        ib5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(tools.this,bluethoot.class);
                startActivity(i);
                //finish();
            }
        });
        ib6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tools.this , camera.class);
                startActivity(intent);
                //finish();
            }
        });
        ib7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tools.this , torch.class);
                startActivity(intent);
                //finish();
            }
        });
        ib8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tools.this , vibrate.class);
                startActivity(intent);
                //finish();
            }
        });
        ib9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tools.this,danger.class);
                startActivity(intent);
                //finish();
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
