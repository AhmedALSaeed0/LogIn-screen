package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button loginButton;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton=findViewById(R.id.loginButton);
        email=findViewById(R.id.inputEmail);
        password=findViewById(R.id.inputPassword);
        DataBase db=new DataBase(this);
        ArrayList n=db.GetDataName();
        ArrayList p=db.GetDataPassword();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if((n.get(0).toString()).equalsIgnoreCase((email.getText()).toString()))
                    {
                        if((p.get(0).toString()).equalsIgnoreCase(String.valueOf((password.getText()))))
                            Toast.makeText(getApplicationContext(),"Welcome Ahmed",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getApplicationContext(),"Wrong Password",Toast.LENGTH_LONG).show();
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Wrong Email",Toast.LENGTH_LONG).show();

            }
        });
    }
}