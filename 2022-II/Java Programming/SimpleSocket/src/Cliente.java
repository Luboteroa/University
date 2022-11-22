import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        final int PORT = 4444;
        final String HOST = "127.0.0.1";
        try (Socket cs = new Socket(HOST, PORT);
             BufferedReader desdeServidor = new BufferedReader(
                     new InputStreamReader(cs.getInputStream()));
             PrintWriter haciaElServidor =
                     new PrintWriter(cs.getOutputStream(), true) )
        {
            for (int i=0; i<500; ++i)
                haciaElServidor.println("Mensaje " + (i+1));
        }
        catch (Exception e)
        {
            System.out.println("No se pudo establecer la conexión.");
            System.out.println(e.getMessage());
        }
    }
}
