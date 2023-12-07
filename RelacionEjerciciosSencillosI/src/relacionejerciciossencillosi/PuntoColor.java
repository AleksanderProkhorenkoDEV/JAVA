/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relacionejerciciossencillosi;

import java.util.Objects;


public class PuntoColor extends Punto{
   private String color; 
   public PuntoColor(){
       color = "blanco";
   }
   public PuntoColor(double x, double y, String c){
       super(x,y);
       this.color = c;
   }
   public PuntoColor(double v, String c){
       this(v,v,c);
   }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    public boolean equals(PuntoColor c){
        boolean sonIguales=false;
        if (super.equals(this) && this.color.equalsIgnoreCase(c.color)) {
            sonIguales=true;
        }
        return sonIguales;
    }
    
    @Override
    public String toString() {
        return "PuntoColor:  color=" + color +" Coordenadas:" + super.toString();
    }
   
}
