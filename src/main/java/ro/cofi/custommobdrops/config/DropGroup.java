package ro.cofi.custommobdrops.config;

import java.util.ArrayList;
import java.util.List;

public class DropGroup extends Drop {

    private enum Mode {
        CHANCE, // percentage
        WEIGHT
    }

    private Mode mode = Mode.CHANCE;
    private int rollsMin = 1;
    private int rollsMax = 1;
    private List<Drop> drops = new ArrayList<>();

    @Override
    protected boolean isValid() {
        return !drops.isEmpty();
    }
}
