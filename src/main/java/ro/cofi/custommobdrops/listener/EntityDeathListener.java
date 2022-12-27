package ro.cofi.custommobdrops.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import ro.cofi.custommobdrops.CustomMobDrops;

public class EntityDeathListener extends AbstractListener {

    public EntityDeathListener(CustomMobDrops plugin) {
        super(plugin);
    }

    @EventHandler(ignoreCancelled = true)
    public void onEntityDeath(EntityDeathEvent event) {
        int x = 5;
    }
}
