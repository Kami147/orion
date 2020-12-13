package git.littledraily.orion.api.module;

import git.littledraily.orion.OrionMod;
import git.littledraily.orion.api.setting.Setting;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LittleDraily
 * @since 10/12/20
 */

public class Module {
    protected Minecraft mc = Minecraft.getMinecraft();

    Category category;
    String name;
    String description;
    boolean enabled;
    int key;

    protected final List<Setting> settings = new ArrayList<>();

    public Module(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
        enabled = false;
        key = Keyboard.KEY_NONE;
    }

    public Module(String name, Category category) {
        this.name = name;
        this.description = null;
        this.category = category;
        enabled = false;
        key = Keyboard.KEY_NONE;
    }

    public void toggle() {
        enabled = !enabled;
        onToggle();
        if (enabled) {
            enableEvent();
        } else {
            disableEvent();
        }
    }

    public void enableEvent() {
        OrionMod.EVENT_BUS.subscribe(this);
        onEnable();
    }

    public void disableEvent() {
        OrionMod.EVENT_BUS.unsubscribe(this);
        onDisable();
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Category getCategory() {
        return category;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public List<Setting> getSettings() {
        return this.settings;
    }

    protected <E extends Setting> E addSetting(final E setting) {
        this.settings.add(setting);
        return setting;
    }

    public Setting getSettingByName(final String name) {
        return this.settings.stream().filter(setting -> setting.getName().equalsIgnoreCase(name)).findAny().orElse(null);
    }
    public void onToggle() {}
    public void onEnable(){}
    public void onDisable(){}
    public void onUpdate(){}
}