
/*
 * Ejecutar jar:
 * java -cp fichero.jar Fichero
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**Clase que ejecuta el fichero jar y el proceso
 * @author Andrea Castilla Cocera
 * @email acascoc098@g.educaand.es
 */
public class Evalua {
    //Todos los string que necesitamos para el ProcessBuilder
    static final String com = "java";
    static final String op = "-cp";
    static final String jar = "Base.jar";
    static final String clase = "Base"; 
    public static void main(String[] args) throws IOException {
        System.out.println("Introduce los argumentos (a, b) de la ecuación (ax + b = 0): ");
        String a = new Scanner(System.in).nextLine();
        String b = new Scanner(System.in).nextLine();

        //Creamos el proceso
        String[] comandos = {com,op,jar,clase};
        ProcessBuilder pb = new ProcessBuilder(comandos);
        Process p = pb.start();

        try {
            OutputStream os = p.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            PrintWriter pw = new PrintWriter(osw);
            pw.print(a);
            pw.print(b);
            pw.close();
            //System.out.println(a + b); Para llevar el control
            
            int x = (-Integer.parseInt(b))/Integer.parseInt(a);
            System.out.println("El resultado de la ecuación: " + x);

            if (p.waitFor() == 0) {
                System.out.println("Ejecución correcta del proceso.");
            } else {
                System.out.println("ERROR: en la ejecución del proceso.");
            }

            InputStreamReader is = new InputStreamReader(p.getInputStream());
            BufferedReader br = new BufferedReader(is);

            String resultado = br.readLine();
            System.out.println(resultado);
            br.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
