package Ejercicios22_23_24;

public class CocheHibrido extends CocheMejorado{

    int consumoElect;
    int carga;
    String tipoCombustible;
    int litrosEnTanque;
    int consumoCombust;

    private CocheHibrido(){}

    public CocheHibrido(int consumoElect, int carga, String tipoCombustible, int litrosEnTanque, int consumoCombust) {
        this.consumoElect = consumoElect;
        this.carga = carga;
        this.tipoCombustible = tipoCombustible;
        this.litrosEnTanque = litrosEnTanque;
        this.consumoCombust = consumoCombust;
    }

    @Override
    public void encender() {
        if(!estaEncendido){
            System.out.println("Arrancando coche a hibrido");
            estaEncendido = true;
        } else {
            System.out.println("El coche a hibrido ya estaba encendido!!!");
        }
    }

    @Override
    public void apagar() {
        if(estaEncendido){
            System.out.println("Apagando el coche a combustion");
            estaEncendido = false;
        } else {
            System.out.println("El coche a combustion ya estaba apagado!!!");
        }
    }

    @Override
    public int kmEstimados() {
        return ((carga/consumoElect) + (litrosEnTanque/consumoCombust)) * 100;
    }
}
