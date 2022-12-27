package ro.cofi.custommobdrops.config;

import ro.cofi.custommobdrops.config.condition.BaseConditionMapper;
import ro.cofi.custommobdrops.config.condition.Condition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MobProfile {

    private List<String> ids = new ArrayList<>();
    private boolean enabled = true;
    private boolean overwrite = false;
    private Condition condition = event -> true;
    private DropGroup rootDropGroup = null;

    public MobProfile(Map<String, ?> map) {
        if (map.containsKey("id")) {
            Object id = map.get("id");
            if (id instanceof String stringId) {
                ids.add(stringId);
            } else if (id instanceof List<?> idList) {
                // only add strings
                for (Object idElem : idList)
                    if (idElem instanceof String stringId)
                        ids.add(stringId);
            }
        }

        if (map.containsKey("enabled"))
            enabled = (boolean) map.get("enabled");

        if (map.containsKey("overwrite"))
            overwrite = (boolean) map.get("overwrite");

        if (map.containsKey("conditions"))
            //noinspection unchecked
            condition = BaseConditionMapper.from((List<Map<?, ?>>) map.get("conditions"));
    }

    public boolean isValid() {
        return !ids.isEmpty() && rootDropGroup != null;
    }
}
