package com.example.yoyo.ciudades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {
    public Spinner ciudades_Spinner;
    public Spinner paises_Spinner;
    public TextView nombreCiudad;
    public String paisSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicializar los componentes
        paises_Spinner = (Spinner) findViewById(R.id.paises);
        ciudades_Spinner = (Spinner) findViewById(R.id.ciudades);
        nombreCiudad = (TextView) findViewById(R.id.texto);
        initSpinner();







       /* setContentView(R.layout.activity_main);
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
*/
    }
    public class MyOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (parent.getId() == R.id.paises) {
                



                paisSelected = (parent.getItemAtPosition(position).toString());
                nombreCiudad.setText(paisSelected);
            }
            if (parent.getId() == R.id.ciudades) {
                paisSelected = (parent.getItemAtPosition(position).toString());
                nombreCiudad.setText(paisSelected);
            }
            //Podemos hacer varios ifs o un switchs por si tenemos varios spinners.
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private void initSpinner() {
        // Creamos el adaptador
        ArrayAdapter<CharSequence> adapterPaises = ArrayAdapter.createFromResource(this, R.array.paises, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.ciudadesespana, android.R.layout.simple_spinner_item);
        // Creamos el Listener
        AdapterView.OnItemSelectedListener escuchador = new  MyOnItemSelectedListener();
        // Elegimos el tipo grafico de spinner
        adapterPaises.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
        //Le indicamos al spinner el adaptador a usar
        paises_Spinner.setAdapter(adapterPaises);
        ciudades_Spinner.setAdapter(adapter);
        // Le añadimos el listener al spinner
        paises_Spinner.setOnItemSelectedListener(escuchador);
        ciudades_Spinner.setOnItemSelectedListener(escuchador);
       // this.ciudades_Spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
    }
    }



/*
    public void onItemSelectedListener(){
            nombreCiudad.setText(ciudades_Spinner.getSelectedItem().toString());
            //nombreCiudad.setText(parent.getSelectedItem().toString());
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }
    */

