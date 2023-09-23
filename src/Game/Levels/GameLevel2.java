// 211490297 Gal Mansuryan
package Game.Levels;

import Game.Backgrounds.BackgroundLevel2;

import Movement.Sprite;
import Movement.Velocity;
import Shapes.Absract.Point;
import Shapes.Absract.Rectangle;
import Shapes.GameItems.Block;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The GameLevel2 class implements the LevelInformation interface
 * to define the properties and behavior of level 1 in the game.
 */
public class GameLevel2 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 5;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> balls = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            balls.add(new Velocity(-2 + i, 5));
        }
        return balls;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 300;
    }

    @Override
    public String levelName() {
        return "Level 2";
    }

    @Override
    public Sprite getBackground() {
        return new BackgroundLevel2();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            if (i % 2 == 0) {
                blocks.add(new Block(new Rectangle(new Point(25 + i * 50, 280), 50, 30,
                        new Color(180, 95, 218), 'b')));
            } else {
                blocks.add(new Block(new Rectangle(new Point(25 + i * 50, 280), 50, 30,
                        new Color(157, 104, 250), 'b')));
            }

        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
}
