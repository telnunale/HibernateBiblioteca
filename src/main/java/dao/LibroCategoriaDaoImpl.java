package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.LibroCategoria;

import java.util.Optional;

public class LibroCategoriaDaoImpl implements LibroCategoriadao{

    EntityManager em;

    public LibroCategoriaDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean crearLibroCategoria(LibroCategoria lb) {
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(lb);
            et.commit();
            return true;
        } catch (RuntimeException e) {
            et.rollback();
            return false;
        }
        //return false;
    }

    @Override
    public Optional<LibroCategoria> buscarPorID(int id) {
        return Optional.empty();
    }

    @Override
    public boolean eliminarLibroCategoria(LibroCategoria lb) {
        return false;
    }
}
