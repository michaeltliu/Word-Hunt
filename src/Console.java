import java.io.IOException;
import java.util.*;

public class Console {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter 16 letters one after another. " +
                "From left to right across rows, then from top to bottom down columns.");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Solver solver = new Solver(input);
        TreeMap<String, ArrayList<Integer>> map = solver.solve();
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            System.out.println(entry);
        }
        Visualizer visualizer = new Visualizer(map, input);
    }
}