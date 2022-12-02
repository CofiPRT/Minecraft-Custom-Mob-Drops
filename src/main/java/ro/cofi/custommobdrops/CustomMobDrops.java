package ro.cofi.custommobdrops;

import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.function.Function;

public final class CustomMobDrops extends JavaPlugin {

    private static CustomMobDrops plugin;

    @SuppressWarnings("squid:S3010") // paper will call the constructor, can't initialize statically
    public CustomMobDrops() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        // register listeners
        Arrays.<Function<CustomMobDrops, ? extends Listener>>asList(

        ).forEach(listener -> getServer().getPluginManager().registerEvents(listener.apply(this), this));
    }

    public static CustomMobDrops getPlugin() {
        return plugin;
    }

    public static NamespacedKey getNamespacedKey(String key) {
        return new NamespacedKey(plugin, key);
    }

}
