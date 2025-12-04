package model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "isbn", unique = true, nullable = false, length = 20)
    private String isbn;
    @Column(name = "fecha_publicacion")
    private LocalDate fecha_publicacion;
    @Column(name = "paginas")
    private int paginas;
    @Column(name = "titulo", length = 200)
    private String titulo;
    @Column(name = "editorial", length = 100)
    private String editorial;
    //Un Libro va tener un autor
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor_id;
    //Un libro puede tener muchas categorias
   @JoinColumn(name = "categoria_id", nullable = false)
    private int categoria_id;

    @OneToMany(mappedBy = "libro_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LibroCategoria> listaLibroCategoria;

    //tabla intermedia
    @ManyToMany(mappedBy = "librosFavoritos") // Relación inversa
    private List<Usuario> listaUsuariosConLibrosFavoritos;

    public Libro( int categoria_id, Autor autor_id, String editorial, String titulo, int paginas, LocalDate fecha_publicacion, String isbn, int id) {
        this.listaUsuariosConLibrosFavoritos = new ArrayList<>();
        this.listaLibroCategoria = new ArrayList<>();
        this.categoria_id = categoria_id;
        this.autor_id = autor_id;
        this.editorial = editorial;
        this.titulo = titulo;
        this.paginas = paginas;
        this.fecha_publicacion = fecha_publicacion;
        this.isbn = isbn;
        this.id = id;
    }

    public Libro() {
    }
    public List<Usuario> getUsuarios() {
        return listaUsuariosConLibrosFavoritos;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.listaUsuariosConLibrosFavoritos = usuarios;
    }
    public void anadirUsuarioFavorito(Usuario u){
        this.listaUsuariosConLibrosFavoritos.add(u);
    }
    public void borrarUsuarioFavorito(Usuario u){
        this.listaUsuariosConLibrosFavoritos.remove(u);
    }
    public int getId() {
        return id;
    }

    public List<LibroCategoria> getListaLibroCategoria() {
        return listaLibroCategoria;
    }

    public void setListaLibroCategoria(List<LibroCategoria> listaLibroCategoria) {
        this.listaLibroCategoria = listaLibroCategoria;
    }

    public List<Usuario> getListaUsuariosConLibrosFavoritos() {
        return listaUsuariosConLibrosFavoritos;
    }

    public void setListaUsuariosConLibrosFavoritos(List<Usuario> listaUsuariosConLibrosFavoritos) {
        this.listaUsuariosConLibrosFavoritos = listaUsuariosConLibrosFavoritos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(LocalDate fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Autor getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(Autor autor_id) {
        this.autor_id = autor_id;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", fecha_publicacion=" + fecha_publicacion +
                ", paginas=" + paginas +
                ", editorial='" + editorial + '\'' +
                ", autor_id=" + autor_id +
                ", categoria_id=" + categoria_id +
                '}';
    }
}
