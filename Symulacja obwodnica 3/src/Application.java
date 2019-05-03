import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Application {
    public static void main(String argv[]){
        Road road = new Road(100,3,3,1);
        road.addVehicle(new Vehicle(69,Type.CAR,0,0,4,1));
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
                road.addVehicle(new Vehicle(i,Type.CAR,0,p,v ,1));
            }

        }
    }
}
