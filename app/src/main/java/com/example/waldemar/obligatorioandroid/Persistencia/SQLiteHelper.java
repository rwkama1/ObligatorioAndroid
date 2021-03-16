package com.example.waldemar.obligatorioandroid.Persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;




public class SQLiteHelper extends SQLiteOpenHelper {
    private Context contexto;


    public SQLiteHelper(Context contexto) {
        super(contexto, SQLiteContrato.NOMBRE_BASE_DATOS, null, SQLiteContrato.VERSION_BASE_DATOS);

        this.contexto = contexto;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLiteContrato.Obra.SQL_CREAR_TABLAOBRA);
        sqLiteDatabase.execSQL(SQLiteContrato.Material.SQL_CREAR_TABLAMATERIAL);
        sqLiteDatabase.execSQL(SQLiteContrato.Movimiento.SQL_CREAR_TABLAMOVIMIENTO);

        sqLiteDatabase.execSQL(SQLiteContrato.Obra.SQL_INSERTAR_DATOS_OBRA1);
        sqLiteDatabase.execSQL(SQLiteContrato.Obra.SQL_INSERTAR_DATOS_OBRA2);
        sqLiteDatabase.execSQL(SQLiteContrato.Obra.SQL_INSERTAR_DATOS_OBRA3);

        sqLiteDatabase.execSQL(SQLiteContrato.Material.SQL_INSERTAR_DATOS_MATERIAL1);
        sqLiteDatabase.execSQL(SQLiteContrato.Material.SQL_INSERTAR_DATOS_MATERIAL2);
        sqLiteDatabase.execSQL(SQLiteContrato.Material.SQL_INSERTAR_DATOS_MATERIAL3);

        sqLiteDatabase.execSQL(SQLiteContrato.Movimiento.SQL_INSERTAR_DATOS_MOV);
        sqLiteDatabase.execSQL(SQLiteContrato.Movimiento.SQL_INSERTAR_DATOS_MOV1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
