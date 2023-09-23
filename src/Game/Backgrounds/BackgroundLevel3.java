// 211490297 Gal Mansuryan
package Game.Backgrounds;

import Movement.Sprite;
import Shapes.Absract.Point;
import Shapes.Absract.Rectangle;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * The BackgroundLevel3 class represents the background of Level 3 in the game.
 */
public class BackgroundLevel3 implements Sprite {
    private List<Rectangle> sky = new ArrayList<>();
    private List<Rectangle> clouds = new ArrayList<>();
    private List<Rectangle> stars = new ArrayList<>();
    /**
     * Constructs a new BackgroundLevel3 object.
     * Generates the rectangles that make up the sky, clouds, and stars in the background.
     */
    public BackgroundLevel3() {
        for (int i = 0; i < 170; i++) {
            sky.add(new Rectangle(new Point(20, 580 - i * 4), 760, 4,
                    new Color(0, 0, 204 - i), 'f'));
        }


        clouds.add(new Rectangle(new Point(30, 530), 50, 5,
                new Color(204, 204, 255), 'f'));
        clouds.add(new Rectangle(new Point(50, 525), 50, 5,
                new Color(204, 204, 255), 'f'));
        clouds.add(new Rectangle(new Point(230, 510), 50, 5,
                new Color(204, 204, 255), 'f'));
        clouds.add(new Rectangle(new Point(250, 505), 50, 5,
                new Color(204, 204, 255), 'f'));
        clouds.add(new Rectangle(new Point(600, 450), 50, 5,
                new Color(204, 204, 255), 'f'));
        clouds.add(new Rectangle(new Point(620, 445), 50, 5,
                new Color(204, 204, 255), 'f'));
        clouds.add(new Rectangle(new Point(500, 360), 50, 5,
                new Color(204, 204, 255), 'f'));
        clouds.add(new Rectangle(new Point(520, 355), 50, 5,
                new Color(204, 204, 255), 'f'));
        clouds.add(new Rectangle(new Point(40, 385), 50, 5,
                new Color(204, 204, 255), 'f'));
        clouds.add(new Rectangle(new Point(20, 390), 50, 5,
                new Color(204, 204, 255), 'f'));
        clouds.add(new Rectangle(new Point(500, 530), 50, 5,
                new Color(204, 204, 255), 'f'));
        clouds.add(new Rectangle(new Point(480, 535), 50, 5,
                new Color(204, 204, 255), 'f'));
        clouds.add(new Rectangle(new Point(200, 335), 50, 5,
                new Color(204, 204, 255), 'f'));
        clouds.add(new Rectangle(new Point(180, 340), 50, 5,
                new Color(204, 204, 255), 'f'));
        Random rnd = new Random();
        for (int i = 0; i < 80; i++) {
            stars.add(new Rectangle(new Point(rnd.nextDouble(20, 780), rnd.nextDouble(40, 300)),
                    3, 3, new Color(255, 255, 220), 'b'));
        }

    }

    @Override
    public void drawOn(DrawSurface d) {
        for (Rectangle rectangle : sky) {
            rectangle.drawOn(d);
        }
        for (Rectangle rectangle : clouds) {
            rectangle.drawOn(d);
        }
        for (Rectangle rectangle : stars) {
            rectangle.drawOn(d);
        }
    }

    @Override
    public void timePassed() {
    }
}
