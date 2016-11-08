package com.example.david.dpsproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends navigation {

    EditText userName;
    EditText userPassword;
    EditText passwordConfirm;
    Button signUp;
    ProgressDialog pDialog;
    //Firebase variables
    FirebaseAuth authentication;
    DatabaseReference dbReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText)findViewById(R.id.userName);
        userPassword = (EditText)findViewById(R.id.userPassword);
        passwordConfirm =(EditText)findViewById(R.id.passwordConfirm);
        signUp =(Button)findViewById(R.id.signup);


        authentication= FirebaseAuth.getInstance(); // get instance of my firebase console
        dbReference = FirebaseDatabase.getInstance().getReference(); // access to database

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewAccount(userName.getText().toString(),userPassword.getText().toString());
                ShowProgressDialog();
            }
        });

    }


    protected void createNewAccount(final String email, final String password){
        authentication.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                HideProgressDialog();
                if(!(task.isSuccessful())){
                    Toast.makeText(MainActivity.this,"authentication failed",Toast.LENGTH_SHORT).show();
                }
                else{
                    Users u = new Users(email,password);
                    dbReference.child("Users").child(task.getResult().getUser().getUid()).setValue(u);
                    Intent front_page = new Intent(getApplicationContext(),LogIn.class);
                    startActivity(front_page);
                }
            }
        });
    }
    public void ShowProgressDialog() {
        if (pDialog == null) {
            pDialog = new ProgressDialog(this);
            pDialog.setMessage("Creating New Account");
            pDialog.setIndeterminate(true);
        }
        pDialog.show();
    }
    public void HideProgressDialog() {
        if(pDialog!=null && pDialog.isShowing()){
            pDialog.dismiss();
        }
    }
}
