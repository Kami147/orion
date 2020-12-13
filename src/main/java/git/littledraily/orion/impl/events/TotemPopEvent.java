package git.littledraily.orion.impl.events;

import git.littledraily.orion.api.event.Event;
import net.minecraft.entity.Entity;

/**
 * @author LittleDraily
 * @since 11/12/20
 */

public class TotemPopEvent extends Event {
    public final Entity entity;

    public TotemPopEvent(Entity entity) {
        this.entity = entity;
    }
}
