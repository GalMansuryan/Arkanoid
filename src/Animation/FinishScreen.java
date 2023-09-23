// 211490297 Gal Mansuryan
package Animation;

import biuoop.DrawSurface;
/**
 * The FinishScreen class represents the animation displayed at the end of the game.
 * It displays whether the player won or lost, along with their score.
 */
public class FinishScreen implements Animation {
    private int score;
    private boolean won;
    /**
     * Constructs a new FinishScreen object.
     *
     * @param won   true if the player won the game, false otherwise
     * @param score the player's score
     */
    public FinishScreen(boolean won, int score) {
        this.won = won;
        this.score = score;
    }
    /**
     * Performs one frame of the animation, drawing the appropriate message and score on the given DrawSurface.
     *
     * @param d the DrawSurface to draw on
     */
    public void doOneFrame(DrawSurface d) {
        if (won) {
            d.drawText(230, d.getHeight() / 2, "You Win!", 32);
        } else {
            d.drawText(230, d.getHeight() / 2, "Game Over", 32);
        }
        d.drawText(230, d.getHeight() / 2 + 50, "Your score is " + score, 32);

    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}
