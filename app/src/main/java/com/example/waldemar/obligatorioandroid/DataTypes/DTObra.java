package com.example.waldemar.obligatorioandroid.DataTypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class DTObra implements Serializable {
    private int id;
    private double metroscuadrados;
    private String nombreCliente;
    private String direccion;
    private String fechaContrato;
    private ArrayList<DTMaterial> listMateriales;
    

    public ArrayList<DTMaterial> getListMateriales() {
        return listMateriales;
    }

    public void setListMateriales(ArrayList<DTMaterial> listMateriales) {
        this.listMateriales = listMateriales;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMetroscuadrados() {
        return metroscuadrados;
    }

    public void setMetroscuadrados(double metroscuadrados) {
        this.metroscuadrados = metroscuadrados;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(String fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

        public DTObra()
         {}

    public DTObra(int id, double metroscuadrados, String nombreCliente, String direccion, String fechaContrato,ArrayList<DTMaterial> listMat) {
        setId(id);
        setMetroscuadrados(metroscuadrados);;
        setNombreCliente(nombreCliente);
        setDireccion(direccion);
        setFechaContrato(fechaContrato);
        setListMateriales(listMat);
    }
}
