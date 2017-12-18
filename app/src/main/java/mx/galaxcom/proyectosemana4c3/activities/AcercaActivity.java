package mx.galaxcom.proyectosemana4c3.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import mx.galaxcom.proyectosemana4c3.R;

public class AcercaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);

        android.support.v7.widget.Toolbar miToolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miToolbar);
    }
}
