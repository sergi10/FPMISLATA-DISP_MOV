package com.example.yoyo.ciudades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {
    private Spinner ciudades_Spinner;
    private Spinner paises_Spinner;
    private TextView nombreCiudad;
    private String ciudadSelected;
    private ArrayAdapter<CharSequence> adapterCiudad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicializar los componentes
        paises_Spinner = (Spinner) findViewById(R.id.paises);
        ciudades_Spinner = (Spinner) findViewById(R.id.ciudades);
        nombreCiudad = (TextView) findViewById(R.id.texto);
        initSpinner();
    }
    public class MyOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (parent.getId()) {
                case R.id.paises:
                   if (paises_Spinner.getSelectedItem().toString().equals("Alemania"))
                    {
                        adapterCiudad = ArrayAdapter.createFromResource(getApplicationContext(), R.array.ciudadesalemania, android.R.layout.simple_spinner_item);
                        adapterCiudad.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
                        ciudades_Spinner.setAdapter(adapterCiudad);
                    }
                    else if (paises_Spinner.getSelectedItem().toString().equals("Francia"))
                    {
                        adapterCiudad = ArrayAdapter.createFromResource(getApplicationContext(), R.array.ciudadesfrancia, android.R.layout.simple_spinner_item);
                        adapterCiudad.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
                        ciudades_Spinner.setAdapter(adapterCiudad);
                    }
                   else if (paises_Spinner.getSelectedItem().toString().equals("España"))
                   {
                       adapterCiudad = ArrayAdapter.createFromResource(getApplicationContext(), R.array.ciudadesespana, android.R.layout.simple_spinner_item);
                       adapterCiudad.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
                       ciudades_Spinner.setAdapter(adapterCiudad);
                   }
                    break;
                case R.id.ciudades:
                    ciudadSelected = (parent.getItemAtPosition(position).toString());
                    nombreCiudad.setText(ciudadSelected);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private void initSpinner() {
        // Creamos el adaptador
        ArrayAdapter<CharSequence> adapterPaises = ArrayAdapter.createFromResource(this, R.array.paises, android.R.layout.simple_spinner_item);
        adapterCiudad = ArrayAdapter.createFromResource(this, R.array.ciudadesespana, android.R.layout.simple_spinner_item);
        // Creamos el Listener
        AdapterView.OnItemSelectedListener escuchador = new  MyOnItemSelectedListener();
        // Elegimos el tipo grafico de spinner
        adapterPaises.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        adapterCiudad.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        //Le indicamos al spinner el adaptador a usar
        paises_Spinner.setAdapter(adapterPaises);
        ciudades_Spinner.setAdapter(adapterCiudad);
        // Le añadimos el listener al spinner
        paises_Spinner.setOnItemSelectedListener(escuchador);
        ciudades_Spinner.setOnItemSelectedListener(escuchador);
       // this.ciudades_Spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
    }
}
