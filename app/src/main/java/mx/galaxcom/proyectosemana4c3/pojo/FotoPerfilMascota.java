package mx.galaxcom.proyectosemana4c3.pojo;

/**
 * Created by david on 15/12/2017.
 */

public class FotoPerfilMascota {
    private int foto;
    private String rating;

    public FotoPerfilMascota(int foto, String rating){
        this.foto = foto;
        this.rating = rating;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
