package Modelos;

public class Cuadrado extends PoligonoRegular{
    public Cuadrado(double lado)
    {
        super(lado, 4);
    }

    @Override
    public double area()
    {
        return getLado()*getLado();
    }
}
