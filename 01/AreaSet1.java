public class AreaSet1 {
    public static void main(String[] args) {
        int w1, w2, w3, h1, h2, h3, h4;
        int room_a, room_b, room_c, room_d, hall;
        w1 = 5;
        w2 = 5;
        w3 = 5;
        h1 = 3;
        h2 = 3;
        h3 = 3;
        h4 = 9;

        room_a = w1 * h1;
        room_b = w3 * h2;
        room_c = w3 * h3;
        room_d = w3 * (h4 - h2 - h3);
        hall = w2 * h2;
        System.out.println(room_a);
        System.out.println(room_b);
        System.out.println(room_c);
        System.out.println(room_d);
        System.out.println(hall);
    }
}
