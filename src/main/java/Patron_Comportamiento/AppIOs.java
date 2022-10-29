package Patron_Comportamiento;

public class AppIOs implements Receptor{
    @Override
    public void notificacion(int actPendientes) {

        System.out.println("Apreciado usuario de SmartHouse APP, hay " + actPendientes +
                " actualizaciónes pendientes,\npinche en el siguiente link (https://www.smarthouse/actualizarIOs)" +
                " para actualizar\no diríjase a Apple Store para actualizar\n\n");

    }
}