package Modelos;

import static java.lang.Math.tan;

public class PoligonoRegular implements Figura {
    private double lado;
    private int numLados;
    private double apotema;
    private double EPSILON = 1e-20;

    public PoligonoRegular(double lado, int numLados)
        throws  IllegalArgumentException{
        if(numLados<3)
            throw new IllegalArgumentException("El numero de lados es invalido." + " N: " + numLados);
        if(lado<this.EPSILON)
            throw new IllegalArgumentException("El tamano del lado no es valido." + " lado: " + lado + "; EPSILON: " + EPSILON);
        this.lado = lado;
        this.numLados = numLados;
        apotema = (lado/2/tan(3.141592/numLados));
    }

    public double getEPSILON()
    {
        return EPSILON;
    }

    public void setEPSILON(double EPSILON) throws IllegalArgumentException
    {
        if(EPSILON<0)
            throw new IllegalArgumentException("EPSILON Invalido " + "Epsilon=" + EPSILON);
        this.EPSILON = EPSILON;
    }

    @Override
    public double perimetro() {
        return numLados*lado;
    }

    @Override
    public double area() {
        return numLados*lado*apotema/2.0;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public int getNumLados() {
        return numLados;
    }

    public void setNumLados(int numLados) {
        this.numLados = numLados;
    }

    public double getApotema() {
        return apotema;
    }

    public void setApotema(double apotema) {
        this.apotema = apotema;
    }
}
