import java.time.LocalDate;
import java.util.LinkedList;

public class Dog {
    public static enum Race {
        galgo,
        terrier,
        bulldog,
        alaskan,
        pastor,
        boston,
        french_puddle,
        golden_retriever,
        dachshund,
        berger
    }

    public static enum Genre {
        male,
        female
    }
    public final String name;
    private final LocalDate birth;
    private final Race race;
    private final Genre genre;
    private final float weight;
    private Person owner;
    private LinkedList<Consultation> consultations = new LinkedList<Consultation>();

    public Dog(String name, LocalDate birth, Race race, Genre genre, float weight, Person owner)
    {
        this.name = name;
        this.birth = birth;
        this.race = race;
        this.genre = genre;
        this.weight = weight;
        this.owner = owner;
    }

    public void ChangeOwner(Person owner)
    {
        var oldOwner = this.owner;
        this.owner = owner;

        System.out.println(this.name + " cambio de dueno de " + oldOwner.name + " por: " + owner.name);
        System.out.println("\n-------------------------------------------------------------------------------------\n");
    }

    public void Consultation(Consultation consultation)
    {
        this.consultations.add(consultation);
    }

    public void SeeDogConsultations()
    {
        System.out.println(this.name + " ha tenido las siguientes consultas:");
        for (Consultation consultation : consultations)
        {
            System.out.println("\n- Consulta con el veterinario: " + consultation.veterinarian +
                    "\nRazones: " + consultation.reason +
                    "\nDiagnostico: " + consultation.finalDiagnostic);
        }
        System.out.println("\n-------------------------------------------------------------------------------------\n");
    }
}



