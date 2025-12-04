package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Prestamo;

import java.util.Optional;

public class prestamodaoImpl implements PrestamoDao{
    private EntityManager em;

    public prestamodaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean crearPrestamo(Prestamo prestamo) {
        EntityTransaction et= em.getTransaction();
        try{
            et.begin();
            em.persist(prestamo);
            et.commit();
            return true;
        } catch (RuntimeException e) {
            if(et.isActive()){
                et.rollback();
                return false;
            }
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<Prestamo> buscarPorID(int id) {
        Prestamo l = em.find(Prestamo.class,id);
        return Optional.of(l);
    }

    @Override
    public Prestamo actulizarPrestamo(Prestamo prestamo) {
        EntityTransaction et= em.getTransaction();
        try{
            et.begin();
            Prestamo l=em.merge(prestamo);
            et.commit();
            return l;
        } catch (RuntimeException e) {
            if(et.isActive()){
                et.rollback();
            }
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean eliminarPrestamo(Prestamo prestamo) {
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            Optional<Prestamo> l = this.buscarPorID(prestamo.getId());
            if(l.isPresent()) {
                em.remove(prestamo);
                et.commit();
                return true;
            }
            return false;
        } catch (RuntimeException e) {
            if(et.isActive()){
                et.rollback();
                return false;
            }
            throw new RuntimeException(e.getMessage());
        }
    }
}
