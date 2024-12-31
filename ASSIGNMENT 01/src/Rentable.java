public interface Rentable {
    void  rent(Customer customer, int days);
    void returnVehicle()       ;
    boolean availabilityForRental();
    String getModel();
}
