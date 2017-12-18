package mx.galaxcom.proyectosemana4c3.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import javax.mail.search.RecipientStringTerm;

import mx.galaxcom.proyectosemana4c3.R;
import mx.galaxcom.proyectosemana4c3.adapters.FotoPerfilMascotaAdapter;
import mx.galaxcom.proyectosemana4c3.pojo.FotoPerfilMascota;

public class PerfilFragment extends Fragment {
    ArrayList<FotoPerfilMascota> fotosPerfil;
    private RecyclerView rvFotos;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvFotos = (RecyclerView) v.findViewById(R.id.rvFotosPerfil);

        GridLayoutManager layoutManager= new GridLayoutManager(getActivity(), 3);

        rvFotos.setLayoutManager(layoutManager);

        fotosPerfil = new ArrayList<>();

        fotosPerfil.add(new FotoPerfilMascota(R.drawable.perro1, "0"));
        fotosPerfil.add(new FotoPerfilMascota(R.drawable.perro1, "6"));
        fotosPerfil.add(new FotoPerfilMascota(R.drawable.perro1, "10"));
        fotosPerfil.add(new FotoPerfilMascota(R.drawable.perro1, "9"));
        fotosPerfil.add(new FotoPerfilMascota(R.drawable.perro1, "5"));
        fotosPerfil.add(new FotoPerfilMascota(R.drawable.perro1, "7"));
        fotosPerfil.add(new FotoPerfilMascota(R.drawable.perro1, "13"));
        fotosPerfil.add(new FotoPerfilMascota(R.drawable.perro1, "4"));
        fotosPerfil.add(new FotoPerfilMascota(R.drawable.perro1, "2"));

        FotoPerfilMascotaAdapter adapter = new FotoPerfilMascotaAdapter(fotosPerfil);
        rvFotos.setAdapter(adapter);

        return v;
    }

}
