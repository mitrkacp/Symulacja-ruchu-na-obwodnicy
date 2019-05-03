import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Simulation extends Thread{
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

    public void run(){
        Road road = new Road(100,3,10,1);
        Random rand = new Random();
        int v;
        int p;

        for(int i=0; i<10000; i++){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            v = rand.nextInt(9)+1;//losowa v samochodu od 1 do 10
            p = rand.nextInt(3); // losowy pas dla samochodu

            System.out.println(road);
            road.update();

            if(i%2==0){
                road.addVehicle(new Vehicle(i,Type.CAR,0,p,v ,rand.nextInt(6)+4));
            }

        }
    }
}
