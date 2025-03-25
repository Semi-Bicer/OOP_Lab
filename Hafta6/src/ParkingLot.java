import static java.lang.reflect.Array.set;

public class ParkingLot {
    private final int capacity;
    public double balance;
    double fee;
    Vehicle[] Vehicles;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public Vehicle[] getVehicles() {
        return Vehicles;
    }

    public void setVehicles(Vehicle[] vehicles) {
        Vehicles = vehicles;
    }




    public ParkingLot(int capacity , double fee){
        this.capacity = capacity;
        setFee(fee);
        this.Vehicles = new Vehicle[capacity];
    }

    public ParkingLot(Vehicle[] vehicles , double fee){
        this.capacity = vehicles.length;
        this.fee = fee;
        this.Vehicles = vehicles;
        this.balance = 0;
    }

    public void dislodgeVehicle(Vehicle vehicle){
        for (int i = 0; i < Vehicles.length; i++){
            if (Vehicles[i] != null && Vehicles[i].getID() == vehicle.ID)
            {
                Vehicles[i] = null;
                balance += fee;

                break;
            }
        }
    }

    public void addVehicle(Vehicle vehicle){
        for (int i = 0; i < Vehicles.length; i++){
            if ( Vehicles[i] == null){
                Vehicles[i] = vehicle;
                balance += fee;
                break;
            }
        }
    }

    public double getFee(){
        return fee;
    }

    public String toString() {
        String text = "";
        for (Vehicle v:  Vehicles){
            if (v != null){
                text += v.toString()  + "\n";
            }
        }
        return text;
    }
}
