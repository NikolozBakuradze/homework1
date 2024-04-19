import java.util.ArrayList;
import java.util.List;

public class RentalCompany {
    private int uid = 0;
    private List<Scooter> scooters = new ArrayList<>();

    public List<Scooter> availableScooters() {
        List<Scooter> result = new ArrayList<>();
        for (Scooter scooter : scooters) {
            if (scooter.isAvailable()) {
                result.add(scooter);
            }
        }
        return result;
    }

    public void addScooter(Scooter scooter) {
        scooter.setId(uid++);
        scooters.add(scooter);
    }

    public boolean removeScooter(int id) {
        boolean removed = false;
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id) {
                scooters.remove(scooter);
                removed = true;
                break;
            }
        }
        return removed;
    }

    public void rentScooter(int id) throws ScooterNotFoundException, ScooterNotAvailableException {
        Scooter scooter = findScooter(id);
        if (scooter == null) {
            throw new ScooterNotFoundException("Scooter with ID " + id + " not found.");
        }
        if (!scooter.isAvailable()) {
            throw new ScooterNotAvailableException("Scooter with ID " + id + " is not available for rent.");
        }
        scooter.setAvailable(false);
    }

    public void returnScooter(int id, double x, double y) throws ScooterNotFoundException, ScooterAvailableException {
        Scooter scooter = findScooter(id);
        if (scooter == null) {
            throw new ScooterNotFoundException("Scooter with ID " + id + " not found.");
        }
        if (scooter.isAvailable()) {
            throw new ScooterAvailableException("Scooter with ID " + id + " is already available.");
        }
        scooter.setX(x);
        scooter.setY(y);
        scooter.setAvailable(true);
    }

    public void displayAllScooters() {
        System.out.println("List of all scooters:");
        for (Scooter scooter : scooters) {
            System.out.println(scooter);
        }
    }

    public Scooter findScooter(int id) {
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id) {
                return scooter;
            }
        }
        return null;
    }

    static class ScooterNotFoundException extends Exception {
        public ScooterNotFoundException(String message) {
            super(message);
        }
    }

    static class ScooterNotAvailableException extends Exception {
        public ScooterNotAvailableException(String message) {
            super(message);
        }
    }

    static class ScooterAvailableException extends Exception {
        public ScooterAvailableException(String message) {
            super(message);
        }
    }
}