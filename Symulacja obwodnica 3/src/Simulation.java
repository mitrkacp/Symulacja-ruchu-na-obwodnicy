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


    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }


    public ArrayList<Intersection> getIntersections() {
        return intersections;
    }

    public void setIntersections(ArrayList<Intersection> intersections) {
        this.intersections = intersections;
    }


    private void create(){
        Road r1_1 = new Road(227,3,10,1);
        Road r1_2 = new Road(227,3,10,2);
        Road r2_1 = new Road(427,3,10,3);
        Road r2_2 = new Road(427,3,10,4);
        Road r3_1 = new Road(200,3,10,5);
        Road r3_2 = new Road(200,3,10,6);
        Road r4_1 = new Road(160,3,10,7);
        Road r4_2 = new Road(160,3,10,8);
        Road r5_1 = new Road(293,3,10,9);
        Road r5_2 = new Road(293,3,10,10);
        Road r6_1 = new Road(213,3,10,11);
        Road r6_2 = new Road(213,3,10,12);
        Road r7_1 = new Road(107,3,10,13);
        Road r7_2 = new Road(107,3,10,14);
        Road r8_1 = new Road(160,3,10,15);
        Road r8_2 = new Road(160,3,10,16);
        Road r9_1 = new Road(240,3,10,17);
        Road r9_2 = new Road(240,3,10,18);
        Road r10_1 = new Road(133,3,10,19);
        Road r10_2 = new Road(133,3,10,20);
        Road r11_1 = new Road(253,3,10,21);
        Road r11_2 = new Road(253,3,10,22);
        Road r12_1 = new Road(427,3,10,23);
        Road r12_2 = new Road(427,3,10,24);
        Road r13_1 = new Road(147,3,10,25);
        Road r13_2 = new Road(147,3,10,26);
        Road r14_1 = new Road(227,3,10,27);
        Road r14_2 = new Road(227,3,10,28);
        Road r15_1 = new Road(373,3,10,29);
        Road r15_2 = new Road(373,3,10,30);
        Road r16_1 = new Road(360,3,10,31);
        Road r16_2 = new Road(360,3,10,32);


        intersections.add(new Intersection(1,r1_1,r2_2,r1_2,r2_1,2,"Ofiar Katynia"));
        intersections.add(new Intersection(2,r2_1,r3_2,r2_2,r3_1,2,"Wolomborski"));
        intersections.add(new Intersection(3,r3_1,r4_2,r3_2,r4_1,2,"Imbramowski"));
        intersections.add(new Intersection(4,r4_1,r5_2,r4_2,r5_1,2,"Polsadu"));
        intersections.add(new Intersection(5,r5_1,r6_2,r5_2,r6_1,2,"Mistrzejowice"));
        intersections.add(new Intersection(6,r6_1,r7_2,r6_2,r7_1,2,"Czyżyny"));
        intersections.add(new Intersection(7,r7_1,r8_2,r7_2,r8_1,2,"Dywizjonu 308"));
        intersections.add(new Intersection(8,r8_1,r9_2,r8_2,r9_1,2,"Łęg"));
        intersections.add(new Intersection(9,r9_1,r10_2,r9_2,r10_1,2,"Płaszów"));
        intersections.add(new Intersection(10,r10_1,r11_2,r10_2,r11_1,2,"Bagry"));
        intersections.add(new Intersection(11,r11_1,r12_2,r11_2,r12_1,2,"Kabel"));
        intersections.add(new Intersection(12,r12_1,r13_2,r12_2,r13_1,2,"Łagiewniki"));
        intersections.add(new Intersection(13,r13_1,r14_2,r13_2,r14_1,2,"Solvay"));
        intersections.add(new Intersection(14,r14_1,r15_2,r14_2,r15_1,2,"Ruczaj"));
        intersections.add(new Intersection(15,r15_1,r16_2,r15_2,r16_1,2,"Przegorzały"));
        intersections.add(new Intersection(16,r16_1,r1_2,r16_2,r1_1,2,"Zarzecze"));
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
            v = rand.nextInt(9)+1;//losowa v samochodu od 1 do 9
            p = rand.nextInt(3); // losowy pas dla samochodu

            System.out.println(road);
            road.update();

            if(i%2==0){
                road.addVehicle(new Vehicle(i,Type.CAR,0,p,v ,rand.nextInt(6)+4));
            }

        }
    }
}
