import java.net.ServerSocket;
import java.net.Socket;

public class Listener extends Thread {
    @Override
    public void run() {
        final int PORT = 4444;
        try (ServerSocket ss = new ServerSocket(PORT)) {
            while (true) {
                try  {
                    Socket cs = ss.accept();
                    Connection myConnection = new Connection(cs, PORT);
                    myConnection.start();
                } catch (Exception e) {
                    System.out.println("No se pudo iniciar la conexión " +
                            "el puerto " + PORT);
                    System.out.println(e.getMessage());
                }
            }
        }catch (Exception e) {
            System.out.println("No se pudo iniciar el servidor " +
                    "el puerto " + PORT);
            System.out.println(e.getMessage());
        }
    }
}
