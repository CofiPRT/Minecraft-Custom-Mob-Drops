package ro.cofi.custommobdrops.config;

import org.bukkit.configuration.file.FileConfiguration;
import ro.cofi.custommobdrops.CustomMobDrops;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConfigManager {

    private final CustomMobDrops plugin;
    private final FileConfiguration config;

    private final List<MobProfile> mobProfiles;

    public ConfigManager(CustomMobDrops plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
        this.mobProfiles = initProfiles();
    }

    public boolean isEnabled() {
        String key = "enabled";
        if (!config.contains(key)) {
            config.set(key, true);
            plugin.getLogger().warning(plugin.prefixMessage(
                "Missing config key: " + key + ". Defaulting to: " + config.getBoolean(key)
            ));
        }

        return config.getBoolean(key);
    }

    public void save() {
        // TODO
    }

    private List<MobProfile> initProfiles() {
        List<MobProfile> profiles = new ArrayList<>();

        List<Map<?, ?>> mobs = config.getMapList("mobs");
        for (Map<?, ?> mob : mobs) {
            //noinspection unchecked - we know it's a Map<String, ?>
            MobProfile profile = new MobProfile((Map<String, ?>) mob);
            if (profile.isValid())
                profiles.add(profile);
        }

        return profiles;
    }

}
