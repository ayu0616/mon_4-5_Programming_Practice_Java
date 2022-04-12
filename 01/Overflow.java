public class Overflow {
    public static void main(String[] args) {
        int i1, i2;
        i1 = 4;
        i2 = 1000;
        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        i1 = i1 * i2;
        System.out.println("i1 = " + i1);
    }
}
