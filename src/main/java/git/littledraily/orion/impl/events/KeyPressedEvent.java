package git.littledraily.orion.impl.events;

import git.littledraily.orion.api.event.Event;

/**
 * @author LittleDraily
 * @since 11/12/20
 */

public class KeyPressedEvent extends Event {
    final int key;

    public KeyPressedEvent(int key) {
        this.key = key;
    }
}
