// 211490297 Gal Mansuryan
package Game.Levels;

import Movement.Sprite;
import Movement.Velocity;
import Shapes.Absract.Point;
import Shapes.Absract.Rectangle;
import Shapes.GameItems.Block;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * The OGLevel class implements the LevelInformation interface
 * to define the properties and behavior of level 1 in the game.
 */
public class OGLevel implements LevelInformation {
    private Color[] palette = {new Color(210, 175, 230), new Color(216, 180, 216),
            new Color(219, 182, 255), new Color(224, 176, 255),
            new Color(201, 160, 220), new Color(200, 162, 200)};

    @Override
    public int numberOfBalls() {
        return 0;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        return null;
    }

    @Override
    public int paddleSpeed() {
        return 0;
    }

    @Override
    public int paddleWidth() {
        return 0;
    }

    @Override
    public String levelName() {
        return null;
    }

    @Override
    public Sprite getBackground() {
        return null;
    }

    @Override
    public List<Block> blocks() {
        List<Block> gameBlocks = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 12 - i; j++) {
                gameBlocks.add(new Block(new Rectangle(new Point(720 - j * 60, 100 + i * 30),
                        60, 30, this.palette[i], 'b')));
            }
        }
        return gameBlocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 0;
    }
}
