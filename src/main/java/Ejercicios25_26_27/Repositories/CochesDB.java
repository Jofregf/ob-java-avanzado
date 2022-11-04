package Ejercicios25_26_27.Repositories;

import Ejercicios25_26_27.EntitiesInterfaces.CochesCompletos;

import java.util.ArrayList;

public interface CochesDB {

    ArrayList<CochesCompletos> obtener();
    CochesCompletos buscar(CochesCompletos coche);
    void insertar(CochesCompletos coche);
    void borrar(CochesCompletos coche);
    void actualizarCoches(CochesCompletos coche);
}
