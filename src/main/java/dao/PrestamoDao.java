package dao;

import criteria.PrestamoCriteria;
import model.Categoria;
import model.EstadoPrestamoEnum;
import model.Prestamo;

import java.util.List;
import java.util.Optional;

public interface PrestamoDao {
    boolean crearPrestamo(Prestamo prestamo);
    Optional<Prestamo> buscarPorID(int id);
    Prestamo actulizarPrestamo(Prestamo prestamo);
    boolean eliminarPrestamo(Prestamo prestamo);
    public List<Prestamo> recuperarTodos();
    public List<Prestamo> getPrestamoEstado(EstadoPrestamoEnum estado);
    public List<Prestamo> getPrestamoCriteria(PrestamoCriteria p);
}
