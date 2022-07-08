import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordLengthHistogram {
    String filename;
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
                lengthCounts.get(i).toString();
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

    public void computeHistogram() throws FileNotFoundException {
        parseFile(filename);
        for (Map.Entry<Integer, Integer> entry : lengthCounts.entrySet()) {
            int numberChar = getNumberChar(entry.getValue());
            String histBar = "#".repeat(numberChar) + " ".repeat(lineLength + 1 - numberChar);
            histogram.put(entry.getKey(), histBar);
        }
    }

    public void displayHistogram() {
        try {
            computeHistogram();
        } catch (FileNotFoundException e) {
            System.out.println("histogram is not ready");
            e.printStackTrace();
            System.exit(0);
        }
        lengthCounts.forEach((charLength, count) -> System.out.printf("%-3d:%s %d\n", charLength,
                histogram.get(charLength), count));
    }

    public static void main(String[] args) throws FileNotFoundException {
        WordLengthHistogram histo = new WordLengthHistogram();
        System.out.print("input filename => ");
        Scanner scanner = new Scanner(System.in);
        String inputFilename = scanner.nextLine().strip();
        scanner.close();

        if (inputFilename == "") {
            histo.filename = "./book.txt";
        } else {
            histo.filename = inputFilename;
        }

        histo.displayHistogram();
    }
}
