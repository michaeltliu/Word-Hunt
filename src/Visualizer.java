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
            for (int i = 0; i < 4; i ++) {
                for (int j = 0; j < 4; j ++) {
                    g.drawRect(50 + 100*j, 50 + 100*i, 100, 100);
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
                    g.drawString(Character.toString(input.charAt(4*i + j)), 95 + 100*j, 100 + 100*i);
                }
            }
        }

        private void paintCurrentPath(Graphics g) {
            ArrayList<Integer> currentPath = paths.get(whichPath);
            int startingI = currentPath.get(0) / 10 - 1;
            int startingJ = (currentPath.get(0) % 10) - 1;
            g.drawOval(75 + startingJ * 100, 75 + startingI * 100, 50, 50);
            for (int i = 0; i < currentPath.size() - 1; i ++) {
                int prevI = currentPath.get(i) / 10 - 1;
                int prevJ = (currentPath.get(i) % 10) - 1;
                int nextI = (currentPath.get(i + 1) / 10) - 1;
                int nextJ = (currentPath.get(i + 1) % 10) - 1;
                g.drawLine(100 + prevJ * 100, 100 + prevI * 100,
                        100 + nextJ * 100, 100 + nextI * 100);
            }
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

        frame.setSize(500, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(this);

        whichPath = this.paths.size() - 1;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            whichPath --;
            panel.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

}
