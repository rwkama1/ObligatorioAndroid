package com.example.waldemar.obligatorioandroid;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.waldemar.obligatorioandroid.DataTypes.DTMovimiento;
import java.util.List;



public class AdapterMovimiento extends BaseAdapter {
    private Context contexto;
    private List<DTMovimiento> mov;


    public AdapterMovimiento(Context contexto, List<DTMovimiento> mov) {
        this.contexto = contexto;
        this.mov = mov;
    }


    @Override
    public int getCount() {
        return mov.size();
    }

    @Override
    public DTMovimiento getItem(int position) {
        return mov.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        MovViewHolder movViewHolder;

        if (item == null) {
            LayoutInflater inflador = LayoutInflater.from(contexto);
            item = inflador.inflate(R.layout.listitem_movimiento, parent, false);

            movViewHolder = new MovViewHolder(item);
            item.setTag(movViewHolder);
        } else {
            movViewHolder = (MovViewHolder)item.getTag();
        }

        movViewHolder.enlazarMovimiento(mov.get(position));

        return item;
    }



    protected class MovViewHolder {


        private TextView tvCantidad;
        private TextView tvObs;

        public MovViewHolder(View vista) {

            tvCantidad = (TextView) vista.findViewById(R.id.tvCantidad);
            tvObs=(TextView)vista.findViewById(R.id.tvObservacion);

        }
        public void enlazarMovimiento(DTMovimiento mov) {
            tvCantidad.setText("Cantidad: "+String.valueOf(mov.getCantidad()));
            tvObs.setText("Observación: "+mov.getObservacion());

        }

    }

}
