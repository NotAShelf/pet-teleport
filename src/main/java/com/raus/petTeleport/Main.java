package com.raus.petTeleport;

import de.jeff_media.updatechecker.UpdateChecker;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
		private static final int SPIGOT_RESOURCE_ID = 77688;

	@Override
	public void onEnable(){
		// Listeners
		getServer().getPluginManager().registerEvents(new UnloadListener(), this);
		UpdateChecker.init(this, SPIGOT_RESOURCE_ID)
				.checkEveryXHours(24)
				.setNotifyOpsOnJoin(true)
				.setNotifyByPermissionOnJoin("petteleport.admin")
				.checkNow();
		getLogger().info("PetTeleport has been enabled.");
	}

	@Override
	public void onDisable()
	{
		getLogger().info("PetTeleport has been disabled.");
	}
}