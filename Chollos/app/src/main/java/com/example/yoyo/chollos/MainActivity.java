package com.example.yoyo.chollos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;

import android.widget.Button;


public class MainActivity extends Activity {
    private EditText user;
    private EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonLogin = (Button) findViewById(R.id.btn_login);
        user = (EditText) findViewById(R.id.et_user) ;
        pass = (EditText) findViewById(R.id.et_pass) ;
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent DashBoard = new Intent(getApplicationContext(), DashBoardActivity.class);
                DashBoard.putExtra("user", user.getText().toString());
                DashBoard.putExtra("pass", pass.getText().toString());
                startActivity(DashBoard);
            }
        });

    }
}
