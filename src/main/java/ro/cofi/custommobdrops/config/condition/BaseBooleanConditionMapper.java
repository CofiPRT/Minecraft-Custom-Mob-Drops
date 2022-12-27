package ro.cofi.custommobdrops.config.condition;

public abstract class BaseBooleanConditionMapper extends BaseConditionMapper<Boolean> {

    @Override
    protected Boolean adapt(Object object) {
        return object instanceof Boolean bool ? bool : null;
    }

}
