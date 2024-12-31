public class Car extends Vehicle implements Rentable{
    private final boolean hasAirConditioner;


    //Creating the Constructor for a car
    public Car(String vehicleId, String model, double baseRentalRate,boolean availability, boolean hasAirConditioner) {
        super(vehicleId, model, baseRentalRate,availability);
        this.hasAirConditioner = hasAirConditioner;
    }



    @Override
     public double calculateRentalCost(int days) {
        double cost = getBaseRentalRate()*days;
            if (hasAirConditioner) {
                cost += 10 * days;// Additional GPS fees that may be incurred.
            }
            return cost;
    }

    @Override
    public boolean availabilityForRental() {
            return isAvailable();
        }

    @Override
    public void rent(Customer customer, int days) {
        if(!isAvailable()) {
            throw new IllegalArgumentException("This Car is currently not available for rental. ");
        }
        setAvailability(false);
        System.out.println("Car rented to"+ customer.getName()+" for " + days + " days");
    }

    @Override
    public void returnVehicle() {
        setAvailability(true);
    }

    @Override
    public String toString() {
        return super.toString() + ", Air Conditioner :" + (hasAirConditioner? "Yes": "No");
    }
}
