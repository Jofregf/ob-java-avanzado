package Ejercicios22_23_24;

public class CocheCombustion extends CocheMejorado{

    String tipoCombustible;
    int consumo;
    int litrosEnTanque;

    private CocheCombustion(){}

    public CocheCombustion(String tipoCombustible, int consumo, int litrosEnTanque) {
        this.tipoCombustible = tipoCombustible;
        this.consumo = consumo;
        this.litrosEnTanque = litrosEnTanque;
    }

    @Override
    public void encender() {
        if(!estaEncendido){
            System.out.println("Arrancando coche a combustion");
            estaEncendido = true;
        } else {
        System.out.println("El coche a combustion ya estaba encendido!!!");
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
        return (litrosEnTanque/consumo) * 100;
    }
}
