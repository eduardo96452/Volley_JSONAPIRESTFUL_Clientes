package com.example.volley_jsonapirestful.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Productos {

    private String descipcion;
    private String barcode;
    private String preciounidad;
    private String unidad;
    private String fechacreacion;

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getPreciounidad() {
        return preciounidad;
    }

    public void setPreciounidad(String preciounidad) {
        this.preciounidad = preciounidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Productos(JSONObject a) throws JSONException {

        descipcion= a.getString("descripcion").toString();
        barcode =  a.getString("barcode").toString();
        preciounidad =  a.getString("precio_unidad").toString();
        unidad =  a.getString("unidad").toString();
        fechacreacion= a.getString("fechacreacion").toString();
    }

    public static ArrayList<Productos> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Productos> producto = new ArrayList<>();

        for (int i = 0; i < datos.length() && i<20; i++) {
            producto.add(new Productos(datos.getJSONObject(i)));
        }
        return producto;
    }
}
