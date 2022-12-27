package ro.cofi.custommobdrops.config.condition;

public class AttributeOnFireConditionMapper extends BaseBooleanConditionMapper {

    @Override
    public Condition apply(Boolean onFire) {
        return event -> event.getEntity().getFireTicks() > 0 == onFire;
    }

}
