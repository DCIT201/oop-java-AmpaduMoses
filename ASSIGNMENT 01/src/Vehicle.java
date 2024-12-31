public abstract class Vehicle {
    //class is abstract and would contain abstract methods...
    private final String vehicleId;
    private final String model;
    private final double baseRentalRate;
    private boolean availability;
    private double rating;

    //Constructor
    public Vehicle(String vehicleId, String model, double baseRentalRate, boolean availability) {

        if (vehicleId == null || model == null || baseRentalRate < 0) {
            throw new IllegalArgumentException("Input is invalid.");
        }

        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.availability = availability;

    }
   //Static factory methods
   public static Car creatingCar(String vehicleId, String model, double baseRentalRate, boolean availability, boolean hasAirConditioner) {
        return new Car(vehicleId, model, baseRentalRate, availability, hasAirConditioner);
   }
    public static Motorcycle creatingMotorcycle(String vehicleId, String model, double baseRentalRate,boolean availability, boolean helmetRequired) {
        return new Motorcycle(vehicleId, model, baseRentalRate, availability, helmetRequired);
    }
    public static Truck creatingTruck(String vehicleId, String model, double baseRentalRate, boolean availability) {
        return new Truck(vehicleId, model, baseRentalRate,availability);
    }


    //Getters and Setters

    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean available){
        this.availability = available;
    }

    //Rating System
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        if( rating < 0 || rating > 5 ){
            throw new IllegalArgumentException("Rating is invalid and must be between 0 and 5.");
        }
        this.rating=rating;

    }
//Abstract methods for Rental Calculations.
    public abstract double calculateRentalCost(int days);
    public abstract boolean availabilityForRental();

    @Override
    public String toString() {
        return "Vehicle ID:" + vehicleId + ", Model:" + model+ ",Base Rate:" + baseRentalRate+ ",Availability:" + availability;
    }


}
