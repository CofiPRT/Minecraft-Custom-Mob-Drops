package ro.cofi.custommobdrops.config.condition;

public class AttributeTagConditionMapper extends BaseStringConditionMapper {

    @Override
    public Condition apply(String tag) {
        return event -> event.getEntity().getScoreboardTags().contains(tag);
    }

}
