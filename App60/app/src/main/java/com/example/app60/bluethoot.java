package com.example.app60;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class bluethoot extends AppCompatActivity {

    ImageButton lb;
    BluetoothAdapter ba;
    private boolean blue = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluethoot);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Bluethooth");


        lb=(ImageButton)findViewById(R.id.imageButton19);
        ba=BluetoothAdapter.getDefaultAdapter();

        lb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(blue == false)
                {
                    ba.enable();
                    blue=true;
                    lb.setImageResource(R.drawable.on);
                }
                else
                {
                    ba.disable();
                    blue=false;
                    lb.setImageResource(R.drawable.off);
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