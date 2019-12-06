package com.cursania.ccmejia.cursaniaandroid.Views.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cursania.ccmejia.cursaniaandroid.Data.Api.Api;
import com.cursania.ccmejia.cursaniaandroid.Data.Api.ApiRoutes;
import com.cursania.ccmejia.cursaniaandroid.Data.Model.Cuarto;
import com.cursania.ccmejia.cursaniaandroid.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CuartosAdapter extends RecyclerView.Adapter<CuartosAdapter.ViewHolder>  {

    private List<Cuarto> cuartos;

    public CuartosAdapter() {
        this.cuartos = new ArrayList<>();
    }

    public void setCuartos(List<Cuarto> cuartos){
        this.cuartos = cuartos;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView lugarText;
        public TextView descripcionText;
        public TextView precioText;
        public ImageView fotoImage;

        public ViewHolder(View itemView){
            super(itemView);
            fotoImage = itemView.findViewById(R.id.imagen_lugar);
            lugarText = itemView.findViewById(R.id.nombre_lugar);
            descripcionText = itemView.findViewById(R.id.descripcion_lugar);
            precioText = itemView.findViewById(R.id.precioMensual);
        }

    }

    @Override
    public CuartosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CuartosAdapter.ViewHolder viewHolder, int position){

        Cuarto cuarto = this.cuartos.get(position);

        viewHolder.lugarText.setText(cuarto.getNombre_lugar());
        viewHolder.precioText.setText(cuarto.getPrecioMensual());
        viewHolder.descripcionText.setText(cuarto.getDescripcion_lugar());

        String url = cuarto.getImagen_lugar();
        Picasso.get().load(url).into(viewHolder.fotoImage);

    }

    @Override
    public int getItemCount(){
        return this.cuartos.size();
    }

}
