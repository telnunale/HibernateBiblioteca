package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Autor;
import model.Categoria;
import model.Usuario;

import java.util.Optional;

public class categoriadaoImpl implements CategoriaDao{
    EntityManager em;

    public categoriadaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean crearCategoria(Categoria categoria) {
        EntityTransaction e = em.getTransaction();
        try {
            e.begin();
            em.persist(categoria);
            e.commit();
            return true;
        } catch (RuntimeException ex) {
            e.rollback();
            return false;
        }
    }

    @Override
    public Optional<Categoria> buscarPorID(int id) {
        Categoria c = em.find(Categoria.class, id);
        return Optional.of(c);
    }

    @Override
    public Categoria actulizarCategoria(Categoria categoria) {
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            Categoria a = em.merge(categoria);
            tran.commit();
            return a;
        } catch (RuntimeException e) {
            tran.rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean eliminarCategoria(Categoria categoria) {
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            Optional<Categoria> a = this.buscarPorID(categoria.getId());
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
