/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Cafetera;

/**
 *
 * @author Usuario
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cafetera c = new Cafetera ();
        Cafetera c2 = new Cafetera (1500);
        Cafetera c3 = new Cafetera (1500,750); 
        Cafetera c4 = new Cafetera (1500,30);
        c3.servirTaza(50);
        System.out.println(c3);
        c2.llenarCafetera();
        System.out.println(c2);
        c4.servirTaza(40);
        System.out.println(c4);
        c2.vaciarCafetera();
        System.out.println(c2);
    }
    
}
