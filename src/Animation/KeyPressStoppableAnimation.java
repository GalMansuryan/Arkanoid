// 211490297 Gal Mansuryan
package Animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * The KeyPressStoppableAnimation class represents an animation that can be stopped by pressing a specific key.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;
    /**
     * Constructs a new KeyPressStoppableAnimation object.
     *
     * @param sensor    the KeyboardSensor used to check key presses
     * @param key       the key that stops the animation when pressed
     * @param animation the animation to be stopped
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.key = key;
        this.sensor = sensor;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
        if (this.sensor.isPressed(key)) {
            if (!isAlreadyPressed) {
                animation = null;
            }
        } else {
            isAlreadyPressed = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return animation == null;
    }
}
