package com.example.volley_jsonapirestful.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.volley_jsonapirestful.R;
import com.example.volley_jsonapirestful.models.Productos;

import java.util.ArrayList;

public class adaptadorproducto extends ArrayAdapter<Productos> {

    public adaptadorproducto(Context context, ArrayList<Productos> datos) {
        super(context, R.layout.ly_itemdatos, datos);
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.ly_itemproducto, null);

        TextView lbldescripcion = (TextView)item.findViewById(R.id.lbldescripcion);
        lbldescripcion.setText(getItem(position).getDescipcion());

        TextView lblbarcode = (TextView)item.findViewById(R.id.lblbarcode);
        lblbarcode.setText(getItem(position).getBarcode());

        TextView lblpreciounidad = (TextView)item.findViewById(R.id.lblpreciounidad);
        lblpreciounidad.setText(getItem(position).getPreciounidad());

        TextView lblunidad = (TextView)item.findViewById(R.id.lblunidad);
        lblunidad.setText(getItem(position).getUnidad());

        TextView lblfechacreacion = (TextView)item.findViewById(R.id.lblfechacreacion);
        lblfechacreacion.setText(getItem(position).getFechacreacion());

        return(item);
    }
}