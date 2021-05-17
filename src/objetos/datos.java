
package objetos;

import java.io.*;
import java.util.Scanner;

public class datos {
 public void escribirArchivo(String lineas) {
        FileWriter fichero = null;
        try {
            fichero = new FileWriter("archivo/datos", true);
            fichero.write(lineas + "\n");
            fichero.close();

        } catch (Exception ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        }
    }

    public void leeFichero() {
        // Fichero del que queremos leer
        File fichero = new File("archivo/datos");
        Scanner s = null;

        try {
            s = new Scanner(fichero);

            // Leemos linea a linea el fichero
            while (s.hasNextLine()) {
                String linea = s.nextLine(); 	// Guardamos la linea en un String
                System.out.println(linea);      // Imprimimos la linea
            }

        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            // Cerramos el fichero tanto si la lectura ha sido correcta o no
            try {
                if (s != null) {
                    s.close();
                }
            } catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
    }   
}
