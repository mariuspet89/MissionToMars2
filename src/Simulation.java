import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Simulation {

    public List<U1> loadU1(List<Item> items) {
        List<U1> rockets = new ArrayList<>();
        U1 rocket = new U1();

        for (Item item : items) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                rockets.add(rocket);
                rocket = new U1();
                rocket.carry(item);
            }
        }
        return rockets;
    }


    public List<U2> loadU2(List<Item> items){
        List<U2> rockets = new ArrayList<>();
        U2 rocket = new U2();

        for (Item item : items) {
            if(rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                rockets.add(rocket);
                rocket = new U2();
                rocket.carry(item);
            }
        }
        return rockets;
    }

    public long runSimulation(List<Rocket> rockets) {
        long simulationCost = 0;
        for (Rocket rocket : rockets ) {
            simulationCost = simulationCost + sendRocket(rocket);
        }
        return simulationCost;
    }
    public long sendRocket(Rocket rocket) {
        if(rocket.launch() && rocket.land()) {
            return rocket.getCost();
        } else {
            System.out.println("crashed");
            return rocket.getCost() + sendRocket(rocket);
        }
    }

    public List<Item> loadItems(String fileName) {
        List<Item> items = new ArrayList<>();
        try {
            BufferedReader bufferredReader = new BufferedReader(new FileReader(fileName));
            String line = bufferredReader.readLine();
            while(line != null){
                Item item = createItem(line);
                items.add(item);
                line = bufferredReader.readLine();
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    private Item createItem(String line) {
        String[] elements = line.split("=");
        return new Item(elements[0], Integer.parseInt(elements[1]));

    }




}
