import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class RentalAgency {
    private final List<Rentable> vehicles = new ArrayList<>();
    private final List<RentalTransaction> transactions = new ArrayList<>();

    // Adding a vehicle to the agency
    public void addVehicle(Rentable vehicle) {
        vehicles.add(vehicle);
    }

    // Renting a vehicle
    public void rentVehicle(Customer customer, Rentable vehicle, int days, boolean insurance)
            throws VehicleNotAvailableException, CustomerNotEligibleException {
        if (!vehicle.availabilityForRental()) {
            throw new VehicleNotAvailableException("This vehicle is not available for rental.");
        }
        if (!customer.isEligibleForRental()) {
            throw new CustomerNotEligibleException("This customer is not eligible for rental.");
        }

        vehicle.rent(customer, days);
        RentalTransaction transaction = new RentalTransaction(customer, vehicle, new Date(), days, insurance);
        transactions.add(transaction);
        customer.addRentalTransaction(transaction);
        customer.setCurrentRental(vehicle);
        customer.addPoints(days * 10); // Add loyalty points
    }



    // Returning the vehicle
    public void returnVehicle(Customer customer, Rentable vehicle, boolean insurance) {
        vehicle.returnVehicle();
        customer.removeCurrentRental(vehicle);
        if (insurance) {
            System.out.println("Insurance processed.");
        }
    }

    public List<RentalTransaction> getTransactions() {
        return transactions;
    }
}
