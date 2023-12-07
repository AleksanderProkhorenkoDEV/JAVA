/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relacionejerciciossencillosi;

public class Circulo {

    private Punto centro;
    private double radio;

    private double origen_x;
    private double origen_y;
    private double getX;

    public void Circulo() {
        this.centro = new Punto();
        this.radio = 0.0;
    }

    public Circulo(Punto p, double radio) {
        if (!ValidarParametros(radio)) {
            throw new IllegalArgumentException("El radio no puede ser negativo");
        }
        //this(p.getX(), p.getY(), radio);
        //Tener cuidado con poner this.centro = p; Porque viola el principio de encapsulación porque el usuario puedo modificar los valores 
        //del objeto porque p lo puede escribir el usuario, por lo tanto tienes que crear un nuevo objeto donde copiarlo y asi no modifica nada
        //Este proceso se llama una copia defensiva

    }

    public Circulo(Circulo c) {
        this(c.centro.getX(), c.centro.getY(), c.radio);
    }

    public Circulo(double origen_x, double origen_y, double radio) {
        if (!ValidarParametros(radio)) {
            throw new IllegalArgumentException("El radio no puede ser negativo");
        }
        this.centro = new Punto(origen_x, origen_y);
        this.radio = radio;
    }

    public Punto getCentro() {
        return centro;
    }

    public double getRadio() {
        return radio;
    }

    public double getArea() {
        return this.radio * this.radio * Math.PI;
    }

    public double getCircunferencia() {
        return (this.radio * 2) * Math.PI;
    }

    public void setRadio(double radio) {
        if (radio > 0) {
            this.radio = radio;
        }
    }

    public void setCentro(Punto centro) {
        this.centro = new Punto(centro);
    }

    @Override
    public String toString() {
        return "[ " + centro.toString() + "\t, radio=" + radio + "]";
    }

    public boolean equals(Circulo c) {
        return this.radio== c.radio && this.centro.equals(c.centro);
    }
//Para comparar objetos se usa el equals, si no comparas referencias. 
    private boolean ValidarParametros(double numero) {
        return numero >= 0;
    }

}
