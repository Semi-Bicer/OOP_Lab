public class Main {
    public static void main(String[] args){
        Vehicle a1 = new Vehicle(20243, "Mehmet Yılmaz");
        Vehicle a2 = new Vehicle(20114, "İpek Şanlı");
        Vehicle a3 = new Vehicle(20243, "Ahmet Boz");

        Vehicle[] vehicles = {a1, a2, a3};

        ParkingLot o1 = new ParkingLot(vehicles, 7);
        o1.dislodgeVehicle(a1);

        Vehicle a4 = new Vehicle(20765, "İsmail Yılmaz");
        o1.addVehicle(a4);
        o1.dislodgeVehicle(a2);
        System.out.println(o1);
        System.out.println("Total balance: " );
    }
}
