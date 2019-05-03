import java.util.ArrayList;

public class Simulation {
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Road> roads;
    private ArrayList<Intersection> intersections;

    public Simulation(){
        vehicles = new ArrayList<>();
        roads = new ArrayList<>();
        intersections = new ArrayList<>();
    }

    public void update(){
        for (Road r: roads){
            //TODO dla kazdej drogi sprawdzamy jak zachowaja sie nalezace do niej pojazdy
            r.update();
            System.out.println(r);
        }
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public ArrayList<Road> getRoads() {
        return roads;
    }

    public void setRoads(ArrayList<Road> roads) {
        this.roads = roads;
    }

    public ArrayList<Intersection> getIntersections() {
        return intersections;
    }

    public void setIntersections(ArrayList<Intersection> intersections) {
        this.intersections = intersections;
    }
}
