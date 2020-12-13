package git.littledraily.orion.impl.events;

import git.littledraily.orion.api.event.Event;
import net.minecraft.entity.MoverType;

/**
 * @author LittleDraily
 * @since 11/12/20
 */

public class PlayerMoveEvent extends Event {
    MoverType Type;
    double X;
    double Y;
    double Z;

    public PlayerMoveEvent(MoverType type, double x, double y, double z) {
        Type = type;
        X = x;
        Y = y;
        Z = z;
    }

    public MoverType getType() {
        return Type;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public double getZ() {
        return Z;
    }

    public void setX(double x) {
        X = x;
    }

    public void setY(double y) {
        Y = y;
    }

    public void setZ(double z) {
        Z = z;
    }

}
