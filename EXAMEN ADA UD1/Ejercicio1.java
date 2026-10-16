import java.io.File;

public class Ejercicio1 {

    public static void main(String[] args) {
        listar("C:\\Users\\Manuel Iglesias\\Videos");
    }

    public static void listar(String ruta) {
        
        File directorio = new File(ruta);

        File[] contenido = directorio.listFiles();

        if(contenido==null) {
            System.out.println("No se puede leer el directorio.");
            return;
        }

        for(File archivo : contenido) {
            System.out.println(archivo.getName());
        }
    }
}