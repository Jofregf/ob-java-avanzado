package Refactoring;

import java.time.LocalDate;

public class Main {

    public static void main (String[] args){
        Persona persona = new Persona("Ari")
                .apellido("Jofre")
                .edad(1)
                .telefono(2612551212L)
                .direccion("San Martin 1515");
        System.out.println(persona.nombre + " " + persona.apellido + " " + persona.edad
                + " " + persona.telefono + " " + persona.direccion);
    }
}
