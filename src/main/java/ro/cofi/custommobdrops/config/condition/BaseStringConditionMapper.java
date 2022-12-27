package ro.cofi.custommobdrops.config.condition;

public abstract class BaseStringConditionMapper extends BaseConditionMapper<String> {

    @Override
    protected String adapt(Object object) {
        return object instanceof String string ? string : null;
    }

}
