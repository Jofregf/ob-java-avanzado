package Ejercicios19_20_21.Sesion21;

public class Main {
    public static void main(String[] args) {

        Usuarios usuarios = new Usuarios();

        //Para asegurarnos de que trabajamos con un fichero vacío
        usuarios.borrarTodosLosUsuarios(); //COMENTAR PARA COMPROBAR QUE SUCEDE CON UN FICHERO YA INICIALIZADO

        //1º usuario
        Usuario usuario = new Usuario();
        usuario.nombreUsuario = "openbootcamp";
        usuario.nombre = "Open";
        usuario.apellidos = "Bootcamp";
        usuario.email = "ejemplos@open-bootcamp.com";
        usuario.nivelAcceso = 10;

        //2º usuario
        Usuario usuario2 = new Usuario();
        usuario2.nombreUsuario = "openbootcamp2";
        usuario2.nombre = "Open";
        usuario2.apellidos = "Bootcamp";
        usuario2.email = "ejemplos@open-bootcamp.com";
        usuario2.nivelAcceso = 20;

        //Los añadimos al fichero
        try {
            System.out.println("Añadiendo usuario " + usuario.nombreUsuario);
            usuarios.crearUsuario(usuario);
        }catch (Exception e){
            System.out.println("Error al crear usuario: " + e.getMessage());
        }

        try {
            System.out.println("Añadiendo usuario " + usuario2.nombreUsuario);
            usuarios.crearUsuario(usuario2);
        }catch (Exception e){
            System.out.println("Error al crear usuario: " + e.getMessage());
        }

        try {
            Usuario usuarioObtenido = usuarios.obtenerUsuario("openbootcamp2");
            System.out.println(usuarioObtenido.toString());
        }catch (Exception e){
            System.out.println("Error obteniendo usuario: " + e.getMessage());
        }

        System.out.println("\nUsuarios contenidos actualmente en " + usuarios.ficheroDatos + ":");
        for (Usuario a : usuarios.listarUsuarios()) {
            System.out.println(a.nombreUsuario);
        }

        System.out.println("\nBorrando usuario: openbootcamp2");
        usuarios.borrarUsuario("openbootcamp2");

        System.out.println("\nUsuarios contenidos actualmente en " + usuarios.ficheroDatos + ":");
        for (Usuario a : usuarios.listarUsuarios()) {
            System.out.println(a.nombreUsuario);
        }
    }
}
