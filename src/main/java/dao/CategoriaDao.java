package dao;

import model.Categoria;
import model.Usuario;

import java.util.Optional;

public interface CategoriaDao {
    boolean crearCategoria(Categoria categoria);
    Optional<Categoria> buscarPorID(int id);
    Categoria actulizarCategoria(Categoria categoria);
    boolean eliminarCategoria(Categoria categoria);
}
