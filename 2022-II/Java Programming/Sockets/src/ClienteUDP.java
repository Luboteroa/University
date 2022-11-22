import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteUDP {
    final static int PUERTO_SERVIDOR = 5000;
    static byte[] buffer = new byte[1024];
    public static void main(String[] args) throws SocketException {

        try
        {
            InetAddress direccionServidor = InetAddress.getByName("localhost");
            DatagramSocket socketUDP = new DatagramSocket();

            Registro();

            String mensajeCliente = "Hola mundo desde el cliente!";

            buffer = mensajeCliente.getBytes();

            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

            socketUDP.receive(peticion);
            System.out.println("Recibo peticion");

            String mensaje = new String(peticion.getData());
            System.out.println(mensaje);

            socketUDP.close();

        }catch (SocketException ex)
        {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void Registro() throws IOException {
        InetAddress direccionServidor = InetAddress.getByName("localhost");
        DatagramSocket socketUDP = new DatagramSocket();

        System.out.println("--------MENU PRINCIPAL--------");
        System.out.println("Ingrese nombre de registro: \n");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nombreRegistro = reader.readLine();

        //Mandamos el nombre al servidor
        buffer = nombreRegistro.getBytes();

        DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);

        System.out.println("Envio el datagrama");
        socketUDP.send(pregunta);
    }
}
