package Ejercicios22_23_24;

// Crea una clase coche aplicándole el principio de responsabilidad única (S).
public class Coche {

    String modelo;
    String marca;
    String matricula;
    int añoFabricación;

    // Adaptación del código con principio de Liskov
    boolean estaEncendido = false;

    public void encender(){}

    public int kmEstimados(){
        return 0;
    }

    public void apagar(){}


}
