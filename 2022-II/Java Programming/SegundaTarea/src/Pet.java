import java.time.LocalDate;
import java.util.LinkedList;

public class Pet {
    public final String name;
    private LocalDate birth;
    private float weight;
    private Genre genre;
    private Person owner;
    private LinkedList<Consultation> consultations = new LinkedList<Consultation>();

    public Pet(String name, LocalDate birth, Genre genre, float weight, Person owner) {

        this.name = name;
        this.birth = birth;
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

    public void SeePetConsultations()
    {
        System.out.println(this.name + " ha tenido las siguientes consultas:");
        for (Consultation consultation : consultations)
        {
            System.out.println("\n- Consulta con el veterinario: " + consultation.veterinarian.name +
                    "\nRazones: " + consultation.reason +
                    "\nDiagnostico: " + consultation.finalDiagnostic);
        }
        System.out.println("\n-------------------------------------------------------------------------------------\n");
    }

    public static enum Genre {
        male,
        female
    }
}
