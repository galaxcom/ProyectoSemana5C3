package mx.galaxcom.proyectosemana4c3.presentador;

import android.content.Context;

import java.util.ArrayList;

import mx.galaxcom.proyectosemana4c3.db.ConstructorMascotas;
import mx.galaxcom.proyectosemana4c3.pojo.Mascota;
import mx.galaxcom.proyectosemana4c3.vista.IListaMascotasFragmentView;

/**
 * Created by david on 22/12/2017.
 */

public class ListaMascotasFragmentPresenter implements IListaMascotasFragmentPresenter {
    ConstructorMascotas constructorMascotas;
    ArrayList<Mascota> mascotas;
    Context context;
    IListaMascotasFragmentView vista;

    public ListaMascotasFragmentPresenter (IListaMascotasFragmentView vista, Context context){
        this.vista = vista;
        this.context = context;
        obtenerMascotasBaseDatos();
    }
    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        vista.inicializarAdapter(vista.crearAdapter(mascotas));
    }

}
