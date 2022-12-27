package ro.cofi.custommobdrops.config.condition;

public class AttributeNameConditionMapper extends BaseStringConditionMapper {

    @Override
    public Condition apply(String name) {
        return event -> event.getEntity().getName().equals(name);
    }

}
