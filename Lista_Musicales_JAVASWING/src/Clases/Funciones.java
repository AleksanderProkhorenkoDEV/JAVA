package Clases;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase funciones, aqui se encuentran las funciones que usamos para validar los
 * parametros de entrada de las funciones, para el correcto funcionamiento del
 * programa.
 *
 * @author Aleksander Trujillo Prokhorenko
 * @version JDK 16
 */
public class Funciones {

    /**
     * Funcion que se encarga de comprobar el minimo de un parametro
     * introducido, es decir, esta funcion recibe un valor numerico Int, el cual
     * se limita, esto quiere decir que no se puede introducir uno inferior al
     * parametro establecido como minimo. Para que devuelva true el valor
     * introducido tiene que ser mayor o igual al minimo en caso contrario
     * devuelve false.
     *
     * @param parametro
     * @param minimo
     * @return
     */
    public static boolean comprobarMinimo(int parametro, int minimo) {
        return parametro >= minimo;
    }

    /**
     * En esta funcion recibe por parametro un String que es un texto, en el
     * cual mediante el metodo .isBlank(); que su valor de retorno es boolean,
     * en el caso de que la cadena este vacia o contenga espacios en blanco
     * unicamente devuelve True, en caso contrario devuelve False
     *
     * @param texto, String
     * @return boolean.
     */
    public static boolean ValidarCadenaTexto(String texto) {
        return !texto.isBlank();
    }

    /**
     * Esta expresion regular recibe por parametro un String, y con el
     * Pattern.compile se le asigna una cadena String que es una expresion
     * regular, una vez hecho mediante el Matcher le pasamos por parametro el
     * texto introducido en la funcion y con el metodo .matches() comprobamos
     * que haya alguna similitud en caso de que le haya devuelve true y en caso
     * contrario de no hayar ninguna devuelve false.
     *
     * @param texto, String
     * @return boolean
     */
    public static boolean expresionRegularNumeros(String texto) {
        Pattern cadenaTexto = Pattern.compile("-1|[0-9]{1,9}");
        Matcher m = cadenaTexto.matcher(texto);
        return (m.matches());
    }

    /**
     * Esta funcion recibe por paremtro un String, el cual es una ruta y
     * mediante un metodo .isBlank() comprueba que la cadena de texto no este
     * vacia o contenga unicamente espacios en blanco, en coso de que sea un
     * String valido devolvera True, en caso contrario de no estar bien formado
     * el String devolvera False
     *
     * @param parametro
     * @return
     */
    public static boolean comprobarRuta(String parametro) {
        return !parametro.isBlank();
    }

}
