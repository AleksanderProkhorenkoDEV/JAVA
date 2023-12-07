/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Academia;

/**
 *
 * @author Usuario
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String array [] = new String [5];
       
        Asignatura a1= new Asignatura ("Lengua", 12);
        Asignatura a2 = new Asignatura ("Biologia",12);
        Asignatura a3 = new Asignatura ("Matematicas",20);
        Estudiante e1 = new Estudiante ("Pepe", "Villuela", "Fernandez");
        Estudiante e2 = new Estudiante ("Fernando", "Jimenez","Villuela");
        a2.setHoras(15 );
        if (!a1.equals(a2)) {
            System.out.println("Son distintas");
        }
 
        if (e1.añadeAsignatura(a3)) {
            System.out.println("Puede añadirse");
            
        }
        if (e1.añadeAsignatura(a1)) {
            System.out.println("Puede añadirse");
        }
        System.out.println(e1);
        if (!e1.equals(e2)) {
            System.out.println("Son distintos");
        }
        e1.getNumeroHorasMatriculadas();
        System.out.println(e1+"\n nºAsignaturas: "+e1.getNumeroAsignaturasMatriculadas()+"\n nºHoras: "+e1.getNumeroHorasMatriculadas());
    }
    
}
