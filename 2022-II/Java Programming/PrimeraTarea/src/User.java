import java.time.LocalDate;

public class User extends Person{

    public User(String name, int id, String adress, String phone, LocalDate birth) {
        super(name, id, adress, phone, birth);
    }
}
