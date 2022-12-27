package ro.cofi.custommobdrops.config.condition;

public class AttributeWorldConditionMapper extends BaseStringConditionMapper {

    @Override
    public Condition apply(String world) {
        return event -> event.getEntity().getWorld().getName().equals(world);
    }

}
