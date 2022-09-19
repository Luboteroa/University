import java.time.LocalDate;

public class Cat extends Pet{
    public CatRace race;

    public Cat(String name, LocalDate birth, CatRace race, Pet.Genre genre, float weight, Person owner)
    {
        super(name, birth, genre, weight, owner);
    }
    public enum CatRace
    {
        Abisino,
        Asiatico,
        Azul_Ruso,
        Balinés,
        Bengalí,
        Birmano,
        Bombay,
        Burmés,
        Burmilla,
        Chinchilla
    }
}
