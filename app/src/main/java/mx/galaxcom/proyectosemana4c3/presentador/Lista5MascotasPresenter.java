package mx.galaxcom.proyectosemana4c3.presentador;

import android.content.Context;

import java.util.ArrayList;

import mx.galaxcom.proyectosemana4c3.vista.ILista5MascotasView;
import mx.galaxcom.proyectosemana4c3.db.ConstructorMascotas;
import mx.galaxcom.proyectosemana4c3.pojo.Mascota;

/**
 * Created by david on 21/12/2017.
 */

public class Lista5MascotasPresenter implements ILista5MascotasPresenter {
    private ILista5MascotasView vista;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public Lista5MascotasPresenter(ILista5MascotasView vista, Context context){
        this.vista = vista;
        this.context = context;
        obtenerUltimasMascotasBaseDatos();
    }

    @Override
    public void obtenerUltimasMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerMascotasUltimosLikes();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        vista.inicializarAdapter(vista.crearAdapter(mascotas));
    }
}
