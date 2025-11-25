package dao;

import model.Categoria;
import model.Prestamo;

import java.util.Optional;

public interface PrestamoDao {
    boolean crearPrestamo(Prestamo prestamo);
    Optional<Prestamo> buscarPorID(int id);
    Prestamo actulizarPrestamo(Prestamo prestamo);
    boolean eliminarPrestamo(Prestamo prestamo);
}
