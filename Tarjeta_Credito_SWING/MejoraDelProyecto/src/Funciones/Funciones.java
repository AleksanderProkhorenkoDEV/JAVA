/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import static java.lang.System.in;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import poo_gestiontarjetascredito.TarjetaCredito;

/**
 * Con esta clase, creo todas las funciones necesarias para validar datos y
 * comprobar el correcto funcionamiento del programa
 *
 * @author Aleksander
 * @version JDK 16
 * @see TarjetaCredito
 * @see regex.Matcher
 * @see regex.Pattern
 *
 */
public class Funciones {

    private static int tarjetasCreditoCreadas;
    private static int indiceArrayBusquedaNIF;
    private static int numeroMovimiento;

    static {
        tarjetasCreditoCreadas = 0;
        indiceArrayBusquedaNIF = 0;
        numeroMovimiento = 0;
    }

    public static boolean expresionRegularNumeros(String texto) {
        Pattern cadenaTexto = Pattern.compile("[0-9]{1,9}");
        Matcher m = cadenaTexto.matcher(texto);
        return (m.matches());
    }

    /**
     * Con estas funcion comprueba si una cadena de texto cumple el maximo y el
     * minimo de caracteres permitido y devuelve un boolean
     *
     * @param texto cadena de String
     * @param maximo cantidad maxima de caracteres que puede tener el String
     * @param minimo cantidad minimo de caracteres que puede tener el String
     * @return validarCadena devuelve true o false
     */
    public static boolean ValidarCadenaTexto(String texto, int maximo, int minimo) {
        boolean validarCadena = false;

        if (expresionRegularNombre(texto) && (texto.length() < maximo && minimo > texto.length())) {
            validarCadena = true;
        }
        return validarCadena;
    }

    /**
     * Esta funcion devuelve un boolean en funcion de si un valor Double cumple
     * el el minimo
     *
     * @param cantidad es la cantidad introducida por el user
     * @param minimo cantidad minima que se le permite al user meter
     * @return validarParametro boolean que devuelve true o false
     */
    public static boolean ValidarParametroDouble(double cantidad, int minimo) {
        boolean validarParametro = false;
        if (cantidad > minimo) {
            validarParametro = true;
        }
        return validarParametro;
    }

    /**
     * Funcion que comprueba los posibles documentos identificadores de una
     * persona NIE, CIF, NIF mediante unas expresiones regulares
     *
     * @param numero cadena de caracteres
     * @return documentoValido, es un boolean
     */
    public static boolean ValidarDocumentoIdentidad(String numero) {
        numero = numero.toUpperCase();
        boolean documentoValido = false;
        if (expresionRegularNIF(numero)) {
            documentoValido = true;
        }
        if (expresionRegularCIF(numero)) {
            documentoValido = true;
        }
        if (expresionRegularNIE(numero)) {
            documentoValido = true;
        }
        return documentoValido;
    }

    /**
     * Metodo con el cual se valida que el usuario metada un pin correcto
     * mediante una expresion regular
     *
     * @param numero cadena de texto
     * @return numeroValidoPin boolean
     */
    public static boolean ValidarNumeroPin(String numero) {
        boolean numeroValidoPin = false;
        if (expresionRegularPin(numero)) {
            numeroValidoPin = true;
        }
        return numeroValidoPin;
    }

    /**
     * Este metodo comprueba que el numero introducido esta dentro de los
     * parametros permitidos de los limites establecidos por el programador, es
     * una funcion boolean en caso de que sea correcta devuelve true
     *
     * @param numeroParametro
     * @param maximo limite maximo permitido por el programador
     * @param minimo limite minimo permitido por el programador
     * @return validarLimite boolean
     */
    public static boolean ValidarLimite(int numeroParametro, int maximo, int minimo) {
        boolean validarLimite = false;
        String numeroS = numeroParametro+"";
        if (Funciones.expresionRegularNumeros(numeroS)) {
            int numero = Integer.parseInt(numeroS);
            if (numero >= minimo && numero <= maximo) {
                validarLimite = true;
            }
        }
        return validarLimite;
    }

    /**
     * Esta funcion se encargar de generar CVV mediante un Array[3] mediante una
     * funcion de la appi de Java de generar numeros random
     *
     * @param CVV es una lista de Array vacia
     * @return CVV devuelve un Array relleno con el nuevo CVV
     */
    public static int[] GeneradorCVV(int[] CVV) {
        for (int i = 0; i < CVV.length; i++) {
            CVV[i] = (int) (Math.random() * 10);
        }
        return CVV;
    }

