package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="nombre",length=100,nullable = false)
    private String nombre;
    @Column(name="nacionalidad",length = 50)
    private String nacionalidad;

    @OneToMany(mappedBy = "autor_id",cascade = CascadeType.ALL)
    private List<Libro> libros;



    public Autor( String nacionalidad, String nombre) {

        this.nacionalidad = nacionalidad;
        this.nombre = nombre;
    }
    public Autor(){}




    public List<Libro> getListalibros() {
        return libros;
    }

    public void setListaLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public void anadirLibros(Libro p){
        this.libros.add(p);
    }

    public void borrarLibro(Libro p){
        this.libros.remove(p);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", libros='" + libros.size() + '\'' +
                '}';
    }
}
