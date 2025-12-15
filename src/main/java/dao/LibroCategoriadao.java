package dao;

import model.LibroCategoria;

import java.util.Optional;

public interface LibroCategoriadao {
    boolean crearLibroCategoria(LibroCategoria lb);
    Optional<LibroCategoria> buscarPorID(int id);
    boolean eliminarLibroCategoria(LibroCategoria lb);
}
