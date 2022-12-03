package ro.cofi.custommobdrops;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import ro.cofi.custommobdrops.config.ConfigManager;

import java.util.Arrays;
import java.util.function.Function;

public final class CustomMobDrops extends JavaPlugin {

    private static final ChatColor PLUGIN_NAME_COLOR = ChatColor.AQUA;

    private static CustomMobDrops plugin;

    private ConfigManager configManager;

    @SuppressWarnings("squid:S3010") // paper will call the constructor, can't initialize statically
    public CustomMobDrops() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        // save the config file from the jar into the server folder, in case it doesn't exist yet
        saveDefaultConfig();

        // init fields
        configManager = new ConfigManager(this);

        // register listeners
        Arrays.<Function<CustomMobDrops, ? extends Listener>>asList(

        ).forEach(listener -> getServer().getPluginManager().registerEvents(listener.apply(this), this));

        // register commands
//        Objects.requireNonNull(getServer().getPluginCommand("nrreload")).setExecutor(new ReloadCommand(this));
    }

    @Override
    public void onDisable() {
        configManager.saveConfig();
    }

    public static CustomMobDrops getPlugin() {
        return plugin;
    }

    public static NamespacedKey getNamespacedKey(String key) {
        return new NamespacedKey(plugin, key);
    }

    public String prefixMessage(String message) {
        message = "[%s%s%s] %s".formatted(PLUGIN_NAME_COLOR, getName(), ChatColor.RESET, message);
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
