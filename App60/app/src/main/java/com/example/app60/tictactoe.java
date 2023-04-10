package com.example.app60;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class tictactoe extends AppCompatActivity {

    TextView playerOneName , playerTwoName ;
    LinearLayout playerOneLayout , playerTwoLayout ;
    ImageView image1 , image2 , image3 , image4 , image5 , image6 , image7 , image8 , image9 ;
    final List<int[]> combinationsList = new ArrayList<>();
    int [] boxPositions = {0,0,0,0,0,0,0,0,0};
    int playerTurn = 1;
    int TotalSelectedBoxes = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tic Tac Toe");

        playerOneName = (TextView) findViewById(R.id.playerOneName);
        playerTwoName = (TextView) findViewById(R.id.playertwoName);
        playerOneLayout = (LinearLayout) findViewById(R.id.playerOneLaytout);
        playerTwoLayout = (LinearLayout) findViewById(R.id.playerTwoLayout);

        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);
        image5 = (ImageView) findViewById(R.id.image5);
        image6 = (ImageView) findViewById(R.id.image6);
        image7 = (ImageView) findViewById(R.id.image7);
        image8 = (ImageView) findViewById(R.id.image8);
        image9 = (ImageView) findViewById(R.id.image9);


        combinationsList.add(new int[]{0,1,2});
        combinationsList.add(new int[]{3,4,5});
        combinationsList.add(new int[]{6,7,8});
        combinationsList.add(new int[]{0,3,6});
        combinationsList.add(new int[]{1,4,7});
        combinationsList.add(new int[]{2,5,8});
        combinationsList.add(new int[]{2,4,6});
        combinationsList.add(new int[]{0,4,8});

        String getPlayerOneName = getIntent().getStringExtra("playerOne");
        String getPlayerTwoName = getIntent().getStringExtra("playerTwo");

        playerOneName.setText(getPlayerOneName);
        playerTwoName.setText(getPlayerTwoName);



        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(0)){

                    performAction((ImageView)view , 0);
                }
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(1)){

                    performAction((ImageView)view , 1);
                }
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(2)){

                    performAction((ImageView)view , 2);
                }
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(3)){

                    performAction((ImageView)view , 3);
                }
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(4)){
                    performAction((ImageView)view , 4);

                }
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(5)){
                    performAction((ImageView)view , 5);

                }
            }
        });

        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(6)){
                    performAction((ImageView)view , 6);

                }
            }
        });

        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(7)){

                    performAction((ImageView)view , 7);
                }
            }
        });

        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(8)){

                    performAction((ImageView)view , 8);

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
    boolean isBoxSelectable(int boxPosition){
        boolean response = false;
        if(boxPositions[boxPosition] == 0){
            response = true ;
        }
        return response;
    }
    private void performAction (ImageView imageView , int selectedBoxPosition){

        boxPositions[selectedBoxPosition] = playerTurn;
        if(playerTurn == 1 ){
            imageView.setImageResource(R.drawable.tic2);

            if(checkPlayerWin()){

                winDialog winDialog = new winDialog(tictactoe.this , playerOneName.getText().toString() + "Has Won The Match" , tictactoe.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else if(TotalSelectedBoxes == 9){
                winDialog winDialog = new winDialog(tictactoe.this ,  "It is Draw !" , tictactoe.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else {
                changePlayerTurn(2);
                TotalSelectedBoxes++;
            }
        }
        else{
            imageView.setImageResource(R.drawable.tic1);
            if(checkPlayerWin()){
                winDialog winDialog = new winDialog(tictactoe.this , playerTwoName.getText().toString() + "Has Won The Match" , tictactoe.this);
                winDialog.setCancelable(false);
                winDialog.show();

            }
            else if(selectedBoxPosition == 9){
                winDialog winDialog = new winDialog(tictactoe.this ,  "It is Draw !" , tictactoe.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else {

                changePlayerTurn(1);
                TotalSelectedBoxes++;
            }
        }

    }
    private void changePlayerTurn (int currentPlayerTurn){
        playerTurn = currentPlayerTurn;
        if(playerTurn == 1){
            playerOneLayout.setBackgroundResource(R.drawable.round_black_blue_border);
            playerTwoLayout.setBackgroundResource(R.drawable.round_back_dark_blue);
        }
        else{
            playerOneLayout.setBackgroundResource(R.drawable.round_back_dark_blue);
            playerTwoLayout.setBackgroundResource(R.drawable.round_black_blue_border);
        }
    }
    private boolean checkPlayerWin(){
        boolean response = false ;
        for(int i=0 ; i<combinationsList.size() ; i++){
            int[] combination = combinationsList.get(i);

            if(boxPositions[combination[0]]  ==  playerTurn && boxPositions[combination[1]] == playerTurn && boxPositions[combination[2]] == playerTurn ) {
                response = true;
            }
        }
        return response;
    }
    public void restartTheMatch(){
        boxPositions = new int[] {0,0,0,0,0,0,0,0,0};
        playerTurn =  1;
        TotalSelectedBoxes = 1;
        image1.setImageResource(R.drawable.transparent);
        image2.setImageResource(R.drawable.transparent);
        image3.setImageResource(R.drawable.transparent);
        image4.setImageResource(R.drawable.transparent);
        image5.setImageResource(R.drawable.transparent);
        image6.setImageResource(R.drawable.transparent);
        image7.setImageResource(R.drawable.transparent);
        image8.setImageResource(R.drawable.transparent);
        image9.setImageResource(R.drawable.transparent);

    }
}