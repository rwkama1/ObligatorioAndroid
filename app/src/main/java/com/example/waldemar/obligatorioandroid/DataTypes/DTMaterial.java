package com.example.waldemar.obligatorioandroid.DataTypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;



public class DTMaterial implements Serializable {
    private int idmaterial;
    private String nombreMaterial;
    private String fechaMaterial;
    private int stock;
    private String descripcion;
    private ArrayList<DTMovimiento> listMovimiento=null;

    public ArrayList<DTMovimiento> getListMovimiento() {
        return listMovimiento;
    }

    public void setListMovimiento(ArrayList<DTMovimiento> listMovimiento) {
        this.listMovimiento = listMovimiento;
    }

    public int getIdmaterial() {
        return idmaterial;
    }

    public void setIdmaterial(int idmaterial) {
        this.idmaterial = idmaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getFechaMaterial() {
        return fechaMaterial;
    }

    public void setFechaMaterial(String fechaMaterial) {
        this.fechaMaterial = fechaMaterial;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public DTMaterial()
    {}
    public DTMaterial(int idmaterial,String nombreMaterial, String fechaMaterial, int stock, String descripcion,ArrayList<DTMovimiento> listMovimiento) {
       setIdmaterial(idmaterial);
        setNombreMaterial(nombreMaterial);
        setFechaMaterial(fechaMaterial);
        setStock(stock);
        setDescripcion(descripcion);
        setListMovimiento(listMovimiento);

    }
}
