package model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestamo")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fecha_inicio")
    private LocalDate fecha_inicio;
    @Column(name = "fecha_devolucion")
    private LocalDate fecha_devolucion;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoPrestamoEnum estado;

    @Column(name = "fecha_fin")
    private LocalDate fecha_fin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ejemplar_id", nullable = false)
    private Ejemplar ejemplar_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario_id;


    public Prestamo(LocalDate fecha_inicio, LocalDate fecha_devolucion, EstadoPrestamoEnum estado, Ejemplar ejemplar_id, Usuario usuario_id) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_devolucion = fecha_devolucion;
        this.estado = estado;
        this.ejemplar_id = ejemplar_id;
        this.usuario_id = usuario_id;
        this.fecha_fin= this.fecha_inicio.plusDays(7);
    }

    public Prestamo(EstadoPrestamoEnum estado) {
        this.estado = estado;
    }

    public Prestamo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(LocalDate fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public EstadoPrestamoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoPrestamoEnum estado) {
        this.estado = estado;
    }

    public Ejemplar getEjemplar_id() {
        return ejemplar_id;
    }

    public void setEjemplar_id(Ejemplar ejemplar_id) {
        this.ejemplar_id = ejemplar_id;
    }

    public Usuario getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Usuario usuario_id) {
        this.usuario_id = usuario_id;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_devolucion=" + fecha_devolucion +
                ", estado=" + estado +
                ", ejemplar_id=" + this.ejemplar_id +
                ", usuario_id=" + this.usuario_id +
                '}';
    }
}
