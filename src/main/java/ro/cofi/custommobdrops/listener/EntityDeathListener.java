package ro.cofi.custommobdrops.listener;

import org.bukkit.entity.Mob;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import ro.cofi.custommobdrops.CustomMobDrops;

public class EntityDeathListener extends AbstractListener {

    public EntityDeathListener(CustomMobDrops plugin) {
        super(plugin);
    }

    @EventHandler(ignoreCancelled = true)
    public void onEntityDeath(EntityDeathEvent event) {
        // only care about mobs
        if (!(event.getEntity() instanceof Mob mob))
            return;
    }
}
