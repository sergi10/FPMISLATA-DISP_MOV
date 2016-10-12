package com.example.yoyo.chollos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DashBoardActivity extends AppCompatActivity {
    private TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        msg = (TextView) findViewById(R.id.lbl_welcom);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            msg.setText("Bienvenido : \n" + bundle.getString("user") + "\nusando el password: \n" + bundle.getString("pass"));
        }

        Button buttonLogOut = (Button) findViewById(R.id.btn_logout);
        buttonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Login = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(Login);
            }
        });
        Button btnPulsar = (Button) findViewById(R.id.btn_pulsar);
        btnPulsar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btnPulsado();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

       // int id = item.getItemId();
        switch (item.getItemId()){
            case (R.id.lbl_menuSalir):
                Log.d( "\n\nMenu","Elegida la opcion lbl_menuSalir\n\n");
                finish();
                break;
            case R.id.lbl_menuAbout:
                Log.d( "\n\nMenu","Elegida la opcion lbl_menuAbout\n\n");
                Intent about = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(about);
                //return true;
                break;
            case R.id.lbl_menu_Buscador:
                Toast.makeText(this, "\nElegida la opcion lbl_menu_Buscador\n", Toast.LENGTH_SHORT).show();
                Log.d( "\n\nMenu","Elegida la opcion lbl_menu_Buscador\n\n");
                break;
            case R.id.lbl_menuChangepass:
                Log.d( "\n\nMenu","Elegida la opcion lbl_menuChangepass\n\n");
                Intent changepass = new Intent(getApplicationContext(), ChangePassActivity.class);
                startActivity(changepass);
                break;
            case R.id.lbl_menuChollosDisponibles:
                Toast.makeText(this, "\nElegida la opcion lbl_menuChollosDisponibles\n", Toast.LENGTH_SHORT).show();
                Log.d( "\n\nMenu","Elegida la opcion lbl_menuChollosDisponibles\n\n");
                break;
            case R.id.lbl_menuContacto:
                Toast.makeText(this, "\nElegida la opcion lbl_menuContacto\n", Toast.LENGTH_SHORT).show();
                Log.d( "\n\nMenu","Elegida la opcion lbl_menuContacto\n\n");
                break;
            case R.id.lbl_menuLocalizador:
                Toast.makeText(this, "\nElegida la opcion lbl_menuLocalizador\n", Toast.LENGTH_SHORT).show();
                Log.d( "\n\nMenu","Elegida la opcion lbl_menuLocalizador\n\n");
                break;
            case R.id.lbl_menuTopChollos:
                Toast.makeText(this, "\nElegida la opcion lbl_menuTopChollos\n", Toast.LENGTH_SHORT).show();
                Log.d( "\n\nMenu","Elegida la opcion lbl_menuTopChollos\n\n");
                break;
            default:
                return false;
        }
        return super.onOptionsItemSelected(item);
    }

    public void btnPulsado() {
        Toast.makeText(this, "Pulsado", Toast.LENGTH_SHORT).show();
    }
}
