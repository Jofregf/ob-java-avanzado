package Patron_Comportamiento;

import java.util.ArrayList;

public class Notificador {
    private ArrayList<Receptor> usuarios = new ArrayList<>();

    public void meteUsuario(Receptor usuario){
        usuarios.add(usuario);
    }

    public void notifica(int actPendientes){ //notifica a todos los usuarios
        for (Receptor usuario : usuarios){
            usuario.notificacion(actPendientes);
        }
    }
}