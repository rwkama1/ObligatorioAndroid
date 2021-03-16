package com.example.waldemar.obligatorioandroid;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.waldemar.obligatorioandroid.DataTypes.DTMaterial;
import com.example.waldemar.obligatorioandroid.Persistencia.PersistenciaMaterial;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleMaterialFragment extends Fragment {

    protected TextView tvnombreMat;
    protected EditText tvDescripcionMat;
    protected TextView tvFechaAlta;
    protected TextView tvStockMat;

    public DetalleMaterialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_material, container, false);


    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        tvnombreMat = (TextView) getView().findViewById(R.id.tvNombre);
        tvDescripcionMat =getView().findViewById(R.id.etDescripcion);
        tvFechaAlta = (TextView)getView().findViewById(R.id.tvFecha);
        tvStockMat = (TextView)getView().findViewById(R.id.tvStock);


    }

    public void mostrarMaterial(DTMaterial material) {
        tvnombreMat.setText("Nombre: "+material.getNombreMaterial());
        tvDescripcionMat.setText(material.getDescripcion());
        tvFechaAlta.setText("Fecha Alta: "+material.getFechaMaterial());
        tvStockMat.setText("Stock: "+String.valueOf(material.getStock()));

    }
    public void modificarMaterial(DTMaterial material)
    {
        if (tvDescripcionMat.getText().toString().equals("")) {
            Toast.makeText(getActivity(),"La Descripción esta vacía",Toast.LENGTH_LONG).show();
        }
        else
        {
          material.setDescripcion(tvDescripcionMat.getText().toString());
            PersistenciaMaterial.modificarMaterial(getActivity(), material);
            Toast.makeText(getActivity(),"Se modifico el material correctamente",Toast.LENGTH_LONG).show();
        }
    }

}
