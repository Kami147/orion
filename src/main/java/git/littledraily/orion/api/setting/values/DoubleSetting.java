package git.littledraily.orion.api.setting.values;

import git.littledraily.orion.api.setting.Setting;

public class DoubleSetting extends Setting {
    double min;
    double value;
    double max;

    public DoubleSetting(String name, double min, double value, double max) {
        super(name);
        this.min = min;
        this.value = value;
        this.max = max;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }
}