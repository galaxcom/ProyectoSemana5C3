package mx.galaxcom.proyectosemana4c3.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mx.galaxcom.proyectosemana4c3.R;
import mx.galaxcom.proyectosemana4c3.SendMailAsynTask;

public class ContactoActivity extends AppCompatActivity {

    EditText etNombre, etEmail, etMensaje;
    Button btnEnviarMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        android.support.v7.widget.Toolbar miToolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miToolbar);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etEmail = (EditText) findViewById(R.id.etCorreo);
        etMensaje = (EditText) findViewById(R.id.etMensaje);
        btnEnviarMail = (Button) findViewById(R.id.btnEnviarCorreo);

        btnEnviarMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mSubject = (etNombre.getText().toString() + " te envió un mensaje");
                String mMessage = ("Email del Contacto:" + etEmail.getText().toString() + " Mensaje: " + etMensaje.getText().toString());
                new SendMailAsynTask(ContactoActivity.this, mSubject, mMessage).execute();
            }
        });

    }
}
