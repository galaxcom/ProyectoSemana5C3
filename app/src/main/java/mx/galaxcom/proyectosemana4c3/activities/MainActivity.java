package mx.galaxcom.proyectosemana4c3.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import mx.galaxcom.proyectosemana4c3.R;
import mx.galaxcom.proyectosemana4c3.adapters.PageAdapter;
import mx.galaxcom.proyectosemana4c3.fragments.ListaMascotasFragment;
import mx.galaxcom.proyectosemana4c3.fragments.PerfilFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        crearViewPager();

        //setSupportActionBar(miToolbar);*/

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments =  new ArrayList<>();

        fragments.add(new ListaMascotasFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void crearViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_profile);
    }

    public void estrellaOnClick(MenuItem menuItem){
        Intent intent = new Intent(MainActivity.this, Lista5Mascotas.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.miContacto:
                Intent intent = new Intent(MainActivity.this, ContactoActivity.class);
                startActivity(intent);
                break;
            case R.id.miAcercaDe:
                Intent i = new Intent(MainActivity.this, AcercaActivity.class);
                startActivity(i);
        }


        return super.onOptionsItemSelected(item);
    }
}

