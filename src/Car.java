public class Car extends Vehicle{
    public Car(String modelName, int maxSpeed, double fuelConsumptionIndex ) {
        super(modelName, maxSpeed, fuelConsumptionIndex , TypeOfVehicle.CAR);
    }

    public Car(String modelName, int maxSpeed, double fuelConsumptionIndex, TypeOfVehicle hybrid) {
        super(modelName, maxSpeed, fuelConsumptionIndex, hybrid);
    }
}
