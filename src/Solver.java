import java.util.*;

public class Solver {
    private final int height;       // keeping two variables in case I decide to expand
    private final int width;        // to general rectangles
    private String[][] letters;

    public Solver(String input) {
        height = (int) Math.sqrt(input.length());
        width = height;
        letters = new String[height][width];
        for (int i = 0; i < height; i ++) {
            for (int j = 0; j < width; j ++) {
                letters[i][j] = Character.toString(input.charAt(i * width + j));
            }
        }
    }

    public ArrayList<String> solve() {
        HashMap<ArrayList<Integer>, ArrayList<String>> words = new HashMap<>();
        Queue<String> phrases = new LinkedList<>();
        Queue<ArrayList<Integer>> paths = new LinkedList<>();
        for (int i = 0; i < width*height; i ++) {
            phrases.add(letters[i / width][i % width]);
            ArrayList<Integer> p = new ArrayList<>();
            p.add(i);
            paths.add(p);
        }

        // check up to 7 layers deep
        while (paths.peek().size() <= 7) {
            ArrayList<Integer> copy = new ArrayList<>(paths.remove());

        }
    }
}