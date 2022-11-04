package Ejercicios25_26_27.Repositories;

import Ejercicios25_26_27.Entities.CocheCombustion;
import Ejercicios25_26_27.Entities.CocheElectrico;
import Ejercicios25_26_27.Entities.CocheHibrido;
import Ejercicios25_26_27.EntitiesInterfaces.CochesCompletos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CochesFichero implements CochesDB{

    public String ficheroDatos = "src/main/java/Ejercicios25_26_27/RepositoryFiles/Coches.txt";

    @Override
    public CochesCompletos buscar(CochesCompletos coche) {
        ArrayList<CochesCompletos> coches = obtener();

        for(CochesCompletos cocheActual: coches) {
            if(cocheActual.getCoche().getModelo().equalsIgnoreCase(coche.getCoche().getModelo())){
                return cocheActual;
            }
        }
        return null;
    }

    @Override
    public void insertar(CochesCompletos coche) {

        if (buscar(coche) == null) {
            //Forma de escribir en fichero implementada por VRoman en las sesiones
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(ficheroDatos, true);
                PrintStream printStream = new PrintStream(fileOutputStream);
                printStream.println(separarCochePorComas(coche));
                printStream.flush();
                printStream.close();
            } catch (Exception e) {
                System.out.println("Error al insertar " + e.getMessage());
            }
        }
    }

    @Override
    public void borrar(CochesCompletos coche) {

        ArrayList<CochesCompletos> coches = obtener();

        for(int i = 0; i < coches.size(); i++) {
            if(coches.get(i).getCoche().getMarca().equalsIgnoreCase(coche.getCoche().getMarca())){
                coches.remove(i);
            }
        }
        try{
            PrintStream printStream = new PrintStream(ficheroDatos);

            for(CochesCompletos cocheActual : coches) {
                String cocheComas = separarCochePorComas(cocheActual);
                printStream.println(cocheComas);
            }
            printStream.flush();
            printStream.close();
        }catch(Exception e){
            System.out.println("Error al borrar coche en fichero: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<CochesCompletos> obtener() {

        ArrayList<CochesCompletos> coches = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(ficheroDatos));
            while(scanner.hasNext()){
                String cocheActual = scanner.next();
                String[] partes = cocheActual.split(",");
                CochesCompletos coche = null;
                switch(partes[0]){
                    case "combustion":
                        // Modelo coche Combustion: 0 modelo, 1 marca, 2 matricula, 3 añoFabricacion, 4 estaencendido,
                        // 5 tipo, 6 tipoCombustible, 7 consumo, 8 litrosEntanque
                        coche = new CocheCombustion()
                                .setTipoCombustible(partes[6])
                                .setConsumo(Integer.parseInt(partes[7]))
                                .setLitrosEnTanque(Integer.parseInt(partes[8]));
                    case "electrico":
                        // Modelo coche Electrico: 0 modelo, 1 marca, 2 matricula, 3 añoFabricacion, 4 estaencendido,
                        // 5 tipo, 6 consumo, 7 carga
                        coche = new CocheElectrico()
                                .setConsumo(Integer.parseInt(partes[6]))
                                .setCarga(Integer.parseInt(partes[7]));
                    case "hibrido":
                        // Modelo coche Hibrido: 0 modelo, 1 marca, 2 matricula, 3 añoFabricacion, 4 estaencendido,
                        // 5 tipo, 6 consumoElect, 7 carga, 8 tipoCombustible, 9 litros en tanque, 10 consumoCombust
                        coche = new CocheHibrido()
                                .setConsumoElect(Integer.parseInt(partes[6]))
                                .setCarga(Integer.parseInt(partes[7]))
                                .setTipoCombustible(partes[8])
                                .setLitrosEnTanque(Integer.parseInt(partes[9]))
                                .setConsumoCombustible(Integer.parseInt(partes[10]));
                    default:
                        System.out.println("Tipo de coche erroneo");
                }
                coche.getCoche().setTipo(partes[5])
                        .setModelo(partes[0])
                        .setMarca(partes[1])
                        .setMatricula(partes[2])
                        .setAñoFabricación(Integer.parseInt(partes[3]))
                        .setEstaEncendido(Boolean.parseBoolean(partes[4]));

                coches.add(coche);
            }
            scanner.close();
        }catch (Exception e){
            System.out.println("Error al obtener coches de fichero: " + e.getMessage());
        }
        return coches;
    }

    private String separarCochePorComas(CochesCompletos coche){
        String cocheComas = "";
        switch(coche.getCoche().getTipo()) {
            case "combustion":
                // Modelo coche Combustion: 0 modelo, 1 marca, 2 matricula, 3 añoFabricacion, 4 estaencendido,
                // 5 tipo, 6 tipoCombustible, 7 consumo, 8 litrosEntanque
                cocheComas = coche.getCoche().getModelo()
                        + "," + coche.getCoche().getMarca()
                        + "," + coche.getCoche().getMatricula()
                        + "," + coche.getCoche().getAñoFabricación()
                        + "," + coche.getCoche().getEstaEncendido()
                        + "," + coche.getCoche().getTipo()
                        + "," + ((CocheCombustion) coche).getTipoCombustible()
                        + "," + ((CocheCombustion) coche).getConsumo()
                        + "," + ((CocheCombustion) coche).getLitrosEnTanque();
            case "electrico":
                // Modelo coche Electrico: 0 modelo, 1 marca, 2 matricula, 3 añoFabricacion, 4 estaencendido,
                // 5 tipo, 6 consumo, 7 carga
                cocheComas = coche.getCoche().getModelo()
                        + "," + coche.getCoche().getMarca()
                        + "," + coche.getCoche().getMatricula()
                        + "," + coche.getCoche().getAñoFabricación()
                        + "," + coche.getCoche().getEstaEncendido()
                        + "," + coche.getCoche().getTipo()
                        + "," + ((CocheElectrico) coche).getConsumo()
                        + "," + ((CocheElectrico) coche).getCarga();
            case "hibrido":
                // Modelo coche Hibrido: 0 modelo, 1 marca, 2 matricula, 3 añoFabricacion, 4 estaencendido,
                // 5 tipo, 6 consumoElect, 7 carga, 8 tipoCombustible, 9 litros en tanque, 10 consumoCombust
                cocheComas = coche.getCoche().getModelo()
                        + "," + coche.getCoche().getMarca()
                        + "," + coche.getCoche().getMatricula()
                        + "," + coche.getCoche().getAñoFabricación()
                        + "," + coche.getCoche().getEstaEncendido()
                        + "," + coche.getCoche().getTipo()
                        + "," + ((CocheHibrido) coche).getConsumoElect()
                        + "," + ((CocheHibrido) coche).getCarga()
                        + "," + ((CocheHibrido) coche).getTipoCombustible()
                        + "," + ((CocheHibrido) coche).getLitrosEnTanque()
                        + "," + ((CocheHibrido) coche).getConsumoCombust();

        }
        return cocheComas;
    }

    @Override
    public void actualizarCoches(CochesCompletos coche) {
        borrar(coche);
        insertar(coche);
    }
}
