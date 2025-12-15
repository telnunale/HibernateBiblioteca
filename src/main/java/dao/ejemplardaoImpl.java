package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Autor;
import model.Ejemplar;

import java.util.Optional;

public class ejemplardaoImpl implements EjemplarDao{
    private EntityManager em;

    public ejemplardaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean crearEjemplar(Ejemplar ejemplar) {
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(ejemplar);
            et.commit();
            return true;
        } catch (RuntimeException e) {
            et.rollback();
            return false;
        }
    }

    @Override
    public Optional<Ejemplar> buscarPorID(int id) {
        Ejemplar e = em.find(Ejemplar.class,id);
        return Optional.of(e);
    }

    @Override
    public Ejemplar actulizarEjemplar(Ejemplar ejemplar) {
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            Ejemplar a = em.merge(ejemplar);
            tran.commit();
            return a;
        } catch (RuntimeException e) {
            tran.rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean eliminarEjemplar(Ejemplar ejemplar) {
        EntityTransaction et= em.getTransaction();
        try{
            et.begin();

            Ejemplar e = em.find(Ejemplar.class, ejemplar.getId());
            if(e!=null){
                em.remove(e);
                et.commit();
                return true;
            }
            return false;
        } catch (RuntimeException e) {

            et.rollback();
            return false;
        }
    }
}
