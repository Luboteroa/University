
public class Servidor {
    public static void main(String[] args) {
        Listener myListener = new Listener();
        myListener.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Programa del servidor iniciado.");
        try {
            myListener.join();
            System.out.println("El hilo terminó correctamente.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("El programa ha terminado.");
    }
}
