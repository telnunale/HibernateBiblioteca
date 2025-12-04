package dao;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Prestamo;
import model.Usuario;

import java.util.Optional;

public class usuariodaoImpl implements UsuarioDao{
    private EntityManager entityManager;

    public usuariodaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean crearUsuario(Usuario usuario) {
        EntityTransaction tran=entityManager.getTransaction();
        try{
            tran.begin();
            entityManager.persist(usuario);
            tran.commit();
            return true;
        } catch (Exception e) {
            if(tran.isActive()){
                tran.rollback();
                return false;
            }
            throw new RuntimeException("Error al crear usuario"+e.getMessage());
        }
    }

    @Override
    public Optional<Usuario> buscarPorID(int id) {
        Usuario u = entityManager.find(Usuario.class,id);
        Optional<Usuario> usuarioRecuperado=Optional.of(u);
        return usuarioRecuperado;
    }

    @Override
    public Usuario actulizarUsuario(Usuario usuario) {
        EntityTransaction tran=entityManager.getTransaction();
        try{
            tran.begin();
            Usuario usuarioactualizado=entityManager.merge(usuario);
            tran.commit();
            return usuario;
        } catch (Exception e) {
            if(tran.isActive()){
                tran.rollback();
                return  usuario;
            }
            throw new RuntimeException("Error al crear usuario"+e.getMessage());
        }
    }

    @Override
    public boolean eliminarUsuario(Usuario usuario) {
        EntityTransaction tran=entityManager.getTransaction();
        try{
            tran.begin();
            Usuario u = entityManager.find(Usuario.class,usuario.getId());
            if(u!=null){
                entityManager.remove(u);
                tran.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if(tran.isActive()){
                tran.rollback();
                return  false;
            }
            throw new RuntimeException("Error al borrar usuario"+e.getMessage());
        }
    }




}
