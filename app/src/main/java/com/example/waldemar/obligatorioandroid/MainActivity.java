package com.example.waldemar.obligatorioandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.waldemar.obligatorioandroid.DataTypes.DTObra;

public class MainActivity extends AppCompatActivity implements ListaObraFragment.OnObraSeleccionadaListener {
    public static final String EXTRA_OBRA = "EXTRA_OBRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public void onObraSeleccionada(DTObra obra) {
        DetalleObraFragment frgDetalleObra = (DetalleObraFragment)getSupportFragmentManager().findFragmentById(R.id.frgDetalleObra);

        if (frgDetalleObra != null) {
            frgDetalleObra.mostrarObra(obra);
        } else {
            Intent intencionDetalleObra = new Intent(this, DetalleObraActivity.class);
            intencionDetalleObra.putExtra(EXTRA_OBRA, obra);

            startActivity(intencionDetalleObra);
        }

    }
}
