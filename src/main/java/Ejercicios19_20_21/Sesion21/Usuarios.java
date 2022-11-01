package Ejercicios19_20_21.Sesion21;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuarios {

    public String ficheroDatos = "usuarios.txt";


    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList();

        try {
            Scanner scanner = new Scanner(new File(ficheroDatos));

            while (scanner.hasNext()) {
                String usuarioActual = scanner.next();
                String []partes = usuarioActual.split(",");

                Usuario usuario = new Usuario();
                usuario.nombreUsuario = partes[0];
                usuario.nombre = partes[1];
                usuario.apellidos = partes[2];
                usuario.email = partes[3];
                usuario.nivelAcceso = Integer.parseInt(partes[4]);

                usuarios.add(usuario);
            }

            scanner.close();
        } catch (Exception e) {
        }

        return usuarios;
    }

    public Usuario obtenerUsuario(String username) throws Exception {
        ArrayList<Usuario> usuarios = listarUsuarios();

        for (Usuario usuario : usuarios) {
            if (usuario.nombreUsuario.equalsIgnoreCase(username)) {
                System.out.println("\nObteniendo usuario: " + username);
                return usuario;
            }
        }
        throw new Exception("\"Error al tratar de obtener usuario: " + username );
    }

    //He modificado el método para que no sobreescriba el fichero, sino que añada el usuario
    public void crearUsuario(Usuario usuario) throws Exception {
        ArrayList<Usuario> usuarios = listarUsuarios();

        for (Usuario usuarioTemp : usuarios) {
            if (usuarioTemp.nombreUsuario.equalsIgnoreCase(usuario.nombreUsuario)) {
                throw new Exception("Usuario ya existente en el fichero.");
            }
        }

        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            File file = new File(ficheroDatos);
            if (!file.exists()){ //Si no existiera el fichero, se crea
                file.createNewFile();
            }

            fw = new FileWriter(file.getAbsoluteFile(), true);//true indica añadir en lugar de sobreescribir
            bw = new BufferedWriter(fw);

            bw.write(UsuarioToString(usuario));

            System.out.println("usuario creado");
        } catch (Exception e) {
            System.out.println("Error al añadiendo el usuario al fichero: " + e.getStackTrace());
        } finally {
            if (bw != null)
                bw.close();
            if (fw != null)
                fw.close();
        }
    }

    public void borrarUsuario(String username) {
        ArrayList<Usuario> usuarios = listarUsuarios();

        try {
            PrintStream printStream = new PrintStream(ficheroDatos);

            for (Usuario usuarioActual : usuarios) {
                if (usuarioActual.nombreUsuario.equalsIgnoreCase(username)) {
                    continue;
                }
                printStream.println(UsuarioToString(usuarioActual));
            }
            printStream.close();
            System.out.println("Usuario: " + username + "---->borrado");

        } catch (Exception e) {
            System.out.println("Error intentando borrar usuario del fichero: " + e.getMessage());
        }
    }

    public void borrarTodosLosUsuarios(){
        try{
            System.out.println("Vaciando: " + ficheroDatos);
            PrintStream printStream = new PrintStream(ficheroDatos);
            printStream.close();
        } catch (Exception e) {
            System.out.println("Error limpiando el fichero : " + ficheroDatos);
        }
    }

    public String UsuarioToString(Usuario usuario){
        return new StringBuilder().append('\n')
                .append(usuario.nombreUsuario)
                .append(',').append(usuario.nombre)
                .append(',').append(usuario.apellidos)
                .append(',').append(usuario.email)
                .append(',').append(usuario.nivelAcceso).toString();
    }
}
