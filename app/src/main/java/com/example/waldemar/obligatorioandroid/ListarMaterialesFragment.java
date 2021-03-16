package com.example.waldemar.obligatorioandroid;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.waldemar.obligatorioandroid.DataTypes.DTMaterial;
import com.example.waldemar.obligatorioandroid.DataTypes.DTObra;
import com.example.waldemar.obligatorioandroid.Persistencia.PersistenciaMaterial;
import com.example.waldemar.obligatorioandroid.Persistencia.PersistenciaObra;


import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListarMaterialesFragment extends Fragment {


    public static ListarMaterialesFragment getInstance() {
        return new ListarMaterialesFragment();
    }
    DTObra obra=null;
    ArrayList<DTMaterial> listaMateriales=null;
    AdaptadorMaterial adapterMaterial=null;




    protected ListView lvMateriales;

    protected ListarMaterialesFragment.OnMaterialSeleccionadoListener onMaterialSeleccionadoListener;

    public ListarMaterialesFragment() {

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof ListarMaterialesFragment.OnMaterialSeleccionadoListener) {
            onMaterialSeleccionadoListener = (ListarMaterialesFragment.OnMaterialSeleccionadoListener)context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listar_materiales, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle extras = getActivity().getIntent().getExtras();
        obra = (DTObra)extras.getSerializable(DetalleObraActivity.obraenviada);
        lvMateriales=getView().findViewById(R.id.lvMateriales);
        obra = PersistenciaObra.buscarObra(getActivity(),obra.getId());
        listaMateriales=obra.getListMateriales();
        adapterMaterial=new AdaptadorMaterial(getActivity(),listaMateriales);
        lvMateriales.setAdapter(adapterMaterial);


        lvMateriales.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lvMaterialesOnItemClick(parent, view, position, id);
            }

        });

    }

    protected void lvMaterialesOnItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (onMaterialSeleccionadoListener != null) {
            onMaterialSeleccionadoListener.onMaterialSeleccionado((DTMaterial) parent.getItemAtPosition(position));
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();

        onMaterialSeleccionadoListener = null;
    }

public void filtroconStock(DTObra obra)
{
    listaMateriales= PersistenciaMaterial.listarMaterialesconStock(getActivity(),obra.getId());
    adapterMaterial=new AdaptadorMaterial(getActivity(),listaMateriales);
    lvMateriales.setAdapter(adapterMaterial);
}
public void filtrosinStock(DTObra obra)
{
    listaMateriales= PersistenciaMaterial.listarMaterialessinStock(getActivity(),obra.getId());
    adapterMaterial=new AdaptadorMaterial(getActivity(),listaMateriales);
    lvMateriales.setAdapter(adapterMaterial);
}
public void actualizarLista(DTObra obra)
    {
        obra = PersistenciaObra.buscarObra(getActivity(),obra.getId());
        listaMateriales=obra.getListMateriales();
        adapterMaterial=new AdaptadorMaterial(getActivity(),listaMateriales);
        lvMateriales.setAdapter(adapterMaterial);
    }

    public interface OnMaterialSeleccionadoListener {

        void onMaterialSeleccionado(DTMaterial material);

    }
}
