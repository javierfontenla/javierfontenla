package clase3;

import java.util.Scanner;

public class Ejercicio1 {
   // 1. Escribir un método que reciba un número y retorne su doble

    public static void main(String args []){

        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        int num = input.nextInt();



        System.out.println("El doble del numero ingresado es: " + duplicar(num));


    }
    public static int duplicar (int num){
        return num * 2;
    }













}
