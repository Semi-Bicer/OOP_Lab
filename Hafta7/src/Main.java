import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TurtleGraph tg = new TurtleGraph();
        int choice = -1;

        mainLoop: do{
            System.out.println("1. Pen up");
            System.out.println("2. Pen down");
            System.out.println("3. Turn right");
            System.out.println("4. Turn left");
            System.out.println("5.x Move Forward x");
            System.out.println("6. Display the 20-by-20 array");
            System.out.println("9. Exit");

            choice = sc.nextInt();
            switch (choice){
                case 1: tg.penUp(); break;
                case 2: tg.penDown(); break;
                case 3: tg.turnRight(); break;
                case 4: tg.turnLeft(); break;
                case 5:
                    System.out.println("how many step do you want to across? ");
                    tg.moveForward(sc.nextInt());
                    break;
                case 6: tg.display(); break;
                case 9: break mainLoop;
                default: break;
            }

        }while(choice != 9);
    }
}