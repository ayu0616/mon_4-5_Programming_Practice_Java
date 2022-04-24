public class DiceTest {
    public static void main(String[] args) {
        Dice dice1 = new Dice("my dice", 6);
        // Dice dice2 = new Dice("your dice", 4);
        // System.out.println(dice1.name);
        // System.out.println(dice2.name);
        // dice2 = dice1;
        // System.out.println(dice1.name);
        // System.out.println(dice2.name);

        // dice1 = null;
        System.out.println(dice1.name);

        dice1.name = "his dice";
        System.out.println(dice1.name);
    }
}
