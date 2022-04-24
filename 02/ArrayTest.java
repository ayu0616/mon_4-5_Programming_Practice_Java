public class ArrayTest {
    public static void main(String[] args) {
        int[] A;
        A = new int[5];

        System.out.println("代入する前のサイズは" + A.length);

        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }

        System.out.println("代入した後のサイズは" + A.length);
    }
}
