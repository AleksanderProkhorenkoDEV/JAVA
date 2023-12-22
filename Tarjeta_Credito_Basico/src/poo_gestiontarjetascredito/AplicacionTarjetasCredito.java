/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo_gestiontarjetascredito;

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
        boolean cerrarPrograma = false;
        boolean cerrarSubMenu = false;
        int indiceMenu = 0;
        int indiceSubMenu = 0;
        String nif;
        final int OPCION_CREAR_TARJETA = 1;
        final int OPCION_ELIMINAR_TARJETA = 2;
        final int OPCION_GESTIONAR_TARJETA = 3;
        final int OPCION_CONSULTAR_GASTOS = 4;
        final int OPCION_SALIR_PROGRAMA = 5;

        System.out.println(
                "\t---------------------------------");
        System.out.println(
                "\tAplicacion de gestion de tarjetas");
        System.out.println(
                "\t---------------------------------");
        do {
            Funciones.Funciones.mostrarMenu();
            do {
                System.out.println("¿Que desea hacer?");
                indiceMenu = Funciones.Funciones.leerDatosTeclado(indiceMenu);
            } while (indiceMenu < 1 && indiceMenu > 5);
            switch (indiceMenu) {
                case OPCION_CREAR_TARJETA -> {
                    if (Funciones.Funciones.numeroDeTarjetasCreadas() < 10) {
                        Funciones.Funciones.crearTarjetaCredito(array);
                        System.out.println("Llevas:" + Funciones.Funciones.numeroDeTarjetasCreadas() + " tarjetas de credito");
                    } else {
                        System.out.println("No se pueden crear mas de 10");
                    }
                }
                case OPCION_ELIMINAR_TARJETA -> {
                    System.out.println("Para eliminar una tarjeta, debe introducir el NIF");
                    nif = teclado.nextLine();
                    if (Funciones.Funciones.ValidarDocumentoIdentidad(nif)) {
                        Funciones.Funciones.eliminarTarjetaCredito(nif, array);
                    }
                }
                case OPCION_GESTIONAR_TARJETA -> {
                    do {
                        System.out.println("\nIntroduzca el NIF");
                        nif = teclado.nextLine();
                    } while (!Funciones.Funciones.ValidarDocumentoIdentidad(nif));
                    do {
                        if (Funciones.Funciones.buscarNIF(nif, array)) {
                            Funciones.Funciones.mostrarSubMenu();
                            do {
                                System.out.println("¿Que desea hacer?");
                                indiceSubMenu = Funciones.Funciones.leerDatosTeclado(indiceMenu);
                            } while (indiceMenu < 1 && indiceMenu > 7);
                            Funciones.Funciones.gestionTarjetaCredito(indiceSubMenu, nif, array);
                        } else {
                            System.err.println("NIF no concuerda con ninguna tarjeta de credito");
                        }
                    } while (!cerrarSubMenu && indiceSubMenu != 8);
                }
                case OPCION_CONSULTAR_GASTOS ->
                    System.out.println(Funciones.Funciones.mostrarGastoTotalTarjetas(array));
                case OPCION_SALIR_PROGRAMA ->
                    cerrarPrograma = true;
            }
        } while (!cerrarPrograma);

    }
}
