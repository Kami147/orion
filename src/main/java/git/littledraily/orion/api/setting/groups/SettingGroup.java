package git.littledraily.orion.api.setting.groups;

import git.littledraily.orion.api.setting.Setting;

import java.util.ArrayList;
import java.util.List;

public class SettingGroup {
    public final String name;
    public boolean sectionExpanded;

    final List<Setting> settings = new ArrayList<>(1);

    public SettingGroup(String name) {
        this.name = name;
        this.sectionExpanded = false;
    }

    public Setting get(String name) {
        for (Setting setting : settings) {
            if (setting.getName().equals(name)) return setting;
        }

        return null;
    }
    public Setting add(Setting setting) {
        settings.add(setting);
        return setting;
    }

    public List<Setting> getSettings() {
        return settings;
    }
}
