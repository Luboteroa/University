public class Methods {

    private double base;
    private double altura;

    public Methods(double base, double altura)
    {
        this.base = base; 
        this.altura = altura;
    }
    public double Area()
    {
        return base*altura/2.0;
    }
}
