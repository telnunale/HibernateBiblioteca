package dao;

import model.Autor;

import java.util.Optional;

public interface AutorDao {
    boolean crearAutor(Autor autor);
    Optional<Autor> buscarPorID(int id);
    Autor actulizarAutor(Autor autor);
    boolean eliminarAutor(Autor autor);
}
