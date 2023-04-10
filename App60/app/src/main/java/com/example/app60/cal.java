package com.example.app60;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class cal extends AppCompatActivity {

    EditText e1, e2;
    TextView t1;
    Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Calculator");

        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        t1 = (TextView) findViewById(R.id.textView);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();

                Float i1 = Float.parseFloat(s1);
                Float i2 = Float.parseFloat(s2);

                Float i3 = i1 + i2;

                String s3 = Float.toString(i3);
                t1.setText(s3);
                Toast.makeText(cal.this, "The Result is = "+s3, Toast.LENGTH_SHORT).show();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();

                Float i1 = Float.parseFloat(s1);
                Float i2 = Float.parseFloat(s2);

                Float i3 = i1 - i2;

                String s3 = Float.toString(i3);
                t1.setText(s3);
                Toast.makeText(cal.this, "The Result is = "+s3, Toast.LENGTH_SHORT).show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();

                Float i1 = Float.parseFloat(s1);
                Float i2 = Float.parseFloat(s2);

                Float i3 = i1 * i2;

                String s3 = Float.toString(i3);
                t1.setText(s3);
                Toast.makeText(cal.this, "The Result is = "+s3, Toast.LENGTH_SHORT).show();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();

                Float i1 = Float.parseFloat(s1);
                Float i2 = Float.parseFloat(s2);

                Float i3 = i1 / i2;

                String s3 = Float.toString(i3);
                t1.setText(s3);
                Toast.makeText(cal.this, "The Result is = "+s3, Toast.LENGTH_SHORT).show();
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