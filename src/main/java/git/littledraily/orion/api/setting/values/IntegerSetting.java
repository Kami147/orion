package git.littledraily.orion.api.setting.values;

import git.littledraily.orion.api.setting.Setting;

public class IntegerSetting extends Setting {
    int min;
    int value;
    int max;

    public IntegerSetting(String name, int min, int value, int max) {
        super(name);
        this.min = min;
        this.value = value;
        this.max = max;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}