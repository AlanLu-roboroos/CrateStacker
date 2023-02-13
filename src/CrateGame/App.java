package CrateGame;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class App {
    static Game game;
    static JFrame frame;
    static Timer timer, spawnTimer;
    static Random random = new Random();

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
        timer.setDelay(1000 / 240);
        timer.addActionListener(e -> {
            game.repaint();
        });

        timer.start();

        spawnTimer = new Timer(0, null);
        spawnTimer.setRepeats(true);
        spawnTimer.setDelay(500);
        spawnTimer.addActionListener(e -> {
            while (game.spawnable() && !game.spawnCrate(random.nextInt(8))) {
            }
            // game.spawnCrate(0);
        });

        spawnTimer.start();

    }
}
