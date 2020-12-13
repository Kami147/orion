package git.littledraily.orion.impl.events;

import git.littledraily.orion.api.event.Event;
import net.minecraft.network.Packet;

/**
 * @author LittleDraily
 * @since 10/12/20
 */

public class PacketEvent extends Event {
    private final Packet packet;

    public PacketEvent(Packet packet) {
        super();
        this.packet = packet;
    }

    public Packet getPacket() {
        return packet;
    }

    public static class Receive extends PacketEvent {
        public Receive(Packet packet) {
            super(packet);
        }
    }

    public static class Send extends PacketEvent {
        public Send(Packet packet) {
            super(packet);
        }
    }
}
