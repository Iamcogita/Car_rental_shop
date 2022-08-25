public abstract class Vehicle{
    private String modelName;
    private int maxSpeed;
    private double fuelConsumptionIndex;
    private final int initialFuel = 25;
    private double currentFuel;
    private TypeOfVehicle typeOfVehicle;

    public Vehicle(String modelName, int maxSpeed, double fuelConsumptionIndex , TypeOfVehicle typeOfVehicle){
        this.modelName = modelName;
        this.maxSpeed = maxSpeed;
        this.fuelConsumptionIndex = fuelConsumptionIndex;
        this.typeOfVehicle = typeOfVehicle;
    }
    private void fuelConsumption(int distance){
        this.currentFuel = this.initialFuel;
        if (tripWithoutRefuel(distance)) return;
        tripWithRefuel(distance);
    }
    private boolean tripWithoutRefuel(int distance) {
        double maxDistanceFullTank = this.initialFuel * 100 / this.fuelConsumptionIndex ;
        if( maxDistanceFullTank > distance){
            this.currentFuel -= distance * this.fuelConsumptionIndex / 100 ;
            System.out.println("Current fuel is approximately " + Math.round(this.currentFuel) + " liters of gas.");
            return true;
        }
        return false;
    }
    private void tripWithRefuel(int distance) {
        int refuelCounter = 0 ;
        String singleOrPlural = "times.\n";
        double consumptionPerKil = this.fuelConsumptionIndex / 100;
        for (int i = 0; i < distance; i++){
            this.currentFuel -= consumptionPerKil;
            if(this.currentFuel <= 0){
                refuelCounter++;
                fullRefuel();}
        }
        if(refuelCounter == 1){
            singleOrPlural = "time.\n";}
        System.out.printf("Had to refuel %s %s", refuelCounter, singleOrPlural);
        System.out.println("Approximately " + Math.round(this.currentFuel) + " liters of gas remain in the tank.");
    }

    public double getCurrentFuel() {return currentFuel;}

    public TypeOfVehicle getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void drive(int distance, int time){
        checkIfPossible(distance , time);
        fuelConsumption(distance);
    }
    private void checkIfPossible(int distance, int time){
        if ( distance <= 0 || time <= 0) {
            throw new RuntimeException("Those values aren't accepted by the rentalShop.");}
        double necessarySpeed = distance / ( time * 24 );
        if( this.maxSpeed < necessarySpeed ){
            throw new RuntimeException("Not possible to travel that distance in such a small amount of time.");
        }
    }

    public void fullRefuel() {
        this.currentFuel = this.initialFuel;
    }

    @Override
    public String toString() {
        return typeOfVehicle + ": " + modelName + " ";
    }
}