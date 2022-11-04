package Ejercicios25_26_27.Entities;

import Ejercicios25_26_27.EntitiesInterfaces.CocheMejorado;
import Ejercicios25_26_27.EntitiesInterfaces.CochesCompletos;

public class CocheHibrido implements CocheMejorado, CochesCompletos {

    int consumoElect;
    int carga;
    String tipoCombustible;
    int litrosEnTanque;
    int consumoCombust;

    public Coche coche = new Coche().setTipo("hibrido");

    public CocheHibrido(){}

    @Override
    public void encender() {
        if(!coche.getEstaEncendido()){
            System.out.println("Arrancando coche a hibrido");
            coche.setEstaEncendido(true);
        } else {
            System.out.println("El coche a hibrido ya estaba encendido!!!");
        }
    }

    @Override
    public void apagar() {
        if(coche.getEstaEncendido()){
            System.out.println("Apagando el coche a combustion");
            coche.setEstaEncendido(false);
        } else {
            System.out.println("El coche a combustion ya estaba apagado!!!");
        }
    }

    @Override
    public int kmEstimados() {
        return ((carga/consumoElect) + (litrosEnTanque/consumoCombust)) * 100;
    }

    @Override
    public Coche getCoche() {
        return coche;
    }

    public CocheHibrido setConsumoElect(int consumoElect) {
        this.consumoElect = consumoElect;
        return this;
    }

    public CocheHibrido setCarga(int carga) {
        this.carga = carga;
        return this;
    }

    public CocheHibrido setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
        return this;
    }

    public CocheHibrido setLitrosEnTanque(int litrosEnTanque) {
        this.litrosEnTanque = litrosEnTanque;
        return this;
    }

    public CocheHibrido setConsumoCombustible(int consumoCombustible) {
        this.consumoCombust = consumoCombustible;
        return this;
    }

    public int getConsumoElect() {
        return consumoElect;
    }

    public int getCarga() {
        return carga;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public int getLitrosEnTanque() {
        return litrosEnTanque;
    }

    public int getConsumoCombust() {
        return consumoCombust;
    }
}
