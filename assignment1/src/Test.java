import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    private Map<Integer, Integer> lengthCounts = new HashMap<>();
    private int lineLength = 64;
    private int maxCount = 0;
    private int maxCharLength = 0;
    private double numberCharParam;
    private Map<Integer, String> histogram = new HashMap<>();

    private void parseFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file, "utf-8");

        while (scanner.hasNext()) {
            String lineString = scanner.nextLine().toLowerCase().replaceAll("[^a-z\s']", "");
            for (String word : lineString.split("\s")) {
                if (word != "") {
                    int length = word.length();
                    try {
                        lengthCounts.put(length, lengthCounts.get(length) + 1);
                    } catch (NullPointerException e) {
                        lengthCounts.put(length, 1);
                    }
                }
            }
        }
        scanner.close();

        for (Map.Entry<Integer, Integer> entry : lengthCounts.entrySet()) {
            int charLength = entry.getKey();
            int count = entry.getValue();
            if (charLength > maxCharLength) {
                maxCharLength = charLength;
            }
            if (count > maxCount) {
                maxCount = count;
            }
        }

        for (int i = 1; i < maxCharLength; i++) {
            try {
                int a = lengthCounts.get(i);
            } catch (NullPointerException e) {
                lengthCounts.put(i, 0);
            }
        }

        numberCharParam = lineLength / Math.log(maxCount);
    }

    private int getNumberChar(int count) {
        if (count == 0) {
            return 0;
        } else {
            return (int) (Math.log(count) * numberCharParam + 1);
        }
    }

    public void computeHistogram() {
        for (Map.Entry<Integer, Integer> entry : lengthCounts.entrySet()) {
            int numberChar = getNumberChar(entry.getValue());
            String histBar = "#".repeat(numberChar) + " ".repeat(lineLength + 1 - numberChar);
            histogram.put(entry.getKey(), histBar);
        }
    }

    public void displayHistogram() throws FileNotFoundException {
        lengthCounts.forEach((charLength, count) -> System.out.printf("%d :%s %d\n", charLength,
                histogram.get(charLength), count));
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "/Users/OgawaAyumu/Downloads/book.txt";
        Test test = new Test();
        test.parseFile(filename);
        test.computeHistogram();
        test.displayHistogram();
    }
}
