// 211490297 Gal Mansuryan
package Score;

import Game.Counter;
import Game.Levels.GameLevel;
import Movement.Sprite;
import Shapes.Absract.Point;
import Shapes.Absract.Rectangle;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The Score.ScoreIndicator class implements the Movment.Sprite interface
 * and is responsible for displaying the current score on the game screen.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;
    private String levelName;

    private Rectangle scoreBlock = new Rectangle(new Point(0, 0), 800, 20,
            Color.white, 't');

    /**
     * Constructs a ScoreIndicator object with the specified score counter and level name.
     *
     * @param score     The counter representing the score.
     * @param levelName The name of the level.
     */
    public ScoreIndicator(Counter score, String levelName) {
        this.levelName = levelName;
        this.score = score;
    }

    @Override
    public void drawOn(DrawSurface d) {
        scoreBlock.drawOn(d);
        String scoreTitle = "Score: " + score.toString();
        String levelTitle = "Level Name: " + levelName;
        d.setColor(Color.black);
        d.drawText(30, 15, levelTitle, 12);
        d.drawText(730, 15, scoreTitle, 12);

    }

    /**
     * Adds the score indicator to the specified game.
     *
     * @param g The game to add the score indicator to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    @Override
    public void timePassed() {

    }
}
