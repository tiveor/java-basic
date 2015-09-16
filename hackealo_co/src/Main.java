import java.util.*;

/**
 * User: tiveor
 * Date: 9/16/15
 * Time: 14:27
 */
public class Main {
    public static void main(String[] args) {
        String letters = "BSLPJTvWbAwZGHUcJYrnIjBoGmaMCByZASyqboladgPAqPstgcgdwKSDtXYVpvhiNZCeldsdMiSFpCPzRJJruJCeqUVPmYwuTIgbYQtXUzcxWfEaRcVHomlJSmSrdhwehKAJYurBfMVaoykjsYYLdflojDmllDlNQFaCUnoBLQmCjGUCIIQOQmCHiwYqfoSfdDbrbKT";
        letters = letters.toLowerCase();

        Map<Character, Letter> letterMap = new HashMap<Character, Letter>();

        for (int i = 0; i < letters.length(); i++) {
            char character = letters.charAt(i);
            if (letterMap.containsKey(character)) {
                letterMap.get(character).inc();
            } else {
                letterMap.put(character, new Letter(character));
            }
        }

        ArrayList<Letter> sortedLetters = new ArrayList<Letter>(letterMap.values());
        Collections.sort(sortedLetters, new CustomComparator());

        System.out.println("====================");
        for (Letter l : sortedLetters) {
//            System.out.println(l.toString());
            System.out.print(l.getCharacter());
        }
        System.out.println("\n====================");


    }

    public static class CustomComparator implements Comparator<Letter> {
        @Override
        public int compare(Letter o1, Letter o2) {
            return o1.compareTo(o2);
        }
    }
}
