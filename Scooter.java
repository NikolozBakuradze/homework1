public class Scooter {
    private int id;
    private String model;
    private int batteryLevel;
    private double x, y;
    private boolean available;

    public Scooter(String model, int batteryLevel, double x, double y, boolean available) {
        this.model = model;
        this.batteryLevel = batteryLevel;
        this.x = x;
        this.y = y;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Scooter{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", batteryLevel=" + batteryLevel +
                ", x=" + x +
                ", y=" + y +
                ", available=" + available +
                '}';
    }
}