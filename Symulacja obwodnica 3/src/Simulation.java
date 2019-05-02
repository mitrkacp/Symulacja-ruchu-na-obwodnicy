import java.util.ArrayList;

public class Simulation {
    //private ArrayList<Vehicle> vehicles;
    private ArrayList<Road> roads;
    private ArrayList<Intersection> intersections;

    public Simulation(){
        //vehicles = new ArrayList<>();
        roads = new ArrayList<>();
        intersections = new ArrayList<>();
    }

    public void update(){
        for (Road r: roads){
            //TODO dla kazdej drogi sprawdzamy jak zachowaja sie nalezace do niej pojazdy
        }
    }
}
