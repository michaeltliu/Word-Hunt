import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.TreeMap;

public class Visualizer implements KeyListener {
    public class Panel extends JPanel {
        public void paint(Graphics g) {
            super.paint(g);
            paintGrid(g);
            paintCurrentPath(g);
        }

        private void paintGrid(Graphics g) {
            
        }

        private void paintCurrentPath(Graphics g) {

        }
    }

    private ArrayList<ArrayList<Integer>> paths;
    private String input;
    private JFrame frame;
    private Panel panel;
    private int whichPath;

    public Visualizer(TreeMap<String, ArrayList<Integer>> paths, String input) {
        this.paths = new ArrayList<>(paths.values());
        this.input = input;

        frame = new JFrame("Word Hunt Solver");
        panel = new Panel();

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(this);

        whichPath = 0;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

}
