import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio3 {

    public static void copiar(String origen, String destino,
                              boolean reemplazar) throws IOException {

        File archivoOrigen = new File(origen);
        File archivoDestino = new File(destino);

        if (!archivoOrigen.isFile()) {
            throw new IOException("El origen no es un archivo");
        }

        // Si el destino es una carpeta, conservamos el nombre original.
        if (archivoDestino.isDirectory()) {
            archivoDestino = new File(archivoDestino,
                                      archivoOrigen.getName());
        }

        // Si el destino ya existe y no se permite reemplazarlo.
        if (archivoDestino.exists() && !reemplazar) {
            throw new IOException("El archivo destino ya existe");
        }

        FileInputStream entrada = new FileInputStream(archivoOrigen);
        FileOutputStream salida = new FileOutputStream(archivoDestino);

        byte[] buffer = new byte[1024];
        int cantidad;

        while ((cantidad = entrada.read(buffer)) != -1) {
            salida.write(buffer, 0, cantidad);
        }

        entrada.close();
        salida.close();
    }

    public static void main(String[] args) {
        try {
            copiar("C:/DAM/origen.txt", "C:/DAM/copia.txt", true);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}