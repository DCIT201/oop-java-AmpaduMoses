import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Customer implements LoyaltyProgram {
    private final String name;
    private final String driverLicenseNumber;
    private final List<RentalTransaction> rentalHistory;
    private List<Rentable> currentRentals;
    private int loyaltyPoints;
    private double rating;

    private Customer(String name, String driverLicenseNumber) {
        this.name = name;
        this.driverLicenseNumber = driverLicenseNumber;
        this.rentalHistory = new ArrayList<>();
        this.currentRentals = new ArrayList<>();
    }

    // Static factory method
    public static Customer createCustomer(String name, String driverLicenseNumber) {
        return new Customer(name, driverLicenseNumber);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public List<RentalTransaction> getRentalHistory() {
        return Collections.unmodifiableList(rentalHistory);
    }

    public List<Rentable> getCurrentRentals() {
        return Collections.unmodifiableList(currentRentals);
    }
    //Setters
    public void setCurrentRental(Rentable vehicle) {
        this.currentRentals= (List<Rentable>) vehicle;
    }

    // Manage rental history
    public void addRentalTransaction(RentalTransaction transaction) {
        rentalHistory.add(transaction);
    }

    // Track current rentals
    public void addCurrentRental(Rentable rental) {
        currentRentals.add(rental);
    }

    public void removeCurrentRental(Rentable rental) {
        currentRentals.remove(rental);
    }

    // Implement rental eligibility checks
    public boolean isEligibleForRental() {
        return currentRentals.size() < 3;
    }

    // LoyaltyProgram implementation
    @Override
    public void addPoints(int points) {
        loyaltyPoints += points;
    }

    @Override
    public int getPoints() {
        return loyaltyPoints;
    }

    @Override
    public void redeemPoints(int points) throws InsufficientPointsException {
        if (points > loyaltyPoints) {
            throw new InsufficientPointsException("Not enough loyalty points.");
        }
        loyaltyPoints -= points;
    }

    // Rating system
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 0 and 5.");
        }
        this.rating =rating;
    }
}
