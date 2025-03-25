import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException{
        // Ders İçeriği Örnekleri

        // Infinite Loops
//        for ( ; ; ) // intentionally infinite loops
//        {
//            // ...
//        }
//        while(true)
//        {
//            //statements
//        }

        // Loop with no body
        // The body of a loop can be empty.
//        int i;
//        int sum = 0;
//
//        //sum the numbers through 5
//        for (i = 1; i <= 5; sum+=i++) ;
//
//        System.out.println("Sum is " + sum); // -> Sum is 15

        //Branching Statements
//        for (int i=0; i < 100; i++){
//            if (i == 50)
//                break;
//            System.out.println("Rule #" + i);
//        } // Rule #49


        //Break Infinite Loop
        // Read input until a q is received.
//        char ch;
//        for ( ; ; ){
//            ch = (char) System.in.read(); // get a char
//            if (ch == 'q')
//                break;
//        }
//        System.out.println("You pressed q!");

        // Branching Statements
//        for (int i=0; i < 100; i++){
//            if (i == 50)
//                continue;
//            System.out.println("Rule #" + i);
//        } // -> Rule#1-49 and Rule#51-99

        /*
        * The return statement exits from the  current method, and control flow returns to where the method was invoked.
        *
        * return count;
        *
        * The data type of the returned value must match the type of the method's declared return value.
        *
        * return; //when a method declared void
        * */

        /*
 Break with Nested Loops
        for (int i = 0; i< 3; i++){
            for (int j = 2; j<5; j++){
                if (j == 4)
                    break; //only breaks the inner
                System.out.println(i + "," + j);
            }
        }
        //Labeled Break
        /*Block that will be broken is labeled and use this label as the target of a break statement* /
        outer: for (int i=0; i<3;i++){
            for (int j = 2; j<5; j++){
                if (j==4)
                    break outer;
                System.out.println(i + "," + j);
            }
        }
*/

        int firstArg = 0;
        if (args.length > 0){
            firstArg = Integer.parseInt(args[0]);
        }
        System.out.println(firstArg);

        String [] [] names = {
                {"Mr. ", "Mrs. ", "Ms. "},
                {"Smith", "Jones"}
        };

        System.out.println(names [0][0] + names [1][0]); // Mr. Smith
        System.out.println(names [0][2] + names [1][1]); // Ms. Jones
    }
}
