package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="nombre",unique = true,nullable = false,length = 50)
    private String nombre;
    @Column(name = "descripcion",length = 255)
    private String descripcion;

    @OneToMany(mappedBy = "categoria_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LibroCategoria> listaLibroCategoria = new ArrayList<>();

    public Categoria( String nombre, String descripcion) {

        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public Categoria(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}


