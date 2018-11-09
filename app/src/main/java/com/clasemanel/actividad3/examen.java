package com.clasemanel.actividad3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class examen extends AppCompatActivity {

    private EditText nombre;
    private EditText horas;

    private Button guardar;
    private Button horasTiene;

    private MyDBAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen);

        nombre = (EditText) findViewById(R.id.examen_nombre);
        horas = (EditText) findViewById(R.id.examen_horas);

        guardar = (Button) findViewById(R.id.examen_guardar);
        horasTiene  = (Button) findViewById(R.id.examen_horasTiene);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adaptador = new MyDBAdapter(getApplicationContext());
                adaptador.open();

                adaptador.insertarAsignatura(nombre.getText().toString(), horas.getText().toString());
            }
        });

        horasTiene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adaptador = new MyDBAdapter(getApplicationContext());
                adaptador.open();

                horas.setText(adaptador.recuperarHorasAsignatura(nombre.getText().toString()));
            }
        });
    }
}
