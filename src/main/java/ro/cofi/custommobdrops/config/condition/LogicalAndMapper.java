package ro.cofi.custommobdrops.config.condition;

import java.util.List;
import java.util.Map;

public class LogicalAndMapper extends BaseListConditionMapper {

    @Override
    protected Condition apply(List<Map<?, ?>> mapList) {
        List<Condition> conditionList = parseList(mapList);

        if (conditionList.isEmpty())
            return Condition.TRUE;

        return event -> {
            for (Condition condition : conditionList)
                if (!condition.test(event))
                    return false;

            return true;
        };
    }

}
