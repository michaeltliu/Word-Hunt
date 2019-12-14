import java.io.IOException;
import java.util.*;

public class Solver {
    private String[][] letters;
    private Words myWords;

    public Solver(String input) throws IOException {
        letters = new String[4][4];
        for (int i = 0; i < 4; i ++) {
            for (int j = 0; j < 4; j ++) {
                letters[i][j] = Character.toString(input.charAt(i * 4 + j));
            }
        }
        myWords = new Words();
    }

    public TreeMap<String, ArrayList<Integer>> solve() {
        // contains all confirmed words
        // sorts entries by length of the word
        TreeMap<String, ArrayList<Integer>> words = new TreeMap<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        if (o1.equals(o2)) return 0;
                        if (o1.length() > o2.length()) return -1;
                        return 1;
                    }
                }
        );
        // contains phrases in the process of being built
        Queue<String> phrases = new LinkedList<>();
        // contains the path through the letter matrix corresponding to each phrase
        Queue<ArrayList<Integer>> paths = new LinkedList<>();

        // adds first letters
        for (int i = 0; i < 16; i ++) {
            phrases.add(letters[i / 4][i % 4]);
            ArrayList<Integer> p = new ArrayList<>();
            p.add(i);
            paths.add(p);
        }

        // check up to 7 layers deep
        while (!paths.isEmpty()) {
            ArrayList<Integer> pathCopy = new ArrayList<>(paths.remove());
            String phrase = phrases.remove();

            if (myWords.isWord(phrase) && phrase.length() > 1) words.put(phrase, pathCopy);

            int currI = pathCopy.get(pathCopy.size() - 1) / 4;
            int currJ = pathCopy.get(pathCopy.size() - 1) % 4;
            int[] delta = new int[] {-1, 0, 1};

            for (int i = 0; i < 9; i ++) {
                int newI = currI + delta[i / 3];
                int newJ = currJ + delta[i % 3];
                if (inBounds(newI, newJ) && !pathCopy.contains(4 * newI + newJ)) {
                    String newPhrase = phrase + letters[newI][newJ];
                    ArrayList<Integer> newPath = new ArrayList<>(pathCopy);
                    newPath.add(4 * newI + newJ);

                    if (newPath.size() < 7) {
                        phrases.add(newPhrase);
                        paths.add(newPath);
                    }
                    else if (myWords.isWord(newPhrase)){
                        words.put(newPhrase, newPath);
                    }
                }
            }
        }

        // modifies path to be in readable row-column format
        for (ArrayList<Integer> list : words.values()) {
            for (int i = 0; i < list.size(); i ++) {
                int x = list.get(i);
                list.set(i, (x/4 + 1) * 10 + (x%4 + 1));
            }
        }

        return words;
    }

    private boolean inBounds(int i, int j) {
        return (i >= 0 && i < 4 && j >= 0 && j < 4);
    }
}