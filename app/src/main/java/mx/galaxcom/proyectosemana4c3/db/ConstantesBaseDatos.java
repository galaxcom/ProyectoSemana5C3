package mx.galaxcom.proyectosemana4c3.db;

/**
 * Created by david on 22/12/2017.
 */

public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLA_MASCOTAS        = "mascota";
    public static final String TABLA_MASCOTAS_ID     = "id";
    public static final String TABLA_MASCOTAS_NOMBRE = "nombre";
    public static final String TABLA_MASCOTAS_IMAGEN = "imagen";

    public static final String TABLA_MASCOTAS_LIKES  = "mascota_likes";
    public static final String TABLA_MASCOTAS_LIKES_ID = "id";
    public static final String TABLA_MASCOTAS_LIKES_ID_MASCOTA = "id_contacto";
    public static final String TABLA_MASCOTAS_LIKES_NUMERO_LIKES = "numero_likes";
}
