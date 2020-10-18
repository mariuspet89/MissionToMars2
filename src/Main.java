import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*Rocket rocket = new Rocket(18000,10000, 120 );
        Item item = new Item("caramida", 21);
        System.out.println(rocket.canCarry(item));*/

        Simulation simulation = new Simulation();
        List<Item> phase1Items = simulation.loadItems("Phase-1.txt");
        List<Item> phase2Items = simulation.loadItems("Phase-2.txt");

        List<U1> phase1U1 = simulation.loadU1(phase1Items);
        List<U1> phase2U1 = simulation.loadU1(phase2Items);

        List<Rocket> u1Rockets = new ArrayList<>();
        u1Rockets.addAll(phase1U1);
        u1Rockets.addAll(phase2U1);

        List<U2> phase1U2 = simulation.loadU2(phase1Items);
        List<U2> phase2U2 = simulation.loadU2(phase2Items);

        System.out.println("U1 cost: " + simulation.runSimulation(u1Rockets));

        List<Rocket> u2Rockets = new ArrayList<>();
        u2Rockets.addAll(phase1U2);
        u2Rockets.addAll(phase2U2);

        System.out.println("U2 cost: "+ simulation.runSimulation(u2Rockets));


    }
}
