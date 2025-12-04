package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import model.Autor;

import java.util.List;
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
            TypedQuery<Autor> q = em.createQuery(
                    "SELECT count(a) FROM Autor a WHERE a.nombre = :nombre",
                    Autor.class
            );
            q.setParameter("nombre", autor.getNombre());


            List<Autor> existe = q.getResultList();
            if (existe.size() > 0) {
                return false;
            }
            e.begin();
            em.persist(autor);
            e.commit();
            return true;


        } catch (RuntimeException ex) {
            if (e.isActive()) {
                e.rollback();
                return false;
            }
            throw new RuntimeException(ex.getMessage());
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
            Autor a = em.find(Autor.class, autor.getId());
            if (a != null) {
                em.remove(autor);
                tran.commit();
                return true;
            }
            return false;

        } catch (RuntimeException e) {
            if (tran.isActive()) {
                tran.rollback();
            }
            return false;
        }
    }
}
