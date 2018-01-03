package mx.galaxcom.proyectosemana4c3.vista;

import android.app.Activity;

import java.util.ArrayList;

import mx.galaxcom.proyectosemana4c3.adapters.MascotaAdapter;
import mx.galaxcom.proyectosemana4c3.pojo.Mascota;

/**
 * Created by david on 21/12/2017.
 */

public interface ILista5MascotasView {
    public void crearLayoutManager();

    public MascotaAdapter crearAdapter(ArrayList<Mascota> mascotas);

    public void inicializarAdapter(MascotaAdapter adapter);

}
