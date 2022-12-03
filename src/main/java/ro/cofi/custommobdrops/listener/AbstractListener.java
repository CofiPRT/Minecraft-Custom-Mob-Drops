package ro.cofi.custommobdrops.listener;

import org.bukkit.event.Listener;
import ro.cofi.custommobdrops.CustomMobDrops;

public abstract class AbstractListener implements Listener {

    protected final CustomMobDrops plugin;

    protected AbstractListener(CustomMobDrops plugin) {
        this.plugin = plugin;
    }

}
