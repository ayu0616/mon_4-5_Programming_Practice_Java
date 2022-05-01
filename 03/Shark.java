public class Shark extends Fish implements Swim {
    public Shark(String name) {
        super(name, "shark");
    }

    @Override
    public void startSwimming() {
        System.out.println(getName() + " started swimming");
    }

    @Override
    public void stopSwimming() {
        System.out.println(getName() + " stopped swimming");
    }
}
