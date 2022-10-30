package Ejercicios12_13_14.Comentarios;

public class EncontrarNumerosPares {

    /**
     * Método que recorre el array de números, comprobando uno por uno si se trata de un número par.
     * Si es un número par, lo muestra en una nueva línea. En caso contrario no hace nada.
     * @param numeros Array de tipo int con los números con los que trabajaremos.
     *
     */
    public int[] EncontrarNumerosPares(int[] numeros){
        // TODO: Se debe intentar reducir la función usando programación funcional.
        for (int numero: numeros){
            if(numero %2 ==0){
                System.out.println(numero);
            }
        }
        return numeros;
    }

}
