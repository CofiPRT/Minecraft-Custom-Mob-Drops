package ro.cofi.custommobdrops.config.condition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class BaseListConditionMapper extends BaseConditionMapper<List<Map<?, ?>>> {

    @Override
    protected List<Map<?, ?>> adapt(Object object) {
        if (!(object instanceof List<?> list))
            return null;

        List<Map<?, ?>> mapList = new ArrayList<>();
        for (Object value : list) {
            if (!(value instanceof Map<?, ?> map))
                continue;

            mapList.add(map);
        }

        if (mapList.isEmpty())
            return null;

        return mapList;
    }

}
