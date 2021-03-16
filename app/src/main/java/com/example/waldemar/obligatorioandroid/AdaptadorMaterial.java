package com.example.waldemar.obligatorioandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.TextView;

import com.example.waldemar.obligatorioandroid.DataTypes.DTMaterial;


import java.util.ArrayList;
import java.util.List;



public class AdaptadorMaterial extends BaseAdapter {
    private Context contexto;
    private ArrayList<DTMaterial> mat;


    public AdaptadorMaterial(Context contexto, ArrayList<DTMaterial> mate) {
        this.contexto = contexto;
        this.mat = mate;
    }
    public void actualizarLista(ArrayList<DTMaterial> newlist) {
        mat.clear();
        mat.addAll(newlist);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mat.size();
    }

    @Override
    public DTMaterial getItem(int position) {
        return mat.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        AdaptadorMaterial.MaterialViewHolder materialViewHolder;

        if (item == null) {
            LayoutInflater inflador = LayoutInflater.from(contexto);
            item = inflador.inflate(R.layout.listitem_material, parent, false);

            materialViewHolder = new AdaptadorMaterial.MaterialViewHolder(item);
            item.setTag(materialViewHolder);
        } else {
            materialViewHolder = (AdaptadorMaterial.MaterialViewHolder)item.getTag();
        }

        materialViewHolder.enlazarMaterial(mat.get(position));

        return item;
    }



    protected class MaterialViewHolder {

       private TextView tvNombre;
       private TextView tvfechaalta;
        private TextView tvdescripcion;
        private TextView tvstock;

        public MaterialViewHolder(View vista) {


            tvNombre = (TextView)vista.findViewById(R.id.tvlNombreMat);
            tvfechaalta = (TextView)vista.findViewById(R.id.tvlFechaAlta);
            tvdescripcion = (TextView)vista.findViewById(R.id.tvlDescripcion);
            tvstock = (TextView)vista.findViewById(R.id.tvlStock);

        }

        public void enlazarMaterial(DTMaterial material) {

            tvNombre.setText(material.getNombreMaterial());
            tvfechaalta.setText("Fecha Alta: "+ material.getFechaMaterial());
            tvdescripcion.setText("Descripción: "+ material.getDescripcion());
            tvstock.setText("Stock: "+ String.valueOf(material.getStock()));

        }

    }
}
