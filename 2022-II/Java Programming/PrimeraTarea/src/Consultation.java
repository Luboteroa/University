import java.time.LocalDate;

public class Consultation {
    private final Consultation consultation = this;
    private final LocalDate date;
    private final Pet pet;
    public final Employee veterinarian;
    public final String reason;
    public String finalDiagnostic;

    public Consultation(Pet pet, Employee veterinarian, String reason)
    {
        //Se reciben los datos de consulta

        this.date = LocalDate.now();
        this.pet = pet;
        this.veterinarian = veterinarian;
        this.reason = reason;
        pet.Consultation(consultation);
        Diagnostic(reason);
        System.out.println("\nFecha de la consulta: "+date);
        System.out.println("\n-------------------------------------------------------------------------------------\n");
    }

    public void Diagnostic(String reason)
    {
        String monitoringVeterinarian;

        /* Se realiza una salida mostrando el monitoreo hecho debido la razón de consulta, si hay un veterinario especializado
        este será recomendado para seguir el proceso, de no ser así, dirá que no se tienen las condiciones necesarias para
        hacer el seguimiento. */

        System.out.println("\nLa razon de su consulta fue: " + reason + " con el veterinario: " + veterinarian.name + "." +
                "\nEste se encargo de que " + pet.name + " se sintiera mucho mejor.");

        switch (reason)
        {
            case "Presion Baja":
                monitoringVeterinarian = Monitoring(1);
                CheckVeterinarian(veterinarian.name, monitoringVeterinarian,
                        "\nLa mascota mostro mejoria, aunque sigue sintiendose con desaliento.",
                        "\nLa mascota muestra una gran mejoria, se recomienda buena alimentacion.");
                break;
            case "Presion Alta":
                monitoringVeterinarian = Monitoring(2);
                CheckVeterinarian(veterinarian.name, monitoringVeterinarian,
                        "\nLa mascota sigue teniendo presion alta.",
                        "\nLa presion de la mascota bajo, se recomienda reposo.");
                break;
            case "Pata rota":
                monitoringVeterinarian = Monitoring(3);
                CheckVeterinarian(veterinarian.name, monitoringVeterinarian,
                        "\nLa mascota no se encuentra caminando bien.",
                        "\nSe le aplican distintas inyecciones a la mascota y se le pone un yeso.");
                break;
            case "Anorexia":
                monitoringVeterinarian = Monitoring(4);
                CheckVeterinarian(veterinarian.name, monitoringVeterinarian,
                        "\nLa mascota sigue sin querer comer.",
                        "\nSe le hace un tratamiento de apetito a la mascota, se encuentra mejor.");
                break;
            case "Taquipnea":
                monitoringVeterinarian = Monitoring(5);
                CheckVeterinarian(veterinarian.name, monitoringVeterinarian,
                        "\nLa mascota sigue con respiraciones anormales.",
                        "\nPor medio de inyecciones y medicamentos, La mascota vuelve a tener una respiracion normal.");
                break;
            case "Gastroenteritis":
                monitoringVeterinarian = Monitoring(6);
                CheckVeterinarian(veterinarian.name, monitoringVeterinarian,
                        "\nLa mascota sigue sin apetito debido a su enfermedad.",
                        "\nSe purga La mascota, se ve mejor");
                break;
            case "Moquillo":
                monitoringVeterinarian = Monitoring(7);
                CheckVeterinarian(veterinarian.name, monitoringVeterinarian,
                        "\nLa mascota sigue con gran cantidad de mucosa en su nariz, no puede respirar bien.",
                        "\nSe hacen incisiones nasales a la mascota, parece que respira mejor.");
                break;
            case "Hepatitis infecciosa":
                monitoringVeterinarian = Monitoring(8);
                CheckVeterinarian(veterinarian.name, monitoringVeterinarian,
                        "\nLa mascota tiene el higado inflamado",
                        "\nSe aplican medicamentos a la mascota que lo hacen calmar");
                break;
            default:
                System.out.println("La enfermedad de su mascota no se encuentra dentro de los conocimientos de esta clinica veterinaria");
                break;
        }
    }

    public String Monitoring(int sickCase)
    {
        //A cada veterinario especializado se le dictamina por un número respecto a la razón de consulta

        Employee monitoringVeterinarian;
        switch (sickCase)
        {
            case 1:
                return "Juan Carlos";
            case 2:
                return  "Enrique";
            case 3:
                return  "Luis";
            case 4:
                return  "Carlos";
            case 5:
                return  "Felipe";
            case 6:
                return  "Augusto";
            case 7:
                return  "Daniel Felipe";
            case 8:
                return "Eduardo";
            default:
                return null;
        }
    }

    private void CheckVeterinarian(String var1, String var2, String diagnosticBad, String diagnosticGood)
    {
        //Check if the Var1 is equal to var2
        boolean isEqual = (var1 == var2) ? true: false;
        if(isEqual)
        {
            finalDiagnostic = (diagnosticGood +"\n" + veterinarian.name +" es el mas especializado en el tema, no se recomienda seguimiento.");
            System.out.println(finalDiagnostic);
            return;
        }
        finalDiagnostic = (diagnosticBad + "\nSe le recomienda seguir un tratamiento con el veterinario especializado " + var2);
        System.out.println(finalDiagnostic);
    }
}
