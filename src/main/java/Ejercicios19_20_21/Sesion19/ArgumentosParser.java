package Ejercicios19_20_21.Sesion19;

import java.util.Set;
import java.util.TreeMap;

public class ArgumentosParser {
    private TreeMap<String, String> argumentos = new TreeMap(); //Uso un TreeMap en lugar de Hashmap, para asegurarme
    // de que no se desordenan los datos. (Usando el hashmap me desordenaba los resultados)
    private String []args;

    private ArgumentosParser(){}

    //Constructor con argumentos
    public ArgumentosParser(String []args){
        this.args = args;
    }

    //Función que registra todos los identificadores de las frases
    public void regIdFrase(String []args){
        for(String argumento : args) {
            if(argumento.startsWith("-")){argumentos.put(argumento, "");}

        }
    }

    //Función que devuelve Set<String> con las claves(identificadores de Frases)
    public Set<String> getIdFrase(){
        return argumentos.keySet();
    }

    //Función que obtiene la frase según el identificador
    public String getFrase(String identificadorFrase){
        return argumentos.get(identificadorFrase);
    }

    //Función que asigna cada frase con su identificador
    public void setIdentificadorValor(String identificadorFrase, String frase){
        argumentos.replace(identificadorFrase, frase);
    }

    //Parser
    public void parse(){
        for(int i=0; i<args.length; i++){

            String identificadorFrase = args[i];

            //Metemos la frase completa dentro de (frase "valor correspondiente a cada identificadorFrase")
            //Asegurándonos solo 1 espacio entre cada palabra.
            if(argumentos.containsKey(identificadorFrase)){
                String fraseActual = "";
                for(int j= i+1;  j<args.length && !args[j].startsWith("-"); j++){
                    fraseActual += args[j];
                    fraseActual += " ";
                }
                //Asignamos (identificador, frase) eliminando espacios sobrantes
                setIdentificadorValor(identificadorFrase, fraseActual.trim());
            }
        }
    }
}
