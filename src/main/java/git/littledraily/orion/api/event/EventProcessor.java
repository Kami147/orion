package git.littledraily.orion.api.event;

import git.littledraily.eventsystem.Listener;
import git.littledraily.orion.OrionMod;
import git.littledraily.orion.api.module.Module;
import git.littledraily.orion.api.module.ModuleManager;
import git.littledraily.orion.impl.events.*;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

import java.awt.*;

/**
 * @author LittleDraily
 * @since 11/12/20
 */

public class EventProcessor {
    protected Minecraft mc = Minecraft.getMinecraft();

    public EventProcessor() {
        initEvents();
    }

    private void initEvents() {
        MinecraftForge.EVENT_BUS.register(this);
        OrionMod.EVENT_BUS.subscribe(this);
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (mc.player != null && mc.world != null) {
            for (Module module : ModuleManager.getModules()) {
                if (module.isEnabled()) {
                    module.onUpdate();
                }
            }
            OrionMod.EVENT_BUS.post(new UpdateEvent());
        }
    }

    @SubscribeEvent
    public void onWorldRender(RenderWorldLastEvent event) {
        if (mc.world != null) {
            OrionMod.EVENT_BUS.post(new WorldRenderEvent(event.getContext(), event.getPartialTicks()));
        }
    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent event) {
        if (event.isCanceled()) return;
        OrionMod.EVENT_BUS.post(new GameOverlayRenderEvent());
    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onKey(InputEvent.KeyInputEvent event) {
        if (Keyboard.getEventKeyState()) {
            OrionMod.EVENT_BUS.post(new KeyPressedEvent(Keyboard.getEventKey()));
            for (Module module : ModuleManager.getModules()) {
                if (module.getKey() == Keyboard.KEY_NONE) return;
                if (module.getKey() == Keyboard.getEventKey()) {
                    module.toggle();
                }
            }
        }
    }

    @Listener
    public void onPacket(PacketEvent.Receive event) {
        if (event.getPacket() instanceof SPacketEntityStatus) {
            SPacketEntityStatus packet = (SPacketEntityStatus) event.getPacket();
            if (packet.getOpCode() == 35) {
                Entity entity = packet.getEntity(mc.world);
                if (entity == null) return;
                OrionMod.EVENT_BUS.post(new TotemPopEvent(entity));
            }
        }
    }
}
