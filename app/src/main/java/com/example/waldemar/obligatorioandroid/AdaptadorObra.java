package com.example.waldemar.obligatorioandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.waldemar.obligatorioandroid.DataTypes.DTObra;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Waldemar on 04/12/2017.
 */

public class AdaptadorObra extends BaseAdapter {

    private Context contexto;
    private List<DTObra> obra;


    public AdaptadorObra(Context contexto, List<DTObra> obra) {
        this.contexto = contexto;
        this.obra = obra;
    }


    @Override
    public int getCount() {
        return obra.size();
    }

    @Override
    public DTObra getItem(int position) {
        return obra.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        ObraViewHolder obraViewHolder;

        if (item == null) {
            LayoutInflater inflador = LayoutInflater.from(contexto);
            item = inflador.inflate(R.layout.listitem_obra, parent, false);

            obraViewHolder = new ObraViewHolder(item);
            item.setTag(obraViewHolder);
        } else {
            obraViewHolder = (ObraViewHolder)item.getTag();
        }

        obraViewHolder.enlazarObra(obra.get(position));

        return item;
    }



     protected class ObraViewHolder {

        private ImageView imgvObra;
        private TextView tvIdObra;
        private TextView tvFechaObraL;
        private TextView tvMCObra;
        private TextView tvDireccionObra;
        private TextView tvClienteObra;



        public ObraViewHolder(View vista) {

            imgvObra = (ImageView)vista.findViewById(R.id.imgvObra);
            tvIdObra = (TextView)vista.findViewById(R.id.tvidobra);
            tvFechaObraL = (TextView)vista.findViewById(R.id.tvFechaObraL);
            tvMCObra = (TextView)vista.findViewById(R.id.tvMCObra);
            tvDireccionObra = (TextView)vista.findViewById(R.id.tvDireccionObra);
            tvClienteObra = (TextView)vista.findViewById(R.id.tvLCliente);


        }
         private int getIdImagenAvatar(int id) {
             Map<Integer, Integer> idsImagenes = new HashMap();

             idsImagenes.put(1, R.drawable.obra1);
             idsImagenes.put(2, R.drawable.obra2);
             idsImagenes.put(3, R.drawable.obra3);


             return idsImagenes.get(id);
         }


        public void enlazarObra(DTObra obra) {
            int idImagenObra = getIdImagenAvatar(obra.getId());
            imgvObra.setImageResource(idImagenObra);
            tvIdObra.setText("ID: "+String.valueOf(obra.getId()));
            tvFechaObraL.setText("Fecha Contrato: "+obra.getFechaContrato());
            tvMCObra.setText(String.valueOf("Metros Cuadrados: "+obra.getMetroscuadrados()));
            tvDireccionObra.setText("Dirección: "+obra.getDireccion());
            tvClienteObra.setText("Nombre Cliente: "+obra.getNombreCliente());
        }

    }

}
