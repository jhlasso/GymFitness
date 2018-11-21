package jhlasso.gymfitness.Clases;

import java.io.Serializable;

import pl.droidsonroids.gif.GifImageView;

public class EjercicioVo implements Serializable {

    private String nombre;
    private String info;
    private String descripcion;
    private String consejo;
    private int foto;
    private int imagenDetaller;

    public EjercicioVo(String nombre, String info, String descripcion, String consejo, int foto, int imagenDetaller) {
        this.nombre = nombre;
        this.info = info;
        this.descripcion = descripcion;
        this.consejo = consejo;
        this.foto = foto;
        this.imagenDetaller = imagenDetaller;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getConsejo() {
        return consejo;
    }

    public void setConsejo(String consejo) {
        this.consejo = consejo;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getImagenDetaller() {
        return imagenDetaller;
    }

    public void setImagenDetaller(int imagenDetaller) {
        this.imagenDetaller = imagenDetaller;
    }
}
