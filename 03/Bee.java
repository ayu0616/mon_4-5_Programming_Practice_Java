public class Bee extends Insect implements Fly, Walk {
    public Bee(String name) {
        super(name, "bee");
    }

    @Override
    public void startFlying() {
        System.out.println(getName() + " started flying");
    }

    @Override
    public void stopFlying() {
        System.out.println(getName() + " stopped flying");
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
