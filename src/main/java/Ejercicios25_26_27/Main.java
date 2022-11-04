package Ejercicios25_26_27;


import Ejercicios25_26_27.Entities.CocheCombustion;
import Ejercicios25_26_27.Entities.CocheElectrico;
import Ejercicios25_26_27.Entities.CocheHibrido;
import Ejercicios25_26_27.EntitiesInterfaces.CochesCompletos;
import Ejercicios25_26_27.Repositories.CochesDB;
import Ejercicios25_26_27.Repositories.CochesFichero;
import Ejercicios25_26_27.Repositories.CochesMemoria;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//        CochesDB db = new CochesMemoria();
        CochesDB db = new CochesFichero();

        //Creamos los coches (método antiguo paso de valor sustituido por builder).
        // Se implementa builder para poder usar programación funcional

        CocheElectrico electrico = new CocheElectrico().setConsumo(15).setCarga(80);
        CocheHibrido hibrido = new CocheHibrido().setConsumoElect(5).setCarga(55).setConsumoCombustible(20)
                .setLitrosEnTanque(80).setTipoCombustible("Nafta");
        CocheCombustion combustion = new CocheCombustion().setTipoCombustible("Nafta").setConsumo(10)
                .setLitrosEnTanque(80);

        // inicializo los valores de la clase Coche para ver que funcione:
        electrico.coche.setMarca("Tesla").setModelo("T").setAñoFabricación(2021).setMatricula("AC548732");
        hibrido.coche.setMarca("Toyota").setModelo("CH-R").setAñoFabricación(2022).setMatricula("AD401574");
        combustion.coche.setMarca("Volkswagen").setModelo("Nivus").setAñoFabricación(2022).setMatricula("AD235615");

        // Agrego los coches a db
        db.insertar(combustion);
        db.insertar(electrico);
        db.insertar(hibrido);

        // Implemento para ver si cada coche está encendido o no
        for (CochesCompletos cocheActual: db.obtener()) {
            System.out.println("EL coche marca: " + cocheActual.getCoche().getMarca() +
                    "Está encendido?? " + cocheActual.getCoche().getEstaEncendido() );
        }

        // Pruebo si al encender uno afecta el estado de los demás, al tratar de volver a encenderlo.
        electrico.encender();
        db.actualizarCoches(electrico);

        // arrancar todos los coches
        System.out.println("\n--Tratando de arrancar todos los coches.");
        for (CochesCompletos cocheActual : db.obtener()) {
            cocheActual.encender();
            db.actualizarCoches(cocheActual);
        }

        //Obtenemos cuantos km es capaz de recorrer cada coche según (nivel tanque y/o batería)
        // y (consumo de cada tipo)
        System.out.println("\n--¿Cuantos km le quedan a cada coche?");
        for (CochesCompletos cocheActual : db.obtener()) {
            System.out.println("El coche marca: " + cocheActual.getCoche().getMarca() +
                    " puede recorrer " + cocheActual.kmEstimados() + " Kms aproximados");
        }

        // Intento a encender todos los coches de nueva para ver el comportamiento del codigo
        System.out.println("\n--Intentando encender otra vez los coches");
        for (CochesCompletos cocheActual : db.obtener()) {
            cocheActual.encender();
            db.actualizarCoches(cocheActual);
        }

        // Apagamos todos los coches
        System.out.println("\n--¿Cómo estan los coches?");
        for (CochesCompletos cocheActual : db.obtener()) {
            cocheActual.apagar();
            db.actualizarCoches(cocheActual);
        }

        // Intento apagar todos los coches otra vez para ver como se comporta el codigo
        System.out.println("\n--Intentando apagar otra vez los coches");
        for (CochesCompletos cocheActual : db.obtener()){
            cocheActual.apagar();
            db.actualizarCoches(cocheActual);
        }

    }
}
