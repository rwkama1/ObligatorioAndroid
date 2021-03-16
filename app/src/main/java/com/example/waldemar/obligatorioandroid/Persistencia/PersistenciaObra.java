package com.example.waldemar.obligatorioandroid.Persistencia;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.waldemar.obligatorioandroid.DataTypes.DTMaterial;
import com.example.waldemar.obligatorioandroid.DataTypes.DTObra;

import java.util.ArrayList;



public class PersistenciaObra {



public static ArrayList<DTObra> listarObras(Context contexto) {
    ArrayList<DTObra> listaObra=new ArrayList<>();
    SQLiteHelper conn=new SQLiteHelper(contexto);
    SQLiteDatabase db = conn.getReadableDatabase();

    DTObra obra = null;
    Cursor cursor= db.query(SQLiteContrato.TABLA_OBRA, SQLiteContrato.Obra.COLUMNASOBRA, null, null, null, null, SQLiteContrato.Obra.COLUMNA_FECHAOBRA + " ASC");

    while (cursor.moveToNext()) {

        int id=cursor.getInt(cursor.getColumnIndex(SQLiteContrato.COLUMNA_IDOBRA));
       String fecha=cursor.getString(cursor.getColumnIndex(SQLiteContrato.Obra.COLUMNA_FECHAOBRA));
        double metrocuadrado=cursor.getDouble(cursor.getColumnIndex(SQLiteContrato.Obra.COLUMNA_METROSOBRA));
        String direccion=cursor.getString(cursor.getColumnIndex(SQLiteContrato.Obra.COLUMNA_DIRECCIONOBRA));
        String nombreCliente=cursor.getString(cursor.getColumnIndex(SQLiteContrato.Obra.COLUMNA_CLIENTEOBRA));
        obra=new DTObra(id,metrocuadrado,nombreCliente,direccion,fecha,PersistenciaMaterial.listarMateriales(contexto,id));
        listaObra.add(obra);
    }
    return listaObra;
}
    public static DTObra buscarObra(Context contexto,int id) {

        SQLiteHelper conn=new SQLiteHelper(contexto);
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] args=new String[]{ String.valueOf(id) };
        DTObra obra = null;
        Cursor cursor= db.query(SQLiteContrato.TABLA_OBRA, SQLiteContrato.Obra.COLUMNASOBRA, SQLiteContrato.COLUMNA_IDOBRA+"=?", args, null, null,null );

        if (cursor.moveToNext()) {

            int ido=cursor.getInt(cursor.getColumnIndex(SQLiteContrato.COLUMNA_IDOBRA));
            String fecha=cursor.getString(cursor.getColumnIndex(SQLiteContrato.Obra.COLUMNA_FECHAOBRA));
            double metrocuadrado=cursor.getDouble(cursor.getColumnIndex(SQLiteContrato.Obra.COLUMNA_METROSOBRA));
            String direccion=cursor.getString(cursor.getColumnIndex(SQLiteContrato.Obra.COLUMNA_DIRECCIONOBRA));
            String nombreCliente=cursor.getString(cursor.getColumnIndex(SQLiteContrato.Obra.COLUMNA_CLIENTEOBRA));
            obra=new DTObra(ido,metrocuadrado,nombreCliente,direccion,fecha,PersistenciaMaterial.listarMateriales(contexto,ido));

        }
        return obra;
    }

}
