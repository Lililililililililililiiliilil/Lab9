import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String telegram = in.nextLine();
        String[] list_tg = telegram.split(" ");
        ArrayList<String> redacted_tg = new ArrayList<String>();
        int cost = 0;
        for (String word : list_tg) {
            if (word.length() < 3) {
                continue;
            }
            if (word.contains(",")) {
                cost += 20;
                redacted_tg.add(word.substring(0, word.length() - 1));
                redacted_tg.add("comma");
            } else {
                cost += 10;
                redacted_tg.add(word.substring(0, word.length()));
            }
        }
        System.out.println(cost);
        System.out.println(String.join(" ", redacted_tg));

        String lineNew, lines = "";

        while (in.hasNextLine()) {
            lineNew = in.nextLine();
            if (lineNew.isEmpty()) {
                break;
            }
            lines += lineNew;
        }

        String target = in.nextLine();

        String[] seq_list = lines.split("!|\\.|\\?");

        for (String sentence : seq_list) {
            if (Arrays.asList(sentence.split(" ")).contains(target)) {
                System.out.println(sentence);
            }
        }
    }
}
