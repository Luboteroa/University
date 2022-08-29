import java.time.LocalDate;

public class Consultation {
    private final Consultation consultation = this;
    private final LocalDate date;
    private final Dog dog;
    public final Veterinarian veterinarian;
    public final String reason;
    public String finalDiagnostic;

    public Consultation(Dog dog, Veterinarian veterinarian, String reason)
    {
        //Se reciben los datos de consulta

        this.date = LocalDate.now();
        this.dog = dog;
        this.veterinarian = veterinarian;
        this.reason = reason;
        dog.Consultation(consultation);
        Diagnostic(reason);
        System.out.println("\nFecha de la consulta:"+date);
        System.out.println("\n-------------------------------------------------------------------------------------\n");
    }

    public void Diagnostic(String reason)
    {
        Veterinarian monitoringVeterinarian;

        /* Se realiza una salida mostrando el monitoreo hecho debido la razón de consulta, si hay un veterinario especializado
        este será recomendado para seguir el proceso, de no ser así, dirá que no se tienen las condiciones necesarias para
        hacer el seguimiento. */

        System.out.println("\nLa razon de su consulta fue: " + reason + " con el veterinario: " + veterinarian.toString() + "." +
                "\nEste se encargo de que " + dog.name + " se sintiera mucho mejor.");

        switch (reason)
        {
            case "Presion Baja":
                monitoringVeterinarian = Monitoring(1);
                CheckVeterinarian(veterinarian, monitoringVeterinarian,
                        "\nEl perro mostro mejoria, aunque sigue sintiendose con desaliento.",
                        "\nEl perro muestra una gran mejoria, se recomienda buena alimentacion.");
                break;
            case "Presion Alta":
                monitoringVeterinarian = Monitoring(2);
                CheckVeterinarian(veterinarian, monitoringVeterinarian,
                        "\nEl perro sigue teniendo presion alta.",
                        "\nLa presion del perro bajo, se recomienda reposo.");
                break;
            case "Pata rota":
                monitoringVeterinarian = Monitoring(3);
                CheckVeterinarian(veterinarian, monitoringVeterinarian,
                        "\nEl perro no se encuentra caminando bien.",
                        "\nSe le aplican distintas inyecciones al perro y se le pone un yeso.");
                break;
            case "Anorexia":
                monitoringVeterinarian = Monitoring(4);
                CheckVeterinarian(veterinarian, monitoringVeterinarian,
                        "\nEl perro sigue sin querer comer.",
                        "\nSe le hace un tratamiento de apetito al perro, se encuentra mejor.");
                break;
            case "Taquipnea":
                monitoringVeterinarian = Monitoring(5);
                CheckVeterinarian(veterinarian, monitoringVeterinarian,
                        "\nEl perro sigue con respiraciones anormales.",
                        "\nPor medio de inyecciones y medicamentos, el perro vuelve a tener una respiracion normal.");
                break;
            case "Gastroenteritis":
                monitoringVeterinarian = Monitoring(6);
                CheckVeterinarian(veterinarian, monitoringVeterinarian,
                        "\nEl perro sigue sin apetito debido a su enfermedad.",
                        "\nSe purga el perro, se ve mejor");
                break;
            case "Moquillo":
                monitoringVeterinarian = Monitoring(7);
                CheckVeterinarian(veterinarian, monitoringVeterinarian,
                        "\nEl perro sigue con gran cantidad de mucosa en su nariz, no puede respirar bien.",
                        "\nSe hacen incisiones nasales al perro, parece que respira mejor.");
                break;
            case "Hepatitis infecciosa":
                monitoringVeterinarian = Monitoring(8);
                CheckVeterinarian(veterinarian, monitoringVeterinarian,
                        "\nEl perro tiene el higado inflamado",
                        "\nSe aplican medicamentos al perro que lo hacen calmar");
                break;
            default:
                System.out.println("La enfermedad de su perro no se encuentra dentro de los conocimientos de esta clinica veterinaria");
                break;
        }
    }

    public Veterinarian Monitoring(int sickCase)
    {
        //A cada veterinario especializado se le dictamina por un número respecto a la razón de consulta

        Veterinarian monitoringVeterinarian;
        switch (sickCase)
        {
            case 1:
                return Veterinarian.Juan_Carlos;
            case 2:
                return  Veterinarian.Enrique;
            case 3:
                return  Veterinarian.Luis;
            case 4:
                return  Veterinarian.Carlos;
            case 5:
                return  Veterinarian.Felipe;
            case 6:
                return  Veterinarian.Augusto;
            case 7:
                return  Veterinarian.Daniel_Felipe;
            case 8:
                return Veterinarian.Eduardo;
            default:
                return null;
        }
    }

    private void CheckVeterinarian(Veterinarian var1, Veterinarian var2, String diagnosticBad, String diagnosticGood)
    {
        //Check if the Var1 is equal to var2
        boolean isEqual = (var1 == var2) ? true: false;
        if(isEqual)
        {
            finalDiagnostic = (diagnosticGood +"\n" + veterinarian.toString() +" es el mas especializado en el tema, no se recomienda seguimiento.");
            System.out.println(finalDiagnostic);
            return;
        }
        finalDiagnostic = (diagnosticBad + "\nSe le recomienda seguir un tratamiento con el veterinario especializado " + var2.toString());
        System.out.println(finalDiagnostic);
    }
}

enum Veterinarian
{
    Juan_Carlos,
    Enrique,
    Luis,
    Carlos,
    Felipe,
    Augusto,
    Daniel_Felipe,
    Eduardo,
}
