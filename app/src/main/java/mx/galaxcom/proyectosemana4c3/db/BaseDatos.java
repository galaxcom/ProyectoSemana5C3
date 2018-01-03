package mx.galaxcom.proyectosemana4c3.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

import mx.galaxcom.proyectosemana4c3.pojo.Mascota;

/**
 * Created by david on 22/12/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLA_MASCOTAS + "(" +
                                        ConstantesBaseDatos.TABLA_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE + " TEXT UNIQUE, " +
                                        ConstantesBaseDatos.TABLA_MASCOTAS_IMAGEN + " INTEGER" +
                                        ")";
        String queryCrearTablaMascotaLikes = "CREATE TABLE " + ConstantesBaseDatos.TABLA_MASCOTAS_LIKES + "(" +
                                            ConstantesBaseDatos.TABLA_MASCOTAS_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                            ConstantesBaseDatos.TABLA_MASCOTAS_LIKES_ID_MASCOTA + " INTEGER, " +
                                            ConstantesBaseDatos.TABLA_MASCOTAS_LIKES_NUMERO_LIKES + " INTEGER, " +
                                            "FOREIGN KEY (" + ConstantesBaseDatos.TABLA_MASCOTAS_LIKES_ID_MASCOTA + ") " +
                                            "REFERENCES " + ConstantesBaseDatos.TABLA_MASCOTAS + "(" + ConstantesBaseDatos.TABLA_MASCOTAS_ID + ")" +
                                            ")";
        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaMascotaLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLA_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLA_MASCOTAS_LIKES);
        onCreate(db);

    }

    public ArrayList<Mascota> obtenerMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLA_MASCOTAS ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setImagen(registros.getInt(2));

            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }

    public void insertarMascotas(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLA_MASCOTAS, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLA_MASCOTAS_LIKES, null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;

        String query  = "SELECT COUNT(" + ConstantesBaseDatos.TABLA_MASCOTAS_LIKES_NUMERO_LIKES + ")" +
                        " FROM " + ConstantesBaseDatos.TABLA_MASCOTAS_LIKES +
                        " WHERE " + ConstantesBaseDatos.TABLA_MASCOTAS_LIKES_ID_MASCOTA + "=" + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();
        return likes;
    }

    public ArrayList<Mascota> obtenerMascotasUltimosLikes(){
        ArrayList<Mascota> ultimasMascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLA_MASCOTAS_LIKES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        registros.moveToLast();

        try {
                for(int i = 1; i <= 5; i++){

                    int mascotaId = registros.getInt(1);

                /*Crear un nuevo objeto Mascota*/
                    Mascota mascota = new Mascota();

                /*Creamos un nuevo cursor*/
                    String mascota_query = "SELECT * FROM " + ConstantesBaseDatos.TABLA_MASCOTAS + " WHERE " + ConstantesBaseDatos.TABLA_MASCOTAS_ID + " = " + mascotaId;
                    SQLiteDatabase bd = this.getReadableDatabase();
                    Cursor cursor = bd.rawQuery(mascota_query, null);

                    if(cursor != null){
                        cursor.moveToFirst();

                    /*Obtener el nombre de la mascota*/
                        String mascotaNombre;
                        mascotaNombre = cursor.getString(1);
                        mascota.setNombre(mascotaNombre);

                    /*Obtener la imagen de la mascota*/
                        int mascotaFoto;
                        mascotaFoto = cursor.getInt(2);
                        mascota.setImagen(mascotaFoto);

                    /*Agregar la mascota al ArrayList ultimasMascotas*/
                        ultimasMascotas.add(mascota);

                    /*Nos movemos al like previo*/
                        registros.moveToPrevious();

                    /*Cerramos*/
                        bd.close();
                    }
                }
        }
        catch (CursorIndexOutOfBoundsException noHayLikes){
            Toast.makeText(context, "No has dado like a suficientes mascotas", Toast.LENGTH_LONG).show();
        }

        db.close();

        return ultimasMascotas;
    }
}
