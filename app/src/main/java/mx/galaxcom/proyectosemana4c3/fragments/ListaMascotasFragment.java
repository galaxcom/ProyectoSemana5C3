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
import mx.galaxcom.proyectosemana4c3.presentador.IListaMascotasFragmentPresenter;
import mx.galaxcom.proyectosemana4c3.presentador.ListaMascotasFragmentPresenter;
import mx.galaxcom.proyectosemana4c3.vista.IListaMascotasFragmentView;

public class ListaMascotasFragment extends Fragment implements IListaMascotasFragmentView{

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IListaMascotasFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lista_mascotas, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.miRecyclerView);

        crearLayoutManager();

        mascotas = new ArrayList<Mascota>();

        presenter =  new ListaMascotasFragmentPresenter(this, getContext());

        mascotas.add(new Mascota(R.drawable.perro1, "Nombre", 0));
        mascotas.add(new Mascota(R.drawable.perro2, "Nombre", 0));
        mascotas.add(new Mascota(R.drawable.perro3, "Nombre", 0));
        mascotas.add(new Mascota(R.drawable.perro4, "Nombre", 0));
        mascotas.add(new Mascota(R.drawable.perro5, "Nombre", 0));
        mascotas.add(new Mascota(R.drawable.perro6, "Nombre", 0));


        return v;
    }

    @Override
    public void crearLayoutManager() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(layoutManager);

    }

    @Override
    public MascotaAdapter crearAdapter(ArrayList<Mascota> mascotas) {
        MascotaAdapter adapter = new MascotaAdapter(mascotas, getActivity());
        return adapter;
    }

    @Override
    public void inicializarAdapter(MascotaAdapter adapter) {
        listaMascotas.setAdapter(adapter);
    }
}
