package com.example.waldemar.obligatorioandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.waldemar.obligatorioandroid.DataTypes.DTMaterial;


public class DetalleMaterialActivity extends AppCompatActivity {

    DetalleMaterialFragment frgDetalleMaterial;
    DTMaterial material;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_material);
        frgDetalleMaterial = (DetalleMaterialFragment) getSupportFragmentManager().findFragmentById(R.id.frgDetalleMaterial);

        Bundle extras = getIntent().getExtras();
        material = (DTMaterial) extras.getSerializable(ListarMaterialesActivity.EXTRA_MATERIAL);
    }

    @Override
    protected void onStart() {
        super.onStart();

        frgDetalleMaterial.mostrarMaterial(material);
    }


    public void btnModificarOnClick(View view) {
        frgDetalleMaterial.modificarMaterial(material);
    }

    public void btnIraMovOnClick(View view) {
        Intent imov = new Intent(this, ListadoMovimientos.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("materialenviado",material);
        imov.putExtras(bundle);
        startActivity(imov);
    }
}
