// The purpose of this class it to test if the code works or not.
public class Main {
    public static void main(String[] args) {
        // Create a rental company
        RentalCompany rentalCompany = new RentalCompany();

        // Add some scooters with initial values
        rentalCompany.addScooter(new Scooter("Sparrow X10", 80, 41.7121106, 44.7489232, true));
        rentalCompany.addScooter(new Scooter("Zephyr ZX5", 60, 41.7121106, 44.7489232, true));
        rentalCompany.addScooter(new Scooter("Swift S8", 70, 41.7121106, 44.7489232, true));

        // Display all scooters before rental
        System.out.println("Before rental:");
        rentalCompany.displayAllScooters();
        System.out.println();

        // Rent a scooter
        Scooter rentedScooter;
        try {
            rentalCompany.rentScooter(1);
            rentedScooter = rentalCompany.findScooter(1);
            System.out.println("Rented scooter: " + rentedScooter);
        } catch (RentalCompany.ScooterNotFoundException | RentalCompany.ScooterNotAvailableException e) {
            System.out.println(e.getMessage());
            return;
        }

        // Assuming starting location is home
        double startX = 41.72513624949516;
        double startY = 44.72411838774722;

        // Go from home to the university
        goToLocation(rentedScooter, 41.725139, 44.724274);

        // Leave the scooter at the university
        try {
            rentalCompany.returnScooter(rentedScooter.getId(), rentedScooter.getX(), rentedScooter.getY());
            System.out.println("Scooter left at the university");
        } catch (RentalCompany.ScooterNotFoundException | RentalCompany.ScooterAvailableException e) {
            System.out.println(e.getMessage());
            return;
        }

        // Wait for 1 hour (simulated by 1 second here)
        simulateTimePassing(3600);

        // Rent the scooter again
        try {
            rentalCompany.rentScooter(rentedScooter.getId());
            System.out.println("Rented scooter again: " + rentedScooter);
        } catch (RentalCompany.ScooterNotFoundException | RentalCompany.ScooterNotAvailableException e) {
            System.out.println(e.getMessage());
            return;
        }

        // Go from the university back to home
        goToLocation(rentedScooter, startX, startY);

        // Leave the scooter near home
        try {
            rentalCompany.returnScooter(rentedScooter.getId(), rentedScooter.getX(), rentedScooter.getY());
            System.out.println("Scooter left near home");
        } catch (RentalCompany.ScooterNotFoundException | RentalCompany.ScooterAvailableException e) {
            System.out.println(e.getMessage());
            return;
        }

        // Display all scooters after rental
        System.out.println("\nAfter rental:");
        rentalCompany.displayAllScooters();
    }

    private static void goToLocation(Scooter scooter, double x, double y) {
        scooter.setX(x);
        scooter.setY(y);
        System.out.println("Scooter moved to location: (" + x + ", " + y + ")");
    }

    private static void simulateTimePassing(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
            System.out.println("Time passed: " + seconds + " seconds");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}