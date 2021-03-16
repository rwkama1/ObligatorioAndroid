package com.example.waldemar.obligatorioandroid;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.waldemar.obligatorioandroid.DataTypes.DTObra;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleObraFragment extends Fragment {


    public static DetalleObraFragment getInstance() {
        return new DetalleObraFragment();
    }



    protected ImageView imgvImagen;
    TextView tvId;
    protected TextView tvCuadrados;
    protected TextView tvDireccion;
    protected TextView tvFecha;
    protected TextView tvCliente;


    public DetalleObraFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalle_obra, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        imgvImagen = (ImageView)getView().findViewById(R.id.imgvImagen);
        tvId = (TextView) getView().findViewById(R.id.tvId);
        tvCuadrados = (TextView)getView().findViewById(R.id.tvCuadrados);
        tvDireccion = (TextView)getView().findViewById(R.id.tvDireccion);
        tvFecha = (TextView)getView().findViewById(R.id.tvFecha);
        tvCliente = (TextView)getView().findViewById(R.id.tvCliente);

    }

    public void mostrarObra(DTObra obra) {

        int idImagenObra = getResources().getIdentifier("obra" + obra.getId(), "drawable", getActivity().getPackageName());
        imgvImagen.setImageResource(idImagenObra);
        tvId.setText(String.valueOf("ID: "+obra.getId()));
        tvCuadrados.setText(String.valueOf("Metros Cuadrados: "+obra.getMetroscuadrados()));
        tvDireccion.setText("Direccion: "+obra.getDireccion());
        tvFecha.setText("Fecha Contrato: "+obra.getFechaContrato());
        tvCliente.setText("Nombre Cliente: "+obra.getNombreCliente());

    }
    /*
    public void btnListarMatOnClick(View v) {


        Intent intencionListarMat = new Intent(getActivity().getApplicationContext(), ListarMaterialesFragment.class);
        startActivity(intencionListarMat);


    }
*/

}
