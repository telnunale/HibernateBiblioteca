package dao;


import model.Ejemplar;
import java.util.Optional;

public interface EjemplarDao {
    boolean crearEjemplar(Ejemplar ejemplar);
    Optional<Ejemplar> buscarPorID(int id);
    Ejemplar actulizarEjemplar(Ejemplar ejemplar);
    boolean eliminarEjemplar(Ejemplar ejemplar);
}
