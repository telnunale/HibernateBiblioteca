package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="ejemplar")
public class Ejemplar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="codigo",length = 50,unique = true,nullable = false)
    private String codigo;
    @Column(name="ubicacion")
    private String ubicacion;
    @Enumerated(EnumType.STRING)
    @Column(name="estado")
    private EstadoENUM estado;


    @OneToMany(mappedBy = "ejemplar_id",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Prestamo> listaPrestamo;

    public Ejemplar(List<Prestamo> listaPrestamo) {
        this.listaPrestamo = listaPrestamo;
    }

    public Ejemplar(String codigo, String ubicacion, EstadoENUM estado) {

        this.codigo = codigo;
        this.ubicacion = ubicacion;
        this.estado = estado;

    }

    public List<Prestamo> getlistaPrestamo() {
        return listaPrestamo;
    }

    public void setlistaPrestamo(List<Prestamo> listaPrestamo) {
        this.listaPrestamo = listaPrestamo;
    }


    public void anadirPrestamo(Prestamo e){
        this.listaPrestamo.add(e);
    }

    public void borrarPrestamo(Prestamo e){
        this.listaPrestamo.remove(e);
    }
    public Ejemplar() {
         this.estado= EstadoENUM.DISPONIBLE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public EstadoENUM getEstado() {
        return estado;
    }

    public void setEstado(EstadoENUM estado) {
        this.estado = estado;
    }



    @Override
    public String toString() {
        return "Ejemplar{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", estado=" + estado +
                ", cantida de prestamos=" + this.listaPrestamo.size() +
                '}';
    }
}