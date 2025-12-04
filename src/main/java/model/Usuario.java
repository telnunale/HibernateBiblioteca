package model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="dni",unique = true,nullable = false,length=20)
    private String dni;
    @Column(name="nombre",nullable = false,length=100)
    private String nombre;
    @Column(name="apellidos",nullable = false,length=100)
    private String apellidos;
    @Column(name="email",unique = true,nullable = false,length=100)
    private String email;
    @Column(name="telefono",length=20)
    private String telefono;
    @Column(name="fecha_nacimiento")
    private LocalDate fecha_nacimiento;
    @Column(name="fecha_registro")
    private LocalDateTime fecha_registro;

    @OneToMany(mappedBy = "usuario_id",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Prestamo> listaPrestamo;

    //tabla intermedia

    //Lado propiteatio porque tiene la join table
    @ManyToMany
    @JoinTable(
            name = "favoritos",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id")
    )
    private List<Libro> librosFavoritos;

    public Usuario(LocalDateTime fecha_registro, LocalDate fecha_nacimiento, String email, String telefono, String nombre, String apellidos, String dni) {
        this.fecha_registro = fecha_registro;
        this.fecha_nacimiento = fecha_nacimiento;
        this.email = email;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.librosFavoritos=new ArrayList<>();
    }
    public Usuario() {

    }

    public List<Libro> getLibrosFavoritos() {
        return librosFavoritos;
    }
    public void anadirLibroFavorito(Libro l){
        this.librosFavoritos.add(l);
    }
    public void borrarLibroFavorito(Libro l){
        this.librosFavoritos.add(l);
    }



    public void setLibrosFavoritos(List<Libro> libros) {
        this.librosFavoritos = libros;
    }

    public List<Prestamo> getListaPrestamo() {
        return listaPrestamo;
    }

    public void setListaPrestamo(List<Prestamo> listaPrestamo) {
        this.listaPrestamo = listaPrestamo;
    }

    public void anadirPrestamo(Prestamo p){
        this.listaPrestamo.add(p);
    }

    public void borrarPrestamo(Prestamo p){
        this.listaPrestamo.remove(p);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }



    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", fecha_registro=" + fecha_registro +
                ",prestamo="+ this.listaPrestamo.size() +
                '}';
    }
}
