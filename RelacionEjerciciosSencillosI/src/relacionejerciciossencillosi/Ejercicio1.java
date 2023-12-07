/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionejerciciossencillosi;

/**
 *
 * @author Usuario
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        Punto p1 = new Punto();
        Punto p2 = new Punto(5.4, 6);
        Punto p3 = new Punto(6.6, 6.6);
        Punto p4 = new Punto(8, 8);

        System.out.println("---PRIMERA PRUEBA---");
        System.out.println(p1);
        System.out.println("Punto x: " + p1.getX() + " Punto y: " + p1.getY());
        System.out.println(p1.equals(p4));
        System.out.println("---SEGUNDA PRUEBA----");
        p1.setX(6.6);
        p1.setY(6.6);
        System.out.println("Punto x: " + p2.getX() + " Punto y: " + p2.getY());
        System.out.println(p1);
        System.out.println(p3);
        System.out.println(p1.equals(p3));
        System.out.println("---TERCERA PRUEBA---");
        //Circulo c1 = new Circulo(p1, 5);
        //Circulo c2 = new Circulo(p2, 10);
        //Circulo c3 = new Circulo(p3, 15);
        //System.out.println(c1);
        //System.out.println(c2);
        //System.out.println(c2.getArea());
        //System.out.println(c3.getCircunferencia());
        //System.out.println(c1.equals(c3));

        System.out.println("---Punto Color---");
        PuntoColor pC1 = new PuntoColor(5, 5, "Blanco");
        PuntoColor pC2 = new PuntoColor();
        PuntoColor pC3 = new PuntoColor();
        PuntoColor pC4 = new PuntoColor();
        System.out.println(pC1);
        pC1.setColor("Morado");
        System.out.println(pC1);
        System.out.println(pC1.getColor());
        System.out.println(pC2);
        pC2.setColor("Purpura");
        pC2.setX(4);
        pC2.setY(10);
        System.out.println(pC2);
        System.out.println(pC3.equals(pC4));
    }

}
