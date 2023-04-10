package com.example.app60;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.admin.DevicePolicyManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.icu.util.Freezable;
import android.media.MediaPlayer;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.ImageView;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class danger extends AppCompatActivity implements SensorEventListener   {

    MediaPlayer mp;
    WifiManager wm;
    BluetoothAdapter ba;
    CameraManager cm;
    Vibrator v1;
    ImageView i1;
    SensorManager sm;
    Sensor s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danger);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Danger , Leave Now");


        mp=MediaPlayer.create(this,R.raw.danger4);
        wm=(WifiManager)getSystemService(WIFI_SERVICE);
        ba=BluetoothAdapter.getDefaultAdapter();
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        v1=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        i1=(ImageView)findViewById(R.id.imageView);

        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this ,s ,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        float x=sensorEvent.values[0];
        float y=sensorEvent.values[1];
        float z=sensorEvent.values[2];

        int x1=(int)x;
        int y1=(int)y;
        int z1=(int)z;

        if(x1!=0){
            Toast.makeText(this, "Why you Are Tilding Your phone !", Toast.LENGTH_SHORT).show();
            mp.start();
            wm.setWifiEnabled(true);
            ba.enable();

            i1.setImageResource(R.drawable.danger1);
            if(Build.VERSION.SDK_INT>26){
                v1.vibrate(200000);
            }
            else {
                v1.vibrate(200000);
            }
            try{
                String id =cm.getCameraIdList()[0];
                cm.setTorchMode(id,true);
            }
            catch (CameraAccessException e){

            }
        }
        else{
            Toast.makeText(danger.this, "why you turn back", Toast.LENGTH_SHORT).show();
            wm.setWifiEnabled(false);
            ba.disable();

            i1.setImageResource(R.drawable.danger2);
            try{
                String id =cm.getCameraIdList()[0];
                cm.setTorchMode(id,false);
            }
            catch (CameraAccessException e){

            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

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