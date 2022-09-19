import java.time.LocalDate;
public class Person {
    public final String name;
    private final int id;
    private final String adress;
    private final String phone;
    private final LocalDate birth;
    public Person(String name, int id, String adress, String phone, LocalDate birth)
    {
        this.name = name;
        this.id = id;
        this.adress = adress;
        this.phone = phone;
        this.birth = birth;
    }
}
