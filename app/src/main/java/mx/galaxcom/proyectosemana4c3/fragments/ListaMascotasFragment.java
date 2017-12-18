package mx.galaxcom.proyectosemana4c3.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.galaxcom.proyectosemana4c3.R;
import mx.galaxcom.proyectosemana4c3.adapters.MascotaAdapter;
import mx.galaxcom.proyectosemana4c3.pojo.Mascota;

public class ListaMascotasFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    public ListaMascotasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lista_mascotas, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.miRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(layoutManager);

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.perro1, "Nombre"));
        mascotas.add(new Mascota(R.drawable.perro2, "Nombre"));
        mascotas.add(new Mascota(R.drawable.perro3, "Nombre"));
        mascotas.add(new Mascota(R.drawable.perro4, "Nombre"));
        mascotas.add(new Mascota(R.drawable.perro5, "Nombre"));
        mascotas.add(new Mascota(R.drawable.perro6, "Nombre"));

        MascotaAdapter adapter = new MascotaAdapter(mascotas);
        listaMascotas.setAdapter(adapter);
        return v;


    }

}
