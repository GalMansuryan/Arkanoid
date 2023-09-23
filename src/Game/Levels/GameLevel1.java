// 211490297 Gal Mansuryan
package Game.Levels;

import Game.Backgrounds.BackgroundLevel1;

import Movement.Sprite;
import Movement.Velocity;
import Shapes.Absract.Point;
import Shapes.Absract.Rectangle;
import Shapes.GameItems.Block;
import Game.Levels.NormanLevel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * The GameLevel1 class implements the LevelInformation interface
 * to define the properties and behavior of level 1 in the game.
 */
public class GameLevel1 implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l = new ArrayList<>();
        l.add(new Velocity(0, 5));
        return l;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "level 1";
    }

    @Override
    public Sprite getBackground() {
        return new BackgroundLevel1();
    }

    @Override
    public List<Block> blocks() {
        List<Block> l = new ArrayList<>();
        l.add(new Block(new Rectangle(new Point(355, 245), 50, 50, new Color(153, 0, 0),
                'b')));
        return l;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
