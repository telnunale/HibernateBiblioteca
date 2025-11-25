package model;

import jakarta.persistence.*;

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
    @Column(name="libro_id",nullable = false)
    private int libro_id;

    public Ejemplar(int id, String codigo, String ubicacion, EstadoENUM estado, int libro_id) {
        this.id = id;
        this.codigo = codigo;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.libro_id = libro_id;
    }

    public Ejemplar(EstadoENUM estado) {
         this.estado= estado;
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

    public int getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(int libro_id) {
        this.libro_id = libro_id;
    }

    @Override
    public String toString() {
        return "Ejemplar{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", estado=" + estado +
                ", libro_id=" + libro_id +
                '}';
    }
}