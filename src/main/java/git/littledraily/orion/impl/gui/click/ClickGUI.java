package git.littledraily.orion.impl.gui.click;

import git.littledraily.orion.api.util.OrionFontRenderer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;

import java.awt.*;

public class ClickGUI extends GuiScreen {

    OrionFontRenderer fontRenderer = new OrionFontRenderer(new Font("Arial", 0, 18));

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        fontRenderer.drawString("cockandballs", 5,5, -1);
    }
}
