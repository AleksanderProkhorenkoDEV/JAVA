package Clases;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * Clase ModeloTablaCanciones, esta extiende del modelo abstracto de Table, para
 * asi poder darle una personalizacion como yo desee, para poder usarla tienes
 * que sobrescribir 4 metodos, estos son getRowCount(), getColumnCount(),
 * getColumnName(), getValueAt(). Ademas en esta clase tenemos un
 * ArrayList<Cancion> en el cual almacenaremos las canciones que se vayan
 * añadiendo a lista o en su caso contrario las eliminaremos.
 *
 * @author Aleksander Trujillo Prokhorenko
 * @version JDK 16
 *
 */
public class ModeloTablaCanciones extends AbstractTableModel {

    private String[] nombreColumnas = {"Indice", "Titulo", "Duracion", "ruta"};
    private ArrayList<Cancion> listaCanciones;

    /**
     * Constructor por defecto de la clase ModeloTablaCanciones, en el cual
     * inicializamos el ArrayList<Cancion>.
     */
    public ModeloTablaCanciones() {
        this.listaCanciones = new ArrayList<>();
    }

    /**
     * Metodo getter que recibe por parametro un indice, con el cual accederemos
     * a una Cancion determinada de la lista, antes de poder acceder a este
     * elemento comprobamos que este indice este dentro del tamaño del ArrayList
     * para no acceder a posiciones nulas, en caso de que este dentro de los
     * parametros se obtendra esa cancion y se devolvera en caso contrario se
     * devolvera null
     *
     * @param index, int
     * @return cancion, Objecto Cancion
     */
    public Cancion getCancion(int index) {
        Cancion cancion = null;
        if ((index >= 0) && (index < this.listaCanciones.size())) {
            cancion = this.listaCanciones.get(index);
        }
        return cancion;
    }

    /**
     * Metodo void, que se encarga de añadir objetos Cancion a la lista de
     * Canciones. Esta recibe por paremtro un Objeto Cancion ya creado y
     * utilizando el metodo publico de ArrayList<> .add añado ese objeto.
     *
     * @param c
     */
    public void añadirCancion(Cancion c) {
        listaCanciones.add(c);
    }

    /**
     * Metodo void, que se encargar de crear una lista nueva, esta realmente lo
     * que hace es borrar los datos actuales que tiene el ArrayList<> dejandolo
     * vacio medianete el metodo .removeAll(variable ArrayList).
     */
    public void crearListaNueva() {
        this.listaCanciones.removeAll(listaCanciones);
    }

    /**
     * Metodo booleano, que recibe por parametro un indice y un titulo nuevo
     * para la cancion, este indice es la posicion en la que se encuentra la
     * cancion en el Array y si esta dentro de los valores permitidos los cuales
     * son mayor o igual que cero y menor que el tamaño del ArrayList, comprueba
     * que el texto del titulo nuevo sea valido, es decir, que no sea una cadena
     * en blanco o tenga espacios en blanco unicamente, si estas dos
     * validaciones son true se procede a modificar el titulo con el setter de
     * la clase Cancion. Si se modifica correctamente devuelve True en caso de
     * que no se haya podido modificar devuelve False.
     *
     * @param indice, int
     * @param tituloNuevo, String
     * @return esModificado, boolean
     */
    public boolean setTitulo(int indice, String tituloNuevo) {
        boolean esModificado = false;
        if (indice >= 0 && indice < this.listaCanciones.size()) {
            if (Clases.Funciones.ValidarCadenaTexto(tituloNuevo)) {
                this.listaCanciones.get(indice).setTitulo(tituloNuevo);
                esModificado = true;
            }
        }
        return esModificado;
    }

    /**
     * Metodo booleano, que recibe por parametro un indice y una duracion,
     * primero comprueba que el indice este dentro de los parametros del
     * arrayList posteriormente comprueba que la duracion sea -1 o superior a
     * cero, en caso de que no pueda validar ninguna de esas dos cosas no
     * modificara nada. En caso de que todos los valores sean correctos se usa
     * el metodo Setter de la clase Cancion. En caso de modificarse el metodo
     * devuelve True y en caso de que no devuelve False.
     *
     * @param indice, int
     * @param duracion, int
     * @return
     */
    public boolean setDuracion(int indice, int duracion) {
        boolean esModificado = false;
        if (indice >= 0 && indice < this.listaCanciones.size()) {
            this.listaCanciones.get(indice).setDuracion(duracion);
            esModificado = true;
        }
        return esModificado;
    }

    /**
     * Metodo booleano, que se encarga de modificar la ruta de una cancion en
     * concreto, esta recibe por parametro un indice y una ruta nueva, se valida
     * que le indice esta dentro de los parametros del ArrayList y luego se
     * valida que la ruta no este vacia o sean espacios en blanco unicamente
     * mediante una funcion. En caso de que todo sea correcto el metodo devuelve
     * True en caso contrario devuelve False.
     *
     * @param indice
     * @param rutaNueva
     * @return
     */
    public boolean setRuta(int indice, String rutaNueva) {
        boolean esModificado = false;

        if (indice >= 0 && indice < this.listaCanciones.size()) {
            this.listaCanciones.get(indice).setRuta(rutaNueva);
            esModificado = true;
        }
        return esModificado;
    }

    /**
     * Metodo booleano, que recibe por paremtro un indice con el cual acceden a
     * una cancion determinada del ArrayList y eliminan esa cancion siempre y
     * cuando el indice este dentro de los parametros de longitud del ArrayList,
     * en caso de que la eliminacion sea efectiva devuelve True en caso
     * contrario devuelve False.
     *
     * @param indice, int
     * @return esModificado, boolean
     */
    public boolean eliminarCancion(int indice) {
        boolean esModificado = false;
        if (indice >= 0 && indice < this.listaCanciones.size()) {
            this.listaCanciones.remove(indice);
            esModificado = true;
        }
        return esModificado;
    }

    /**
     * Devuelve el número de filas en el modelo de datos de la tabla.
     *
     * @return el número de filas en el modelo de datos de la tabla.
     */
    @Override
    public int getRowCount() {
        return this.listaCanciones.size();
    }

    /**
     * Devuelve el número de columnas en el modelo de datos de la tabla.
     *
     * @return el número de columnas en el modelo de datos de la tabla.
     */
    @Override
    public int getColumnCount() {
        return 4;
    }

    /**
     * Devuelve el nombre de la columna en la posición especificada.
     *
     * @param index el índice de la columna.
     * @return el nombre de la columna en la posición especificada.
     */
    @Override
    public String getColumnName(int index) {
        return this.nombreColumnas[index];
    }

    /**
     * Devuelve el valor en la posición especificada de la tabla.
     *
     * @param rowIndex el índice de la fila.
     * @param columnIndex el índice de la columna.
     * @return el valor en la posición especificada de la tabla.
     * @throws IllegalArgumentException si se intenta acceder a un índice fuera
     * de los valores de la tabla.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cancion c = this.listaCanciones.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0 ->
                value = rowIndex;
            case 1 ->
                value = c.getTitulo();
            case 2 ->
                value = c.getDuracion();
            case 3 ->
                value = c.getRuta();
            default ->
                throw new IllegalArgumentException("No se puede acceder a indices fuera de los valores de la tabla");
        }
        return value;
    }

}
