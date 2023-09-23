// 211490297 Gal Mansuryan
package Animation;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;


/**
 * The AnimationRunner class is responsible for running animations and managing the game's frame rate.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper = new Sleeper();
    /**
     * Constructs a new AnimationRunner object.
     *
     * @param framesPerSecond the desired frame rate for the animations
     * @param gui             the GUI object for the game
     */
    public AnimationRunner(int framesPerSecond, GUI gui) {
        this.framesPerSecond = framesPerSecond;
        this.gui = gui;
    }
    /**
     * Sets the frame rate for the animations.
     *
     * @param fps the new frames per second value
     */
    public void setFramesPerSecond(int fps) {
        this.framesPerSecond = fps;
    }
    /**
     * Runs the given animation.
     *
     * @param animation the Animation object to run
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);

            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}