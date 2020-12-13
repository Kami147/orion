package git.littledraily.orion;

import git.littledraily.eventsystem.bus.EventBus;
import git.littledraily.eventsystem.bus.EventManager;
import git.littledraily.orion.api.event.EventProcessor;
import git.littledraily.orion.api.module.ModuleManager;
import git.littledraily.orion.impl.gui.click.ClickGUI;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(
        modid = "orion",
        name = "Orion",
        version = OrionMod.VERSION
)
public class OrionMod {
    public static final String VERSION = "1.0";

    public static final EventBus EVENT_BUS = new EventManager();
    public static ClickGUI clickGUI;
    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        ModuleManager.init();
        new EventProcessor();
        clickGUI = new ClickGUI();
    }
}
