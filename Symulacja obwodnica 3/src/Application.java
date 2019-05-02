public class Application {
    public static void main(String argv[]){
        Road road = new Road(30,2,3,1);
        road.addVehicle(new Vehicle(69,Type.CAR,0,0,4,1));
        for(int i=0; i<10; i++){
            System.out.println(road);
            road.update();
            if(i<2){
                road.addVehicle(new Vehicle(i,Type.CAR,0,0,8+i,1));
            }

        }
    }
}
