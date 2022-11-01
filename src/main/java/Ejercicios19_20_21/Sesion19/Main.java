package Ejercicios19_20_21.Sesion19;

import java.util.ArrayList;

/*Ejercicio 1º: Implementa Args en uno de los proyectos que se han ido trabajando y aplica las buenas prácticas que
 se han visto en la sesión 19.
-No sé que proyecto utilizar, ya que no he participado en ninguno por ahora. En su lugar voy a usar el siguiente ejercicio:
-Este programa se encarga de capitalizar la primera letra de cada palabra y eliminar espacios vacíos en caso de haberlos
-Tomará como clave del argumento, cualquier palabra que empiece con '-'
-Línea de argumentos que le paso para realizar pruebas:
--Frase1 hola que tal ari?? --Frase2 soy belindo, no grisecito --Frase3 ok, lo que digas
 */

public class Main {
    public static void main(String[] args) {

        ArgumentosParser argumentosParser = new ArgumentosParser(args);
        ArrayList<String> idFrases = new ArrayList();

        argumentosParser.regIdFrase(args); //Registramos todos los identificadores de frase que nos pasen como argumento.

        //parseamos los argumentos
        argumentosParser.parse();

        //Obtenemos los identificadores de frases por separado y ejecutamos el método toJadenCase(frase)
        for(String idFrase : argumentosParser.getIdFrase()){
            System.out.println("\n*Frase orignal: " +idFrase.replace("-", "") + "\n-> " + argumentosParser.getFrase(idFrase));
            System.out.println("*Frase capitalizada: " +idFrase.replace("-", "") + "\n-> " + toJadenCase(argumentosParser.getFrase(idFrase)));
        }
    }


    //Método que capitaliza la primera letra de cada palabra y elimina espacios sobrantes
    public static String toJadenCase(String frase) {
        String resultado = "";

        if ((frase == null) || (frase.length() < 1)) { //Comprobamos si la frase está vacía
            return null;
        }else {
            String buffer;
            buffer = frase.toUpperCase();

            resultado += buffer.charAt(0); //1º caracter a mayúsculas

            for (int i = 1; i < frase.length(); i++) {
                if (frase.charAt(i) == ' ') {
                    resultado+=' ';
                    do {
                        i++;
                    }while (frase.charAt(i) == ' ');
                    resultado += buffer.charAt(i);
                } else {
                    resultado += frase.charAt(i);
                }
            }
        }
        return resultado;

    }
}
