/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo_gestiontarjetascredito;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Este es el main con el cual se ejecuta el programa para probar todo y crear
 * tarjetas
 *
 * @author Aleksander
 * @version JDK 16
 * @see TarjetaCredito
 * @see Movimiento
 * @se Funciones
 */
public class AplicacionTarjetasCredito {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        TarjetaCredito[] array = new TarjetaCredito[10];
        ArrayList<TarjetaCredito> TarjetaCredito = new ArrayList<>();
        boolean cerrarPrograma = false;
        boolean cerrarSubMenu = false;
        int indiceMenu = 0;
        int indiceSubMenu = 0;
        String nif;
        
        System.out.println("\t---------------------------------");
        System.out.println("\tAplicacion de gestion de tarjetas");
        System.out.println("\t---------------------------------");
        do {
            Funciones.Funciones.mostrarMenu();
            do {
                System.out.println("¿Que desea hacer?");
                indiceMenu = Funciones.Funciones.leerDatosTeclado(indiceMenu);
            } while (indiceMenu < 1 && indiceMenu > 5);
            switch (indiceMenu) {
                case 1 -> {
                    if (Funciones.Funciones.numeroDeTarjetasCreadas() < 10) {
                        Funciones.Funciones.crearTarjetaCredito(TarjetaCredito);
                    }
                    System.out.println("Llevas:" + Funciones.Funciones.numeroDeTarjetasCreadas() + " tarjetas de credito. No puedes superar el limite, son 10");
                }
                case 2 -> {
                    System.out.println("Para eliminar una tarjeta, debe introducir el NIF");
                    nif = teclado.nextLine();
                    if (Funciones.Funciones.ValidarDocumentoIdentidad(nif)) {
                        Funciones.Funciones.eliminarTarjetaCredito(nif, TarjetaCredito);
                    }
                }
                case 3 -> {
                    do {
                        System.out.println("\nIntroduzca el NIF");
                        nif = teclado.nextLine();
                    } while (!Funciones.Funciones.ValidarDocumentoIdentidad(nif));
                    do {
                        if (Funciones.Funciones.buscarNIF(nif, TarjetaCredito)) {
                            Funciones.Funciones.mostrarSubMenu();
                            do {
                                System.out.println("¿Que desea hacer?");
                                indiceSubMenu = Funciones.Funciones.leerDatosTeclado(indiceMenu);
                            } while (indiceMenu < 1 && indiceMenu > 7);
                            Funciones.Funciones.gestionTarjetaCredito(indiceSubMenu, nif, TarjetaCredito);
                        } else {
                            System.err.println("NIF no concuerda con ninguna tarjeta de credito");
                        }
                    } while (!cerrarSubMenu && indiceSubMenu != 8);
                }
                case 4 ->
                    System.out.println(Funciones.Funciones.mostrarGastoTotalTarjetas(TarjetaCredito));
                case 5 ->
                    cerrarPrograma = true;
            }
        } while (!cerrarPrograma);

    }

}
