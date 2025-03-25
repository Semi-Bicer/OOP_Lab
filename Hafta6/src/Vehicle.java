public class Vehicle {
    int ID;
    String name;

    public Vehicle(int ID, String name){
        this.ID = ID;
        this.name = name;
    }
    public int getID(){
        return ID;
    }
    public String getName(){
        return name;
    }

    public String toString(){
        return "Araç {" +
                "plaka: " + ID + "/" +
                " sahibi: " + name + "/" +
                "}";
    }
}
