// 211490297 Gal Mansuryan
package Listeners;

/**
 * The Listeners.HitNotifier interface represents an object that can notify listeners of hit events.
 */
public interface HitNotifier {
    /**
     * Adds the specified listener to the list of listeners for hit events.
     *
     * @param hl The listener to be added.
     */
    void addHitListener(HitListener hl);
    /**
     * Removes the specified listener from the list of listeners for hit events.
     *
     * @param hl The listener to be removed.
     */
    void removeHitListener(HitListener hl);
}
