
public class Main {
    public static void main(String[] args) {
        try {
            RentalShop myShop = new RentalShop();
            Client firstClient = new Client("David");
            firstClient.enterShop(myShop);
            System.out.println(myShop);
            myShop.addVehicles(new Car("Toyota" , 180 , 6.7 ));
            firstClient.rent(TypeOfVehicle.CAR); // renting Audi
            System.out.println(myShop);
            firstClient.takeATrip(650, 3);
            firstClient.returnVehicle(); // Audi back in stock
            System.out.println(myShop);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
