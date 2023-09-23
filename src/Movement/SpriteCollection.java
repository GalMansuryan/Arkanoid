// 211490297 Gal Mansuryan
package Movement;

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * The Movment.SpriteCollection class represents a collection of sprites.
 * It can add sprites to the collection, and notify all sprites of the passage of time,
 * and draw all sprites on the screen.
 */
public class SpriteCollection {
    private List<Sprite> sprites = new ArrayList<Sprite>();

    /**
     * Add a sprite to the collection.
     *
     * @param s the sprite to add
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }
    /**
     * Removes the specified sprite from the list of sprites.
     *
     * @param s The sprite to be removed.
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }

    /**
     * Notify all sprites in the collection that time has passed.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spriteList = new ArrayList<>(this.sprites);
        for (Sprite sprite : spriteList) {
            sprite.timePassed();
        }
    }

    /**
     * Draw all sprites in the collection on the given surface.
     *
     * @param d the surface on which to draw the sprites
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite : this.sprites) {
            sprite.drawOn(d);
        }
    }
}