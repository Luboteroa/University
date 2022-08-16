import javax.swing.plaf.synth.SynthTextAreaUI;
import java.time.LocalDate;
import java.util.LinkedList;

public class MainClass {
    public static void main(String[] args)
    {
        LinkedList<Perro> perros = new LinkedList<Perro>();
        perros.add(new Perro("Nana", "Luis Carlos", LocalDate.now()));
        perros.add(new Perro("Krypto", "Superman", LocalDate.now()));
        perros.add(new Perro("Lucas", "Eduard",  LocalDate.now()));
        for (Perro elPerro : perros)
        {
            elPerro.sayHello("Eduard");
            elPerro.yearsOldDog();
        }
    }
}
