import java.time.LocalDate;
import java.util.LinkedList;

public class Dog extends Pet {
    public static enum DogRace {
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

    private DogRace race;

    public Dog(String name, LocalDate birth, DogRace race, Genre genre, float weight, Person owner)
    {
        super(name, birth, genre, weight, owner);
    }
}



