import java.util.Date;

/**
 * This class represents a transaction in which a customer rents a vehicle.
 * It includes attributes for the customer, vehicle, rental date, rental days, and insurance.
 */
public final class RentalTransaction {
    private final Customer customer;
    private final Rentable vehicle;
    private final Date rentalDate;
    private final int rentalDays;
    private final boolean insurance;

    /**
     * Constructs a new RentalTransaction.
     *
     * @param customer   the customer renting the vehicle
     * @param vehicle    the vehicle being rented
     * @param rentalDate the date the rental starts
     * @param rentalDays the number of days the vehicle is rented
     * @param insurance  whether insurance is included in the rental
     */
    public RentalTransaction(Customer customer, Rentable vehicle, Date rentalDate, int rentalDays, boolean insurance) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDate = rentalDate;
        this.rentalDays = rentalDays;
        this.insurance = insurance;
    }

    // Getters
    public Customer getCustomer() {
        return customer;
    }

    public Rentable getVehicle() {
        return vehicle;
    }
    public Date getRentalDate() {
        return rentalDate;
    }
    public int getRentalDays() {
        return rentalDays;
    }
    public boolean isInsurance() {
        return insurance;
    }
}
