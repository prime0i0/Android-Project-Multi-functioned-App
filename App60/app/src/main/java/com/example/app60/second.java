package com.example.app60;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import java.util.concurrent.TimeUnit;

public class second extends AppCompatActivity {

    EditText e1;
    Button b1;
    FirebaseAuth firebaseAuth;
    String phone;
    String otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("OTP Verification");
        phone=getIntent().getStringExtra("mobile").toString();
        e1=(EditText) findViewById(R.id.editText2);
        b1=(Button) findViewById(R.id.button2);
        firebaseAuth=FirebaseAuth.getInstance();
        genotp();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                if(s1.isEmpty())
                {
                    e1.setError("fill otp");
                    return;
                }
                else
                {
                    if(s1.length()!=6)
                    {
                        e1.setError("wrong number");
                        return;
                    }
                    else
                    {
                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(otp,s1);
                        signInWithPhoneAuthCredential(credential);

                    }
                }
            }
        });

    }

    private void genotp()
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,
                60,
                TimeUnit.SECONDS,
                this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        otp=s;
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                        PhoneAuthCredential PhoneAuthCredential = null;
                        signInWithPhoneAuthCredential(PhoneAuthCredential);

                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {

                        Toast.makeText(second.this, "Wrong OTP", Toast.LENGTH_SHORT).show();

                    }
                }
        );
    }

    private void signInWithPhoneAuthCredential (PhoneAuthCredential credential)
    {
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(second.this, "Login Successful !!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(second.this , all.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(second.this, "Wrong OTP !", Toast.LENGTH_SHORT).show();
                }
            }
        }
        );
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