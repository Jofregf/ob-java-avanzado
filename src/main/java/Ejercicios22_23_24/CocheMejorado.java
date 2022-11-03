package Ejercicios22_23_24;

// principio abierto/cerrado
public class CocheMejorado extends Coche{

    // principio de Liskov
    public void encender(){}
    public void apagar(){}
    public int kmEstimados(){
        return 0;
    }
}
