import java.util.ArrayList;
import java.util.List;

public class Rocket implements SpaceShip {

    private List<Item> items = new ArrayList<>();
    protected final int MAX_LIMIT;
    private int currentWeightOfCargo;
    protected final int CONSTRUCTION_WEIGHT;
    private int cost;
    private int currentWeightOfRocket;

    public Rocket(int max_limit, int construction_weight, int cost) {
        MAX_LIMIT = max_limit;
        CONSTRUCTION_WEIGHT = construction_weight;
        this.cost = cost;

    }

    public int getCost() {
        return cost;
    }

    public int getCurrentWeightOfCargo() {
        return currentWeightOfCargo;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {

       /* if (currentWeightOfCargo < MAX_LIMIT) {
            currentWeightOfCargo = currentWeightOfCargo + item.getWeight();
            return true;
        } else {
            return false;
        }*/
        return (currentWeightOfCargo + item.getWeight()) <= MAX_LIMIT;

    }

    @Override
    public void carry(Item item) {
        items.add(item);
        currentWeightOfRocket =
                currentWeightOfCargo +
                item.getWeight() +
                CONSTRUCTION_WEIGHT;

       /* if (canCarry(item)) {
            currentWeightOfRocket = CONSTRUCTION_WEIGHT + item.getWeight();
        } else {
            System.out.println("Maximum limit achieved! ");
        }*/
       // System.out.println("hcs");
    }


}


