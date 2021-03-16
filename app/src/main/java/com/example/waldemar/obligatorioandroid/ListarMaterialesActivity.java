package com.example.waldemar.obligatorioandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.waldemar.obligatorioandroid.DataTypes.DTMaterial;
import com.example.waldemar.obligatorioandroid.DataTypes.DTObra;
import com.example.waldemar.obligatorioandroid.Persistencia.PersistenciaMaterial;
import com.example.waldemar.obligatorioandroid.Persistencia.PersistenciaObra;

import java.util.ArrayList;

public class ListarMaterialesActivity extends AppCompatActivity implements ListarMaterialesFragment.OnMaterialSeleccionadoListener {
    public static final String EXTRA_MATERIAL = "EXTRA_MATERIAL";
DTObra obraMatActivity;
ListarMaterialesFragment frgLM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_materiales);
        frgLM=(ListarMaterialesFragment) getSupportFragmentManager().findFragmentById(R.id.frgListadoMaterial);
        Bundle extras = getIntent().getExtras();
        obraMatActivity = (DTObra)extras.getSerializable(DetalleObraActivity.obraenviada);
    }

    public void btnAgregarMatOnClick(View view) {
        Intent intencionAgregarMat = new Intent(this, AgregarMaterial.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("obramat",obraMatActivity);
        intencionAgregarMat.putExtras(bundle);
        startActivity(intencionAgregarMat);

    }

    public void btnFiltrarsinStockOnClick(View view) {


       frgLM.filtrosinStock(obraMatActivity);
    }

    public void btnFiltrarconStockOnClick(View view) {
        frgLM.filtroconStock(obraMatActivity);

    }

    @Override
    public void onMaterialSeleccionado(DTMaterial material) {
        DetalleMaterialFragment frgDetalleMaterial = (DetalleMaterialFragment)getSupportFragmentManager().findFragmentById(R.id.frgDetalleMaterial);

        if (frgDetalleMaterial != null) {
            frgDetalleMaterial.mostrarMaterial(material);
        } else {
            Intent intencionDetalleMaterial = new Intent(this, DetalleMaterialActivity.class);
            intencionDetalleMaterial.putExtra(EXTRA_MATERIAL, material);

            startActivity(intencionDetalleMaterial);
        }
    }

    public void btnActualizarOnClick(View view) {

        frgLM.actualizarLista(obraMatActivity);
    }
}
