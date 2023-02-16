package mx.anahuac;

import java.util.Scanner;

public class Promedio {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Ingresa el numero de alumnos: ");

        int numeroDeAlumnos=scan.nextInt();

        int[] calificaciones=new int[numeroDeAlumnos];

        for(int posicion=0;posicion<numeroDeAlumnos;posicion++){
            System.out.println("ingresa calificacion del alumno "+posicion);
            int calificacion=scan.nextInt();
            if (calificacion<0){
                System.out.println("No es un valor valido");
            }else{
                calificaciones[posicion]=calificacion;
            }
        }
        int posicion=0;
        int suma=0;
        while (posicion<numeroDeAlumnos){
            suma=suma+calificaciones[posicion];
            posicion=posicion+1;
        }

        float promedio=suma/numeroDeAlumnos;
        System.out.println(promedio);

    }
}
