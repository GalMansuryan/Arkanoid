// 211490297 Gal Mansuryan
package Game.Levels;

import Game.Backgrounds.BackgroundLevel3;
import Movement.Sprite;
import Movement.Velocity;
import Shapes.Absract.Point;
import Shapes.Absract.Rectangle;
import Shapes.GameItems.Block;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * The GameLevel3 class implements the LevelInformation interface
 * to define the properties and behavior of level 1 in the game.
 */
public class GameLevel3 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        velocityList.add(new Velocity(3, 4));
        velocityList.add(new Velocity(-3, 6));
        return velocityList;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 130;
    }

    @Override
    public String levelName() {
        return "level 3";
    }

    @Override
    public Sprite getBackground() {
        return new BackgroundLevel3();
    }

    @Override
    public List<Block> blocks() {
        List<Block> spaceShip = new ArrayList<>();
        spaceShip.add(new Block(new Rectangle(new Point(365, 100), 30, 15, Color.darkGray, 'b')));
        spaceShip.add(new Block(new Rectangle(new Point(350, 115), 60, 30, Color.gray, 'b')));
        for (int i = 0; i < 2; i++) {
            spaceShip.add(new Block(new Rectangle(new Point(320 + 60 * i, 145),
                    60, 30, Color.gray, 'b')));
        }
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 3; i++) {
                if ((j == 1 && i == 1) || (j == 2 && i == 1)) {
                    spaceShip.add(new Block(new Rectangle(new Point(290 + 60 * i, 175 + 30 * j),
                            60, 30, Color.blue, 'b')));
                } else {
                    spaceShip.add(new Block(new Rectangle(new Point(290 + 60 * i, 175 + 30 * j),
                            60, 30, Color.gray, 'b')));
                }

            }
        }
        spaceShip.add(new Block(new Rectangle(new Point(260, 200),
                30, 90, Color.red, 'b')));
        spaceShip.add(new Block(new Rectangle(new Point(470, 200),
                30, 90, Color.red, 'b')));
        spaceShip.add(new Block(new Rectangle(new Point(335, 355),
                90, 20, Color.orange, 'b')));
        spaceShip.add(new Block(new Rectangle(new Point(350, 375),
                60, 20, Color.orange, 'b')));
        spaceShip.add(new Block(new Rectangle(new Point(365, 395),
                30, 20, Color.orange, 'b')));
        return spaceShip;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 27;
    }
}
