package git.littledraily.orion.api.setting.values;

import git.littledraily.orion.api.setting.Setting;


import java.util.Arrays;
import java.util.List;

public class ModesSetting extends Setting {
    private List<String> values;
    private int place;

    public ModesSetting(String name, String defaulval, String... values) {
        super(name);
        this.values = Arrays.asList(values);
        this.place = Arrays.asList(values).indexOf(defaulval);
    }

    public String getValue() {
        return values.get(place);
    }

    public void forward() {
        if (place < values.size() - 1) {
            place++;
        } else {
            place = 0;
        }
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getPlace() {
        return place;
    }
}
