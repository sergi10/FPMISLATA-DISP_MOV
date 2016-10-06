package com.example.yoyo.chollos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;

public class DashBoardActivity extends AppCompatActivity {
    private TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        msg = (TextView) findViewById(R.id.lbl_welcom) ;
        Bundle bundle = getIntent().getExtras();
        msg.setText("Bienvenido : \n" + bundle.getString("user") + "\nusando el password: \n" + bundle.getString("pass") );

        Button buttonLogOut = (Button) findViewById(R.id.btn_logout);
        buttonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Login = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(Login);
            }
        });
    }
}
