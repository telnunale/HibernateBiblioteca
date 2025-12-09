package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import model.EstadoPrestamoEnum;
import model.Libro;
import model.Prestamo;

import java.util.List;
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
    public List<Libro> recuperarTodos(){
        String jpql="Select l FROM Libro p";
        TypedQuery<Libro> query =em.createQuery(jpql,Libro.class);
        return query.getResultList();
    }
    /*public Optional<Libro> getLibroPorTitulo(String titulo){
        String jpql="Select l FROM Libro l where l.titulo = :tituloParam";
        TypedQuery<Libro> query=em.createQuery(jpql, Libro.class);
        query.setParameter("tituloParam",titulo);
        return Optional.of((Libro) query.getSingleResult());
    }*/

}
