/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaClases;

import Conexion.Conexion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import poo_gestiontarjetascredito.Movimiento;
import poo_gestiontarjetascredito.TarjetaCredito;

/**
 * Clase que se encarga de hacer la conexion y todas las operaciones con la base
 * de datos. Esta clase se caracteriza por hacer la conexion con JPA.
 *
 * @author Aleksander Trujillo Prokhorenko
 * @version JDK 16
 */
public class TarjetaCreditoDAOJPA {

    private EntityManager conexion() {
        return Conexion.getInstancia().getFabrica().createEntityManager();
    }

    /**
     * Metodo que insertar tarjetas de credito en la base de datos, esta recibe
     * por parametro una tarjeta de credito ya formada y crea la conexion con la
     * base de datos usando el EntityManager, posteriormente obtiene la
     * transaccion y la inicia luego coge el objeto tarjeta entero y lo hace
     * persistenten en la base de datos y cierra la transaccion.
     *
     * @param tarjeta, Objeto de la clase TarjetaCredito.
     */
    public void insertarTarjeta(TarjetaCredito tarjeta) {
        EntityManager entidadManager = conexion();
        try {
            entidadManager.getTransaction().begin();
            entidadManager.persist(tarjeta);
            entidadManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entidadManager.getTransaction().rollback();
        } finally {
            entidadManager.close();
        }
    }

    /**
     * Metodo que se encarga de introducir el ultimo movimiento de una tarjeta
     * de credito, para ello recibe una tarjeta por parametro y mediante los
     * metodos de la clase obtiene el ulitmo y crea un movimiento nuevo para no
     * copiar referencias y lo inserta en la base de datos de la misma forma que
     * inserto la tarjeta con el EntityManager.
     *
     * @param tarjeta, Objeto de la clase TarjetaCredito.
     */
    public void introducirMovimiento(TarjetaCredito tarjeta) {
        EntityManager entidadManager = conexion();
        try {
            entidadManager.getTransaction().begin();
            Movimiento m = new Movimiento(tarjeta.getUltimoMovimiento().getCantidad(), tarjeta.getUltimoMovimiento().getConcepto(), tarjeta.getUltimoMovimiento().getFecha(), tarjeta);
            entidadManager.persist(m);
            entidadManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entidadManager.getTransaction().rollback();
        } finally {
            entidadManager.close();
        }
    }

    /**
     * Metodo que se encarga de eliminar una tarjeta de credito en la tabla
     * movimientos y en la tabla tarjeta de credito, para evitar que se queden
     * movimientos huerfanos primero borramos todos los que existan en relacion
     * a ese numero de tarjeta de credito y posteriormente borramos la tarjeta
     * de credito de su tabla correspondiente
     *
     * @param tarjeta, Objeto de la clase TarjetaCredito.
     */
    public void eliminarTarjeta(TarjetaCredito tarjeta) {
        EntityManager entidadManager = conexion();
        try {
            EntityTransaction entityTransaction = entidadManager.getTransaction();
            entityTransaction.begin();

            String sql2 = "DELETE FROM Movimiento m WHERE m.numerotarjeta =  :numerotarjeta";
            Query consultaMovimiento = entidadManager.createQuery(sql2);
            consultaMovimiento.setParameter("numerotarjeta", tarjeta);
            consultaMovimiento.executeUpdate();

            String sql = "DELETE FROM TarjetaCredito t WHERE t.numeroTarjeta = :numeroTarjeta";
            Query consultaTarjeta = entidadManager.createQuery(sql);
            consultaTarjeta.setParameter("numeroTarjeta", tarjeta.getNumeroTarjeta());
            consultaTarjeta.executeUpdate();

            entityTransaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entidadManager.getTransaction().rollback();
        } finally {
            entidadManager.close();
        }
    }

    /**
     * Metodo que se encarga de modificar el pin de una tarjeta enconcreto, para
     * ello recibimos por parametro dos vairables, una String que es el pin
     * nuevo y el otro una TarjetaCredito con el cual sacaremos el numero de
     * esta para poder buscarla y posteriormente hacerle un UPDATE en la tabla
     * tarjetas modificando el PIn de esa donde (WHERE) coincidan los mismo
     * numeros de tarjetas
     *
     * @param tarjeta
     * @param pinNuevo
     */
    public void modificarPIN(TarjetaCredito tarjeta, String pinNuevo) {
        EntityManager entidadManager = conexion();
        try {
            String sql = "UPDATE TarjetaCredito t SET t.pin = :pinNuevo WHERE t.numeroTarjeta = :numeroTarjeta";
            Query consulta = entidadManager.createQuery(sql);
            EntityTransaction entityTX = entidadManager.getTransaction();
            consulta.setParameter("pinNuevo", pinNuevo);
            consulta.setParameter("numeroTarjeta", tarjeta.getNumeroTarjeta());
            entityTX.begin();
            consulta.executeUpdate();
            entityTX.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entidadManager.getTransaction().rollback();
        } finally {
            entidadManager.close();
        }
    }

    /**
     * Metodo que se usa en el Main para cargar todos los datos de la base al
     * inicial el programa, para ello recorre la tabla Tarjeta de credito una a
     * una y las va agregando a un TypedQuery para sacar el resultado de la
     * consulta que mas tarde pasamos a un List y de ahi lo lanzamos al main
     *
     * @return
     */
    public List<TarjetaCredito> obtenerTarjetas() {
        EntityManager entityManager = conexion();
        List<TarjetaCredito> tarjetas = null;
        try {
            String sql = "SELECT  t FROM TarjetaCredito t ";
            TypedQuery<TarjetaCredito> consulta = entityManager.createQuery(sql, TarjetaCredito.class);
            tarjetas = consulta.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return tarjetas;
    }
}
