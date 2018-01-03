package mx.galaxcom.proyectosemana4c3.pojo;

/**
 * Created by david on 07/12/2017.
 */

public class Mascota {
    private int id;
    private int imagen;
    private String nombre;
    private int rating;

    public Mascota(int imagen, String nombre, int rating) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.rating = rating;
    }

    public Mascota(){
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
