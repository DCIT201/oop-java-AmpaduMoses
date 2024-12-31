public class Truck extends Vehicle implements Rentable {

    public Truck(String vehicleId, String model, double baseRentalRate, boolean isAvailable) {
        super(vehicleId, model, baseRentalRate, isAvailable);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * getBaseRentalRate();
    }

    @Override
    public boolean availabilityForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailable()) {
            setAvailability(false);
            System.out.println("Truck rented to " + customer.getName() + " for " + days + " days.");
        } else {
            System.out.println("Truck is not available.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailability(true);
        System.out.println("Truck returned.");
    }

    @Override
    public String getModel() {
        return super.getModel();
    }
}