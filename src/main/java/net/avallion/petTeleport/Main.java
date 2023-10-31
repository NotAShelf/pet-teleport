package net.avallion.petTeleport;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("PetTeleport has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("PetTeleport has been disabled.");
    }
}
