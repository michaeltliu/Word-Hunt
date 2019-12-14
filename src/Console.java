import java.io.IOException;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the letters one after another. " +
                "From left to right across rows, then from top to bottom down columns.");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Solver solver = new Solver(input);
        System.out.println(solver.solve());
    }
}