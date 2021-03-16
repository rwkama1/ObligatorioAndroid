package com.example.waldemar.obligatorioandroid.Persistencia;

/**
 * Created by Waldemar on 30/11/2017.
 */

public class SQLiteContrato {
    public static final String NOMBRE_BASE_DATOS = "BaseDatosObligatorio.sqlite3";
    public static final int VERSION_BASE_DATOS = 1;
    public static final String TABLA_MATERIAL = "Material";
    public static final String TABLA_MOVIMIENTO = "Movimiento";
    public static final String TABLA_OBRA = "Obra";
    public static final String IDMATERIAL="Idmaterial";
    public static final String COLUMNA_IDOBRA= "IdObra";
    public static final String COLUMNA_NOMBREMATERIAL= "NombreMaterial";
    private SQLiteContrato() {

    }


    public static abstract class Obra  {


        public static final String COLUMNA_FECHAOBRA = "FechaObra";
        public static final String COLUMNA_METROSOBRA = "MetrosObra";
        public static final String COLUMNA_DIRECCIONOBRA = "DireccionObra";
        public static final String COLUMNA_CLIENTEOBRA = "ClienteObra";

        public static final String[] COLUMNASOBRA= { COLUMNA_IDOBRA, COLUMNA_FECHAOBRA, COLUMNA_METROSOBRA, COLUMNA_DIRECCIONOBRA,COLUMNA_CLIENTEOBRA};

        public static final String SQL_CREAR_TABLAOBRA = new StringBuilder("CREATE TABLE ").append(TABLA_OBRA).append(" (")
                .append(COLUMNA_IDOBRA).append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(COLUMNA_FECHAOBRA).append(" TEXT NOT NULL, ")
                .append(COLUMNA_METROSOBRA).append(" REAL NOT NULL, ")
                .append(COLUMNA_DIRECCIONOBRA).append(" TEXT NOT NULL, ")
                .append(COLUMNA_CLIENTEOBRA).append(" TEXT NOT NULL);").toString();

        public static final String SQL_INSERTAR_DATOS_OBRA1 = new StringBuilder("INSERT INTO ").append(TABLA_OBRA).append(" VALUES (NULL, '2017-11-02', 2000,'18 De julio','Juansito');").toString();
        public static final String SQL_INSERTAR_DATOS_OBRA2 = new StringBuilder("INSERT INTO ").append(TABLA_OBRA).append(" VALUES (NULL, '2017-11-03', 3000,'Venezuela 154','Pedrito');").toString();
        public static final String SQL_INSERTAR_DATOS_OBRA3 = new StringBuilder("INSERT INTO ").append(TABLA_OBRA).append(" VALUES (NULL, '2017-11-04', 1000,'Herrera 124','Maria');").toString();

    }

    public static abstract class Material  {

        public static final String COLUMNA_FECHAMATERIAL = "FechaMaterial";
        public static final String COLUMNA_STOCK = "StockMaterial";
        public static final String COLUMNA_DESCRIPCIONMAT = "DescripcionMaterial";
        public static final String COLUMNA_OBRAMATERIAL = "ObraMaterial";


        public static final String[] COLUMNASMATERIAL= {IDMATERIAL,COLUMNA_NOMBREMATERIAL, COLUMNA_FECHAMATERIAL, COLUMNA_STOCK, COLUMNA_DESCRIPCIONMAT,COLUMNA_OBRAMATERIAL};

        public static final String SQL_CREAR_TABLAMATERIAL = new StringBuilder("CREATE TABLE ").append(TABLA_MATERIAL).append(" (")
                .append(IDMATERIAL).append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(COLUMNA_NOMBREMATERIAL).append(" TEXT NOT NULL, ")
                .append(COLUMNA_FECHAMATERIAL).append(" TEXT NOT NULL, ")
                .append(COLUMNA_STOCK).append(" INTEGER NOT NULL, ")
                .append(COLUMNA_DESCRIPCIONMAT).append(" TEXT NOT NULL, ")
                .append(COLUMNA_OBRAMATERIAL).append(" INTEGER NOT NULL, ")
                /*.append(" PRIMARY KEY (").append(COLUMNA_NOMBREMATERIAL).append(",").append(COLUMNA_OBRAMATERIAL).append("), ")*/
                .append(" FOREIGN KEY (").append(COLUMNA_OBRAMATERIAL).append(") REFERENCES ").append(TABLA_OBRA).append("(").append(COLUMNA_IDOBRA).append("));")
                .toString();

        public static final String SQL_INSERTAR_DATOS_MATERIAL1 = new StringBuilder("INSERT INTO ").append(TABLA_MATERIAL).append(" VALUES (NULL, 'Mármol', '2017-11-12', 100,'Es una roca metamórfica compacta formada a partir de rocas',1);").toString();
        public static final String SQL_INSERTAR_DATOS_MATERIAL2 = new StringBuilder("INSERT INTO ").append(TABLA_MATERIAL).append(" VALUES (NULL,' Vidrio', '2017-11-13', 0,'Es un material inorgánico duro, frágil, transparente y amorfo que se encuentra en la naturaleza',1);").toString();
        public static final String SQL_INSERTAR_DATOS_MATERIAL3 = new StringBuilder("INSERT INTO ").append(TABLA_MATERIAL).append(" VALUES (NULL, 'Arcilla','2017-11-14', 50,'Es una roca sedimentaria descompuesta constituida por agregados de silicatos de aluminio hidratados',2);").toString();

    }
    public static abstract class Movimiento  {

        public static final String COLUMNA_MATERIALMOVIMIENTO = "MaterialMovimiento";
        public static final String COLUMNA_CANTIDAD = "CantidadMovimiento";
        public static final String COLUMNA_OBSERVACION = "ObservacionMovimiento";




        public static final String[] COLUMNASMOVIMIENTO= {COLUMNA_MATERIALMOVIMIENTO, COLUMNA_CANTIDAD, COLUMNA_OBSERVACION};

        public static final String SQL_CREAR_TABLAMOVIMIENTO = new StringBuilder("CREATE TABLE ").append(TABLA_MOVIMIENTO).append(" (")
                .append(COLUMNA_CANTIDAD).append(" INTEGER NOT NULL, ")
                .append(COLUMNA_OBSERVACION).append(" TEXT NOT NULL, ")
                .append(COLUMNA_MATERIALMOVIMIENTO).append(" INTEGER NOT NULL, ")
                .append(" FOREIGN KEY (").append(COLUMNA_MATERIALMOVIMIENTO).append(") REFERENCES ").append(TABLA_MATERIAL).append("(").append(IDMATERIAL).append("));")
                .toString();

        public static final String SQL_INSERTAR_DATOS_MOV = new StringBuilder("INSERT INTO ").append(TABLA_MOVIMIENTO).append(" VALUES (100, 'Stock Inicial', 1);").toString();
        public static final String SQL_INSERTAR_DATOS_MOV1 = new StringBuilder("INSERT INTO ").append(TABLA_MOVIMIENTO).append(" VALUES (50, 'Stock Inicial', 3);").toString();

    }


}
