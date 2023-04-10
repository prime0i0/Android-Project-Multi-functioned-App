package com.example.app60;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class fourtwo extends AppCompatActivity {

    TextView t1,t2,t3,t4;
    EditText e1;
    Button b1,b2,b3,b4;
    Random random = new Random();

    int number1 , number2;
    int ans;
    int rans;
    int score = 0;
    int life = 3;
    CountDownTimer timer;
    private static final long START_TIMER = 30000;
    Boolean run;
    long time_left = START_TIMER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourone);
        getSupportActionBar().setTitle("Math Game ?");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        t1=(TextView) findViewById(R.id.textView2); //score
        t2=(TextView) findViewById(R.id.textView4); //life
        t3=(TextView) findViewById(R.id.textView6); //time
        t4=(TextView) findViewById(R.id.textView7); //question
        e1=(EditText)findViewById(R.id.editText6); //answer
        b1=(Button) findViewById(R.id.button9); //ok
        b2=(Button) findViewById(R.id.button10); //next question
        b3=(Button) findViewById(R.id.button11);
        b4=(Button) findViewById(R.id.button12);

        game();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ans = Integer.valueOf(e1.getText().toString());

                pauseTimer();

                if(ans == rans)
                {
                    score = score + 10;
                    t1.setText(""+score);
                    t4.setText("Congratulations , Your answer is True .");
                }
                else
                {

                    life = life - 1;
                    t2.setText(""+life);
                    t4.setText("Sorry , Your Answer is wrong .");
                }

                if(life <= 0)
                {
                    Toast.makeText(fourtwo.this, "GAME OVER", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(fourtwo.this , result.class);
                    intent.putExtra("score",score);
                    startActivity(intent);
                    finish();
                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                e1.setText("");
                game();
                resetTimer();

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(fourtwo.this , result.class);
                startActivity(i1);
                finish();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(fourtwo.this , four.class);
                startActivity(i2);
                finish();
            }
        });

    }

    public void game()
    {
        number1 = random.nextInt(100);
        number2 = random.nextInt(100);

        rans = number1 - number2;

        t4.setText(number1 + " - " + number2);
        startTimer();
    }

    public void startTimer()
    {
        timer = new CountDownTimer(time_left,1000) {
            @Override
            public void onTick(long l) {

                time_left = l;
                updateText();


            }

            @Override
            public void onFinish() {

                run = false;
                pauseTimer();
                resetTimer();
                updateText();
                life = life - 1 ;
                t2.setText(""+life);
                t4.setText("Sorry ! Time is up !");

            }
        }.start();
        run = true;
    }
    public void updateText()
    {
        int seconds = (int)(time_left / 1000) % 60;
        String s1 = String.format(Locale.getDefault(),"%02d",seconds);
        t3.setText(s1);
    }
    public void pauseTimer()
    {

        timer.cancel();
        run = false;
    }
    public void resetTimer()
    {
        time_left = START_TIMER;
        updateText();
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
