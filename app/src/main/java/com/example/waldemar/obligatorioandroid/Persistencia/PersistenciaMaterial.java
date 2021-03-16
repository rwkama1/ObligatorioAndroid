package com.example.waldemar.obligatorioandroid.Persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.waldemar.obligatorioandroid.DataTypes.DTMaterial;
import com.example.waldemar.obligatorioandroid.DataTypes.DTObra;

import java.util.ArrayList;


public class PersistenciaMaterial {

    protected static ArrayList<DTMaterial> listarMateriales(Context contexto,int id) {

            ArrayList<DTMaterial> listaMateriales=new ArrayList<>();
            SQLiteHelper conn=new SQLiteHelper(contexto);

            SQLiteDatabase db2 = conn.getReadableDatabase();
            String[] parametro=new String[]{ String.valueOf(id) };
            DTMaterial mat = null;
            Cursor cursor2= db2.query(SQLiteContrato.TABLA_MATERIAL, SQLiteContrato.Material.COLUMNASMATERIAL, SQLiteContrato.Material.COLUMNA_OBRAMATERIAL+"=?",parametro, null, null, null);

            String nombre;
            String fecha;
            int stock;
            String descripcion;

            while (cursor2.moveToNext()) {
                id=cursor2.getInt(cursor2.getColumnIndex(SQLiteContrato.IDMATERIAL));
                nombre=cursor2.getString(cursor2.getColumnIndex(SQLiteContrato.COLUMNA_NOMBREMATERIAL));
                fecha=cursor2.getString(cursor2.getColumnIndex(SQLiteContrato.Material.COLUMNA_FECHAMATERIAL));
                stock=cursor2.getInt(cursor2.getColumnIndex(SQLiteContrato.Material.COLUMNA_STOCK));
                descripcion=cursor2.getString(cursor2.getColumnIndex(SQLiteContrato.Material.COLUMNA_DESCRIPCIONMAT));
                mat=new DTMaterial(id,nombre,fecha,stock,descripcion,PersistenciaMovimiento.listarMovimientos(contexto,id));
                listaMateriales.add(mat);

            }

            return listaMateriales;
    }
    public static void agregarMaterial(Context contexto,DTObra obra) {
        SQLiteHelper conn=new SQLiteHelper(contexto);
     SQLiteDatabase baseDatos= conn.getWritableDatabase();
        ContentValues valores = new ContentValues();

            ArrayList<DTMaterial> lista = obra.getListMateriales();
            int stockMaterial = lista.get(lista.size() - 1).getStock();
baseDatos.beginTransaction();
try {
    valores.put(SQLiteContrato.COLUMNA_NOMBREMATERIAL, lista.get(lista.size() - 1).getNombreMaterial());
    valores.put(SQLiteContrato.Material.COLUMNA_DESCRIPCIONMAT, lista.get(lista.size() - 1).getDescripcion());
    valores.put(SQLiteContrato.Material.COLUMNA_FECHAMATERIAL, lista.get(lista.size() - 1).getFechaMaterial());
    valores.put(SQLiteContrato.Material.COLUMNA_STOCK, stockMaterial);
    valores.put(SQLiteContrato.Material.COLUMNA_OBRAMATERIAL, obra.getId());
    long idinsert=baseDatos.insert(SQLiteContrato.TABLA_MATERIAL, null, valores);
    valores.clear();
    valores.put(SQLiteContrato.Movimiento.COLUMNA_MATERIALMOVIMIENTO,idinsert);
    valores.put(SQLiteContrato.Movimiento.COLUMNA_CANTIDAD,stockMaterial);
    valores.put(SQLiteContrato.Movimiento.COLUMNA_OBSERVACION,"Stock Inicial");
    baseDatos.insert(SQLiteContrato.TABLA_MOVIMIENTO,null,valores);
    baseDatos.setTransactionSuccessful();

}
finally {
    baseDatos.endTransaction();
}

    }
    public static void modificarMaterial(Context contexto,DTMaterial material) {
        SQLiteHelper conn=new SQLiteHelper(contexto);
        SQLiteDatabase baseDatos= conn.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(SQLiteContrato.Material.COLUMNA_DESCRIPCIONMAT, material.getDescripcion());
        baseDatos.update(SQLiteContrato.TABLA_MATERIAL,valores,SQLiteContrato.IDMATERIAL+" = ?",new String[]{String.valueOf(material.getIdmaterial())});
        valores.clear();
    }
    public static ArrayList<DTMaterial> listarMaterialesconStock(Context contexto,int id) {
        ArrayList<DTMaterial> listaMateriales=new ArrayList<>();
        SQLiteHelper conn=new SQLiteHelper(contexto);

        SQLiteDatabase db2 = conn.getReadableDatabase();
        String[] parametro=new String[]{ String.valueOf(id) };
        DTMaterial mat = null;
        Cursor cursor2= db2.query(SQLiteContrato.TABLA_MATERIAL, SQLiteContrato.Material.COLUMNASMATERIAL, SQLiteContrato.Material.COLUMNA_OBRAMATERIAL+"=?"+" AND "+SQLiteContrato.Material.COLUMNA_STOCK+">0",parametro, null, null, null);

        String nombre;
        String fecha;
        int stock;
        String descripcion;
        int idmat;
        while (cursor2.moveToNext()) {
            idmat=cursor2.getInt(cursor2.getColumnIndex(SQLiteContrato.IDMATERIAL));
            nombre=cursor2.getString(cursor2.getColumnIndex(SQLiteContrato.COLUMNA_NOMBREMATERIAL));
            fecha=cursor2.getString(cursor2.getColumnIndex(SQLiteContrato.Material.COLUMNA_FECHAMATERIAL));
            stock=cursor2.getInt(cursor2.getColumnIndex(SQLiteContrato.Material.COLUMNA_STOCK));
            descripcion=cursor2.getString(cursor2.getColumnIndex(SQLiteContrato.Material.COLUMNA_DESCRIPCIONMAT));

            mat=new DTMaterial(idmat,nombre,fecha,stock,descripcion,null);
            listaMateriales.add(mat);

        }

        return listaMateriales;
    }
    public static ArrayList<DTMaterial> listarMaterialessinStock(Context contexto,int id) {
        ArrayList<DTMaterial> listaMateriales=new ArrayList<>();
        SQLiteHelper conn=new SQLiteHelper(contexto);

        SQLiteDatabase db2 = conn.getReadableDatabase();
        String[] parametro=new String[]{ String.valueOf(id) };
        DTMaterial mat = null;
        Cursor cursor2= db2.query(SQLiteContrato.TABLA_MATERIAL, SQLiteContrato.Material.COLUMNASMATERIAL, SQLiteContrato.Material.COLUMNA_OBRAMATERIAL+"=?"+" AND "+SQLiteContrato.Material.COLUMNA_STOCK+"<=0",parametro, null, null, null);

        String nombre;
        String fecha;
        int stock;
        String descripcion;
        int idmat;
        while (cursor2.moveToNext()) {

            idmat=cursor2.getInt(cursor2.getColumnIndex(SQLiteContrato.IDMATERIAL));
            nombre=cursor2.getString(cursor2.getColumnIndex(SQLiteContrato.COLUMNA_NOMBREMATERIAL));
            fecha=cursor2.getString(cursor2.getColumnIndex(SQLiteContrato.Material.COLUMNA_FECHAMATERIAL));
            stock=cursor2.getInt(cursor2.getColumnIndex(SQLiteContrato.Material.COLUMNA_STOCK));
            descripcion=cursor2.getString(cursor2.getColumnIndex(SQLiteContrato.Material.COLUMNA_DESCRIPCIONMAT));

            mat=new DTMaterial(idmat,nombre,fecha,stock,descripcion,null);
            listaMateriales.add(mat);

        }

        return listaMateriales;
    }
    public static DTMaterial buscarMateriales(Context contexto,int idmat) {

        SQLiteHelper conn=new SQLiteHelper(contexto);
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] args=new String[]{String.valueOf(idmat)};
        DTMaterial mat = null;
        Cursor cursor= db.query(SQLiteContrato.TABLA_MATERIAL, SQLiteContrato.Material.COLUMNASMATERIAL, SQLiteContrato.IDMATERIAL+" = ?", args, null, null,null );


        String fecha;
        int stock;
        String descripcion;
        String nombrem;

        if (cursor.moveToNext()) {

             idmat=cursor.getInt(cursor.getColumnIndex(SQLiteContrato.IDMATERIAL));
            nombrem=cursor.getString(cursor.getColumnIndex(SQLiteContrato.COLUMNA_NOMBREMATERIAL));
            fecha=cursor.getString(cursor.getColumnIndex(SQLiteContrato.Material.COLUMNA_FECHAMATERIAL));
            stock=cursor.getInt(cursor.getColumnIndex(SQLiteContrato.Material.COLUMNA_STOCK));
            descripcion=cursor.getString(cursor.getColumnIndex(SQLiteContrato.Material.COLUMNA_DESCRIPCIONMAT));
            mat=new DTMaterial(idmat,nombrem,fecha,stock,descripcion,PersistenciaMovimiento.listarMovimientos(contexto,idmat));
        }
        return mat;
    }


}
