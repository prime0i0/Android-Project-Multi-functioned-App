package com.example.app60;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class AddPlayers extends AppCompatActivity {

    EditText playerOne,playerTwo;
    Button startGameBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add Player");

        playerOne=(EditText) findViewById(R.id.playerOneName);
        playerTwo=(EditText) findViewById(R.id.playertwoName);
        startGameBtn=(Button) findViewById(R.id.startGameBtn);

        startGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s1 = playerOne.getText().toString();
                String s2 =  playerTwo.getText().toString();

                if(s1.isEmpty() || s2.isEmpty()){
                    Toast.makeText(AddPlayers.this, "Please Enter Player Name", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(AddPlayers.this , tictactoe.class);
                    intent.putExtra("playerOne",s1);
                    intent.putExtra("playerTwo",s2);
                    startActivity(intent);
                    //finish();
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