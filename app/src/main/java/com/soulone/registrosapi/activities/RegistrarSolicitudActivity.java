package com.soulone.registrosapi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.soulone.registrosapi.Interfaces.configuracionRetrofit;
import com.soulone.registrosapi.R;
import com.soulone.registrosapi.models.Solicitud;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrarSolicitudActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerTipo;
    private EditText correoText;
    private EditText descText;
    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_solicitud);

        spinnerTipo=findViewById(R.id.spTypeSolicitud);
        correoText=findViewById(R.id.tilCorreo2);
        descText=findViewById(R.id.etMontico);
        register=findViewById(R.id.buttonRegistrar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createSolicitud();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private void createSolicitud(){
        String tipo=spinnerTipo.getSelectedItem().toString();
        String correo=correoText.getText().toString();
        String des=descText.getText().toString();

        Solicitud solicitud=new Solicitud(correo,tipo,des);
        Call<Solicitud> solicitudCall= configuracionRetrofit.jsonApiRetrofit().createSolicitud(solicitud);
        solicitudCall.enqueue(new Callback<Solicitud>() {
            @Override
            public void onResponse(Call<Solicitud> call, Response<Solicitud> response) {
                Toast.makeText(getApplicationContext(),"Agregado correctamente",Toast.LENGTH_SHORT);
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }

            @Override
            public void onFailure(Call<Solicitud> call, Throwable t) {

            }
        });

    }
}

