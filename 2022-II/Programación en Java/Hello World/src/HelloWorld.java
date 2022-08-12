import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args){
        //This is a comment
        long CanNotStoreThisInint = 2147483648L;

        String name = "Luis ";
        final int numFinal = 9; //Final means that won't change in the future even the programmer wants to

        int num = 1;
        num++;

        System.out.println(name + num);

        /*ASCII CODING
        char myVar1 = 65, myVar2 = 60, myVar3 = 62;
        System.out.println(myVar1);
        System.out.println(myVar2);
        System.out.println(myVar3);
         */

        String txt = "Please locate where 'locate' occurs!";
        System.out.println(txt.indexOf("locate")); // Outputs 7

        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
}
