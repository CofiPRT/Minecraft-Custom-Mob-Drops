package ro.cofi.custommobdrops.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DropItem extends Drop {

    private enum DurabilityType {
        FULL,
        FLAT,
        PERCENT
    }

    private String id;
    private int amountMin = 1;
    private int amountMax = 1;

    private String customName;
    private List<String> lore = new ArrayList<>();
    private Map<String, Integer> enchantments = new HashMap<>();

    private DurabilityType durabilityType = DurabilityType.FULL;
    private double durabilityMin = 1;
    private double durabilityMax = 1;

    @Override
    protected boolean isValid() {
        return id != null;
    }
}
