public class Client {
    private String name;
    private RentalShop shop;
    private Vehicle myVehicle;
    public Client(String name){this.name = name;}
    public void enterShop(RentalShop shop){this.shop = shop;}

    public void rent(TypeOfVehicle vehicle){
        if(myVehicle != null){ throw new RuntimeException("Already rented a vehicle."); }
        myVehicle = shop.takeVehicle(vehicle);
        System.out.println("Rented: " + myVehicle);
    }

    public void takeATrip(int kilometers, int days){
        myVehicle.drive(kilometers,days);
    }

    public void returnVehicle() {
        shop.returnRented(myVehicle);
    }
}
