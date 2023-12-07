/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Academia;
/**
 * Ejercicio que relaciona dos clases "Estudiante" y "Asignatura" para aprender POO
 * @author Aleksander Trujillo
 * @vesion JDK 17
 * @see Asignatura
 * 
 */
public class Estudiante {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private Asignatura[] listaAsignatura = new Asignatura[5];
    private int horasAsignaturasGet = 0;
    private int numeroAsignaturasGet = 0;
    /**
     * Constructor por defecto que establece todos los valores a 0
     */
    public Estudiante() {
        nombre = "";
        apellido1 = "";
        apellido2 = "";
        Asignatura listaAsignatura[] = new Asignatura[5];
    }
    /**
     * Con este constructor creamos los objetos de Estudiante
     * @param nombre Es el nombre del estudiante
     * @param apellido1 Primer apellido en relación con el estudiante
     * @param apellido2 Segundo apellido en relación con el estudiante
     * @throws new IllegalargumentException en caso de que algun texto introducido no sea correcto. 
     */
    public Estudiante(String nombre, String apellido1, String apellido2) {
        if (ValidarTexto(nombre, apellido1, apellido2)) {
            throw new IllegalArgumentException("El texto introducido es incorrecto");
        }
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;

    }
    /**
     * Constructor copia que recibe los datos del constructor y los copia
     * @param e Recibe los datos de estudiante (nombre, apellido1, apellido2)
     */
    public Estudiante(Estudiante e) {
        this(e.apellido1, e.apellido2, e.nombre);
    }
    /**
     * Sirve para comprobar que se puede añadir una asignatura mas a un estudiante y agregarla a su lista
     * @param a Recibe por parametros (nombre y horas de las asignaturas)
     * @return true en caso de poder añadirla correctamente, false en caso de que no cumpla los requisitos para añadirla
     */
    public boolean añadeAsignatura(Asignatura a) {
        boolean añadirAsignatura = false;
        int horas;
        int contador = 0;
        horas = a.getHoras();
        if (horas < 30) {
            contador++;
            añadirAsignatura = true;
            this.listaAsignatura[contador] = a;

        }
        numeroAsignaturasGet = numeroAsignaturasGet + contador;
        horasAsignaturasGet = horasAsignaturasGet + a.getHoras();
        return añadirAsignatura;
    }
    /**
     * Sirve para sacar la asignatura que hay almacenada en un array de objetos mediante su posicion que es lo que se recibe por parametro
     * @param posicion es el indice del array para poder recorrerlo
     * @return el nombre de la asignatura que se encuentra en la posicion introducida
     */
    public Asignatura getAsignatura(int posicion) {
        Asignatura nombreAsignatura;
        nombreAsignatura = listaAsignatura[posicion];
        return nombreAsignatura;

    }
    /**
     * Este getter nos sirve para sacar el numero de cuantas Asignaturas tiene matriculadas un estudiante
     * @return devuelve el numero de Asignaturas que tiene matriculadas el alumno
     */
    public int getNumeroAsignaturasMatriculadas() {
        int numeroAsignaturas = 0;
        numeroAsignaturas = numeroAsignaturasGet;
        return numeroAsignaturas;
    }
    /**
     * El getter nos devuelve el numero de horas que tiene matriculada un alumno en total
     * @return devuelve el numero total de horas que tiene matriculada
     */
    public int getNumeroHorasMatriculadas() {
        int numeroHoras = 0;
        numeroHoras = horasAsignaturasGet;
        return numeroHoras;
    }
    /**
     * Con este método podemos comparar dos objetos para saber si son iguales o no, de manera booleana 
     * @param e recibe por parametros nombre, apellido1, apellido2
     * @return devuelve true en caso de que haya una igualdad entre los dos objetos y false en caso de que no haya igualdad.
     */
    public boolean equals(Estudiante e) {
        boolean igualdad = false;
        if (e.nombre.equalsIgnoreCase(nombre) && e.apellido1.equalsIgnoreCase(apellido1) && e.apellido2.equalsIgnoreCase(apellido2)) {
            igualdad = true;
        }
        return igualdad;
    }

    @Override
    public String toString() {
        String nombreAsignaturas = "";
        for (int i = 0; i < listaAsignatura.length; i++) {
            nombreAsignaturas = nombreAsignaturas + listaAsignatura[i];
        }
        return "Estudiante\nNombre:" + nombre + "\nApellidos: " + apellido1 + " " + apellido2 + "\n" + nombreAsignaturas;
    }

    private boolean ValidarTexto(String nombre, String apellido1, String apellido2) {
        return (nombre.isBlank() || nombre.isEmpty()) && (apellido1.isBlank() || apellido1.isEmpty()) && (apellido2.isBlank() || apellido2.isEmpty());
    }
}
