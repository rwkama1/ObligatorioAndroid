package com.example.waldemar.obligatorioandroid;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.example.waldemar.obligatorioandroid.DataTypes.DTObra;
import com.example.waldemar.obligatorioandroid.Persistencia.PersistenciaObra;
import com.example.waldemar.obligatorioandroid.Persistencia.SQLiteContrato;
import com.example.waldemar.obligatorioandroid.Persistencia.SQLiteHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaObraFragment extends Fragment {

    public static ListaObraFragment getInstance() {
        return new ListaObraFragment();
    }

    ArrayList<DTObra> listaObra;


    protected GridView gvObras;

    protected OnObraSeleccionadaListener onObraSeleccionadaListener;

    public ListaObraFragment() {

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnObraSeleccionadaListener) {
            onObraSeleccionadaListener = (OnObraSeleccionadaListener)context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lista_obra, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        gvObras= getView().findViewById(R.id.gvObras);



        listaObra=PersistenciaObra.listarObras(getActivity());

        AdaptadorObra adapterObra=new AdaptadorObra(getActivity(),listaObra);
        gvObras.setAdapter(adapterObra);

        gvObras.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                gvObrasOnItemClick(parent, view, position, id);
            }

        });
    }


    protected void gvObrasOnItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (onObraSeleccionadaListener != null) {
            onObraSeleccionadaListener.onObraSeleccionada((DTObra)parent.getItemAtPosition(position));
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();

        onObraSeleccionadaListener = null;
    }

    public interface OnObraSeleccionadaListener {

        void onObraSeleccionada(DTObra obra);

    }

}
