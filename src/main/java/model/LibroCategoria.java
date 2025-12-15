package model;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "libro_categoria")
public class LibroCategoria {

    @EmbeddedId
    private LibroCategoriaid id;


    @ManyToOne
    @MapsId("categoria_id")
    @JoinColumn(name = "categoria_id")
    private Categoria categoria_id;

    @ManyToOne
    @MapsId("libro_id")
    @JoinColumn(name = "libro_id")
    private Libro libro_id;

    @Column(name = "puntuacion")
    private int puntuacion;

    public LibroCategoria( Categoria categoria_id, Libro libro_id, int puntuacion) {

        this.categoria_id = categoria_id;
        this.libro_id = libro_id;
        this.puntuacion = puntuacion;
    }

    public LibroCategoria() {
    }

    public LibroCategoriaid getId() {
        return id;
    }

    public void setId(LibroCategoriaid id) {
        this.id = id;
    }

    public Categoria getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Categoria categoria_id) {
        this.categoria_id = categoria_id;
    }

    public Libro getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(Libro libro_id) {
        this.libro_id = libro_id;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "LibroCategoria{" +
                "id=" + id +
                ", categoria_id=" + categoria_id +
                ", libro_id=" + libro_id +
                ", puntuacion=" + puntuacion +
                '}';
    }
}
