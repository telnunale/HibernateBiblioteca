package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Libro;

import java.util.Optional;

public class librodaoImpl implements LibroDao{
    private EntityManager em;

    public librodaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean crearLibro(Libro libro) {
        EntityTransaction et= em.getTransaction();
        try{
            et.begin();
            em.persist(libro);
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
    public Optional<Libro> buscarPorID(int id) {
        Libro l = em.find(Libro.class,id);
        return Optional.of(l);
    }

    @Override
    public Libro actulizarLibro(Libro libro) {
        EntityTransaction et= em.getTransaction();
        try{
            et.begin();
            Libro l=em.merge(libro);
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
    public boolean eliminarLibro(Libro libro) {
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            Optional<Libro> l = this.buscarPorID(libro.getId());
            if(l.isPresent()) {
                em.remove(libro);
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
