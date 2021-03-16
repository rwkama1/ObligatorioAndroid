package com.example.waldemar.obligatorioandroid;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.waldemar.obligatorioandroid.DataTypes.DTMaterial;
import com.example.waldemar.obligatorioandroid.DataTypes.DTObra;
import com.example.waldemar.obligatorioandroid.Persistencia.PersistenciaMaterial;

import java.util.Calendar;

public class AgregarMaterial extends AppCompatActivity  implements DatePickerDialog.OnDateSetListener{

    DTObra obra;
    public static final String TAG_SELECTOR_FECHA = "TAG_SELECTOR_FECHA";
    EditText etFecha;
    EditText etNombre;
    EditText etDescripcion;
    EditText etStock;
    TextView tvObramaterial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_material);
        etFecha =(EditText) findViewById(R.id.etFechaedit);
        etNombre =(EditText) findViewById(R.id.etNombreEdit);
        etDescripcion =(EditText) findViewById(R.id.etDescripcionEdit);
        etStock =(EditText) findViewById(R.id.etStockedit);
        tvObramaterial=(TextView) findViewById(R.id.tvObraMaterial);

        Bundle objetoenviado=getIntent().getExtras();
        obra=(DTObra) objetoenviado.getSerializable("obramat");
        tvObramaterial.setText("Obra:"+" "+ String.valueOf(obra.getId())
      );

    }

    public void btnElegirFechaOnClick(View view) {
        SelectorFechaDialog dialogoFecha = new SelectorFechaDialog();
        dialogoFecha.show(getFragmentManager(), TAG_SELECTOR_FECHA);
    }

    public void btnAgregarMaterialOnClick(View view) {
        if (etNombre.getText().toString().equals("")||etStock.getText().toString().equals("")||etDescripcion.getText().toString().equals("")||etFecha.getText().toString().equals("")) {
            Toast.makeText(this,"Algunos campos quedaron vacios",Toast.LENGTH_LONG).show();
        }
        else
        {
            DTMaterial material = new DTMaterial(0,etNombre.getText().toString(), etFecha.getText().toString(), Integer.parseInt(etStock.getText().toString()), etDescripcion.getText().toString(), null);
            obra.getListMateriales().add(material);
            PersistenciaMaterial.agregarMaterial(this, obra);
            Toast.makeText(this,"Se agrego el material correctamente",Toast.LENGTH_LONG).show();
            etFecha.setText("");
            etDescripcion.setText("");
            etStock.setText("");
            etNombre.setText("");
        }


    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        etFecha.setText(year + "-" + String.format("%1$02d", (month + 1)) + "-" + String.format("%1$02d", dayOfMonth));
    }



    public static class SelectorFechaDialog extends DialogFragment{
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            Calendar calendario = Calendar.getInstance();
            int anio = calendario.get(Calendar.YEAR);
            int mes = calendario.get(Calendar.MONTH);
            int dia = calendario.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener)getActivity(), anio, mes, dia);
        }

    }
}
