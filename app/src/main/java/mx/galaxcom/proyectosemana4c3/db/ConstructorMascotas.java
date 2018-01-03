package mx.galaxcom.proyectosemana4c3.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import mx.galaxcom.proyectosemana4c3.R;
import mx.galaxcom.proyectosemana4c3.pojo.Mascota;

/**
 * Created by david on 21/12/2017.
 */

public class ConstructorMascotas {
    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context){
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        insertarSeisMascotas(db);

        return db.obtenerMascotas();
    }

    public void insertarSeisMascotas(BaseDatos db){
        /* Mascota 1*/
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Nombre 1");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_IMAGEN, R.drawable.perro1);

        db.insertarMascotas(contentValues);

        /* Mascota 2*/
        contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Nombre 2");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_IMAGEN, R.drawable.perro2);

        db.insertarMascotas(contentValues);

        /* Mascota 3*/
        contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Nombre 3");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_IMAGEN, R.drawable.perro3);

        db.insertarMascotas(contentValues);

        /* Mascota 4*/
        contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Nombre 4");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_IMAGEN, R.drawable.perro4);

        db.insertarMascotas(contentValues);

        /* Mascota 5*/
        contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Nombre 5");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_IMAGEN, R.drawable.perro5);

        db.insertarMascotas(contentValues);

        /* Mascota 6*/
        contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Nombre 6");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_IMAGEN, R.drawable.perro6);

        db.insertarMascotas(contentValues);

    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_LIKES_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_LIKES_NUMERO_LIKES, LIKE);

        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }

    public ArrayList<Mascota> obtenerMascotasUltimosLikes(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerMascotasUltimosLikes();
    }
}
