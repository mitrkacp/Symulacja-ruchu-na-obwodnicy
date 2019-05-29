import java.util.ArrayList;

public class Intersection {
    private int id;
    private Road roadCC_in;
    private Road roadCC_out;
    private Road roadC_out;
    private Road roadC_in;
    private int carsInput;
    private String desc;

    public Intersection(int i,Road inC,Road inCC,Road outC,Road outCC, int ci,String d){
        id = i;
        roadC_in = inC;
        roadCC_in = inCC;
        roadC_out = outC;
        roadCC_out = outCC;
        carsInput = ci;
        desc = d;
    }

}
