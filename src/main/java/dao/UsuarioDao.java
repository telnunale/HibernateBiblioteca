package dao;

import model.Prestamo;
import model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioDao {
    boolean crearUsuario(Usuario usuario);
    Optional<Usuario> buscarPorID(int id);
    Usuario actulizarUsuario(Usuario usuario);
    boolean eliminarUsuario(Usuario usuario);
    public Optional<Usuario> findByDni(String dni);
    public List<Object[]> usuariosFavoritos();

}
