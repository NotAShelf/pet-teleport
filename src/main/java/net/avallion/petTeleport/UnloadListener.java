package net.avallion.petTeleport;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Sittable;
import org.bukkit.entity.Tameable;
import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.world.ChunkUnloadEvent;

import java.util.List;

public class UnloadListener implements Listener {
    private final Main plugin;

    public UnloadListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChunkUnload(ChunkUnloadEvent event) {
        handleEntities(event.getChunk().getEntities());
    }

    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent event) {
        handleEntities(event.getFrom().getEntities().toArray(new Entity[0]));
    }

    private void handleEntities(Entity[] entities) {
        boolean logPetTeleports = plugin.getConfig().getBoolean("logPetTeleports");
        List<String> worldBlacklist = plugin.getConfig().getStringList("worldBlacklist");
        boolean isBlacklist = plugin.getConfig().getBoolean("isBlacklist");

        for (Entity ent : entities) {
            if (ent instanceof Sittable && ent instanceof Tameable) {
                Sittable sit = (Sittable) ent;
                Tameable tame = (Tameable) ent;
                if (!sit.isSitting() && tame.getOwner() instanceof Player) {
                    String currentWorld = ent.getWorld().getName();
                    if ((isBlacklist && worldBlacklist.contains(currentWorld)) ||
                            (!isBlacklist && !worldBlacklist.contains(currentWorld))) {
                        continue;
                    }
                    Player ply = (Player) tame.getOwner();
                    ent.teleport(ply);
                    ent.setPortalCooldown(300);

                    if (logPetTeleports) {
                        plugin.getLogger()
                                .info("Pet " + ent.getType() + " was teleported to player " + ply.getName()
                                        + " at coordinates (" + ply.getLocation().getX() + ", "
                                        + ply.getLocation().getY() + ", " + ply.getLocation().getZ() + ")");
                    }
                }
            }
        }
    }
}
