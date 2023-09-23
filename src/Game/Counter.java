// 211490297 Gal Mansuryan
package Game;

/**
 * The Game.Counter class represents a simple counter that can be incremented,
 * decremented, and queried for its current value.
 */
public class Counter {
    private int counter = 0;
    /**
     * Constructs a Game.Counter object with the specified initial value.
     *
     * @param number The initial value of the counter.
     */
    public Counter(int number) {
        this.counter = number;
    }
    /**
     * Increases the counter by the specified amount.
     *
     * @param number The amount to increase the counter by.
     */
    public void increase(int number) {
        this.counter += number;
    }

    /**
     * Decreases the counter by the specified amount.
     *
     * @param number The amount to decrease the counter by.
     */
    public void decrease(int number) {
        this.counter -= number;
    }

    /**
     * Returns the current value of the counter.
     *
     * @return The current value of the counter.
     */
    public int getValue() {
        return this.counter;
    }
    /**
     * Returns a string representation of the counter.
     *
     * @return A string representation of the counter.
     */
    public String toString() {
        return Integer.toString(counter);
    }
}