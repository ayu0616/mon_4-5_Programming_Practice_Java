public class AnimalTester {
    public static void main(String[] args) {
        Lion lion = new Lion("George");
        System.out.println(lion.getName());
        lion.startWalking();
        lion.stopWalking();
    }
}
