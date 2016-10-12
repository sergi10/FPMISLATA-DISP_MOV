package com.example.yoyo.chollos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassActivity extends AppCompatActivity {
    private EditText oldPass;
    private EditText newPass;
    private EditText reNewPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
        Button buttonChangePass = (Button) findViewById(R.id.btn_changePassword);
        oldPass = (EditText) findViewById(R.id.et_curentpass) ;
        newPass = (EditText) findViewById(R.id.et_newpass) ;
        reNewPass = (EditText) findViewById(R.id.et_repeatPass) ;
        oldPass.requestFocus();
        buttonChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent DashBoard = new Intent(getApplicationContext(), DashBoardActivity.class);
              /*
               if (newPass.getText().toString() != reNewPass.getText().toString()){
                   Toast.makeText(v.getContext(), "\nEl nuevo password NO coincide\nvuelva a intentarlo.", Toast.LENGTH_SHORT).show();
                   Log.d( "\n\nbuttonChangePass","newPass != reNewPass\n\n");
                   oldPass.setText("");
                   newPass.setText("");
                   reNewPass.setText("");
                   oldPass.requestFocus();
               }
               */
                startActivity(DashBoard);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

}
