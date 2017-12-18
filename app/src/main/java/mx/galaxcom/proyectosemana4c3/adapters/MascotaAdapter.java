package mx.galaxcom.proyectosemana4c3.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mx.galaxcom.proyectosemana4c3.R;
import mx.galaxcom.proyectosemana4c3.pojo.Mascota;

/**
 * Created by david on 08/12/2017.
 */

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;

    public MascotaAdapter(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder miHolder, int position) {
        Mascota mascota = mascotas.get(position);
        miHolder.imgMascota.setImageResource(mascota.getImagen());
        miHolder.txtNombre.setText(mascota.getNombre());
        miHolder.txtRating.setText(mascota.getRating());

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgMascota;
        private TextView txtNombre;
        private TextView txtRating;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgMascota = (ImageView) itemView.findViewById(R.id.imgMascota);
            txtNombre  = (TextView) itemView.findViewById(R.id.txtNombreMascota);
            txtRating  = (TextView) itemView.findViewById(R.id.txtRating);
        }
    }
}
