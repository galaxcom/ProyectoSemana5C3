package mx.galaxcom.proyectosemana4c3;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by david on 17/12/2017.
 */

public class SendMailAsynTask extends AsyncTask<Void, Void, Void> {
    //Declarar variables
    private Context context;
    private Session session;

    //Información para enviar el mail
    private String subject;
    private String message;

    //Dialogo de progreso que se mostrará mientras el mail se envía
    private ProgressDialog progressDialog;

    //Constructor
    public SendMailAsynTask(Context context, String subject, String message) {
        this.context = context;
        this.subject = subject;
        this.message = message;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //Mostrar el dialogo de progreso mientras se envía el email
        progressDialog = ProgressDialog.show(context, "Enviando mensaje", "Por favor espere...", false, false);
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //Quitar el dialogo de progreso
        progressDialog.dismiss();
        //Mostrar un mensaje de "mensaje enviado"
        Toast.makeText(context, "Mensaje enviado", Toast.LENGTH_LONG).show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        //Crear las propiedades
        Properties props = new Properties();
        //Configurar las propiedades
        props.put("mail.smtp.host", "mail.gx-com.net");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        //Crear una nueva sesión
        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    //Verificar el password
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Config.EMAIL, Config.PASSWORD);
                    }
                });
        try {
            //Crear objeto MimeMessage
            MimeMessage mm = new MimeMessage(session);

            mm.setFrom(new InternetAddress(Config.EMAIL));

            mm.addRecipient(Message.RecipientType.TO, new InternetAddress("galaxcom@gmail.com"));

            mm.setSubject(subject);

            mm.setText(message);

            Transport.send(mm);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
