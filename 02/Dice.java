public class Dice {
    int numberFaces;
    String name;

    public Dice(int n) {
        numberFaces = n;
        name = "my dice";
    }

    public Dice(String diceName, int n) {
        numberFaces = n;
        name = diceName;
    }

    public int rollDice() {
        return (int) (numberFaces * Math.random()) + 1;
    }
}
