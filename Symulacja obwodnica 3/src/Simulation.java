import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Simulation extends Thread{
    private ArrayList<Vehicle> vehicles;
    public ArrayList<Road> roads;
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

        roads.add(r1_1);
        roads.add(r1_2);
        roads.add(r2_1);
        roads.add(r2_2);
        roads.add(r3_1);
        roads.add(r3_2);
        roads.add(r4_1);
        roads.add(r4_2);
        roads.add(r5_1);
        roads.add(r5_2);
        roads.add(r6_1);
        roads.add(r6_2);
        roads.add(r7_1);
        roads.add(r7_2);
        roads.add(r8_1);
        roads.add(r8_2);
        roads.add(r9_1);
        roads.add(r9_2);
        roads.add(r10_1);
        roads.add(r10_2);
        roads.add(r11_1);
        roads.add(r11_2);
        roads.add(r12_1);
        roads.add(r12_2);
        roads.add(r13_1);
        roads.add(r13_2);
        roads.add(r14_1);
        roads.add(r14_2);
        roads.add(r15_1);
        roads.add(r15_2);
        roads.add(r16_1);
        roads.add(r16_2);


        intersections.add(new Intersection(1,r1_1,r2_2,r1_2,r2_1,1.2,"Ofiar Katynia"));
        intersections.add(new Intersection(2,r2_1,r3_2,r2_2,r3_1,1.2,"Wolomborski"));
        intersections.add(new Intersection(3,r3_1,r4_2,r3_2,r4_1,1.2,"Imbramowski"));
        intersections.add(new Intersection(4,r4_1,r5_2,r4_2,r5_1,1.2,"Polsadu"));
        intersections.add(new Intersection(5,r5_1,r6_2,r5_2,r6_1,1.2,"Mistrzejowice"));
        intersections.add(new Intersection(6,r6_1,r7_2,r6_2,r7_1,1.2,"Czyżyny"));
        intersections.add(new Intersection(7,r7_1,r8_2,r7_2,r8_1,1.2,"Dywizjonu 308"));
        intersections.add(new Intersection(8,r8_1,r9_2,r8_2,r9_1,1.2,"Łęg"));
        intersections.add(new Intersection(9,r9_1,r10_2,r9_2,r10_1,1.2,"Płaszów"));
        intersections.add(new Intersection(10,r10_1,r11_2,r10_2,r11_1,1.2,"Bagry"));
        intersections.add(new Intersection(11,r11_1,r12_2,r11_2,r12_1,1.2,"Kabel"));
        intersections.add(new Intersection(12,r12_1,r13_2,r12_2,r13_1,1.2,"Łagiewniki"));
        intersections.add(new Intersection(13,r13_1,r14_2,r13_2,r14_1,1.2,"Solvay"));
        intersections.add(new Intersection(14,r14_1,r15_2,r14_2,r15_1,1.2,"Ruczaj"));
        intersections.add(new Intersection(15,r15_1,r16_2,r15_2,r16_1,1.2,"Przegorzały"));
        intersections.add(new Intersection(16,r16_1,r1_2,r16_2,r1_1,1.2,"Zarzecze"));

        r1_1.setOut(intersections.get(0));
        r2_2.setOut(intersections.get(0));
        r2_1.setOut(intersections.get(1));
        r3_2.setOut(intersections.get(1));
        r3_1.setOut(intersections.get(2));
        r4_2.setOut(intersections.get(2));
        r4_1.setOut(intersections.get(3));
        r5_2.setOut(intersections.get(3));
        r5_1.setOut(intersections.get(4));
        r6_2.setOut(intersections.get(4));
        r6_1.setOut(intersections.get(5));
        r7_2.setOut(intersections.get(5));
        r7_1.setOut(intersections.get(6));
        r8_2.setOut(intersections.get(6));
        r8_1.setOut(intersections.get(7));
        r9_2.setOut(intersections.get(7));
        r9_1.setOut(intersections.get(8));
        r10_2.setOut(intersections.get(8));
        r10_1.setOut(intersections.get(9));
        r11_2.setOut(intersections.get(9));
        r11_1.setOut(intersections.get(10));
        r12_2.setOut(intersections.get(10));
        r12_1.setOut(intersections.get(11));
        r13_2.setOut(intersections.get(11));
        r13_1.setOut(intersections.get(12));
        r14_2.setOut(intersections.get(12));
        r14_1.setOut(intersections.get(13));
        r15_2.setOut(intersections.get(13));
        r15_1.setOut(intersections.get(14));
        r16_2.setOut(intersections.get(14));
        r16_1.setOut(intersections.get(15));
        r1_2.setOut(intersections.get(15));
    }

    private void generateNewCars(){
        Random rand = new Random();
        for(Intersection intr: intersections){
            intr.currentGeneratorCount += intr.getCarsInput();
            while(intr.currentGeneratorCount >= 1){
                intr.currentGeneratorCount -= 1;
                Vehicle v = new Vehicle(vehicles.size()+1,Type.CAR,0,0,rand.nextInt(8)+2,rand.nextInt(4)+6,rand.nextInt(16)+1);
                vehicles.add(v);
                intr.addNewVehicle(v);
            }
        }
    }


    public void run(){
        /*Road road = new Road(100,3,10,1);
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
                road.addVehicle(new Vehicle(i,Type.CAR,0,p,v ,rand.nextInt(6)+4,2));
        }*/

        this.create();
        for(int i =0;i<10000;i++){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for(Road r: roads){
                r.update();
            }

            this.generateNewCars();

            for(Intersection intr: intersections){
                intr.processVehicles();
            }

            System.out.println(roads.get(0));
            System.out.println(roads.get(1));
            System.out.println(roads.get(2));
            System.out.println(roads.get(3));
            System.out.println("#############################");
        }
    }
}
