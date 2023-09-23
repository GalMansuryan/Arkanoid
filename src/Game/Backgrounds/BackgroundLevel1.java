// 211490297 Gal Mansuryan
package Game.Backgrounds;

import Movement.Sprite;
import Shapes.Absract.Circle;
import Shapes.Absract.Point;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * The BackgroundLevel1 class represents the background of Level 1 in the game.
 */
public class BackgroundLevel1 implements Sprite {
    private List<Circle> circles = new ArrayList();
    /**
     * Constructs a new BackgroundLevel1 object.
     * Generates the circles that make up the background.
     */
    public BackgroundLevel1() {
        int radius = 35;
        int r1 = 255;
        int g1 = 255;
        int b1 = 204;
        int r2 = 255;
        int g2 = 229;
        int b2 = 204;
        Point center = new Point(380, 270);
        for (int i = 0; i < 100; i++) {
            circles.add(new Circle(radius, center, new Color(r1, g1, b1)));
            radius += 3;
            circles.add(new Circle(radius, center, new Color(r2, g2, b2)));
            b1 -= 2;
            b2 -= 2;
            g2 -= 2;
            radius += 3;
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        for (int i = 199; i >= 0; i--) {
            circles.get(i).drawOn(d);
        }
    }

    @Override
    public void timePassed() {

    }
}
