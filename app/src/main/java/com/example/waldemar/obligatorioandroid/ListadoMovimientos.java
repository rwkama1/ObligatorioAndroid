package com.example.waldemar.obligatorioandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.waldemar.obligatorioandroid.DataTypes.DTMaterial;
import com.example.waldemar.obligatorioandroid.DataTypes.DTMovimiento;
import com.example.waldemar.obligatorioandroid.Persistencia.PersistenciaMaterial;
import com.example.waldemar.obligatorioandroid.Persistencia.PersistenciaMovimiento;

import java.util.ArrayList;

public class ListadoMovimientos extends AppCompatActivity {
DTMaterial material;
ListView lvMovimiento;
ArrayList<DTMovimiento> listaMovimiento=null;
AdapterMovimiento adapterMovimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_movimientos);
        lvMovimiento=findViewById(R.id.lvMovimientos);
        Bundle extras = getIntent().getExtras();
        material = (DTMaterial)extras.getSerializable("materialenviado");
        material = PersistenciaMaterial.buscarMateriales(this,material.getIdmaterial());

        listaMovimiento=material.getListMovimiento();

        adapterMovimiento=new AdapterMovimiento(this,listaMovimiento);
        lvMovimiento.setAdapter(adapterMovimiento);
    }

    public void btnAMovOnClick(View view) {
        Intent iAMov = new Intent(this, AgregarMovimiento.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("movimiento",material);
        iAMov.putExtras(bundle);
        startActivity(iAMov);

    }

    public void btnActualizarMovOnClick(View view) {
        material = PersistenciaMaterial.buscarMateriales(this,material.getIdmaterial());
        listaMovimiento=material.getListMovimiento();
        adapterMovimiento=new AdapterMovimiento(this,listaMovimiento);
        lvMovimiento.setAdapter(adapterMovimiento);

    }
}
