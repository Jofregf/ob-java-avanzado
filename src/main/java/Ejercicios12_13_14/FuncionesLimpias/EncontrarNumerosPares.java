package Ejercicios12_13_14.FuncionesLimpias;

import java.lang.reflect.Array;
import java.util.Arrays;

public class EncontrarNumerosPares {

    public int[] EncontrarNumerosPares(int[] numeros) {
       return Arrays.stream(numeros).filter(num -> num % 2 == 0).toArray();

    }
}
