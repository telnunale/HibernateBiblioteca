package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Autor;

import java.util.Optional;

public class autordaoImpl implements AutorDao {
    EntityManager em;

    public autordaoImpl(EntityManager e) {
        this.em = e;
    }

    @Override
    public boolean crearAutor(Autor autor) {
        EntityTransaction e = em.getTransaction();
        try {
            e.begin();
            em.persist(autor);
            e.commit();
            return true;
        } catch (RuntimeException ex) {
            e.rollback();
            return false;
        }
    }

    @Override
    public Optional<Autor> buscarPorID(int id) {
        Autor a = em.find(Autor.class, id);
        return Optional.of(a);
    }

    @Override
    public Autor actulizarAutor(Autor autor) {
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            Autor a = em.merge(autor);
            tran.commit();
            return a;
        } catch (RuntimeException e) {
            tran.rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean eliminarAutor(Autor autor) {
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            Optional<Autor> a = this.buscarPorID(autor.getId());
            if (a.isPresent()) {
                em.remove(a.get().getId());
                tran.commit();
                return true;
            }
            return false;
        } catch (RuntimeException e) {
            tran.rollback();
            return false;
        }
    }
}
