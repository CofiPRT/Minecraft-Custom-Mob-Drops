package ro.cofi.custommobdrops.config.condition;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LogicalNotMapper extends BaseListConditionMapper {

    @Override
    protected Condition apply(List<Map<?, ?>> mapList) {
        // only the first condition is used
        List<Condition> conditionList = parseList(Collections.singletonList(mapList.get(0)));

        if (conditionList.isEmpty())
            return Condition.TRUE;

        return event -> !conditionList.get(0).test(event);
    }

}
