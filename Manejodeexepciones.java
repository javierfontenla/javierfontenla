package Clase7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Manejodeexepciones {

    public static void main(String args []){

      //  Scanner input = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
      //  try {
      //      int num = input.nextInt();
      //  } catch (InputMismatchException ex){
      //      System.out.println("El numero ingresado no es valido");
       // } catch (Exception ex){
         //   System.out.println("Ha ocurrido un error. Contacte a su administrador");
        //}



        int [] arregloEntero = new  int[3];
        arregloEntero[0] = 2;
        arregloEntero[1] = 7;
        arregloEntero[2] = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese la posicion a mostrar en el arreglo: ");
        int pos = input.nextInt();

        try {
            System.out.println("la posicion vale " + pos +" vale " + arregloEntero[pos]);
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Se ha accedido a una posicion invalida");
        } catch (Exception ex){
            System.out.println("Ha ocurrido un error. Contacte a su administrador");
        }





    }



}
