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

        /* String txt = "Please locate where locate occurs!";
        System.out.println(txt.indexOf("locate")); // Outputs 7 */

        /* String firstName = "Luis";
        String lastName = "Botero";
        System.out.println("We can do: " + firstName + " " + lastName);
        System.out.println("Or: " + firstName.concat(lastName)); */

        //We use scape characters for some issues that we can have
        /* String txt = "We are so-called \"Vikings\" from the north.";
        String txt2 = " It\'s alright";
        String txt3 = " The character \\ is called backslash.";
        System.out.println(txt + txt2 + txt3); */

        //if else if else and switch
        /* int x = 20;
        int y = 10;
        if(x>y)
        {
            System.out.println("x is greater than y");
        } */

        //Short hand if else
        // variable = (condition) ? expressionTrue : expressionFalse;
        /* int x = 8;
        int y = 10;
        String result = (x>y) ? "x is greater than y" : "y is greater than x";
        System.out.println(result); */

        //Java for statements
        /* for (int i = 0; i < 10; i++) {
            if (i == 4) {
                continue;
            }
            System.out.println(i);
        } */

        //Java Arrays
        /* String[] cars = {"Volvo", "BMW", "Renault", "Mazda"}; */

        //Multidimensional Arrays
        /*int[][] myNumbers = { {1,2,3,4}, {5,6,7} };
        int x = myNumbers[1][2]; //Access the third element (2) in the second array (1)
        System.out.println(x);*/

        //For inside other for loops
        /*for (int i = 0; i < myNumbers.length; ++i) {
            for(int j = 0; j < myNumbers[i].length; ++j) {
                System.out.println(myNumbers[i][j]);
            }
        }*/

        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
}
