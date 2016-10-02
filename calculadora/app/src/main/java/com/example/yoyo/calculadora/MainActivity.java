package com.example.yoyo.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView texto = new TextView(this);
        texto.setText("Holaaa Android!!!");
        setContentView(R.layout.activity_main);

    }
}
