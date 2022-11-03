package Ejercicios22_23_24;

public class CocheElectrico extends CocheMejorado{

    int consumo;
    int carga;

    private CocheElectrico(){}

    public CocheElectrico(int consumo, int carga) {
        this.consumo = consumo;
        this.carga = carga;
    }

    @Override
    public void encender() {
        if(!estaEncendido){
            System.out.println("Arrancando coche electrico");
            estaEncendido = true;
        } else {
        System.out.println("El coche electrico ya estaba encendido!!!");
        }
    }

    @Override
    public void apagar() {
        if(estaEncendido){
            System.out.println("Apagando el coche a electrico");
            estaEncendido = false;
        } else {
        System.out.println("El coche electrico ya estaba apagado!!!");
        }
    }

    @Override
    public int kmEstimados() {
        return (carga/consumo) * 100;
    }
}
