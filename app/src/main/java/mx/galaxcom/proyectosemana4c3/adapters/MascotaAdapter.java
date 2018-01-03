package mx.galaxcom.proyectosemana4c3.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.galaxcom.proyectosemana4c3.R;
import mx.galaxcom.proyectosemana4c3.db.ConstructorMascotas;
import mx.galaxcom.proyectosemana4c3.pojo.Mascota;

/**
 * Created by david on 08/12/2017.
 */

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdapter(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder miHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        miHolder.imgMascota.setImageResource(mascota.getImagen());
        miHolder.txtNombre.setText(mascota.getNombre());
        miHolder.txtRating.setText(String.valueOf(mascota.getRating()));


        miHolder.btnRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(), Toast.LENGTH_LONG).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);

                miHolder.txtRating.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(mascota)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgMascota;
        private TextView txtNombre;
        private TextView txtRating;
        private ImageButton btnRating;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgMascota = (ImageView) itemView.findViewById(R.id.imgMascota);
            txtNombre  = (TextView) itemView.findViewById(R.id.txtNombreMascota);
            txtRating  = (TextView) itemView.findViewById(R.id.txtRating);
            btnRating  = (ImageButton) itemView.findViewById(R.id.imgbHueso);
        }
    }
}
