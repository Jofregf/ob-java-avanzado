package Ejercicios12_13_14.FuncionesLimpias;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] numeros = {1, 15, 25, -170, 2, 10, 125, -2, -10, 32};
        EncontrarNumeroMayor iMayor = new EncontrarNumeroMayor();
        System.out.println(iMayor.EncontrarNumeroMayor(numeros));

        EncontrarNumerosPares aPares = new EncontrarNumerosPares();
        System.out.println(Arrays.toString(aPares.EncontrarNumerosPares(numeros)));
    }
}
