package Ejercicios25_26_27.Entities;

import Ejercicios25_26_27.EntitiesInterfaces.CocheMejorado;
import Ejercicios25_26_27.EntitiesInterfaces.CochesCompletos;

public class CocheElectrico implements CocheMejorado, CochesCompletos {

    int consumo;
    int carga;

    public Coche coche = new Coche().setTipo("electrico");

    public CocheElectrico(){}

    @Override
    public void encender() {
        if(!coche.getEstaEncendido()){
            System.out.println("Arrancando coche electrico");
            coche.setEstaEncendido(true);
        } else {
            System.out.println("El coche electrico ya estaba encendido!!!");
        }
    }

    @Override
    public void apagar() {
        if(coche.getEstaEncendido()){
            System.out.println("Apagando el coche a electrico");
            coche.setEstaEncendido(false);
        } else {
            System.out.println("El coche electrico ya estaba apagado!!!");
        }
    }

    @Override
    public int kmEstimados() {
        return (carga/consumo) * 100;
    }

    @Override
    public Coche getCoche() {
        return coche;
    }

    public CocheElectrico setConsumo(int consumo) {
        this.consumo = consumo;
        return this;
    }

    public CocheElectrico setCarga(int carga) {
        this.carga = carga;
        return this;
    }

    public CocheElectrico setEstaEncendido(boolean estaEncendido) {
        this.coche.setEstaEncendido(estaEncendido);
        return this;
    }

    public int getConsumo(){
        return consumo;
    }

    public int getCarga(){
        return carga;
    }
}
