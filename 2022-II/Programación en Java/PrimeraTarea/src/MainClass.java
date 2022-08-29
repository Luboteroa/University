import java.time.LocalDate;
import java.util.LinkedList;

/*
Tarea #1 Programación en Java
Made by: Luis Carlos Botero Agudelo
2022
all changes will appear in my repository
Github: https://github.com/Luboteroa
 */

public class MainClass {
    public  static  void main(String[] args)
    {
        LinkedList<Person> people = new LinkedList<Person>();
        LinkedList<Dog> dogs = new LinkedList<Dog>();
        LinkedList<Consultation> consultations = new LinkedList<Consultation>();

        //Make a first test of a person, dog and consultation
        people.add(new Person("Luis Carlos", 1002636974, "Calle 10D #35 A-27", "3116892134", LocalDate.of(2001,3,19)));
        dogs.add(new Dog("Nana", LocalDate.of(2001,8,27), Race.golden_retriever, Genre.female, 13, people.get(0)));
        consultations.add(new Consultation(dogs.get(0), Veterinarian.Augusto, "Presion Baja"));

        //Change owner of a dog already created
        people.add(new Person("Alejandro", 42077763, "Via carmenza 8A #73", "3122863367", LocalDate.of(1989, 7, 28)));
        dogs.get(0).ChangeOwner(people.get(1));

        //Make others examples:
        //*A dog with different veterinarians and a different reason:
        consultations.add(new Consultation(dogs.get(0), Veterinarian.Luis, "Pata rota"));

        //*Let's create new people and new Dogs
        people.add(new Person("Juan Felipe", 100263464, "Alfombre roja 123", "428465928", LocalDate.of(1977,12,30)));
        dogs.add(new Dog("Firulais", LocalDate.of(2010,2,1), Race.bulldog, Genre.male, 21, people.get(2)));
        consultations.add(new Consultation(dogs.get(1), Veterinarian.Eduardo, "Gastroenteritis"));

        //Now let's see how many consultations 'Nana' has and what was said in every single one
        dogs.get(0).SeeDogConsultations();
    }
}
