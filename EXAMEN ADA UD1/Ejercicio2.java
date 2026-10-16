import java.io.File;

public class Ejercicio2 {

    public static void listarPorExtension(String ruta, String extension) {
        File directorio = new File(ruta);

        if(!directorio.isDirectory()) {
            System.out.println("Error en la ruta.");
            return;
        }

        File[] contenido = directorio.listFiles();

        for(File archivo : contenido) {
            if(archivo.isFile() && archivo.getName().endsWith("." + extension)) {
                System.out.println(archivo.getName());
            }
        }
    }
}
