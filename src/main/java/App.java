import dao.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.*;
import org.checkerframework.checker.units.qual.A;
import org.hibernate.persister.entity.EntityPersister;
import org.slf4j.bridge.SLF4JBridgeHandler;

import java.time.LocalDate;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();

        try (EntityManager em = Persistence.
                createEntityManagerFactory("biblioteca").createEntityManager()) {

          UsuarioDao usuarioDao = new usuariodaoImpl(em);
           /* Optional<Usuario> u = usuarioDao.buscarPorID(1);
            if (u.isPresent()) {
                System.out.println("usuario encontrado " + u.get());
            } else {
                System.out.println("No se encontro");
            }

            AutorDao ad = new autordaoImpl(em);
            Optional<Autor> a = ad.buscarPorID(1);

            if (a.isPresent()) {
                System.out.println(a);
                a.get().setNacionalidad("Panameño");
                Autor act = ad.actulizarAutor(a.get());
                System.out.println(act);
            } else {
                System.out.println("no se encontró");
            }
            /*Autor nuevoAutor = new Autor("Español", "Juan");
            boolean ok = ad.crearAutor(nuevoAutor);
            System.out.println("Autor creado:" + ok);
            Optional<Autor> koautor = ad.buscarPorID(7);
            if (koautor.isPresent()) {
                boolean ko = ad.eliminarAutor(koautor.get());
                System.out.println("Autor eliminado:" + ko);
            }*/
            PrestamoDao prestamoDAO= new prestamodaoImpl(em);
            Optional<Prestamo> prestamo = prestamoDAO.buscarPorID(2);
            /*if (prestamo.isPresent()){
                System.out.println("Antes de acceder al usuario:");
                System.out.println("Usuario class: " + prestamo.get().getUsuario_id().getClass()); // ← Verás
                System.out.println(prestamo.get());
                System.out.println("Después de acceder al usuario:");
                System.out.println("Usuario ID: " + prestamo.get().getUsuario_id().getId());

            } else {
                System.out.println("Prestamo no encontrado");
            }


            Optional<Usuario> usuario = usuarioDao.buscarPorID(1);
            if (usuario.isPresent()){
                System.out.println("=====USUARIO ENCONTRADO============");
                System.out.println(usuario.get());
            } else {
                System.out.println("Prestamo no encontrado");
            }
            AutorDao ad = new autordaoImpl(em);
            Optional<Autor> a = ad.buscarPorID(3);
            if(a.isPresent()){
                System.out.println(a.get());
            }
            Optional<Prestamo> prestamoID2 = prestamoDAO.buscarPorID(2);*/
            EjemplarDao ejemplarDao = new ejemplardaoImpl(em);
            Optional<Usuario> u = usuarioDao.buscarPorID(2);
            if (u.isPresent()){
                /*System.out.println(u.get());
                for (Prestamo p: u.get().getListaPrestamo()){
                    System.out.println(p);
                }
                Optional<Ejemplar> e = ejemplarDao.buscarPorID(1);
                if (e.isPresent()){
                    Prestamo p = new Prestamo(LocalDate.now(), LocalDate.now().plusDays(7), EstadoPrestamoEnum.ACTIVO, e.get(), u.get());
                    Usuario user = u.get();
                    user.anadirPrestamo(p);
                    usuarioDao.actulizarUsuario(user);
                }*/
                //System.out.println(u.get().getLibrosFavoritos());

                /*for(Libro l :u.get().getLibrosFavoritos() ){
                    System.out.println("Usuario :"+u.get().getNombre()+"  favorito el libro: "+l.getTitulo());
                }
                LibroDao libroDao= new librodaoImpl(em);
                Optional<Libro> libro= libroDao.buscarPorID(4);
                if(libro.isPresent()){
                    u.get().anadirLibroFavorito(libro.get());
                    usuarioDao.actulizarUsuario(u.get());
                }*/


            }



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
