package Ejercicios25_26_27.Entities;

public class Coche {

    private String modelo;
    private String marca;
    private String matricula;
    private int añoFabricación;
    private boolean estaEncendido = false;
    private String tipo;

    public String getModelo() {
        return modelo;
    }

    public Coche setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public String getMarca() {
        return marca;
    }

    public Coche setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public String getMatricula() {
        return matricula;
    }

    public Coche setMatricula(String matricula) {
        this.matricula = matricula;
        return this;
    }

    public int getAñoFabricación() {
        return añoFabricación;
    }

    public Coche setAñoFabricación(int añoFabricación) {
        this.añoFabricación = añoFabricación;
        return this;
    }

    public boolean getEstaEncendido() {
        return estaEncendido;
    }

    public Coche setEstaEncendido(boolean estaEncendido) {
        this.estaEncendido = estaEncendido;
        return this;
    }

    public String getTipo(){
        return tipo;
    }

    public Coche setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }
}
