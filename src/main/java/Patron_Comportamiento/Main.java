package Patron_Comportamiento;

public class Main {
    public static void main(String[] args) {
        Notificador notificador = new Notificador();

        AppIOs ios = new AppIOs();
        AppWindows windows = new AppWindows();
        AppAndroid android = new AppAndroid();

        notificador.meteUsuario(ios);
        notificador.meteUsuario(windows);
        notificador.meteUsuario(android);

        System.out.println("1º actualización de la app");
        notificador.notifica(1);

        System.out.println("2º actualización de la app");
        notificador.notifica(2);
    }
}