    /**
     * Es una funcion public static que comprueba mediante el %10 que la tarjeta
     * introducida es correcta, es boolean en caso de ser correcta devuelve true
     *
     * @param numeroTarjeta valor introducido por parametro
     * @return una condicion de %10 = 0 devuelve true
     */
    public static boolean validarNumeroTarjeta(String numeroTarjeta) {
        int numero1 = 0;
        int numero2 = 0;
        String numeroDelReves = new StringBuffer(numeroTarjeta).reverse().toString();
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
        return (numero1 + numero2) % 10 == 0;
    }

    /**
     * Funcion que muestra por pantalla un mensaje por pantalla sobre el menu
     * principal
     */
    public static void mostrarMenu() {

        System.out.println("""
                           \n
                           1. Crear tarjeta credito 
                           2. Eliminar tarjeta credito 
                           3. Gestionar tarjeta credito 
                           4. Consultar gastos totales 
                           5. Salir del programa
                           \n""");

    }

    /**
     * Funcion que muestra por pantalla un mensaje por pantalla sobre el menu
     * secundario
     */
    public static void mostrarSubMenu() {
        System.out.println("""
                           \n
                           1. Mostrar el numero de tarjeta completo
                           2. Mostrar el nombre del titular de la tarjeta
                           3. Mostrar la fecha de caducidad 
                           4. Modificar el PIN 
                           5. Realizar un pago 
                           6 Consultar movimientos 
                           7 Consultar gasto total 
                           8 volver al menu principal
                           \n""");
    }

    /**
     * Funcion que recibe por parametro un numero metido por el usuario y
     * comprueba qe sea texto, en caso de que no vuelve a preguntar
     *
     * @param numero valor metido por el usuario
     * @return numero devuelve el numero introducido si es correcto
     */
    public static int leerDatosTeclado(int numero) {
        var teclado = new Scanner(in);
        while (!(teclado.hasNextInt())) {
            teclado.nextLine();
            out.println("El valor a introducir tiene que ser numerico");
        }
        numero = teclado.nextInt();

        return numero;
    }

    /**
     * Funcion que recibe por parametro un numero metido por el usuario y
     * comprueba qe sea texto, en caso de que no vuelve a preguntar
     *
     * @param numero valor metido por el usuario
     * @return numero devuelve el numero introducido si es correcto
     */
    public static double leerDatosTecladoCantidad(double numero) {
        var teclado = new Scanner(in);
        while (!(teclado.hasNextDouble())) {
            teclado.nextLine();
            out.println("El valor a introducir tiene que ser numerico");
        }
        numero = teclado.nextDouble();

        return numero;
    }

    /**
     * Funcion que se encarga de crear tarjetas de credito y tiene unas
     * validaciones para poder pasarle esos datos al constructor sin problema,
     * recibe por parametros un Array de tarjetas creado en el archivo main
     *
     * @param TarjetaCredito
     * @return un nuevo objeto con todos los datos pedidos en la funcion que
     * crea las tarjetas de credito
     */
    public static TarjetaCredito crearTarjetaCredito(ArrayList<TarjetaCredito> TarjetaCredito) {
        Scanner teclado = new Scanner(System.in);
        String titular;
        String nif;
        int limite;
        String numeroTarjeta;
        String pin;
        int CVV[] = new int[3];

        do {
            System.out.println("---Introduzca su nombre---");

            titular = teclado.nextLine();
        } while (ValidarCadenaTexto(titular, 80, 15));
        do {
            System.out.println("---Introduzca su NIF---");
            nif = teclado.nextLine();
        } while (!ValidarDocumentoIdentidad(nif) && !buscarNIF(nif, TarjetaCredito));

//        do {
//            System.out.println("---¿Que limite quieres poner? Max 5000 Min 500---");
//            limite = teclado.nextInt();
//        } while (!ValidarLimite(limite, 5000, 500));
        do {

            System.out.println("---Introduce el numero de tarjeta---");
            numeroTarjeta = teclado.nextLine();
        } while (!validarNumeroTarjeta(numeroTarjeta));
        do {
            System.out.println("---Introduce un PIN > 4 digitos---");
            pin = teclado.nextLine();
        } while (!ValidarNumeroPin(pin));

        TarjetaCredito.add(new TarjetaCredito(titular, nif, pin, 1, numeroTarjeta));
        tarjetasCreditoCreadas++;

        return new TarjetaCredito(titular, nif, pin, 1, numeroTarjeta);
    }

