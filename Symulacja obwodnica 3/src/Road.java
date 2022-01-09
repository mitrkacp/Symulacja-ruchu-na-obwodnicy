import java.util.ArrayList;
import java.util.Random;

public class Road {
    public Vehicle getRoadArray(int x,int y) {
        return roadArray[x][y];
    }

    private Vehicle roadArray[][];
    private ArrayList<Vehicle> vehicles;
    private int length;
    private int width;
    private int velocityLimit;
    private int id;
    private Intersection out;

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
        this.roadArray[vehicle.getPositionY()][vehicle.getPositionX()] = vehicle;
        vehicles.add(vehicle);
    }

    public void checkCollision(Vehicle vehicle){
            int distance = 0;
            int car_length = 1;
            if(vehicle.getType() == Type.TRUCK){
                car_length = 2;
            }
            for(int i = vehicle.getPositionX()+car_length; i < length; i++){
                if(roadArray[vehicle.getPositionY()][i] != null) {
                    distance = i - vehicle.getPositionX() - car_length;
                    break;
                }
            }
            if(distance != 0 && vehicle.getVelocity() > distance - car_length){
                if(!switchLaneLeft(vehicle)){
                    vehicle.setVelocity(distance - car_length);
                }
            }
            if(vehicle.getVelocity() > 0){
                switchLaneRight(vehicle);
            }

    }

    public void stopBeforeIntersection(Vehicle v){
        int car_length = 1;
        if(v.getType() == Type.TRUCK){
            car_length = 2;
        }

        int dist = length - v.getPositionX() - car_length;
        if(v.getVelocity() > dist - car_length){
            if(dist > 0)v.setVelocity(dist);
            else v.setVelocity(0);
        }
    }

    boolean switchLaneLeft(Vehicle vehicle){
        if(vehicle.getPositionY() > 0){
            Vehicle prev = null;
            Vehicle next = null;
            for(int i = vehicle.getPositionX(); i > 0; i--) {
                if (roadArray[vehicle.getPositionY() - 1][i] != null) {
                    prev = roadArray[vehicle.getPositionY() - 1][i];
                    break;
                }
            }
            if(prev == null || prev.getVelocity() < vehicle.getPositionX() - prev.getPositionX() - 1){
                for(int i = vehicle.getPositionX(); i < length; i++){
                    if(roadArray[vehicle.getPositionY() - 1][i] != null){
                        next = roadArray[vehicle.getPositionY() - 1][i];
                        break;
                    }
                }
                if(next == null || vehicle.getVelocity() < next.getPositionX() - vehicle.getPositionX() - 1){
                    vehicle.setPositionY(vehicle.getPositionY() - 1);
                    roadArray[vehicle.getPositionY()+1][vehicle.getPositionX()] = null;
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    boolean switchLaneRight(Vehicle vehicle){
        if(vehicle.getPositionY() < 2){
            Vehicle prev = null;
            Vehicle next = null;
            for(int i = vehicle.getPositionX(); i > 0; i--) {
                if (roadArray[vehicle.getPositionY() + 1][i] != null) {
                    prev = roadArray[vehicle.getPositionY() + 1][i];
                    break;
                }
            }
            if(prev == null || prev.getVelocity() < vehicle.getPositionX() - prev.getPositionX() - 1){
                for(int i = vehicle.getPositionX(); i < length; i++){
                    if(roadArray[vehicle.getPositionY() + 1][i] != null){
                        next = roadArray[vehicle.getPositionY() + 1][i];
                        break;
                    }
                }
                if(next == null || vehicle.getVelocity() < next.getPositionX() - vehicle.getPositionX() - 1){
                    vehicle.setPositionY(vehicle.getPositionY() + 1);
                    roadArray[vehicle.getPositionY()-1][vehicle.getPositionX()] = null;
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }


    public void update(){
        ArrayList<Vehicle> toRemove = new ArrayList<>();
        for(Vehicle v: vehicles){
            v.changeVelocity();
            if(v.getVelocity() > this.velocityLimit) v.setVelocity(velocityLimit);
            if(out.lights == 1){
                this.stopBeforeIntersection(v);
            }
            checkCollision(v);

            if(v.getPositionX() + v.getVelocity() < this.length){
                v.move();
                roadArray[v.getPositionY()][v.getPositionX()] = v;
            }
            else{
                toRemove.add(v);
                roadArray[v.getPositionY()][v.getPositionX()] = null;
                if (out.getId() != v.getDestinationId()) out.addVehicleFromRoad(v);
            }
            if(v.getVelocity() > 0){
                roadArray[v.getPositionY()][v.getPositionX() - v.getVelocity()] = null;
            }

        }
        vehicles.removeAll(toRemove);
    }

    @Override
    public String toString() {
        String result = "Road not initialized";
        if(this.roadArray != null){
            result = "";
            for(int i=0;i<this.roadArray.length;i++){
                for(int j=0;j<this.roadArray[0].length;j++){
                    if(this.roadArray[i][j] == null)result += "-" ;
                    else {
                        if(this.roadArray[i][j].getType() == Type.TRUCK)result += "T";
                        else {
                            if (this.roadArray[i][j].getType() == Type.CAR) result += this.roadArray[i][j].getVelocity();
                            else result += "?";
                        }
                    }
                }
                result += "\n";
            }
        }
        return result;
    }

    public void setOut(Intersection out) {
        this.out = out;
    }

    public void putVehicle(Vehicle v) {
        Random rand = new Random();
        ArrayList<Integer> possibleLocation = new ArrayList<>();

        for(int i=0;i<width;i++){
            if(roadArray[i][0] == null) possibleLocation.add(i);
        }
        v.setPositionX(0);
        v.setPositionY(possibleLocation.get(rand.nextInt(possibleLocation.size())));
        this.addVehicle(v);

        /*for(int i=0;i<length;i++){
            for(int j=0;j<width;j++){
                if(roadArray[j][i] == null){
                    v.setPositionX(j);
                    v.setPositionY(i);
                    this.addVehicle(v);
                    return;
                }
            }
        }*/
    }
}
