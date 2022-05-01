public class Lion extends Mammal implements Swim, Walk {
    public Lion(String name){
        super(name, "lion");
    }

    @Override
    public void startSwimming() {
        System.out.println(getName() + " started swimming");
    }

    @Override
    public void stopSwimming() {
        System.out.println(getName() + " stopped swimming");
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
