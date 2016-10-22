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

import com.example.yoyo.chollos.api.MisChollosAPI;
import com.example.yoyo.chollos.pojo.Usuario;

public class ChangePassActivity extends AppCompatActivity {
    private EditText oldPass;
    private EditText newPass;
    private EditText reNewPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
        final MisChollosAPI api = MisChollosAPI.getInstance(this.getApplicationContext());
        final Usuario user = new Usuario();
        Button buttonChangePass = (Button) findViewById(R.id.btn_changePassword);
        oldPass = (EditText) findViewById(R.id.et_curentpass) ;
        newPass = (EditText) findViewById(R.id.et_newpass) ;
        reNewPass = (EditText) findViewById(R.id.et_repeatPass) ;
        oldPass.requestFocus();
        buttonChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent DashBoard = new Intent(getApplicationContext(), DashBoardActivity.class);
                if (oldPass.getText().toString().length() == 0){
                   Toast.makeText(v.getContext(), "\nEl password NO puede ser vacio\nvuelva a intentarlo.", Toast.LENGTH_SHORT).show();
                   Log.d( "\n\nbuttonChangePass","oldPass == null\n\n");
                   this.resetInputs();
                }else if ((newPass.getText().toString().equals(reNewPass.getText().toString())) && (newPass.getText().toString().length() >0)){
                    user.setClaveSeguridad(newPass.getText().toString());
                    api.changePassword(user);
                    Toast.makeText(v.getContext(), "\nSe ha cambiado el password.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(v.getContext(), "\nEl nuevo password NO coincide\nvuelva a intentarlo.\nnewPass= "  + newPass.getText().toString() + " \nreNewPass= " +reNewPass.getText().toString()+" !!!", Toast.LENGTH_SHORT).show();
                    Log.d( "\n\nbuttonChangePass","newPass= "  + newPass.getText().toString() + " reNewPass= " +reNewPass.getText().toString() );
                    this.resetInputs();
               }
                startActivity(DashBoard);
            }

            private void resetInputs() {
                oldPass.setText("");
                newPass.setText("");
                reNewPass.setText("");
                oldPass.requestFocus();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

}
