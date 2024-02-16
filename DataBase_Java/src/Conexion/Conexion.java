/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion {

    private static Conexion instancia = new Conexion();
    private EntityManagerFactory fabrica;

    private Conexion() {
        fabrica = Persistence.createEntityManagerFactory("Trujillo_Prokhorenko_Aleksander_PROG_ProyectoBasesDatosPU");
    }

    public static Conexion getInstancia() {
        return instancia;
    }

    public EntityManagerFactory getFabrica() {
        return fabrica;
    }

}
