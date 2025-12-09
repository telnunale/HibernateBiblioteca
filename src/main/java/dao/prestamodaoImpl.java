package dao;

import criteria.PrestamoCriteria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import model.EstadoPrestamoEnum;
import model.Prestamo;

import java.util.List;
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
    public List<Prestamo> recuperarTodos(){
        String jpql="Select p FROM prestamo p";
        TypedQuery<Prestamo> query =em.createQuery(jpql,Prestamo.class);
        return query.getResultList();
    }
    public List<Prestamo> getPrestamoEstado(EstadoPrestamoEnum estado){
        String jpql="Select p FROM Prestamo p where p.estado = :estadoParam";
        TypedQuery<Prestamo> query=em.createQuery(jpql, Prestamo.class);
        query.setParameter("estadoParam",estado);
        return query.getResultList();
    }

    public List<Prestamo> getPrestamoCriteria(PrestamoCriteria p){
        String jpql="Select p FROM Prestamo p where 1=1";
        if(p.isPresentPrestamo()){
            jpql+= " and p.estado= :estadoParam" ;
        }
        if(p.isPresentFechaInicio()){
            jpql+= " and p.fecha_inicio BETWEEN :fechainicioParam and :fechafinParam" ;

        }
        TypedQuery<Prestamo> query =em.createQuery(jpql,Prestamo.class);
        if(p.isPresentPrestamo()){
            query.setParameter("estadoParam",p.getEstado());
        }
        if(p.isPresentFechaInicio()){
            query.setParameter("fechainicioParam",p.getFechaInicio());
            query.setParameter("fechafinParam",p.getFinFechaInicio());
        }
        return query.getResultList();

    }


}
