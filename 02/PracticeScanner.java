import java.util.Scanner;

public class PracticeScanner {
    public static void main(String[] args) {
        Scanner user_input_scanner = new Scanner(System.in);
        System.out.print("ここに入力してください => ");
        String inputted_text = user_input_scanner.nextLine();
        user_input_scanner.close();
        System.out.println(inputted_text);
    }
}
