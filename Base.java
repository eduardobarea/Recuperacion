import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * Crear un fichero jar:
 * jar cf fichero.jar Fichero.class
 */

 /**
 * @author Andrea Castilla Cocera
 * @email acascoc098@g.educaand.es
 */
public class Base {
    public static void main(String[] args) {

        try {
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader teclado = new BufferedReader (is);
            String a = teclado.readLine();
            String b = teclado.readLine();

            System.out.println("Argumentos: " + a + " " + b);

        } catch (IOException ei) {
            System.out.println("ERROR: error con los flujos E/S");
        }

    }
}