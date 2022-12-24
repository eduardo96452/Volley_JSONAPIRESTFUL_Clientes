package com.example.volley_jsonapirestful;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.volley_jsonapirestful.adaptadores.adaptadorcliente;
import com.example.volley_jsonapirestful.models.Clientes;
import com.example.volley_jsonapirestful.models.Productos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ListView lstProductos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstProductos = (ListView) findViewById(R.id.lstUser);
        RequestQueue queue = Volley.newRequestQueue(this);

        //url para los clientes
        //String url ="https://api.uealecpeterson.net/public/clientes/search";

        //url para los productos
        String url ="https://api.uealecpeterson.net/public/productos/search";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //corregir ↓
                        try {
                            JSONObject JSONlista =  new JSONObject(response);
                            //JSONArray JSONlistaproductos=  new JSONArray(JSONlista);
                            JSONArray JSONlistaproductos= JSONlista.getJSONArray("productos");

                            //para llenar el listview con los clientes
                            //ArrayList<Clientes> lstProductoss = Clientes.JsonObjectsBuild(JSONlistaproductos);
                            //com.example.volley_jsonapirestful.adaptadores.adaptadorcliente adapatorUsuario = new com.example.volley_jsonapirestful.adaptadores.adaptadorcliente( getApplicationContext(), lstProductoss);

                            //para llenar el listview con los productos
                            ArrayList<Productos> lstProductoss = Productos.JsonObjectsBuild(JSONlistaproductos);
                            com.example.volley_jsonapirestful.adaptadores.adaptadorproducto adapatorproducto = new com.example.volley_jsonapirestful.adaptadores.adaptadorproducto( getApplicationContext(), lstProductoss);

                            lstProductos.setAdapter(adapatorproducto);


                        //corregir ↑
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),  error.getMessage(), Toast.LENGTH_LONG).show();

            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headerMap = new HashMap<String, String>();
                //headerMap.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZHVzciI6OSwiZW1haWwiOiJjemFtYnJhbm9AdXRlcS5lZHUuZWMiLCJpYXQiOjE2NzE0OTYzOTEsImV4cCI6MTY3MTg1NjM5MX0.hZooTHB43sV3tdjL2unBAk7xIdClGRg3ltWUFTEfzyc");
                headerMap.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZHVzciI6OSwiZW1haWwiOiJjemFtYnJhbm9AdXRlcS5lZHUuZWMiLCJpYXQiOjE2NzE0OTYzOTEsImV4cCI6MTY3MTg1NjM5MX0.hZooTHB43sV3tdjL2unBAk7xIdClGRg3ltWUFTEfzyc");
                return headerMap;
            }

            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                params.put("fuente", "1");
                return params;
            }
        };

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}