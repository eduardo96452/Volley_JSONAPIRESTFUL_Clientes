package com.example.volley_jsonapirestful.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.volley_jsonapirestful.models.Clientes;
import com.example.volley_jsonapirestful.R;
import java.util.ArrayList;

public class adaptadorcliente extends ArrayAdapter<Clientes> {

    public adaptadorcliente(Context context, ArrayList<Clientes> datos) {
        super(context, R.layout.ly_itemdatos, datos);
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.ly_itemdatos, null);

        TextView lblidentificacion = (TextView)item.findViewById(R.id.lblidentificacion);
        lblidentificacion.setText(getItem(position).getNombres());

        TextView lblNombre = (TextView)item.findViewById(R.id.lblnombre);
        lblNombre.setText(getItem(position).getNombres());

        TextView lbldireccion = (TextView)item.findViewById(R.id.lbldireccion);
        lbldireccion.setText(getItem(position).getDireccion());

        TextView lblcorreo = (TextView)item.findViewById(R.id.lblcorreo);
        lblcorreo.setText(getItem(position).getCorreo());

        TextView lbltelefono = (TextView)item.findViewById(R.id.lbltelefono);
        lbltelefono.setText(getItem(position).getTelefono());

        return(item);
    }
}
