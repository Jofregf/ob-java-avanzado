package Ejercicios12_13_14.FuncionesLimpias;

import java.util.Arrays;

public class EncontrarNumeroMayor {

    public int EncontrarNumeroMayor(int[] numeros) {
        return Arrays.stream(numeros).reduce(0, (a, b) -> (a > b) ? a : b);
    }


}
