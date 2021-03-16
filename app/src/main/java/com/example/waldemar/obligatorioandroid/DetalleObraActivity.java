package com.example.waldemar.obligatorioandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.waldemar.obligatorioandroid.DataTypes.DTMaterial;
import com.example.waldemar.obligatorioandroid.DataTypes.DTObra;
import com.example.waldemar.obligatorioandroid.Persistencia.PersistenciaMaterial;

import java.util.ArrayList;

public class DetalleObraActivity extends AppCompatActivity {

    DetalleObraFragment frgDetalleObra;

    DTObra obra;
public static final String obraenviada="obraenviada";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalle_obra);

        frgDetalleObra = (DetalleObraFragment)getSupportFragmentManager().findFragmentById(R.id.frgDetalleObra);

        Bundle extras = getIntent().getExtras();
        obra = (DTObra)extras.getSerializable(MainActivity.EXTRA_OBRA);
    }

    @Override
    protected void onStart() {
        super.onStart();

        frgDetalleObra.mostrarObra(obra);
    }

    public void btnListarMatOnClick(View v) {

        Intent intencionListarMat = new Intent(this, ListarMaterialesActivity.class);
       intencionListarMat.putExtra(obraenviada,obra);
       startActivity(intencionListarMat);

    }

}
