

public class Road {
    private Vehicle roadArray[][];
    private int velocityLimit;
    private int id;

    public Road(int length,int width, int velocityLimit, int id) {
        this.roadArray = new Vehicle[width][length];
        this.velocityLimit = velocityLimit;
        this.id = id;
    }
}
