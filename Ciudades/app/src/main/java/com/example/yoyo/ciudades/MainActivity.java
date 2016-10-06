package com.example.yoyo.ciudades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner ciudades_Spinner;
    private Spinner paises_Spinner;
    private TextView nombreCiudad;
    public ArrayAdapter<CharSequence> adapterCiudades;
    public ArrayAdapter<CharSequence> adapterPaises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombreCiudad = (TextView) findViewById(R.id.texto);
        ciudades_Spinner = (Spinner) findViewById(R.id.ciudades);
        //ciudades_Spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        paises_Spinner = (Spinner) findViewById(R.id.paises);
        final AdapterView.OnItemSelectedListener onItemSelectedListener = paises_Spinner.getOnItemSelectedListener();
        adapterPaises = ArrayAdapter.createFromResource(this,
                R.array.paises, android.R.layout.simple_spinner_item);
        adapterPaises.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paises_Spinner.setAdapter(adapterPaises);
        paises_Spinner.setOnItemSelectedListener(this);

    }
    public void onItemSelectedListener(){
        if (paises_Spinner.getSelectedItem().toString().equals("España"))
        {
            adapterCiudades= ArrayAdapter.createFromResource(this, R.array.ciudadesespana, android.R.layout.simple_spinner_dropdown_item);
        }
        else if (paises_Spinner.getSelectedItem().toString().equals("Alemania"))
        {
            adapterCiudades= ArrayAdapter.createFromResource(this, R.array.ciudadesalemania, android.R.layout.simple_spinner_dropdown_item);
        }
        else if (paises_Spinner.getSelectedItem().toString().equals("Francia"))
        {
            adapterCiudades= ArrayAdapter.createFromResource(this, R.array.ciudadesfrancia, android.R.layout.simple_spinner_dropdown_item);
        }
        ciudades_Spinner.setAdapter(adapterCiudades);
        ciudades_Spinner.setOnItemSelectedListener(this);
    }
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            nombreCiudad.setText(ciudades_Spinner.getSelectedItem().toString());
            //nombreCiudad.setText(parent.getSelectedItem().toString());
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }
}
