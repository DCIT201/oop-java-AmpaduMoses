public class Main {
    public static void main(String[] args) {
        // Create a rental agency
        RentalAgency rentalAgency = new RentalAgency();

        // Create customers
        Customer customer1 = Customer.createCustomer(" Charles Moses", "DL749832");
        Customer customer2 = Customer.createCustomer("Johnson Sam", "DL909382");

        // Create vehicles
        Car car1 = Vehicle.creatingCar("CR3849", "BMW 5 SERIES", 500.0, true, true);
        Motorcycle motorcycle1 = Vehicle.creatingMotorcycle("MR3222", "Ducati Panigale V4-A", 250.0, true, true);
        Truck truck1 = Vehicle.creatingTruck("TR3923", "Chevrolet Silverado 2500HD", 2500.0, true);

        // Add vehicles to the rental agency
        rentalAgency.addVehicle(car1);
        rentalAgency.addVehicle(motorcycle1);
        rentalAgency.addVehicle(truck1);

        try {
            // Rent vehicles
            rentalAgency.rentVehicle(customer1, car1, 5, true);
            rentalAgency.rentVehicle(customer2, motorcycle1, 3, false);

            // Return vehicles
            rentalAgency.returnVehicle(customer1, car1, true);
            rentalAgency.returnVehicle(customer2, motorcycle1, false);

            // Print rental transactions
            for (RentalTransaction transaction : rentalAgency.getTransactions()) {
                System.out.println("Customer: " + transaction.getCustomer().getName());
                System.out.println("Vehicle: " + transaction.getVehicle().getModel());
                System.out.println("Rental Date: " + transaction.getRentalDate());
                System.out.println("Rental Days: " + transaction.getRentalDays());
                System.out.println("Insurance: " + transaction.isInsurance());
            }
        } catch (VehicleNotAvailableException | CustomerNotEligibleException e) {
            System.out.println(e.getMessage());
        }
    }

}
