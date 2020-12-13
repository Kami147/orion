package git.littledraily.orion.api.event;

import git.littledraily.eventsystem.cancellable.Cancellable;
import git.littledraily.eventsystem.event.EventState;

public class Event extends Cancellable {
    public EventState state = EventState.PRE;

    public void setState(EventState state) {
        this.state = state;
    }

    public EventState getState() {
        return state;
    }

    public void cancel(){
        setCancelled(true);
    }
}
