package git.littledraily.orion.api.util;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;
import static org.newdawn.slick.opengl.renderer.SGL.GL_TEXTURE_2D;

/**
 * @authors LittleDraily
 * @editor olliem5
 * @since 13/12/20
 */

public class OrionFontRenderer  {
    private final UnicodeFont font;

    public OrionFontRenderer(Font fontParm) {
        font = new UnicodeFont(fontParm);
        font.addAsciiGlyphs();
        font.getEffects().add(new ColorEffect(Color.WHITE));

        try {
            font.loadGlyphs();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public int drawString(String text, float x , float y, int color) {
        if (text == null) return color;

        GL11.glPushMatrix();
        GL11.glScaled(0.5, 0.5, 0.5);

        boolean blend = glIsEnabled(GL_BLEND), lighting = glIsEnabled(GL_LIGHTING), texture = glIsEnabled(GL_TEXTURE_2D);

        if (!blend) glEnable(GL_BLEND);
        if (lighting) glDisable(GL_LIGHTING);
        if (texture) glDisable(GL_TEXTURE_2D);

        x *= 2;
        y *= 2;

        font.drawString(x, y, text, new org.newdawn.slick.Color(color));
        if (texture) glEnable(GL_TEXTURE_2D);
        if (lighting) glEnable(GL_LIGHTING);
        if (!blend) glDisable(GL_BLEND);

        glPopMatrix();

        return color;
    }

    public int drawStringWithShadow(String text, float x, float y, int color) {
        drawString(text, x + 0.5F, y + 0.5F, 0x000000);
        return drawString(text, x, y, color);
    }

    public int getCharWidth(char c) {
        return getStringWidth(Character.toString(c));
    }

    public int getStringWidth(String string) {
        return font.getWidth(string) / 2;
    }

    public int getStringHeight(String string) {
        return font.getHeight(string) / 2;
    }
}