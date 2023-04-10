package com.example.app60;

import static com.example.app60.R.id.imageButton26;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;

public class torch extends AppCompatActivity {

    ImageButton b;
    private boolean blue = false;
    CameraManager cm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Torch");
        
        b=(ImageButton) findViewById(R.id.imageButton26);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(blue == false)
                {
                    try{
                        String id = cm.getCameraIdList()[0];
                        cm.setTorchMode(id,true);
                        blue = true;
                        b.setImageResource(R.drawable.dd);
                    }
                    catch (CameraAccessException e){

                    }
                }
                else
                {
                    try {
                        String id = cm.getCameraIdList()[0];
                        cm.setTorchMode(id,false);
                        blue = false;
                        b.setImageResource(R.drawable.cc);
                    }
                    catch (CameraAccessException e){

                    }

                }

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