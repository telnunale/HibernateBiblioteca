package model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LibroCategoriaid  implements Serializable {
    @Column(name = "categoria_id")
    private int categoria_id;

    @Column(name = "libro_id")
    private int libro_id;


    public LibroCategoriaid(int categoria_id, int libro_id) {
        this.categoria_id = categoria_id;
        this.libro_id = libro_id;
    }

    public LibroCategoriaid() {
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public int getModuloId() {
        return libro_id;
    }

    public void setModuloId(int moduloId) {
        this.libro_id = moduloId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LibroCategoriaid that = (LibroCategoriaid) o;
        return Objects.equals(categoria_id, that.categoria_id) && Objects.equals(libro_id, that.libro_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoria_id, libro_id);
    }

    @Override
    public String toString() {
        return "LibroCategoriaid{" +
                "categoria_id=" + categoria_id +
                ", moduloId=" + libro_id +
                '}';
    }
}
