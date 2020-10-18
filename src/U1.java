public class U1 extends Rocket {

    public U1() {
        super(8000, 10000, 100);
    }

    @Override
    public boolean launch() {
        double chance = 0.05 * getCurrentWeightOfCargo() / MAX_LIMIT;
        double random = Math.random() / 10;
        return random >= chance;
    }

    @Override
    public boolean land(){
        double chance = 0.01 * getCurrentWeightOfCargo() / MAX_LIMIT;
        double random = Math.random()/10;
        return random >= chance;
    }
}
