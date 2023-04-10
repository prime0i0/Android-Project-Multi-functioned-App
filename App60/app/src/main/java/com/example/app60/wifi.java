package com.example.app60;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ToggleButton;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class wifi extends AppCompatActivity {

    ImageButton b1;
    WifiManager wm;
    private boolean wifi=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("WiFi");
        b1=(ImageButton) findViewById(R.id.imageButton);

        wm = (WifiManager)getSystemService(WIFI_SERVICE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(wifi==false) {
                    wm.setWifiEnabled(true);
                    wifi = true;
                    b1.setImageResource(R.drawable.red);
                }
                else
                {
                    wm.setWifiEnabled(false);
                    wifi = false;
                    b1.setImageResource(R.drawable.black);
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