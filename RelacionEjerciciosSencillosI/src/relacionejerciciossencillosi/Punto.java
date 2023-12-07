/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relacionejerciciossencillosi;


public class Punto {
        private double x;
        private double y;
        
        public Punto(){
            this.x=0.0;
            this.y=0.0;
        }

    public Punto(double x, double y) {
        if (!ValidarParametros(x)) {
            throw new IllegalArgumentException("El valor de X es erroneo");
        }
        if (!ValidarParametros(y)) {
            throw new IllegalArgumentException("El valor de y es erroneo");
        }
        this.x=x;
        this.y=y;
    }
    public Punto(Punto p){
        this(p.x,p.y);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Punto: x: "+x+" y: "+y;
    }
    public boolean equals(Punto p){
        return this.x == p.x && this.y == p.y;
    }
   
    private boolean ValidarParametros(double numero){
        return numero >=0;
    }
}