    /**
     * Es una funcion que se encarga de eliminar tarjetas de credito ya creadas,
     * recive por parametro el array del main lo hace mediante unas funciones
     * externas que compone la principal, es void por lo tanto no devuelve nada
     * solo modifica internamente
     *
     * @param NIF cadena de String metida por el usuario y valida los datos
     * @param TarjetaCredito
     */
    public static void eliminarTarjetaCredito(String NIF, ArrayList<TarjetaCredito> TarjetaCredito) {

//        if (buscarNIF(NIF, array)) {
//            borradoDeTarjeta(indiceArrayBusquedaNIF, array);
//            tarjetasCreditoCreadas--;
//            System.out.println("La tarjeta se ha eliminado de forma correcta, tienes: " + tarjetasCreditoCreadas);
//        } else {
//            System.out.println("El NIF introducido no aparece, por lo tanto no se elimino nada");
//        }
        if (buscarNIF(NIF, TarjetaCredito)) {
            Funciones.borradoDeTarjeta(TarjetaCredito);
            tarjetasCreditoCreadas--;
            System.out.println("La tarjeta se ha eliminado de forma correcta, tienes: " + tarjetasCreditoCreadas);
        } else {
            System.out.println("El NIF introducido no aparece, por lo tanto no se elimino nada");
        }

    }

    /**
     * Es una funcion que mediante una variable static puede borrar una tarjeta
     * de credito y va enlazada con la funcion eliminar tarjeta de credito
     *
     * @param TarjetaCredito
     */
    public static void borradoDeTarjeta(ArrayList<TarjetaCredito> TarjetaCredito) {
        //array[indiceArrayBusquedaNIF] = null;
        Iterator<TarjetaCredito> it = TarjetaCredito.iterator();
        for (int i = 0; it.hasNext(); i++) {
            if (i == indiceArrayBusquedaNIF) {
                TarjetaCredito.remove(i);
            }
        }
    }

    /**
     * Es una funcion que se encarga de buscar el NIF dentro del array, en caso
     * de encontrarlo devuelve un boolean true, pero si no devuelve false
     *
     * @param nif cadena de texto introducida por el user
     * @param TarjetaCredito
     *
     * @return busqueda
     */
    public static boolean buscarNIF(String nif, ArrayList<TarjetaCredito> TarjetaCredito) {
        boolean busqueda = false;
        nif = nif.toUpperCase();
        Iterator<TarjetaCredito> it = TarjetaCredito.iterator();
        for (int i = 0; it.hasNext(); i++) {
            TarjetaCredito t = it.next();
            if (nif.equals(t.getNif())) {
                busqueda = true;
                indiceArrayBusquedaNIF = i;
            }

        }
//        for (int i = 0; i < array.length && array[i] != null; i++) {
//            if (nif.equals(array[i].getNif())) {
//                busqueda = true;
//                indiceArrayBusquedaNIF = i;
//            }
//        }

        return busqueda;
    }

    /**
     * Funcion que devuelve un valor static en el cual se va autoincrementando
     * mediante las creaciones de credito que se van creando
     *
     * @param TarjetaCredito
     * @return tarjetaCreditoCreadas
     */
    public static int numeroDeTarjetasCreadas() {
        return tarjetasCreditoCreadas;
    }

    /**
     * Es una funcion la cual almacena un switch en el cual se gestiona el sub
     * menu del programa en funcion de lo que el usuario va indicando, en
     * funcion de que el nif introducido sea correcto o no.En caso de que el
     * user quiera salir pulsa el 8 y esto devuelve un boolean al menu para
     * cerrar el do-while que lo contiene
     *
     * @param indiceSubMenu el indice que introduce el usuario para saber que
     * quiere hacer
     * @param nif una cadena de texto que identifica la tarjeta de credito
     * creada
     * @param TarjetaCredito
     */
    public static void gestionTarjetaCredito(int indiceSubMenu, String nif, ArrayList<TarjetaCredito> TarjetaCredito) {
        Scanner teclado = new Scanner(System.in);

        if (Funciones.buscarNIF(nif, TarjetaCredito)) {
            TarjetaCredito array2[];
            array2 = (TarjetaCredito[]) TarjetaCredito.toArray();
            TarjetaCredito tarjeta = array2[indiceArrayBusquedaNIF];
            Funciones.mostrarSubMenu();
            switch (indiceSubMenu) {
                case 1 ->
                    System.out.print(tarjeta.getNumeroTarjeta());
                case 2 ->
                    System.out.print(tarjeta.getTitular());
                case 3 ->
                    System.out.print(tarjeta.getMesCaducidad() + "/" + tarjeta.getAñoCaducidad());
                case 4 -> {
                    String pin;
                    boolean esCorrecto = false;
                    do {
                        System.out.println("Introduce el nuevo pin que desees, recuerda que minimo necesita 4 digitos");
                        pin = teclado.nextLine();
                        if (ValidarNumeroPin(pin)) {
                            tarjeta.setPin(pin);
                            esCorrecto = true;
                        }
                    } while (!esCorrecto);
                }
                case 5 -> {
                    String concepto;
                    double cantidad = 0;
                    System.out.println("---Introduzca el concepto---");
                    concepto = teclado.nextLine();
                    do {
                        System.out.println("---Introduzca una cantidad---");
                        cantidad = Funciones.leerDatosTecladoCantidad(cantidad);
                    } while (cantidad < 0);
                    if (tarjeta.pagar(cantidad, concepto)) {
                        System.out.println("Pago realizado correctamente");
                        numeroMovimiento++;
                    } else {
                        System.err.println("Supera el limite de pago");
                    }
                }
                case 6 -> {
                    int movimientos = 0;
                    do {
                        System.out.println("¿Cuantos movimientos quieres consultar?");
                        movimientos = Funciones.leerDatosTeclado(movimientos);
                    } while (movimientos < 0 || movimientos > numeroMovimiento);
                    System.out.println(tarjeta.movimientos(movimientos));
                }
                case 7 ->
                    System.out.print(tarjeta.gastado());
            }
        }
    }

