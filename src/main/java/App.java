import dao.UsuarioDao;
import dao.usuariodaoImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Usuario;
import org.hibernate.persister.entity.EntityPersister;
import org.slf4j.bridge.SLF4JBridgeHandler;

import java.util.Optional;

public class App {
    public static void main(String[] args) {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();

        try(EntityManager em = Persistence.
                createEntityManagerFactory("biblioteca").createEntityManager()){

            UsuarioDao usuarioDao= new usuariodaoImpl(em);
            Optional<Usuario> u=usuarioDao.buscarPorID(1);
            if(u.isPresent()){
                System.out.println("usuario encontrado "+u.get());
            }     else{
                System.out.println("No se encontro");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
