package Clases;

/**
 * Clase Cancion, la cual utilizamos para la construccion de objetos de tipo
 * Cancion, compuesta por tres atributos privados, los cuales son el Titulo
 * (String), Ruta (String) y Duracion (int).
 *
 * @author Aleksander Trujillo Prokhorenko
 * @version JDK 16
 *
 */
public class Cancion {

    private String titulo;
    private String ruta;
    private int duracion;

    /**
     * Constructor de la clase Cancion, este se encarga de construir objetos
     * Canciones, compuestos por un Titulo, una Ruta y una Duracion. Esto se
     * valida mediante unas funciones booleanas, que en el caso de que sea
     * valido lo introducido por el usuario no ocurrira nada y se asignara el
     * valor al objeto En caso contrario saltaran un Throw
     * IllegalArgumentException.
     *
     * En el caso del titulo saltara si el usuario intenta introducir cadenas
     * vacias o espacios en blanco sin contenido, en caso de la ruta sera lo
     * mismo.
     *
     * @param titulo, String
     * @param ruta, String
     * @param duracion, int
     * @throws titulo, este ocurre cuando el usuario introduce un valor en
     * blanco o unicamente con espacios en blanco unicamente.
     * @throws ruta, este ocurre cuando el usuario introduce una ruta no valida,
     * que estas son cadenas vacias o espacios en blanco unicamente.
     * @throws duracion, esta ocurre cuando el usuario mete un valor inferior a
     * -1 o trata de meter un valor igual a 0, ya que no existen canciones que
     * duren cero o tiempo negativo, en este caso el -1 representa tiempo
     * desconocido por eso esta permitido
     *
     */
    public Cancion(String titulo, String ruta, int duracion) {

        if (!Funciones.ValidarCadenaTexto(titulo)) {
            throw new IllegalArgumentException("El titulo no puede estar vacio");
        }
        if (!Clases.Funciones.comprobarRuta(ruta)) {
            throw new IllegalArgumentException("La ruta introducida no puede estar vacia");
        }
        if ((duracion < -1) || (duracion == 0)) {
            throw new IllegalArgumentException("La duracion introducida no es valida");
        }
        this.titulo = titulo;
        this.ruta = ruta;
        this.duracion = duracion;
    }

    /**
     * Constructor copia del objeto Cancion, el cual copia los atributos de
     * titulo, ruta, duracion.
     *
     * @param c
     */
    public Cancion(Cancion c) {
        this(c.titulo, c.ruta, c.duracion);
    }

    /**
     * Metodo getter de la variable String titulo.
     *
     * @return titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Metodo getter de la variable String ruta.
     *
     * @return ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * Metodo getter de la variable Int duracion.
     *
     * @return duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Metodo setter que modifica el titulo de una Cancion en concreto, esta
     * antes de modificarla comprueba que el titulo sea valido, mediante una
     * funcion, esta funcion comprueba que no sea una cadena vacia o contenga
     * espacios en blanco unicamente.
     *
     * @param titulo, String
     */
    public void setTitulo(String titulo) {
        if (Funciones.ValidarCadenaTexto(titulo)) {
            this.titulo = titulo;
        }

    }

    /**
     * Metodo setter que modifica la ruta de una Cancion en concreto, esta antes
     * de modificarla comprueba que la ruta sea valido, mediante una funcion,
     * esta funcion comprueba que no sea una cadena vacia o contenga espacios en
     * blanco unicamente.
     *
     * @param ruta
     */
    public void setRuta(String ruta) {
        if (Funciones.comprobarRuta(ruta)) {
            this.ruta = ruta;
        }
    }

    /**
     * Metodo setter que modifica la duracion de una Cancion en concreto, esta
     * antes de modificarla comprueba que la duracion sea valido, mediante una
     * funcion, esta funcion comprueba que el valor no sea cero o inferior a -1.
     *
     * @param duracion
     */
    public void setDuracion(int duracion) {
        if (Funciones.comprobarMinimo(duracion, -1)) {
            this.duracion = duracion;
        }
    }

   

}
