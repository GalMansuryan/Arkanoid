// 211490297 Gal Mansuryan

import Animation.AnimationRunner;
import Game.GameFlow;
import Game.Levels.GameLevel1;
import Game.Levels.GameLevel2;
import Game.Levels.GameLevel3;
import Game.Levels.LevelInformation;
import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;


/**
 * The main class of the Ass3 game.
 * The game starts by running the main method of this class.
 * It creates a new instance of the Game and runs it.
 *
 * @author Gal Mansuryan
 */
public class TheGame {
    /**
     * The main method of the game. Creates a new instance of the Game class,
     * initializes it, and runs it.
     *
     * @param args an array of command-line arguments for the level sequence.
     */
    public static void main(String[] args) {
        // Create a GUI object with the specified dimensions
        GUI gui = new GUI("game", 800, 600);

        // Create a list to store the levels
        List<LevelInformation> levels = new ArrayList<>();

        int level;
        for (String s : args) {
            try {
                level = Integer.parseInt(s);
                if (level == 1) {
                    levels.add(new GameLevel1());
                } else if (level == 2) {
                    levels.add(new GameLevel2());
                } else if (level == 3) {
                    levels.add(new GameLevel3());
                }
            } catch (NumberFormatException e) {
                // Ignore non-integer arguments
                System.out.println(" ");
            }
        }
        if (levels.isEmpty()) {
            levels.add(new GameLevel1());
            levels.add(new GameLevel2());
            levels.add(new GameLevel3());
        }
        // Create an AnimationRunner object with a target frame rate and the G
        AnimationRunner animationRunner = new AnimationRunner(60, gui);

        // Create a GameFlow object with the AnimationRunner and GUI
        GameFlow gameFlow = new GameFlow(animationRunner, gui);

        // Run the levels using the GameFlow object
        gameFlow.runLevels(levels);

        // Close the GUI
        gui.close();
    }
}
