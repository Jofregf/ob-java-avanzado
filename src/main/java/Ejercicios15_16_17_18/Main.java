package Ejercicios15_16_17_18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7};
        File fichero = null;
        FileReader fr = null;

        // Arithmetic Exception al tratar de divir un numero entre 0
        try {
            System.out.println(dividir(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Excepcion aritmetica " + e.getMessage());
        }

        // ArrayIndexOutOfBoundsException al intentar acceder a la 7° posicion en array con 6 elementos.
        try {
            System.out.println(numeros[7]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error en la posicion que inteta acceder " + e.getMessage());
        }

        // FileNotFound tratando de acceder a un fichero que no existe.
        try{
            fichero = new File("archivo.txt");
            fr = new FileReader(fichero);
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } finally {
            try{
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e){
                System.out.println("No puede cerrarse el archivo, debido a" + e.getMessage());
            }
        }
    }

    public static int dividir(int numerador, int denominador){
        return numerador / denominador;
    }
}
