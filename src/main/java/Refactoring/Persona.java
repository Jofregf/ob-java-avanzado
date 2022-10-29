package Refactoring;
public class Persona {
    String nombre;
    String apellido;
    int edad;
    long telefono;
    String direccion;

    private void Persona() {}
    public Persona (String nombre){
        this.nombre = nombre;
    }
    public Persona apellido(String Apellido){
        this.apellido = Apellido;
        return this;
    }
    public Persona edad(int edad){
        this.edad = edad;
        return this;
    }
    public Persona telefono(long telefono){
        this.telefono = telefono;
        return this;
    }
    public Persona direccion(String direccion){
        this.direccion = direccion;
        return this;
    }
}
