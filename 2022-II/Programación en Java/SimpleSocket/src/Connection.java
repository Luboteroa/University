import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection extends Thread {
    private final int PORT;
    private final Socket cs;

    public Connection(Socket cs, int PORT) {
        this.PORT = PORT;
        this.cs = cs;
    }

    @Override
    public void run() {
        if (cs != null) {
            try (BufferedReader desdeCliente = new BufferedReader(
                    new InputStreamReader(cs.getInputStream()));
                    /*PrintWriter haciaElCliente = new PrintWriter
                            (cs.getOutputStream(), true)*/ )
            {
                System.out.println("Servidor iniciado en el puerto " + PORT);
                String mensaje;
                while ((mensaje = desdeCliente.readLine()) != null) {
                    System.out.println("El cliente dice: " + mensaje);
                }
            } catch (Exception e) {
                System.out.println("Hubo una excepción creando los flujos.");
                System.out.println(e.getMessage());
            }
        }
    }
}
