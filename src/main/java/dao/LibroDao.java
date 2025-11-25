package dao;

import model.Categoria;
import model.Libro;

import java.util.Optional;

public interface LibroDao {
    boolean crearLibro(Libro libro);
    Optional<Libro> buscarPorID(int id);
    Libro actulizarLibro(Libro libro);
    boolean eliminarLibro(Libro libro);
}
