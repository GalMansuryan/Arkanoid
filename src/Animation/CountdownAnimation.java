// 211490297 Gal Mansuryan
package Animation;

import Movement.SpriteCollection;
import biuoop.DrawSurface;

import java.awt.Color;


/**
 * The CountdownAnimation class displays the given game screen for a specified duration,
 * along with a countdown from a given number to 1.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean running;
    /**
     * Constructs a new CountdownAnimation object.
     *
     * @param numOfSeconds the duration of the animation in seconds
     * @param countFrom    the number to count down from
     * @param gameScreen   the game screen to display
     */
    public CountdownAnimation(double numOfSeconds,
                              int countFrom,
                              SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.running = true;
    }
    /**
     * Performs one frame of the animation, drawing the game screen and the countdown number on the given DrawSurface.
     *
     * @param d the DrawSurface to draw on
     */
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        if (countFrom == 1) {
            this.running = false;
        }
        d.setColor(Color.black);
        d.drawText(365, 290, Integer.toString(countFrom), 50);
        countFrom -= numOfSeconds;
    }
    /**
     * Determines whether the animation should stop or continue.
     *
     * @return true if the animation should stop, false otherwise
     */
    public boolean shouldStop() {
        return !this.running;
    }
}