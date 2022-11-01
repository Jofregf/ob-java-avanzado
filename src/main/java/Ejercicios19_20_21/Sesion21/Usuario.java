package Ejercicios19_20_21.Sesion21;

public class Usuario {
    public String nombreUsuario;
    public String nombre;
    public String apellidos;
    public String email = "";
    public int nivelAcceso;


    @Override
    public String toString() {
        return "--Usuario: " + nombreUsuario + '\n' +
                "nombre: " + nombre + '\n' +
                "apellidos: " + apellidos + '\n' +
                "email: " + email + '\n' +
                "nivelAcceso: " + nivelAcceso;
    }
}
