package poo_gestiontarjetascredito;

import java.time.LocalDateTime;
import Funciones.Funciones;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Esta clase sirve para crear tarjetas de credito, mediante una serie de
 * constructores. Tiene getter/setter para modificar atributos mediante sus
 * respectivas validaciones. Ademas de una serie de metodos como pagar, gastado,
 * movimientos para consultar ciertas cosas
 *
 * @author Aleksander Trujillo
 * @version JDK 16
 * @see Movimiento
 *
 */
@Entity
@Table(name = "tarjetacredito", catalog = "tarjetacreditodb", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TarjetaCredito.findByNTarjeta", query = "SELECT t FROM TarjetaCredito t WHERE t.numeroTarjeta = :numerotarjeta")

})
public class TarjetaCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "titular", length = 80)
    private String titular;
    @Column(name = "nif", length = 9)
    private String nif;
    @Column(name = "pin", length = 2147483647)
    private String pin;
    @Column(name = "limite")
    private int limite;
    @Column(name = "mescaducidad")
    private int mesCaducidad;
    @Column(name = "anocaducidad")
    private int añoCaducidad;
    @Id
    @Basic(optional = false)
    @Column(name = "numerotarjeta", nullable = false, length = 17)
    private String numeroTarjeta;
    @Column(name = "cvv", length = 2147483647)
    private String cvv;
    @OneToMany(mappedBy = "numerotarjeta", fetch = FetchType.LAZY)
    private List<Movimiento> movimientos;

    public TarjetaCredito() {
    }

    /*
    Es el constructor del objeto Tarjeta de credito, en la cual genera una tarjeta entera con CVV, MM/AAAA de caducidad
    @param titular, es el nombre del dueño de la tarjeta de credito (String)
    @param nif, es el documento de identidad de los titulares tanto CIF, NIE, DNI (String)
    @param pin, es una combinacion de caracteres que incluye cualquier tipo menos espacios (String)
    @param limite, es el limite que tiene esa tarjeta de credito para gastar (String)
    @param numeroTarjeta, es el numero de la tarjeta de 16 caracteres con digito de control
    @throws titular, en caso de que no se introduzca la cadena bien
    @throws nif, en caso de no se introduzca el nif
    @throws limite, en caso de que no se respete los minimos y maximos
    @throws numero tarjeta, en caso de que no se respete la estructura
    @throws pin, si se mete un pin menor de cuatro digitos
     */
    public TarjetaCredito(String titular, String nif, String pin, int limite, String numeroTarjeta) {
        if (Funciones.ValidarCadenaTexto(titular, 80, 15)) {
            throw new IllegalArgumentException("Cadena de texto invalida");
        }
        nif = nif.toUpperCase();
        if (!Funciones.ValidarDocumentoIdentidad(nif)) {
            throw new IllegalArgumentException("Documento de identidad introduccido es erroneo");
        }
        if (!Funciones.ValidarLimite(limite, 5000, 500)) {
            throw new IllegalArgumentException("El limite introducido no comple con los parametros limite > 500 y limite < 5000");
        }
        if (!Funciones.validarNumeroTarjeta(numeroTarjeta)) {
            throw new IllegalArgumentException("El numero de la tarjeta es erroneo");
        }
        if (!Funciones.ValidarNumeroPin(pin)) {
            throw new IllegalArgumentException("El pin de la tarjeta es erroneo, no cumple con los parametros establecidos");
        }

        this.titular = titular;
        this.nif = nif;
        this.pin = pin;
        this.limite = limite;
        this.numeroTarjeta = numeroTarjeta;
        this.cvv = generarCvv();
        this.añoCaducidad = LocalDateTime.now().getYear() + 5;
        this.mesCaducidad = LocalDateTime.now().getMonthValue() + 5;
        this.movimientos = new ArrayList<>();
    }
    /**
     * 
     * @param titular
     * @param nif
     * @param pin
     * @param limite
     * @param numeroTarjeta
     * @param año
     * @param mes
     * @param cvv
     * @param array 
     */
    public TarjetaCredito(String titular, String nif, String pin, int limite, String numeroTarjeta, int año, int mes, String cvv, List<Movimiento> array) {
        if (Funciones.ValidarCadenaTexto(titular, 80, 15)) {
            throw new IllegalArgumentException("Cadena de texto invalida");
        }
        nif = nif.toUpperCase();
        if (!Funciones.ValidarDocumentoIdentidad(nif)) {
            throw new IllegalArgumentException("Documento de identidad introduccido es erroneo");
        }
        if (!Funciones.ValidarLimite(limite, 5000, 500)) {
            throw new IllegalArgumentException("El limite introducido no comple con los parametros limite > 500 y limite < 5000");
        }
        if (!Funciones.validarNumeroTarjeta(numeroTarjeta)) {
            throw new IllegalArgumentException("El numero de la tarjeta es erroneo");
        }
        if (!Funciones.ValidarNumeroPin(pin)) {
            throw new IllegalArgumentException("El pin de la tarjeta es erroneo, no cumple con los parametros establecidos");
        }
        if (año <= 0) {
            throw new IllegalArgumentException("El año no puede ser negativo o 0");
        }
        if (mes <= 0) {
            throw new IllegalArgumentException("El mes no puede ser negativo o 0");
        }

        this.titular = titular;
        this.nif = nif;
        this.pin = pin;
        this.limite = limite;
        this.numeroTarjeta = numeroTarjeta;
        this.cvv = cvv;
        this.añoCaducidad = año;
        this.mesCaducidad = mes;
        this.movimientos = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            this.movimientos.add(new Movimiento(array.get(i).getCantidad(), array.get(i).getConcepto(), array.get(i).getFecha()));
        }
    }
    /**
     * 
     * @return 
     */
    private String generarCvv() {
        String cvv = "";
        Random rnd = new Random(System.currentTimeMillis());
        for (int i = 0; i < 3; i++) {
            cvv += rnd.nextInt(0, 10);
        }
        return cvv;
    }

    /*
    Es el constructor copia de la tarjeta de credito en caso de que se quieran modificar los datos sin tocar los originales
    @param tarjeta, es el objeto copia 
     */
    public TarjetaCredito(TarjetaCredito tarjeta) {
        this(tarjeta.titular, tarjeta.nif, tarjeta.pin, tarjeta.limite, tarjeta.numeroTarjeta);
        this.cvv = tarjeta.cvv;
        this.añoCaducidad = tarjeta.añoCaducidad;
        this.mesCaducidad = tarjeta.mesCaducidad;
        for (int i = 0; i < tarjeta.movimientos.size(); i++) {
            this.movimientos.add(new Movimiento(tarjeta.movimientos.get(i)));
        }
    }

    /*
    Metodo getter, devuelve el titular de la tarjeta
     */
    public String getTitular() {
        return titular;
    }

    /*
    Metodo getter, devuelve el nif de la tarjeta
     */
    public String getNif() {
        return nif;
    }

    /*
    Metodo getter, devuelve el pin de la tarjeta
     */
    public String getPin() {
        return pin;
    }

    /**
     * Metodo getter, devuelve el limite de la tarjeta
     *
     * @return
     */
    public int getLimite() {
        return limite;
    }

    /*
    * Metodo getter, devuelve el mes de caducidad de la tarjeta
     */
    public int getMesCaducidad() {
        return mesCaducidad;
    }

    /*
    Metodo getter, devuelve el año de caducidad de la tarjeta
     */
    public int getAñoCaducidad() {
        return añoCaducidad;
    }

    /*
    Metodo getter, devuelve el numero de tarjeta de la tarjeta
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /*
    Metodo getter, devuelve el CVV de la tarjeta
     */
    public String getCVV() {
        return this.cvv;
    }

    /*
    Metodo setter, modifica el pin de la tarjeta
     */
    public void setPin(String pin) {
        if (Funciones.ValidarNumeroPin(pin)) {
            this.pin = pin;
        }
    }

    /*
    Metodo setter, modifica el limite de la tarjeta
     */
    public void setLimite(int limite) {
        if (Funciones.ValidarLimite(limite, 5000, 500)) {
            this.limite = limite;
        }
    }

    /*
    Metodo pagar, con el cual se realizan pagar mientras los datos esten correctos, luego se añade al Array de movimientos
    @param cantidad, es el numero de cantidad que quiere pagar
    @param concepto, es el concepto del pago que se quiere hacer
    @throw en caso de que la cantidad sea cantidad<0 salta
     */
    public boolean pagar(double cantidad, String concepto) {
        boolean aceptarPago = false;
        double cantidadGastada;
        int limiteCasteado;
        limiteCasteado = this.limite;
        cantidadGastada = gastado();
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad introducida es erronea, tiene que ser mayor");
        }
        if ((cantidadGastada + cantidad) <= limiteCasteado) {
            aceptarPago = true;
            this.movimientos.add(new Movimiento(cantidad, concepto));

        }
        return aceptarPago;
    }

    /*
    Metodo gastado, este recorre el Array en busca de movimientos y acumula en una variable el dinero gastado en total de toda la tarjeta y lo devuelve
    @return cantidadGastada el dinero gastado en total
     */
    public double gastado() {
        double cantidadGastada = 0;
        int numeroMovimientos = numeroMovimientos();
        for (int i = 0; i < numeroMovimientos; i++) {
            cantidadGastada += this.movimientos.get(i).getCantidad();
        }
        return cantidadGastada;
    }

    /*
    Este metodo recorre el Array  y cuenta cuantos movimientos hay en este y los almacena en una variable
    @return numeroMovimientos, es el numero de movimientos que hay en total
     */
    public int numeroMovimientos() {
        int numeroMovimientos = 0;
        for (Movimiento movimiento : this.movimientos) {
            if (movimiento != null) {
                numeroMovimientos++;
            }
        }

        return numeroMovimientos;
    }

    /*
    Este meto recorre el array de movimientos en funcion de los que hay y devuelve un string de movientos en los cuales se muestra lo que se ha hecho
    @param numero, es el numero de movimientos que quiere consultar el user
    @return String del objeto movimiento para mostrarselo al user
     */
    public ArrayList<Movimiento> movimientos(int numero) {
        ArrayList<Movimiento> copiaMovimientos = new ArrayList<>();
        int numeroMovimientos = numeroMovimientos();
        if (numeroMovimientos < numero && numero <= 0) {
            throw new IllegalArgumentException("El valor introducido es incorrecto");
        }
        for (int i = 0; i < numero; i++) {
            copiaMovimientos.add(new Movimiento(this.movimientos.get(i)));
        }
        return copiaMovimientos;
    }

    public Movimiento getUltimoMovimiento() {
        Movimiento m = new Movimiento(this.movimientos.get(this.movimientos.size() - 1));
        return m;
    }

    /*
    Metodo que obtiene el digito de control de una tarjeta de credito mediante un algoritmo
    @param numero, es el numero de la tarjeta de credito
    @return digitoControl, devuelve el numero 
     */
    public static int obtenerDigitoControl(String numero) {
        int totalSuma;
        int digitoControl;
        int digito;
        int sumaDigitos = 0;
        for (int j = 0; j < numero.length() - 1; j++) {
            digito = Character.getNumericValue(numero.charAt(j));
            if (j % 2 == 0) {
                digito = digito * 2;
                if (digito >= 10) {
                    digito = (digito % 10) + 1;
                    sumaDigitos += digito;
                } else {
                    sumaDigitos += digito;
                }
            } else {
                sumaDigitos += digito;
            }
        }
        totalSuma = sumaDigitos % 10;
        digitoControl = 10 - totalSuma;
        return digitoControl;
    }

    /*
    Metodo comprobar numero tarjeta, comprueba mediante un algoritmo que los valores introducidos de la tarjeta de credito es correcto mediante el %10 = 0
    @param numero, es el numero de la tarjeta de credito (String)
    return condicion booleana, para comprobar si es correcto o no %10 = 0 devuelve true
     */
    public boolean comprobarNumeroTarjeta(String numero) {
        int numero1 = 0;
        int numero2 = 0;
        int digitoControl = TarjetaCredito.obtenerDigitoControl(numero);
        char caracter;
        int numeroCopiaDigito;
        caracter = numero.charAt(15);
        numeroCopiaDigito = Character.getNumericValue(caracter);
        String numeroDelReves = new StringBuffer(numero).reverse().toString();
        for (int i = 0; i < numeroDelReves.length(); i++) {
            int digito = Character.digit(numeroDelReves.charAt(i), 10);
            if (i % 2 == 0) {
                numero1 += digito;
            } else {
                numero2 += 2 * digito;
                if (digito >= 5) {
                    numero2 -= 9;
                }
            }
        }
        return ((numero1 + numero2) % 10 == 0) && digitoControl == numeroCopiaDigito;
    }

    /*
    Metodo equals compara dos tarjetas de credito mediante .equals comparando el numero de la tarjeta del constructor origianl y del recibido por parametro
    @param Objeto tarjetaCredito
    @return sonIguales, condicon boolean, en caso de ser iguales devuelve true
     */
    private boolean equals(TarjetaCredito t) {
        boolean sonIguales = false;
        if (this.numeroTarjeta.equals(t.numeroTarjeta)) {
            sonIguales = true;
        }
        return sonIguales;
    }

    /*
    metodo toString(), nos permite mostrar por pantalla todos los valores del objeto de una forma clara y estructurada
    @return el obejeto para mostrar por pantalla de forma correcta
     */
    @Override
    public String toString() {
        return "---Tarjeta Credito--- \t\nTitular:" + titular + "\t\nNIF:" + nif + "\t\nMes caducidad:" + mesCaducidad + "\t \nA\u00f1o caducidad:" + añoCaducidad + "\t \nNumero tarjeta:" + numeroTarjeta + "\t\nLimite:" + limite;
    }

}
