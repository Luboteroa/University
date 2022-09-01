package Modelos;

public class Equilatero extends PoligonoRegular{
    public Triangulo triangulo;
    public Equilatero(double lado) throws IllegalArgumentException {
        super(lado, 3);
        triangulo = new Triangulo(lado, lado, lado);
    }
}
