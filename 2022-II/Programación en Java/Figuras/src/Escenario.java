import Modelos.Cuadrado;
import Modelos.Equilatero;
import Modelos.PoligonoRegular;

public class Escenario {
    public static void main(String[] args)
    {
        // Primer ejemplo, con cuadrado
        System.out.println("Cuadrado: ");
        Cuadrado cuadrado = new Cuadrado(10);
        System.out.println(cuadrado.getApotema());
        System.out.println(cuadrado.perimetro());
        System.out.println(cuadrado.area());
        System.out.println("\n--------------------------------------------\n");

        //Segundo ejemplo con Triángulo equilátero
        System.out.println("Triangulo equilatero: ");
        PoligonoRegular trianguloEquilatero = new Equilatero(10);
        System.out.println(trianguloEquilatero.getApotema());
        System.out.println(trianguloEquilatero.perimetro());
        System.out.println(trianguloEquilatero.area());
        System.out.println("\n--------------------------------------------\n");
    }
}
