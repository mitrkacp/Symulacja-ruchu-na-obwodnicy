import java.util.Objects;

public class Vehicle {
    private int id;
    private Type type;
    private int positionX;
    private int positionY;
    private int velocity;
    private int maxVelocity;
    private double slowProbability = 0.05;

    public int getDestinationId() {
        return destinationId;
    }

    private int destinationId;

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public Vehicle(int id, Type type, int positionX, int positionY, int velocity, int maxVelocity_,int id_ ){
        this.id = id;
        this.type = type;
        this.positionX = positionX;
        this.positionY = positionY;
        this.velocity = velocity;
        this.maxVelocity = maxVelocity_;
        this.destinationId = id_;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return id == vehicle.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void accelerate(){
        if(this.velocity+1 >= maxVelocity){
            this.velocity=maxVelocity;
        }
        else{
            this.velocity += 1;
        }
    }

    public void decelerate(){
        if(this.slowProbability > Math.random()){
            this.velocity -= 1;
        }
    }

    public void changeVelocity(){
        accelerate();
        decelerate();
    }

    public void move(){
        this.positionX += velocity;
    }
}
