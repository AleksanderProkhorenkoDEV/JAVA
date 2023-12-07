/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Academia;
/**
 * Clase que crea objetos Asignatura con un nombre y numero total de horas
 * @author Aleksander Trujillo
 * @version JDK 17
 * @see Estudiante
 */
public class Asignatura {

    private String nombre;
    private int horas;
    /**
     * Constructor Asignatura que recibe por parametro el nombre de esta y las horas que tiene
     * @param nombre el nombre de la Asignatura
     * @param horas el numero de horas que tiene la Asignatura
     */
    public Asignatura(String nombre, int horas) {
        if (!ValidarParametros(horas)) {
            throw new IllegalArgumentException("Las horas introducidas son incorrectas");
        }
        this.nombre = nombre;
        this.horas = horas;
    }
    /**
     * Constructor copia de Asignatura 
     * @param a  recibe los datos de nombre y horas
     */
    public Asignatura(Asignatura a) {
        this(a.nombre, a.horas);
    }
    /**
     * Sirve para obtener el nombre de la asignatura 
     * @return el nombre de esta
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Sirve para obtener el numero de horas que tiene la asignatura
     * @return devuelve el numero de horas que tiene
     */
    public int getHoras() {
        return horas;
    }
    /**
     * Modifica el nombre de alguna asignatura introducida 
     * @param nombre recibe el parametro nuevo del nombre que se quiere cambiar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Modifica la cantidad de horas que tiene una asignatura 
     * @param horas las nuevas horas que quieres para modificar 
     */
    public void setHoras(int horas) {
        if (ValidarParametros(horas)) {
            this.horas = horas;
        }
    }

    @Override
    public String toString() {
        return "Asignatura: " + nombre + " horas: " + horas;
    }
    /**
     * Con este método podemos comparar dos objetos para saber si son iguales o no, de manera booleana
     * @param a es el objeto que tiene dentro el nombre y las horas del
     * @return 
     */
    public boolean equals(Asignatura a) {
        return a.horas == horas && a.nombre.equals(nombre);
    }

    private boolean ValidarParametros(int horas) {
        return horas > 0;
    }

}
