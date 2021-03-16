package com.example.waldemar.obligatorioandroid.Persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.waldemar.obligatorioandroid.DataTypes.DTMaterial;
import com.example.waldemar.obligatorioandroid.DataTypes.DTMovimiento;
import com.example.waldemar.obligatorioandroid.DataTypes.DTObra;

import java.util.ArrayList;



public class PersistenciaMovimiento {
    public static ArrayList<DTMovimiento> listarMovimientos(Context contexto,int idmat) {

        ArrayList<DTMovimiento> listarMovimientos=new ArrayList<>();
        SQLiteHelper conn=new SQLiteHelper(contexto);
        SQLiteDatabase db3 = conn.getReadableDatabase();
        String[] parametro=new String[]{String.valueOf(idmat)};
        DTMovimiento movimiento = null;
        Cursor cursor3= db3.query(SQLiteContrato.TABLA_MOVIMIENTO, SQLiteContrato.Movimiento.COLUMNASMOVIMIENTO, SQLiteContrato.Movimiento.COLUMNA_MATERIALMOVIMIENTO+"=?",parametro, null, null, null);


        int cantidad;
        String obs;


        while (cursor3.moveToNext()) {

            cantidad=cursor3.getInt(cursor3.getColumnIndex(SQLiteContrato.Movimiento.COLUMNA_CANTIDAD));
            obs=cursor3.getString(cursor3.getColumnIndex(SQLiteContrato.Movimiento.COLUMNA_OBSERVACION));
            movimiento=new DTMovimiento(cantidad,obs);
            listarMovimientos.add(movimiento);

        }

        return listarMovimientos;
    }
    public static void agregarMovimiento(Context contexto,DTMaterial material) {
        SQLiteHelper conn=new SQLiteHelper(contexto);
        SQLiteDatabase baseDatos= conn.getWritableDatabase();
        ContentValues valores = new ContentValues();

        ArrayList<DTMovimiento> lista = material.getListMovimiento();
        int stockMaterial =material.getStock();
        int cantidad=lista.get(lista.size() - 1).getCantidad();
        int stocknuevo=stockMaterial+cantidad;
        baseDatos.beginTransaction();
        try {
            valores.put(SQLiteContrato.Movimiento.COLUMNA_CANTIDAD, lista.get(lista.size() - 1).getCantidad());
            valores.put(SQLiteContrato.Movimiento.COLUMNA_MATERIALMOVIMIENTO, material.getIdmaterial());
            valores.put(SQLiteContrato.Movimiento.COLUMNA_OBSERVACION, lista.get(lista.size() - 1).getObservacion());
            baseDatos.insert(SQLiteContrato.TABLA_MOVIMIENTO, null, valores);
            valores.clear();
            valores.put(SQLiteContrato.Material.COLUMNA_STOCK, stocknuevo);
            baseDatos.update(SQLiteContrato.TABLA_MATERIAL, valores, SQLiteContrato.IDMATERIAL + "=?", new String[]{String.valueOf(material.getIdmaterial())});
            baseDatos.setTransactionSuccessful();
        }
        finally {
            baseDatos.endTransaction();
        }

    }
}
