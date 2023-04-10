package com.example.app60;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class winDialog extends Dialog  {

    private final String message ;
    private final tictactoe tictactoe;


    public winDialog(@NonNull Context context , String message , tictactoe tictactoe) {
        super(context);
        this.message = message ;
        this.tictactoe = tictactoe ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_dialog_layoutr);

        TextView messageTxt = (TextView) findViewById(R.id.messageTxt);
        Button startAgainBtn = (Button) findViewById(R.id.startAgainBtn);

        messageTxt.setText(message);

        startAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tictactoe.restartTheMatch();
                dismiss();

            }
        });
    }
}
