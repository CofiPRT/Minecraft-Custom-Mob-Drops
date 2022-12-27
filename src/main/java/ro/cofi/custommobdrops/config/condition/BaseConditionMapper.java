package ro.cofi.custommobdrops.config.condition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@SuppressWarnings("StaticInitializerReferencesSubClass") // single threaded, cannot occur
public abstract class BaseConditionMapper<T> {

    public Condition map(Object object) {
        T adapted = adapt(object);

        return adapted == null ? null : apply(adapted);
    }

    protected abstract T adapt(Object object);
    protected abstract Condition apply(T adapted);

    private static final Map<String, Supplier<BaseConditionMapper<?>>> conditionMapper = new HashMap<>();

    static {
        conditionMapper.put("and", LogicalAndMapper::new);
        conditionMapper.put("or", LogicalOrMapper::new);
        conditionMapper.put("not", LogicalNotMapper::new);
        conditionMapper.put("name", AttributeNameConditionMapper::new);
        conditionMapper.put("world", AttributeWorldConditionMapper::new);
        conditionMapper.put("tag", AttributeTagConditionMapper::new);
        conditionMapper.put("on_fire", AttributeOnFireConditionMapper::new);
    }

    public static Condition from(List<Map<?, ?>> conditions) {
        if (conditions == null || conditions.isEmpty())
            return event -> true;

        // an AND is assumed between root conditions
        return conditionMapper.get("and").get().map(conditions);
    }

    protected static List<Condition> parseList(List<Map<?, ?>> conditions) {
        List<Condition> conditionList = new ArrayList<>();

        for (Map<?, ?> conditionElem : conditions) {
            if (conditionElem == null)
                continue;

            for (Map.Entry<?, ?> conditionEntry : conditionElem.entrySet()) {
                if (!(conditionEntry.getKey() instanceof String conditionKey))
                    continue;

                Supplier<BaseConditionMapper<?>> conditionFunction = conditionMapper.get(conditionKey);
                if (conditionFunction == null)
                    continue;

                Condition condition = conditionFunction.get().map(conditionEntry.getValue());
                if (condition == null)
                    continue;

                conditionList.add(condition);
            }
        }

        return conditionList;
    }
}
