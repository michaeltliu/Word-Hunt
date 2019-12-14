import java.io.*;
import java.util.HashSet;

public class Words {
    private HashSet<String> words;

    public Words() throws IOException {
        String path = "C:\\Users\\liumi\\IdeaProjects\\Word-Hunt\\data\\usa2.txt";
        BufferedReader scan = new BufferedReader(new FileReader(path));
        words = new HashSet<>();

        // Reads dictionary into set
        String word;
        while ((word = scan.readLine()) != null) {
            words.add(word);
        }
    }

    public boolean isWord(String w) {
        return words.contains(w);
    }

    public HashSet<String> getWords() {
        return words;
    }
}