package Ejercicios22_23_24;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        ArrayList<Coche> coches = new ArrayList<>();

        // Opcion 1: instanciamos obj de cada clase con la clase hija CocheMejorado
//        CocheMejorado combustion = new CocheCombustion("Nafta", 5, 30);
//        CocheMejorado electrico = new CocheElectrico(3, 21);
//        CocheMejorado hibrido = new CocheHibrido(5, 20, "Nafta", 50, 10);

        // Opcion 2: Instanciar obj de la clase padre (Coche)
//        Coche combustion = new CocheCombustion("Nafta", 5, 30);
//        Coche electrico = new CocheElectrico(3, 21);
//        Coche hibrido = new CocheHibrido(5, 20, "Nafta", 50, 10);

        // Opcion 3: Instanciar obj de las clases hijas (finales)
        CocheCombustion combustion = new CocheCombustion("Nafta", 5, 30);
        CocheElectrico electrico = new CocheElectrico(3, 21);
        CocheHibrido hibrido = new CocheHibrido(5, 20, "Nafta", 50, 10);

        // inicializo los valores de la clase Coche para ver que funcione:
        combustion.marca = "Volkswagen";
        combustion.modelo = "Nivus";
        combustion.añoFabricación = 2022;
        combustion.matricula = "AD235615";

        electrico.marca = "Tesla";
        electrico.modelo = "T";
        electrico.añoFabricación = 2021;
        electrico.matricula = "AC548732";

        hibrido.marca = "Toyota";
        hibrido.modelo = "CH-R";
        hibrido.añoFabricación = 2022;
        hibrido.matricula = "AD401574";

        // Agrego los coches al Array
        coches.add(combustion);
        coches.add(electrico);
        coches.add(hibrido);

        // Implemento para ver si cada coche está encendido o no
        for (Coche cocheActual: coches) {
            System.out.println("EL coche marca: " + cocheActual.marca +
                    "Está encendido?? " + cocheActual.estaEncendido );
        }

        // Pruebo si al encender uno afecta el estado de los demás, al tratar de volver a encenderlo.
        electrico.encender();
        // trato de arrancar todos los coches
        System.out.println("\n--Tratando de arrancar todos los coches.");
        for (Coche cocheActual : coches) {
            cocheActual.encender();
        }

        //Obtenemos cuantos km es capaz de recorrer cada coche según (nivel tanque y/o batería)
        // y (consumo de cada tipo)
        System.out.println("\n--¿Cuantos km le quedan a cada coche?");
        for (Coche cocheActual : coches) {
            System.out.println("El coche marca: " + cocheActual.marca +
                    " puede recorrer " + cocheActual.kmEstimados() + " Kms aproximados");
        }

        // Intento a encender todos los coches de nueva para ver el comportamiento del codigo
        System.out.println("\n--Intentando encender otra vez los coches");
        for (Coche cocheActual : coches) {
            cocheActual.encender();
        }

        // Apagamos todos los coches
        System.out.println("\n--¿Cómo estan los coches?");
        for (Coche cocheActual : coches) {
            cocheActual.apagar();
        }

        // Intento apagar todos los coches otra vez para ver como se comporta el codigo
        System.out.println("\n--Intentando apagar otra vez los coches");
        for (Coche cocheActual : coches){
            cocheActual.apagar();
        }





    }
}
