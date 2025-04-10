public class TurtleGraph {
    enum direction {
        left, right, up, down
    }
    enum penLocation {
        up, down
    }

    private direction d;
    private penLocation p;
    private int row;
    private int column;

    private int[][] room;

    public TurtleGraph(){
        d = direction.right;
        p = penLocation.up;

        row = 0;
        column = 0;
        room = new int[20][20];
    }

    public void turnRight(){
        if (d == direction.right)
            d = direction.down;
        else if (d == direction.down)
            d = direction.left;
        else if (d == direction.left)
            d = direction.up;
        else
            d = direction.right;
    }
    public void turnLeft(){
        if (d == direction.right)
            d = direction.up;
        else if (d == direction.up)
            d = direction.left;
        else if (d == direction.left)
            d = direction.down;
        else
            d = direction.right;
    }

    public void moveForward(int distance){
        if (d == direction.up){
            for (int i = 0; i < distance; i++) {
                if (row == 0)
                    row = 20;
                row--; // goes from up to down
            }
            if (p == penLocation.down)
                room[row][column] = 1;
        }
        else if (d == direction.right){
            for (int i = 0; i < distance; i++) {
                if (column == 19)
                    column = -1;
                column++; // goes from right to left
            }
            if (p == penLocation.down)
                room[row][column] = 1;
        }
        else if (d == direction.down){
            for (int i = 0; i < distance; i++) {
                if (row == 19)
                    row = -1;
                row++;
            }
            if (p == penLocation.down)
                room[row][column] = 1;
        }
        else {
            for (int i = 0; i < distance; i++) {
                if (column == 0)
                    column = 20;
                column--;
            }

            if(p == penLocation.down)
                room[row][column] = 1;
        }
    }

    public void display(){
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                if (room[i][j] == 1)
                    System.out.print(" * ");
                if (room[i][j] == 0)
                    System.out.print(" _ ");
            }
            System.out.println();
        }
    }



    public void penUp(){
        p = penLocation.up;
    }
    public void penDown(){
        p = penLocation.down;
    }


}
