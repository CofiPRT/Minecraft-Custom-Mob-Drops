package ro.cofi.custommobdrops.config.condition;

import org.bukkit.event.entity.EntityDeathEvent;

import java.util.function.Predicate;

public interface Condition extends Predicate<EntityDeathEvent> {
    Condition TRUE = event -> true;
}
