public class Ant extends Insect implements Walk {
    public Ant(String name) {
        super(name, "ant");
    }

    @Override
    public void startWalking() {
        System.out.println(getName() + " started walking");
    }

    @Override
    public void stopWalking() {
        System.out.println(getName() + " stopped walking");
    }
}
