/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_gestiontarjetascredito;

import Funciones.Funciones;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase movimientos, con esta clase podemos organizar los movimientos de la
 * tarjeta de credito mediante un Array, tiene metodos getter/setter y equals()
 *
 * @author Aleksander
 * @since JKD 16
 * @see TarjetaCredito
 */
@Entity
@Table(name = "movimientos", catalog = "tarjetacreditodb", schema = "public")
public class Movimiento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "movimiento_id", nullable = false)
    private Integer movimientoId;
    @Column(name = "cantidad")
    private double cantidad;
    @Column(name = "concepto", length = 2147483647)
    private String concepto;
    @Column(name = "fecha")
    private LocalDateTime fecha;
    @JoinColumn(name = "numerotarjeta", referencedColumnName = "numerotarjeta")
    @ManyToOne(fetch = FetchType.LAZY)
    private TarjetaCredito numerotarjeta;

    public Movimiento() {
    }

    /**
     * Es el construcor de Movimiento, con sus respectivas validaciones para no
     * construir un objeto erroneo
     *
     * @param cantidad es el dinero con el que quiere hacer el pago el user
     * @param concepto es una cadena de texto con la cual justifica el pago
     * @throws cantidad en caso de que esta no sea correcta
     * @throws concepto en caso de que la cadena no sea valida
     */
    public Movimiento(double cantidad, String concepto) {
        if (Funciones.ValidarCadenaTexto(concepto, 50, 0)) {
            throw new IllegalArgumentException("Demasiado largo el concepto");
        }
        if (!Funciones.ValidarParametroDouble(cantidad, 0)) {
            throw new IllegalArgumentException("No puedes meter valores negativos");
        }
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.fecha = LocalDateTime.now();
    }
    /**
     * 
     * @param cantidad
     * @param concepto
     * @param fecha 
     */
    public Movimiento(double cantidad, String concepto, LocalDateTime fecha) {
        if (Funciones.ValidarCadenaTexto(concepto, 50, 0)) {
            throw new IllegalArgumentException("Demasiado largo el concepto");
        }
        if (!Funciones.ValidarParametroDouble(cantidad, 0)) {
            throw new IllegalArgumentException("No puedes meter valores negativos");
        }
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    /**
     *
     * @param cantidad
     * @param concepto
     * @param fecha
     * @param t
     */
    public Movimiento(double cantidad, String concepto, LocalDateTime fecha, TarjetaCredito t) {
        if (Funciones.ValidarCadenaTexto(concepto, 50, 0)) {
            throw new IllegalArgumentException("Demasiado largo el concepto");
        }
        if (!Funciones.ValidarParametroDouble(cantidad, 0)) {
            throw new IllegalArgumentException("No puedes meter valores negativos");
        }
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.numerotarjeta = new TarjetaCredito(t);
    }

    /**
     * Constructor copia de la clase Movimiento
     *
     * @param m, un objeto para copiar
     */
    public Movimiento(Movimiento m) {
        this(m.cantidad, m.concepto);
        m.fecha = fecha;
    }

    /**
     * Es el metodo getter con el cual devuelve el dinero introducido por el
     * usuario
     *
     * @return cantidad, es el dinero que introducio el user
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * Es un metodo getter con el cual devuelve la cadena de texto introducida
     * por el user
     *
     * @return concepto, es una caneda String
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * Metodo getter que devuelve la fecha del movimiento
     *
     * @return fecha
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * Metodo setter sobre el concepto introducido por el user, mediante una
     * validacion de una funcion externa
     *
     * @param concepto modifica la cadena de texto
     */
    public void setConcepto(String concepto) {
        if (Funciones.ValidarCadenaTexto(concepto, 50, 0)) {
            this.concepto = concepto;
        }
    }

    /**
     * Metodo equals() compara dos movimientos mediante un if en el que compara
     * todos los parametros del ulitmo movimiento con el nuevo
     *
     * @param m objeto movimiento nuevo
     * @return son Iguales, boolean que si son iguales devuelve true
     */
    public boolean equals(Movimiento m) {
        boolean sonIguales = false;
        if (this.cantidad == m.cantidad && this.concepto.equals(m.concepto) && this.fecha.isEqual(m.fecha)) {
            sonIguales = true;
        }
        return sonIguales;
    }

    /**
     * Metodo toString() con el cual el usuario puede visualizar los movimientos
     * de una forma correcta
     *
     * @return Movimiento completo
     */
    @Override
    public String toString() {
        return "Movimiento \ncantidad: " + cantidad + "\nConcepto: " + concepto + "\nFecha: " + fecha.getYear() + "-" + fecha.getMonthValue() + "-" + fecha.getDayOfMonth();
    }

}
