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
        this.vehicles = new ArrayList<>();
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

    public void addVehicle(Vehicle vehicle){
        this.roadArray[vehicle.getPositionX()][vehicle.getPositionY()] = vehicle;
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

    @Override
    public String toString() {
        String result = "Road not initialized";
        if(this.roadArray != null){
            result = "";
            for(int i=0;i<this.roadArray.length;i++){
                for(int j=0;j<this.roadArray[0].length;j++){
                    if(this.roadArray[i][j] == null)result += "#";
                    else {
                        if(this.roadArray[i][j].getType() == Type.TRUCK)result += "T";
                        else {
                            if (this.roadArray[i][j].getType() == Type.CAR) result += "C";
                            else result += "?";
                        }
                    }
                }
                result += "\n";
            }
        }
        return result;
    }

}
