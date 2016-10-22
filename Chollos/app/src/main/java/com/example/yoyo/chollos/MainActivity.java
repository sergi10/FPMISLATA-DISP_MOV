package com.example.yoyo.chollos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.view.View;

import android.widget.Button;
import android.widget.Toast;

import com.example.yoyo.chollos.api.MisChollosAPI;
import com.example.yoyo.chollos.pojo.Usuario;


public class MainActivity extends Activity {
    private EditText loginuser;
    private EditText loginpass;
    private Usuario user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface font = Typeface.createFromAsset( getAssets(), "fonts/fontawesome-webfont.ttf" );


        final MisChollosAPI api = MisChollosAPI.getInstance(this.getApplicationContext());
        user = new Usuario();
        Button buttonLogin = (Button) findViewById(R.id.btn_login);
        loginuser = (EditText) findViewById(R.id.et_user) ;
        loginuser.setText("11111111A");
        loginpass = (EditText) findViewById(R.id.et_pass) ;
        loginpass.setText("1234");
        Button button = (Button)findViewById( R.id.buttonFont );
        button.setTypeface(font);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent DashBoard = new Intent(getApplicationContext(), DashBoardActivity.class);
                user.setClaveSeguridad(loginpass.getText().toString());
                user.setNif(loginuser.getText().toString());
                if (api.login(user) == null){
                    Toast.makeText(v.getContext(), "\nEl nuevo usuario o password NO validos\nvuelva a intentarlo.", Toast.LENGTH_SHORT).show();
                    Log.i("\n\nbuttonLogin","\n" +
                            "El nuevo usuario o password NO validos\n\n");
                    this.resetInputs();
                }
                else{
                    DashBoard.putExtra("user", loginuser.getText().toString());
                    DashBoard.putExtra("pass", loginpass.getText().toString());
                    DashBoard.putExtra("logedOK", user);
                    startActivity(DashBoard);
                }

            }

            private void resetInputs() {
                loginuser.setText("");
                loginpass.setText("");
                loginuser.requestFocus();
            }
        });

    }
}
