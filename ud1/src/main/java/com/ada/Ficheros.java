package com.ada;
import java.io.File;
import java.io.IOException;

public class Ficheros {
public static void main (String[] args) {
crearEstructura();
}

public static void crearEstructura() {

        File escritorio = new File("C:\\Users\\Manuel Iglesias\\Desktop");

        File d = new File(escritorio,"d");
        d.mkdir();

        File d1 = new File(d,"d1");
        File d2 = new File(d,"d2");
        File d3 = new File(d,"d3");
        d1.mkdir();
        d2.mkdir();
        d3.mkdir();

        File d21 = new File(d2,"d21");
        File d22 = new File(d2,"d22");
        d21.mkdir();
        d22.mkdir();

        File d31 = new File(d3,"d31");
        d31.mkdir();

        try {

            File f11 = new File(d1,"f11");
            File f12 = new File(d1,"f12");
            File f21 = new File(d2,"f21");
            File f222 = new File(d22,"f222");

            f11.createNewFile();
            f12.createNewFile();
            f21.createNewFile();
            f222.createNewFile();

        } catch(IOException e) {
            System.out.println("Error en la creación de ficheros.");
        }
    }
}
            