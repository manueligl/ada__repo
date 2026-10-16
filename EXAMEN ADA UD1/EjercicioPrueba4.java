import java.io.*;

public class EjercicioPrueba4 {
    public static void copiar(String rutaOrigen, String rutaDestino) throws IOException {

        File origen = new File(rutaOrigen);
        File destino = new File(rutaDestino);

        if(!origen.isDirectory()) {
            throw new IOException("El origen no es un directorio.");
        }
       
        if(!destino.exists()) {
            destino.mkdirs();
        }

        File[] contenido = origen.listFiles();

        for(int i = 0; i < contenido.length; i++) {

            File elemento = contenido[i];
            File nuevoDestino = new File(destino, elemento.getName());

            if(elemento.isDirectory()) {
                copiar(elemento.getPath(), nuevoDestino.getPath());
            } else {
                FileInputStream entrada = new FileInputStream(elemento);
                FileOutputStream salida = new FileOutputStream(nuevoDestino);

                byte[] buffer = new byte[1024];
                int cantidad;

                while((cantidad = entrada.read(buffer)) != -1) {
                    salida.write(buffer, 0, cantidad);
                }
            }
        }
}
}