    /**
     * Es una funcion double que se encarga de mostrar todos los gastos de una
     * tarjeta de credito, el return es la suma total de todo lo gastado en una
     * tarjeta de credito
     *
     * @param TarjetaCredito
     * @return gastoTotal
     */
    public static double mostrarGastoTotalTarjetas(ArrayList<TarjetaCredito> TarjetaCredito) {
        double gastoTotal = 0;
//        for (int i = 0; i < array.length && array[i] != null; i++) {
//            TarjetaCredito tarjeta = array[i];
//            gastoTotal += tarjeta.gastado();
//        }
        Iterator<TarjetaCredito> it = TarjetaCredito.iterator();
        for (; it.hasNext();) {
            TarjetaCredito tarjeta = it.next();
            gastoTotal += tarjeta.gastado();
        }
        return gastoTotal;
    }

    /**
     * Es una funcion que se encargar de comprobar el texto introducido por el
     * usuario mediante una expresion regular, en caso de ser correcta devuelve
     * true
     *
     * @param texto cadena String
     * @return m.matches()
     */
    public static boolean expresionRegularNombre(String texto) {
        Pattern cadenaTexto = Pattern.compile("^([A-Za-zÑñÁáÉéÍíÓóÚú]+['\\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+)(\\s+([A-Za-zÑñÁáÉéÍíÓóÚú]+['\\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+))*$");
        Matcher m = cadenaTexto.matcher(texto);
        return (m.matches());
    }

    /**
     * Es una funcion que se encargar de comprobar el nif introducido por el
     * usuario mediante una expresion regular, en caso de ser correcta devuelve
     * true
     *
     * @param nif cadena String
     * @return m.matches()
     */
    public static boolean expresionRegularNIF(String nif) {
        nif = nif.toUpperCase();
        Pattern numeroDNI = Pattern.compile("[0-9]{8,8}+[A-Z]{1,2}");
        Matcher m = numeroDNI.matcher(nif);
        return (m.matches());
    }

    /**
     * Es una funcion que se encargar de comprobar el cif introducido por el
     * usuario mediante una expresion regular, en caso de ser correcta devuelve
     * true
     *
     * @param cif cadena String
     * @return m.matches()
     */
    public static boolean expresionRegularCIF(String cif) {
        cif = cif.toUpperCase();
        Pattern numeroCIF = Pattern.compile("[ABCDEFGHJKLMPQRSUVNWXYZ]+[0-9]{8,8}");
        Matcher m = numeroCIF.matcher(cif);
        return (m.matches());
    }

    /**
     * Es una funcion que se encargar de comprobar el nie introducido por el
     * usuario mediante una expresion regular, en caso de ser correcta devuelve
     * true
     *
     * @param nie cadena de String
     * @return m.matches()
     */
    public static boolean expresionRegularNIE(String nie) {
        nie = nie.toUpperCase();
        Pattern numeroNIE = Pattern.compile("[X-Z]+[0-9]{7,7}+[A-Z]");
        Matcher m = numeroNIE.matcher(nie);
        return (m.matches());
    }

    /**
     * Es una funcion que se encargar de comprobar el pin introducido por el
     * usuario mediante una expresion regular, en caso de ser correcta devuelve
     * true
     *
     * @param pin cadena de String minimo de 4
     * @return m.matches()
     */
    public static boolean expresionRegularPin(String pin) {
        Pattern numeroPin = Pattern.compile(".\\S{4,}");
        Matcher m = numeroPin.matcher(pin);
        return (m.matches());
    }

    /**
     * Es una funcion boolean que comprueba que el usuario mete uno valor
     * permitido por el menu, es boolean por lo tanto si esta dentro de los
     * parametros devuelve true si es correcto
     *
     * @param respuesta valor introducido por el usuario
     * @return esCorrecto
     */
    public static boolean validarAccionMenu(int respuesta) {
        boolean esCorrecto = false;
        var teclado = new Scanner(in);
        if ((teclado.hasNextDouble())) {
            if (respuesta <= 5 && respuesta >= 1) {
                esCorrecto = true;
            }
        }

        return esCorrecto;
    }

}
