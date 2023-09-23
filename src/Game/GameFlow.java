// 211490297 Gal Mansuryan
package Game;

import Animation.Animation;
import Animation.AnimationRunner;
import Animation.FinishScreen;
import Animation.KeyPressStoppableAnimation;
import Game.Levels.GameLevel;
import Game.Levels.LevelInformation;
import Score.ScoreTrackingListener;
import biuoop.GUI;
import biuoop.KeyboardSensor;


import java.util.List;
/**
 * The GameFlow class is responsible for managing the flow of the game.
 * It handles running levels, tracking scores, and displaying the finish screen.
 */
public class GameFlow {
    private GUI gui;
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboard;
    private ScoreTrackingListener score;
    private boolean win;
    /**
     * Constructs a new GameFlow object.
     *
     * @param animationRunner the AnimationRunner to run the animations
     * @param gui             the GUI object for the game
     */
    public GameFlow(AnimationRunner animationRunner, GUI gui) {
        this.animationRunner = animationRunner;
        score = new ScoreTrackingListener(new Counter(0));
        this.gui = gui;
        this.keyboard = this.gui.getKeyboardSensor();

    }
    /**
     * Runs the list of levels.
     *
     * @param levels the list of LevelInformation objects representing the levels to be played
     */
    public void runLevels(List<LevelInformation> levels) {
        win = true;
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, score, animationRunner, gui);
            level.run();
            if (level.getRemainingBalls() == 0) {
                win = false;
                break;
            }
        }
        Animation finishScreen = new FinishScreen(win, score.getScore().getValue());
        Animation keyAnimation = new KeyPressStoppableAnimation(keyboard, "space", finishScreen);
        this.animationRunner.run(keyAnimation);

    }
}
