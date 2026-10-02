package com.ada;
import java.io.*;

public class FlujoCaracteres {
    public static void main(String[] args) {
    
    // 1. Escribe un programa en el que escribas "Hola, Mundo" en un fichero. 
    // 2. Modifica el programa anterior para escribir en el fichero ya creado. 
    try {

    FileWriter fw= new FileWriter("fichero.txt", true);
    fw.write("Hola,mundo");
    fw.write("\n");
    fw.close();

    } catch (IOException e) {
        System.out.println("Error en la escritura del fichero.");
    }

    // 3. Lee un fichero.
    try {
        FileReader fr = new FileReader("fichero.txt");
        int caracter;
        while ((caracter = fr.read()) != -1) {
                System.out.print((char) caracter);
            }
        fr.close();
    } catch(IOException e) {
        System.out.println("Error al leer el fichero.");
}
    // 4. Lee un fichero que cuente con varias líneas.
    try {
        BufferedReader br = new BufferedReader(new FileReader("fichero.txt"));
        String linea;
        while((linea=br.readLine()) != null) {
            System.out.println(linea);
        }
        br.close();
    } catch (IOException e) {
        System.out.println("Error en la lectura de fichero.");
    }

    // 5. Realiza un programa que cuente el número de palabras de un fichero.
    

}
}
