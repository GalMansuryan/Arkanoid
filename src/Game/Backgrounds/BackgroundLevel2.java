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
 * The BackgroundLevel2 class represents the background of Level 2 in the game.
 */
public class BackgroundLevel2 implements Sprite {
    private List<Circle> waves = new ArrayList<>();
    private int screenEdge = 780;
    /**
     * Constructs a new BackgroundLevel2 object.
     * Generates the waves that make up the background.
     */
    public BackgroundLevel2() {
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 25; j++) {
                if (i % 2 == 0) {
                    waves.add(new Circle(19, new Point(20 + j * 38, 580 - i * 19),
                            new Color(164, 163, 217)));
                } else {
                    waves.add(new Circle(19, new Point(39 + j * 38, 580 - i * 19),
                            new Color(163, 156, 255)));
                }

            }
        }

    }

    @Override
    public void drawOn(DrawSurface d) {
        for (int i = waves.size() - 1; i >= 0; i--) {
            waves.get(i).drawOn(d);
        }
    }

    @Override
    public void timePassed() {
        int n = 0;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 21; j++) {
                if (waves.get(n + j).getCenter().getX() - waves.get(n + j).getRadius() >= screenEdge) {
                    if (i % 2 == 0) {
                        waves.get(n + j).setCenter(new Point(1, waves.get(n + j).getCenter().getY()));
                    } else {
                        waves.get(n + j).setCenter(new Point(1, waves.get(n + j).getCenter().getY()));
                    }

                } else {
                    waves.get(n + j).setCenter(new Point(waves.get(n + j).getCenter().getX() + 1,
                            waves.get(n + j).getCenter().getY()));
                }
            }
            n += 25;
        }


    }
}

