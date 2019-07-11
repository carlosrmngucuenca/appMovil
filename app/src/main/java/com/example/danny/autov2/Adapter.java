package com.example.danny.autov2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by danny on 21/05/17.
 */

public class Adapter extends BaseAdapter {

    Context contexto;
    List<DatosAdapter> Milista;

    public Adapter(Context contexto, List<DatosAdapter> milista) {
        this.contexto = contexto;
        Milista = milista;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return Milista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Milista.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista= convertView;
        LayoutInflater inflate = LayoutInflater.from(contexto);
        vista=inflate.inflate(R.layout.formato_fila,null);
        ImageView imagen =(ImageView)vista.findViewById(R.id.imageViajero);
        TextView Nombre = (TextView) vista.findViewById(R.id.Nombre_Viajero_Fila);
        TextView costo = (TextView) vista.findViewById(R.id.Nombre_Viajero_Costo);

        Nombre.setText(Milista.get(position).getNombre().toString());
        costo.setText(Milista.get(position).getCosto().toString());
        imagen.setImageResource(R.drawable.imagenviajero);
        return vista;
    }
}
