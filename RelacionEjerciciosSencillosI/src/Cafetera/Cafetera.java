/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cafetera;

/**
 *
 * @author Aleksander
 */
public class Cafetera {

    private int capacidadMaxima; //La cantidad maxima de cafe que puede contener.
    private int cantidadActual;  //La cantidad de cafe que tiene en ese momento.

    public Cafetera() {
        capacidadMaxima = 1000;
        cantidadActual = 0;
    }

    public Cafetera(int capacidadMaxima) {
        if (ValidarParametros(capacidadMaxima)) {
            this.capacidadMaxima = capacidadMaxima;
        }

    }

    public Cafetera(int capacidadMaxima, int cantidadActual) {
        if (!ValidarParametros(capacidadMaxima)) {
            throw new IllegalArgumentException("La capacidad introducidad no cumple con los parametros");
        }
        if (!ValidarParametros(cantidadActual)) {
            throw new IllegalArgumentException("La cantidad introducidad no cumple con los parametros");
        }
        this.cantidadActual = cantidadActual;
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        if (ValidarParametros(capacidadMaxima)) {
            this.capacidadMaxima = capacidadMaxima;
        }
    }

    public void setCantidadActual(int cantidadActual) {
        if (ValidarParametros(cantidadActual)) {
            this.cantidadActual = cantidadActual;
        }
    }
    public void llenarCafetera(){
        this.cantidadActual = this.capacidadMaxima;
    }
    public int servirTaza(int cantidad){
        int cantidadServida=0;
        if (ValidarServirTaza(cantidad)) {
            if (this.cantidadActual >= cantidad) {
                this.cantidadActual = this.cantidadActual - cantidad;
            }else{
                this.cantidadActual -= cantidad;
                
            }
        }
        return cantidadServida;
    }
    public void vaciarCafetera(){
        this.cantidadActual=0;
    }
    @Override
    public String toString() {
        return "Cafetera{" + "capacidadMaxima=" + capacidadMaxima + ", cantidadActual=" + cantidadActual + '}';
    }
    
    private boolean ValidarServirTaza(int valor) {
        return valor > 0 && valor <= 50;
    }

    private boolean ValidarParametros(int valor) {
        return valor >= 0;
    }
}
