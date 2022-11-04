package Ejercicios25_26_27.Entities;

import Ejercicios25_26_27.EntitiesInterfaces.CocheMejorado;
import Ejercicios25_26_27.EntitiesInterfaces.CochesCompletos;

public class CocheCombustion implements CocheMejorado, CochesCompletos {

    String tipoCombustible;
    int consumo;
    int litrosEnTanque;

    public Coche coche = new Coche().setTipo("combustion");
    public CocheCombustion(){}

    @Override
    public void encender() {
        if(!getCoche().getEstaEncendido()){
            System.out.println("Arrancando coche a combustion");
            coche.setEstaEncendido(true);
        } else {
            System.out.println("El coche a combustion ya estaba encendido!!!");
        }
    }

    @Override
    public void apagar() {
        if(getCoche().getEstaEncendido()){
            System.out.println("Apagando el coche a combustion");
            coche.setEstaEncendido(false);
        } else {
            System.out.println("El coche a combustion ya estaba apagado!!!");
        }
    }

    @Override
    public int kmEstimados() {
        return (litrosEnTanque/consumo) * 100;
    }

    @Override
    public Coche getCoche() {
        return coche;
    }

    public CocheCombustion setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
        return this;
    }

    public CocheCombustion setConsumo(int consumo) {
        this.consumo = consumo;
        return this;
    }

    public CocheCombustion setLitrosEnTanque(int litrosEnTanque) {
        this.litrosEnTanque = litrosEnTanque;
        return this;
    }

    public String getTipoCombustible(){
        return tipoCombustible;
    }

    public int getConsumo(){
        return consumo;
    }

    public int getLitrosEnTanque(){
        return litrosEnTanque;
    }

    @Override
    public String toString() {
        return "CocheCombustion{" +
                "tipoCombustible='" + tipoCombustible + '\'' +
                ", consumo=" + consumo +
                ", litrosEnTanque=" + litrosEnTanque +
                ", coche=" + coche +
                '}';
    }
}
