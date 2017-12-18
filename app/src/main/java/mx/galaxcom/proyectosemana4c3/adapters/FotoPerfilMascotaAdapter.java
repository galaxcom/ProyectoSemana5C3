package mx.galaxcom.proyectosemana4c3.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mx.galaxcom.proyectosemana4c3.R;
import mx.galaxcom.proyectosemana4c3.pojo.FotoPerfilMascota;

/**
 * Created by david on 15/12/2017.
 */

public class FotoPerfilMascotaAdapter extends RecyclerView.Adapter<FotoPerfilMascotaAdapter.FotoPerfilMascotaViewHolder>{
    ArrayList<FotoPerfilMascota> fotosPerfil;

    public FotoPerfilMascotaAdapter(ArrayList<FotoPerfilMascota> fotosPerfil){
        this.fotosPerfil = fotosPerfil;
    }

    @Override
    public FotoPerfilMascotaAdapter.FotoPerfilMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_perfil, parent, false);
        return new FotoPerfilMascotaAdapter.FotoPerfilMascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FotoPerfilMascotaAdapter.FotoPerfilMascotaViewHolder miHolder, int position) {
        FotoPerfilMascota fotoPerfil = fotosPerfil.get(position);
        miHolder.foto.setImageResource(fotoPerfil.getFoto());
        miHolder.txtRating.setText(fotoPerfil.getRating());

    }

    @Override
    public int getItemCount() {
        return fotosPerfil.size();
    }

    public static class FotoPerfilMascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView txtRating;

        public FotoPerfilMascotaViewHolder(View itemView) {
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.imgFoto);
            txtRating  = (TextView) itemView.findViewById(R.id.txtRatingFoto);
        }
    }
}
