public class Motorcycle extends Vehicle implements Rentable {
    public boolean helmetRequired;

    public Motorcycle(String vehicleId, String model, double baseRentalRate, boolean availability, boolean helmetRequired) {
        super(vehicleId, model, baseRentalRate, availability);
        this.helmetRequired = helmetRequired;
        //Implementing the abstract methods from Vehicle Class
    }

    @Override
    public double calculateRentalCost(int days) {
        double cost = getBaseRentalRate() * days;
        if (helmetRequired) {
            cost += 5 * days;// The additional cost incurred for opting for the helmet
        }
        return cost;
    }


    public boolean availabilityForRental() {
        return isAvailable();

    }

    public void rent(Customer customer, int days) {
        if (isAvailable()) {
            setAvailability(false);
            System.out.println("Motorcycle rented to " + customer.getName() + "for" + days + " days");
        } else {
            System.out.println("Motorcycle is not available.");
        }
    }


    @Override
    public void returnVehicle() {
            setAvailability(true);
            System.out.println("Motorcycle has been returned");
    }

    public String getModel() {
            return super.getModel();
    }





}