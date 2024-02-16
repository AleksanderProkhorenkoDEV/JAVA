/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaClases;

import poo_gestiontarjetascredito.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.ArrayList;

/**
 * Esta clase es la que se encarga de hacer el CRUD con la Base de Datos,
 * tenemos diferentes metodos que se encargan de hacer esto posible
 *
 * @author Alekesander Trujillo Prokhorenko
 * @version JDK 16
 */
public class TarjetaCreditoDAO {

    /**
     * Este metodo llamado conexion(), se encarga de establecer la conexion con
     * la base de datos, tiene distintas variables que se encargan de facilitar
     * su compresion, para poder establecerla tienes que saber tu usuario,
     * contraseña y el nombre de la base de datos a la que te quieres conectar,
     * y depenediendo del programa que uses deberas tener los Drivers de esta,
     * en este caso tengo los de Postgres. En caso de que salte alguna error por
     * conexion o que no se encuentre la clase org.postgresql.Driver saltara un
     * error que se capturara con un bloque catcht().
     *
     * @return conexion
     */
    public Connection conexion() {
        Connection conectar = null;
        String usuario = "postgres";
        String contraseña = "123";
        String bd = "tarjetacreditodb";
        String ip = "localhost";
        String puerto = "5432";
        String cadena = "jdbc:postgresql://" + ip + ":" + puerto + "/" + bd;
        try {
            Class.forName("org.postgresql.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contraseña);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conectar;
    }

    /**
     * Metodo insertarTarjetaCredito, se usa para poder insertar las tarjetas
     * que se crean en el main en la base de datos, para ello tenemos que usar
     * el PreparedStatement para poder crear la consulta, para ello recurriremos
     * al metodo anterior de conexion para poder enviarla alli. Una vez la
     * conexion establecida y la consulta creada, usaremos el set(Tipo de dato)
     * para poder insertarlos, van desde el 1 hasta el 8 porque en SQL se
     * orginzan las columnsa desde el 1 hasta la ultima que haya, y le vamos
     * pasando los datos en el orden que establecimos en la sentencia sql. En el
     * caso de que haya un error al hacer la sentencia se capturara con un
     * bloque catch() y en caso contrario se finalizara este proceso cerrando la
     * conexion y la sentencia siendo ejecutada.
     *
     * @param tarjeta, creada en el jFrame y recibida por parametro para
     * introducirla en la base de datos.
     */
    public void insertarTarjetaCredito(TarjetaCredito tarjeta) {
        Connection conexion = conexion();
        String sql = "INSERT INTO tarjetaCredito (numerotarjeta,nif, titular, pin, limite, mesCaducidad, anoCaducidad, cvv) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, tarjeta.getNumeroTarjeta());
            sentencia.setString(2, tarjeta.getNif());
            sentencia.setString(3, tarjeta.getTitular());
            sentencia.setString(4, tarjeta.getPin());
            sentencia.setInt(5, tarjeta.getLimite());
            sentencia.setInt(6, tarjeta.getMesCaducidad());
            sentencia.setInt(7, tarjeta.getAñoCaducidad());
            sentencia.setInt(8, Integer.parseInt(tarjeta.getCVV()));

        } catch (SQLException ex) {
            Logger.getLogger(TarjetaCreditoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                sentencia.executeUpdate();
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(TarjetaCreditoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * En este metodo introducimos el ultimo movimiento realizado por una
     * tarjeta de credito, para asi evitar la redundancia de movimientos y
     * posibles erroes y copia. Para ello hacemos un INSER INTO tabla, para
     * evitar inyecciones SQL hacemos la consulta parametrizada de ahi que haya
     * '?' en el VALUES, por cada interrogacion que ponemos indicamos que va una
     * variables y para asignarla usamos el PreparedStatement y modificamos la
     * sentencia en el mismo orden del insert.
     *
     * @param tarjeta, obtiene la tarjeta con la cual se ha realizado un pago en
     * el Main y lo añade en la base de datos.
     */
    public void introducirMovimientos(TarjetaCredito tarjeta) {
        Connection conexion = conexion();
        String sql = "INSERT INTO movimientos (numerotarjeta, concepto, cantidad, fecha) VALUES (?,?,?,?)";
        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.prepareStatement(sql);
            Movimiento m = new Movimiento(tarjeta.getUltimoMovimiento());
            sentencia.setString(1, tarjeta.getNumeroTarjeta());
            sentencia.setString(2, m.getConcepto());
            sentencia.setDouble(3, m.getCantidad());
            LocalDateTime fecha = m.getFecha();
            java.sql.Date fechaFinal = java.sql.Date.valueOf(fecha.toLocalDate());
            sentencia.setDate(4, fechaFinal);
            sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                sentencia.close();
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(TarjetaCreditoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Metodo con el cual eliminamos una tarjeta de credito de la base de datos
     * y sus movimientos, para ello recibimos el numero de esta tarjeta por
     * paremtro y creamos dos consultas. Primero borramos todos los movimientos
     * asociados a la tarjeta de credito en la tabla movimientos, una vez esto
     * ya este hecho borramos la tarjeta para evitar problemas con las claves
     * foraneas o dejar movimientos huerfanos.
     *
     * @param nTarjeta
     */
    public void eliminarTarjetaCredito(String nTarjeta) {
        Connection conexion = conexion();
        String sql = "DELETE FROM movimientos WHERE numerotarjeta = '" + nTarjeta + "'";
        String sql2 = "DELETE FROM tarjetaCredito WHERE numerotarjeta = '" + nTarjeta + "'";
        PreparedStatement sentencia = null;
        PreparedStatement sentencia2 = null;
        try {
            sentencia = conexion.prepareStatement(sql);
            sentencia.executeUpdate();
            sentencia2 = conexion.prepareStatement(sql2);
            sentencia2.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(TarjetaCreditoDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                sentencia.close();
                sentencia2.close();
                conexion.close();

            } catch (SQLException ex) {
                Logger.getLogger(TarjetaCreditoDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Metodo que se encarga de recorrer toda la tabla de tarjeta de credito y
     * extraer su movimiento para añadirlo a un ArrayList<TarjetaCredito> que
     * las almacena todas, posteriormente este arrayList se pasa al main para
     * poder cargar todos los datos de la aplicacion al ejecutarse. Cuando
     * termina de recorrerse la tarjeta y todos sus movimientos crea un objeto
     * nuevo con un constructor sobrecargado al cual le pasamos el Array de
     * movimientos para que los carge, posteriormente este Array de movimientos
     * cuando termina con esa tarjeta se inicializa a cero de nuevo para evitar
     * mezclarlos con otra tarjeta.
     *
     * @return arrayTarjetas, devuelve todas las tarjetas almacenadas en la base
     * de datos y sus movimentos.
     */
    public ArrayList<TarjetaCredito> obtenerTarjetas() {
        ArrayList<TarjetaCredito> arrayTarjetas = new ArrayList<>();
        Connection conexion = conexion();
        String sql = "SELECT * FROM tarjetacredito";
        Statement sentencia = null;
        ResultSet rs = null;
        String titular;
        String nif;
        String numeroTarjeta;
        String pin;
        int limite;
        int mes;
        int ano;
        String cvv;

        ArrayList<Movimiento> arrayMovimientos = new ArrayList<>();
        try {
            sentencia = (Statement) conexion.createStatement();
            rs = sentencia.executeQuery(sql);
            while (rs.next()) {
                titular = rs.getString("titular");
                nif = rs.getString("nif");
                numeroTarjeta = rs.getString("numeroTarjeta");
                pin = rs.getString("pin");
                limite = rs.getInt("limite");
                mes = rs.getInt("mesCaducidad");
                ano = rs.getInt("anoCaducidad");
                cvv = rs.getString("cvv");
                String sql2 = "SELECT * FROM movimientos WHERE numerotarjeta = '" + numeroTarjeta + "'";
                Statement sentencia2 = null;
                ResultSet rs2 = null;
                String concepto;
                double cantidad;
                LocalDateTime fecha;
                try {
                    sentencia2 = (Statement) conexion.createStatement();
                    rs2 = sentencia.executeQuery(sql2);
                    while (rs2.next()) {
                        concepto = rs2.getString("concepto");
                        cantidad = rs2.getDouble("cantidad");
                        java.sql.Date fechaSql = rs2.getDate("fecha");
                        java.util.Date utilDate = new java.util.Date(fechaSql.getTime());
                        Instant instant = utilDate.toInstant();
                        fecha = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                        arrayMovimientos.add(new Movimiento(cantidad, concepto, fecha));
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                } finally {
                    sentencia2.close();
                    rs2.close();
                }
                arrayTarjetas.add(new TarjetaCredito(titular, nif, pin, limite, numeroTarjeta, mes, ano, cvv, arrayMovimientos));
                arrayMovimientos = new ArrayList<>();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                rs.close();
                sentencia.close();
                conexion.close();

            } catch (SQLException ex) {
                Logger.getLogger(TarjetaCreditoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arrayTarjetas;
    }

    /**
     * Este metodo se encarga de buscar en la base de datos una tarjeta de
     * credito mediante su numero de tarjeta y modificarle el numero de PIN que
     * tiene, para ello hacemos un UPDATE de la tabla tarjetacredito SET pin
     * antiguo por el pin nuevo WHERE el numeroTarjeta = al numoro introducido
     * por parametro.
     *
     * @param nTarjeta, String cade de 16 longitud que identifica a una tarjeta.
     * @param pin, cadena de String que tiene una longitud mayor a cuatro.
     */
    public void modificarCodigoPin(String nTarjeta, String pin) {
        Connection conexion = conexion();
        String sql = "UPDATE tarjetacredito SET pin = '" + pin + "' WHERE numeroTarjeta = '" + nTarjeta + "'";
        if (Funciones.Funciones.ValidarNumeroPin(pin)) {
            try {
                PreparedStatement sentencia = conexion.prepareCall(sql);
                sentencia.executeUpdate();
                sentencia.close();
                conexion.close();

            } catch (SQLException ex) {
                Logger.getLogger(TarjetaCreditoDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
