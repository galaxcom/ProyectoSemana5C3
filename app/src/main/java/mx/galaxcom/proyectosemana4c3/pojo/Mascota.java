package mx.galaxcom.proyectosemana4c3.pojo;

/**
 * Created by david on 07/12/2017.
 */

public class Mascota {
    private int imagen;
    private String nombre;
    public String rating = "5";

    public Mascota(int imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
