import javax.swing.*;

public class App {
    static Game game;
    static JFrame frame;
    static Timer timer;

    public static void main(String[] args) throws Exception {
        frame = new JFrame("CrateStacker");
        game = new Game();
        timer = new Timer(0, null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Constants.WIDTH, Constants.HEIGHT);
        frame.setResizable(false);

        frame.add(game);

        frame.setVisible(true);

        timer.setRepeats(true);
        timer.setDelay(1000 / 60);
        timer.addActionListener(e -> {
            game.repaint();
        });

        timer.start();

    }
}
