import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio4 {

    public static void copiarDirectorio(String origen, String destino)
            throws IOException {

        File directorioOrigen = new File(origen);
        File directorioDestino = new File(destino);

        if (!directorioOrigen.isDirectory()) {
            throw new IOException("El origen no es un directorio");
        }

        if (!directorioDestino.exists()) {
            directorioDestino.mkdirs();
        }

        File[] elementos = directorioOrigen.listFiles();

        for (int i = 0; i < elementos.length; i++) {

            File elemento = elementos[i];
            File nuevoDestino = new File(directorioDestino,
                                         elemento.getName());

            if (elemento.isDirectory()) {

                // Volvemos a llamar al método para copiar la carpeta.
                copiarDirectorio(elemento.getPath(),
                                 nuevoDestino.getPath());

            } else {

                FileInputStream entrada = new FileInputStream(elemento);
                FileOutputStream salida = new FileOutputStream(nuevoDestino);

                byte[] buffer = new byte[1024];
                int cantidad;

                while ((cantidad = entrada.read(buffer)) != -1) {
                    salida.write(buffer, 0, cantidad);
                }

                entrada.close();
                salida.close();
            }
        }
    }

    public static void main(String[] args) {
        try {
            copiarDirectorio("C:/DAM/origen", "C:/DAM/destino");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}