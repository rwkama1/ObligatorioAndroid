package com.example.waldemar.obligatorioandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.waldemar.obligatorioandroid.DataTypes.DTMaterial;
import com.example.waldemar.obligatorioandroid.DataTypes.DTMovimiento;
import com.example.waldemar.obligatorioandroid.Persistencia.PersistenciaMaterial;
import com.example.waldemar.obligatorioandroid.Persistencia.PersistenciaMovimiento;


public class AgregarMovimiento extends AppCompatActivity {
DTMaterial materialmov;
EditText etCantidad;
EditText etObservacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_movimiento);
        etCantidad=(EditText) findViewById(R.id.etCantidad);
        etObservacion=(EditText) findViewById(R.id.etObservacion);

        Bundle objetoenviado=getIntent().getExtras();
        materialmov=(DTMaterial) objetoenviado.getSerializable("movimiento");


    }

    public void btnAgregarMovimientoOnClick(View view) {
        if (etCantidad.getText().toString().equals("")||etObservacion.getText().toString().equals("")) {
            Toast.makeText(this,"Algunos campos quedaron vacios",Toast.LENGTH_LONG).show();
        }
        else
        {
            DTMovimiento movi = new DTMovimiento(Integer.parseInt(etCantidad.getText().toString()),etObservacion.getText().toString());
            materialmov.getListMovimiento().add(movi);
            PersistenciaMovimiento.agregarMovimiento(this, materialmov);
            Toast.makeText(this,"Se agrego el movimiento correctamente",Toast.LENGTH_LONG).show();
            etCantidad.setText("");
            etObservacion.setText("");

        }
    }
}
