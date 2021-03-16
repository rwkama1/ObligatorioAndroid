package com.example.waldemar.obligatorioandroid.DataTypes;


import java.io.Serializable;

public class DTMovimiento implements Serializable {

    private int cantidad;
    private String observacion;



    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }


    public DTMovimiento() {

    }

    public DTMovimiento(int cantidad, String observacion) {

        setCantidad(cantidad);
        setObservacion(observacion);


    }
}
