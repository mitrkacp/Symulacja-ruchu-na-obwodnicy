import java.util.ArrayList;

public class Intersection {
    public int getId() {
        return id;
    }

    public int lights; //0 - rondo, 1 - czerwone, 2 - zielone
    private int lightsCounterInit;
    private int lightsCounter;
    private int id;
    private Road roadCC_in;
    private Road roadCC_out;
    private Road roadC_out;
    private Road roadC_in;

    public double getCarsInput() {
        return carsInput;
    }

    private double carsInput;

    public String getDesc() {
        return desc;
    }

    private String desc;
    private ArrayList<Vehicle> newVehicles;
    private ArrayList<Vehicle> vehiclesToBeProcessed;
    private int maxVehiclesProcessed = 3;

    public double currentGeneratorCount = 0;

    public Intersection(int i,Road inC,Road inCC,Road outC,Road outCC, double ci,String d,int l, int lc){
        id = i;
        roadC_in = inC;
        roadCC_in = inCC;
        roadC_out = outC;
        roadCC_out = outCC;
        carsInput = ci;
        desc = d;
        newVehicles = new ArrayList<>();
        vehiclesToBeProcessed = new ArrayList<>();
        lights = l;
        lightsCounterInit = lc;
        lightsCounter = lightsCounterInit;
    }


    public void addNewVehicle(Vehicle v){
        newVehicles.add(v);
    }

    public void addVehicleFromRoad(Vehicle v){
        vehiclesToBeProcessed.add(v);
    }

    public void update(){
        int vNum;
        if(maxVehiclesProcessed < vehiclesToBeProcessed.size()) vNum = maxVehiclesProcessed;
        else {
            if(lights != 2) {
                int freeSpace = maxVehiclesProcessed - vehiclesToBeProcessed.size();
                if (freeSpace > newVehicles.size()) {
                    for (int i = newVehicles.size(); i > 0; i--) {
                        vehiclesToBeProcessed.add(newVehicles.get(0));
                        newVehicles.remove(0);
                    }
                } else {
                    for (int i = freeSpace; i > 0; i--) {
                        vehiclesToBeProcessed.add(newVehicles.get(0));
                        newVehicles.remove(0);
                    }
                }
            }
            vNum = vehiclesToBeProcessed.size();
        }
        for(int i=0;i<vNum;i++){
            if(id == vehiclesToBeProcessed.get(0).getDestinationId()){
                vehiclesToBeProcessed.remove(0);
            }
            else{
                int dist = Math.abs(id - vehiclesToBeProcessed.get(0).getDestinationId());
                if(id < vehiclesToBeProcessed.get(0).getDestinationId()){
                    int dist2 = Math.abs(id-(vehiclesToBeProcessed.get(0).getDestinationId()-16));
                    if(dist > dist2) {
                        roadC_out.putVehicle(vehiclesToBeProcessed.get(0));
                    }else{
                        if(dist == dist2){
                            if(Math.random() < 0.5)roadC_out.putVehicle(vehiclesToBeProcessed.get(0));
                            else roadCC_out.putVehicle(vehiclesToBeProcessed.get(0));
                        }else{
                            roadCC_out.putVehicle(vehiclesToBeProcessed.get(0));
                        }
                    }
                }
                else{
                    int dist2 = Math.abs(id-(vehiclesToBeProcessed.get(0).getDestinationId()+16));
                    if(dist > dist2) {
                        roadCC_out.putVehicle(vehiclesToBeProcessed.get(0));
                    }else{
                        if(dist == dist2){
                            if(Math.random() < 0.5)roadC_out.putVehicle(vehiclesToBeProcessed.get(0));
                            else roadCC_out.putVehicle(vehiclesToBeProcessed.get(0));
                        }else{
                            roadC_out.putVehicle(vehiclesToBeProcessed.get(0));
                        }
                    }
                }
                vehiclesToBeProcessed.remove(0);
            }
        }

        lightsCounter--;
        if(lightsCounter == 0){
            this.changeLights();
            lightsCounter = lightsCounterInit;
        }

    }

    public void changeLights(){
        if(lights == 1){
            lights = 2;
            return;
        }
        if(lights == 2)lights = 1;
    }

    @Override
    public String toString() {
        return desc + " id: " + id + " Lights: " + lights + " LC: " + lightsCounter + " VTPSize: " + vehiclesToBeProcessed.size() + " NVsize: " + newVehicles.size();
    }
}
