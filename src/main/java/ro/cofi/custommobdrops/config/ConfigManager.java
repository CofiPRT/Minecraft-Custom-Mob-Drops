package ro.cofi.custommobdrops.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import ro.cofi.custommobdrops.CustomMobDrops;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class ConfigManager {

    private static final String FILE_NAME = "config.json";

    private final CustomMobDrops plugin;

    private File configFile;
    private FileConfiguration config;

    public ConfigManager(CustomMobDrops plugin) {
        this.plugin = plugin;

        saveDefaultConfig();
    }

    /**
     * Create the config file in the server files, if necessary, thus guaranteeing its existence.
     */
    public void saveDefaultConfig() {
        initConfigFile();

        if (!configFile.exists())
            plugin.saveResource(FILE_NAME, false);
    }

    /**
     * Instantiate the java {@link File} instance representing the config file. May not exist.
     */
    private void initConfigFile() {
        if (configFile == null)
            configFile = new File(plugin.getDataFolder(), FILE_NAME);
    }

    /**
     * Loads the config in memory from the server files. In case the config is
     * not yet saved on the server, load default values from the jar.
     */
    public void reloadConfig() {
        initConfigFile();

        config = YamlConfiguration.loadConfiguration(configFile);

        // load default values
        InputStream defaultStream = plugin.getResource(FILE_NAME);

        if (defaultStream != null)
            config.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream)));
    }

    /**
     * Simple getter that guarantees a non-null result.
     *
     * @return The portal data configuration.
     */
    public FileConfiguration getConfig() {
        if (config == null)
            reloadConfig();

        return config;
    }

    /**
     * A {@link FileConfiguration} is saved in memory unless instructed to be written to the disk.
     */
    public void saveConfig() {
        if (config == null || configFile == null)
            return;

        try {
            getConfig().save(configFile);
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, plugin.prefixMessage("Could not save " + FILE_NAME), e);
        }
    }
}
