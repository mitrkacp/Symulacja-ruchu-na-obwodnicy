import java.util.ArrayList;

public class Road {
    private Vehicle roadArray[][];
    private ArrayList<Vehicle> vehicles;
    private int length;
    private int width;
    private int velocityLimit;
    private int id;

    public Road(int length_,int width_, int velocityLimit, int id) {
        this.length = length_;
        this.width = width_;
        this.roadArray = new Vehicle[width][length];
        this.velocityLimit = velocityLimit;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getVelocityLimit() {
        return velocityLimit;
    }

    public void setVelocityLimit(int velocityLimit) {
        this.velocityLimit = velocityLimit;
    }

    public void addVehicle(int id, Type type, int positionX, int positionY, int velocity, int roadId){
        Vehicle vehicle = new Vehicle(id,type,positionX,positionY,velocity,roadId);
        vehicles.add(vehicle);
    }

    public void checkCollision(Vehicle vehicle){
            int distance = 0;
            for(int i = vehicle.getPositionX()+1; i < length; i++){
                if(roadArray[vehicle.getPositionY()][i] != null){
                    distance = i - vehicle.getPositionX() - 1;
                    break;
                }
            }
            if(distance != 0 && vehicle.getVelocity() > distance-1){
                vehicle.setVelocity(distance-1);
            }
    }

    public void update(){
        for(Vehicle v: vehicles){
            //TODO
        }
    }
}
