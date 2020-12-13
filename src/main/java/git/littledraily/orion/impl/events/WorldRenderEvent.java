package git.littledraily.orion.impl.events;

import git.littledraily.orion.api.event.Event;
import net.minecraft.client.renderer.RenderGlobal;

/**
 * @author LittleDraily
 * @since 11/12/20
 */

public class WorldRenderEvent extends Event {
    private final RenderGlobal context;
    private final float partialTicks;

    public WorldRenderEvent(RenderGlobal context, float partialTicks) {
        this.context = context;
        this.partialTicks = partialTicks;
    }

    public float getPartialTicks() {
        return partialTicks;
    }

    public RenderGlobal getContext() {
        return context;
    }
}
