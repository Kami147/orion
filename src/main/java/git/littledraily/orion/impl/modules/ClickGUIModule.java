package git.littledraily.orion.impl.modules;

import git.littledraily.orion.OrionMod;
import git.littledraily.orion.api.module.Category;
import git.littledraily.orion.api.module.Module;
import org.lwjgl.input.Keyboard;

public class ClickGUIModule extends Module {
    public ClickGUIModule() {
        super("ClickGUI", "Opens the ClickGUI", Category.CLIENT, Keyboard.KEY_Y);
    }

    @Override
    public void onEnable() {
        mc.displayGuiScreen(OrionMod.clickGUI);
        toggle();
    }
}
