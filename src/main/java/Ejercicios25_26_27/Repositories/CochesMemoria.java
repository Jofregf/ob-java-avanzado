package Ejercicios25_26_27.Repositories;

import Ejercicios25_26_27.EntitiesInterfaces.CochesCompletos;

import java.util.ArrayList;

public class CochesMemoria implements CochesDB{

    ArrayList<CochesCompletos> coches = new ArrayList<>();

    @Override
    public ArrayList<CochesCompletos> obtener() {
        return coches;
    }

    @Override
    public CochesCompletos buscar(CochesCompletos coche) {
        for(CochesCompletos cocheActual : coches) {
            if (cocheActual.getCoche().getMatricula().equalsIgnoreCase(coche.getCoche().getMatricula())){
                return cocheActual;
            }
        }
        return null;
    }

    @Override
    public void insertar(CochesCompletos coche) {
        for(CochesCompletos cocheActual : coches) {
            if(cocheActual.getCoche().getMatricula().equalsIgnoreCase(coche.getCoche().getMatricula())){
                return;
            }
        }
        coches.add(coche);
    }

    @Override
    public void borrar(CochesCompletos coche) {
        for(int i = 0; i < coches.size(); i++){
            if(coches.get(i).getCoche().getMatricula().equalsIgnoreCase(coche.getCoche().getMatricula())){
                coches.remove(i);
            }
        }
    }

    @Override
    public void actualizarCoches(CochesCompletos coche) {
        System.out.println("Coche en memoria actualizado");
    }
}
