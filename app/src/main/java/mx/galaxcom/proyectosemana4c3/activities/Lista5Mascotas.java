package mx.galaxcom.proyectosemana4c3.activities;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.*;

import java.util.ArrayList;

import mx.galaxcom.proyectosemana4c3.vista.ILista5MascotasView;
import mx.galaxcom.proyectosemana4c3.R;
import mx.galaxcom.proyectosemana4c3.adapters.MascotaAdapter;
import mx.galaxcom.proyectosemana4c3.pojo.Mascota;
import mx.galaxcom.proyectosemana4c3.presentador.ILista5MascotasPresenter;
import mx.galaxcom.proyectosemana4c3.presentador.Lista5MascotasPresenter;

public class Lista5Mascotas extends AppCompatActivity implements ILista5MascotasView {

    ArrayList<Mascota> misMascotas;
    private RecyclerView miListaMascotas;
    private ILista5MascotasPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista5_mascotas);

        android.support.v7.widget.Toolbar miToolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        miListaMascotas = (RecyclerView) findViewById(R.id.rvActivity2);

        presenter = new Lista5MascotasPresenter(this, this);

        crearLayoutManager();

        misMascotas = new ArrayList<Mascota>();

    }

    @Override
    public void crearLayoutManager() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        miListaMascotas.setLayoutManager(linearLayoutManager);
    }

    @Override
    public MascotaAdapter crearAdapter(ArrayList<Mascota> mascotas) {
        MascotaAdapter miAdapter = new MascotaAdapter(mascotas, this);
        return miAdapter;
    }

    @Override
    public void inicializarAdapter(MascotaAdapter adapter) {
        miListaMascotas.setAdapter(adapter);
    }
}
