import java.io.File;
import java.io.IOException;

public class Ejercicio2prueba {
    public static void mostrar(String ruta, String extension) throws IOException{
        File directorio = new File(ruta);

        if(!directorio.isDirectory()) {
            throw new IOException("La ruta no es un directorio.")
        }

        File[] contenido = directorio.listFiles();

        for(File archivo : contenido) {
            if(archivo.isFile() && archivo.getName().endsWith("." + extension)) {
                System.out.println(archivo.getName());
            }
        
        }
    }
}
