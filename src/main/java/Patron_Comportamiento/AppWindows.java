package Patron_Comportamiento;

public class AppWindows implements Receptor{
    @Override
    public void notificacion(int actPendientes) {

        System.out.println("Apreciado usuario de SmartHouse APP, hay " + actPendientes +
                " actualizaciónes pendientes,\nclick en el link (https://www.smarthouse/actualizarWind)" +
                " para actualizar\no diríjase a MicrosoftStore para actualizar\n\n");
    }
}