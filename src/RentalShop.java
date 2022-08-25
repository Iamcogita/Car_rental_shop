import java.util.*;

public class RentalShop{

    private List<Vehicle> inStore = Arrays.asList(
            new Car ("Audi", 180,7.3 ),
            new Motorcycle ( "Honda", 100, 2.4  ),
            new Hybrid("BMW", 190,5.2 )
    );

    public RentalShop(){}

    public Vehicle addVehicles(Vehicle vehicle){
        ArrayList<Vehicle> temp = new ArrayList<>();
        temp.addAll(inStore);
        temp.add(vehicle);
        inStore = temp;
        return vehicle;
    }

    @Override
    public String toString() {
        return "This shop has in stock { " + inStore + " }" ;
    }

    public Vehicle takeVehicle(TypeOfVehicle vehicle) {
        Optional<Vehicle> opt = inStore.stream().filter(v->v.getTypeOfVehicle().equals(vehicle)).findFirst();
        if(opt.isEmpty()){throw new RuntimeException("No vehicles of that type to rent.");}
        inStore.remove(opt.get());
        return opt.get();
    }
    public void returnRented(Vehicle vehicle) {
        if(vehicle.getCurrentFuel() < 20){
            double priceToPay = (20 - vehicle.getCurrentFuel()) * 1.5;
            System.out.println("You'll have to pay " + Math.round(priceToPay) + " euros as a penalty.");
        }
        ArrayList<Vehicle> temp = new ArrayList<>();
        temp.addAll(inStore);
        temp.add(vehicle);
        inStore = temp;
    }


}
