// 211490297 Gal Mansuryan
package Animation;

import biuoop.DrawSurface;
/**
 * The PauseScreen class represents the animation displayed when the game is paused.
 * It prompts the player to press space to continue.
 */
public class PauseScreen implements Animation {
    /**
     * Performs one frame of the animation, drawing the "paused" message on the given DrawSurface.
     *
     * @param d the DrawSurface to draw on
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(20, d.getHeight() / 2, "paused -- press space to continue", 32);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }

}