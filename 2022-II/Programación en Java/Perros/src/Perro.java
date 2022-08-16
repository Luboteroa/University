import java.time.LocalDate;
import java.util.LinkedList;

public class Perro {
    private final String name;
    private final LinkedList<String> meeted;
    private final LocalDate birth;

    public Perro(String name, String owner, LocalDate localDate)
    {
        this.name = name;
        this.birth = localDate;
        meeted = new LinkedList<String>();
        meeted.add(owner);
    }

    public void sayHello(String person)
    {
        if(knowsTo(person))
        {
            System.out.println(name + " mueve la cola a: " + person + ".");
        }else
        {
            System.out.println(name + " le ladra a: " + person + ".");
        }
    }

    public boolean knowsTo(String person)
    {
        return meeted.contains(person);
    }

    public void introduceSomebody(String person)
    {
        if(knowsTo(person))
        {
            System.out.println(name + " ya conocia a: " + person + ".");
            return;
        }
        System.out.println(name + " Ahora conoce a: " + person + ".");
        meeted.add(person);
    }

    public void yearsOldDog()
    {
        var yearsOld = LocalDate.now().getYear() - birth.getYear();
        var monthsOld = LocalDate.now().getMonth().getValue() - birth.getMonth().getValue();

        System.out.println("La edad de " + name + " es " + yearsOld + " Anos " + monthsOld + " meses.");
    }
}
