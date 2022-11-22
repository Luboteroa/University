import java.util.Random;
import java.util.Scanner;

public class Partida {
    private Jugador jugador1, jugador2;
    public Partida(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }
    public void jugar() {
        Jugador actual, siguiente, inicial, otroJugador;
        inicial = seleccionarJugadorAleatoriamente();
        actual = inicial;
        otroJugador = (inicial == jugador1) ? jugador2 : jugador1;
        String pos = "";

        //Solicitar al usuario que ingrese por teclado una posición en el tablero
        while(!valida(pos)){
            pos = ingresoPosition(actual);
        }

        //Actualizar taablero
        actualizarTablero(pos);

        while(!tableroLleno() && ganador()==null){
            //Se inicia la posición nueva como vacío
            pos = "";

            if(actual==jugador1) siguiente=jugador2;
            else siguiente = jugador1;

            while(!valida(pos)){
                pos = ingresoPosition(siguiente);
            }

            actualizarTablero(pos);
            actual = siguiente;
        }
        if(tableroLleno())
            mostrarMensajeTableroLleno();
        else if(ganador()!=null)
            mostrarMensajeGanador();
    }

    private void mostrarMensajeGanador() {
    }

    private void mostrarMensajeTableroLleno() {
        
    }

    private void actualizarTablero(String pos) {
    }

    private boolean tableroLleno() {
        return  false;
    }

    private boolean valida(String pos) {
        if(pos.length()!=2)
        {
            System.out.println("La cadena no tiene 2 caracteres.");
            return  false;
        }
        else if(pos.charAt(0)!='A' && pos.charAt(0)!='B' && pos.charAt(0)!= 'C')
        {
            System.out.println("La columna no es correcta.");
            return false;
        }
        else if(pos.charAt(0)!='1' && pos.charAt(0)!='2' && pos.charAt(0)!= '3')
        {
            System.out.println("La columna no es correcta.");
            return false;
        }
        else if(!pos.equals(" "))
        {
            System.out.println("La posición ya está ocupada.");
            return false;
        }
        return true;
    }

    private String ingresoPosition(Jugador actual) {
        System.out.print(actual.getNombre() + ", por favor ingrese una posición: ");
        return  (new Scanner(System.in)).nextLine();
    }

    private Jugador seleccionarJugadorAleatoriamente() {
        Random aleatorio = new Random();
        return((aleatorio.nextInt()%2==0) ? jugador1 : jugador2);
    }

    public Jugador ganador() {
        return null; //TODO.
    }

    public void mostrarTablero()
    {
        System.out.println("   A   B   C");
        System.out.println(" +---+---+---+");
        System.out.println(" 1 | " + tablero[0][0] + " | " + tablero[0][1] + " | " + tablero[0][2] + " | ");
        System.out.println(" +---+---+---+");
        System.out.println(" 1 | " + tablero[1][0] + " | " + tablero[1][1] + " | " + tablero[1][2] + " | ");
        System.out.println(" +---+---+---+");
        System.out.println(" 1 | " + tablero[2][0] + " | " + tablero[2][1] + " | " + tablero[2][2] + " | ");
        System.out.println(" +---+---+---+");
    }
}
