//This code name's Valentina. Such as beauty as her.

import java.time.LocalDate;
import java.util.LinkedList;

/*
Tarea #2 Programación en Java
Made by: Luis Carlos Botero Agudelo
2022
all changes will appear in my repository
Github: https://github.com/Luboteroa
 */

public class MainClass {
    public  static  void main(String[] args)
    {
        LinkedList<Employee> employees = new LinkedList<>();
        LinkedList<User> users = new LinkedList<>();

        LinkedList<Cat> cats = new LinkedList<>();
        LinkedList<Dog> dogs = new LinkedList<>();

        LinkedList<Consultation> consultations = new LinkedList<Consultation>();

        //Make a first test of a person, dog and consultation
        employees.add(new Employee("Luis Carlos", 1002636974, "Calle 10D #35 A-27", "3116892134", LocalDate.of(2001,3,19)));
        dogs.add(new Dog("Nana", LocalDate.of(2001,8,27), Dog.DogRace.golden_retriever, Pet.Genre.female, 13, employees.get(0)));
        consultations.add(new Consultation(dogs.get(0), employees.get(0), "Presion Baja"));

        //Change owner of a dog already created
        users.add(new User("Alejandro", 42077763, "Via carmenza 8A #73", "3122863367", LocalDate.of(1989, 7, 28)));
        dogs.get(0).ChangeOwner(users.get(0));

        //Make others examples:
        //*A dog with different veterinarians and a different reason:
        consultations.add(new Consultation(dogs.get(0), employees.get(0), "Pata rota"));

        //*Let's create new people and new Dogs
        employees.add(new Employee("Juan Felipe", 100263464, "Alfombre roja 123", "428465928", LocalDate.of(1977,12,30)));
        dogs.add(new Dog("Firulais", LocalDate.of(2010,2,1), Dog.DogRace.bulldog, Pet.Genre.male, 21, employees.get(1)));
        consultations.add(new Consultation(dogs.get(1), employees.get(1), "Gastroenteritis"));

        //Now let's see how many consultations 'Nana' has and what was said in every single one
        dogs.get(0).SeePetConsultations();

        //Now let's create a new user and a new cat and make a consultation for this new cat
        users.add(new User("Camila", 1002636984, "Barrio Manzana Cuadrada rota", "3142867734", LocalDate.of(1997, 4, 29)));
        cats.add(new Cat("Thor", LocalDate.of(2022,2,24), Cat.CatRace.Asiatico, Pet.Genre.male, 9, users.get(1)));
        consultations.add(new Consultation(cats.get(0), employees.get(1), "Esta triste"));

        //Lets add another consultation and see the consultation story of this new Cat
        consultations.add((new Consultation(cats.get(0), employees.get(0), "Anorexia")));
        cats.get(0).SeePetConsultations();
    }
}
