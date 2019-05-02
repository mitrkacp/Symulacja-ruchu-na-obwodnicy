public class Application {
    public static void main(String argv[]){
        Road road = new Road(30,2,3,1);
        road.addVehicle(new Vehicle(69,Type.CAR,0,0,17,1));
        for(int i=0; i<3; i++){
            System.out.println(road);
            road.update();
        }
    }
}
