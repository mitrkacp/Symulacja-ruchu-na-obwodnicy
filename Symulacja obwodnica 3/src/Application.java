public class Application {
    public static void main(String argv[]){
        Road road = new Road(30,2,3,1);
        road.addVehicle(new Vehicle(69,Type.CAR,1,5,1,1));
        System.out.println(road);
    }
}
