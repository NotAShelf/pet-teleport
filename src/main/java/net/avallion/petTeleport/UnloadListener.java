package net.avallion.petTeleport;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Sittable;
import org.bukkit.entity.Tameable;
import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.world.ChunkUnloadEvent;

public class UnloadListener implements Listener {
    // Event handler for chunk unload event
    @EventHandler
    public void onChunkUnload(ChunkUnloadEvent event) {
        // Handle entities in the unloaded chunk
        handleEntities(event.getChunk().getEntities());
    }

    // Event handler for world change event
    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent event) {
        // Handle entities in the player's previous world
        handleEntities(event.getFrom().getEntities().toArray(new Entity[0]));
    }

    // Method to handle teleportation of pets
    private void handleEntities(Entity[] entities) {
        for (Entity ent : entities) {
            // Check if the entity is a pet that can teleport with its owner
            if (ent instanceof Sittable && ent instanceof Tameable) {
                Sittable sit = (Sittable) ent;
                Tameable tame = (Tameable) ent;
                // Check if the pet is not sitting and its owner is online
                if (!sit.isSitting() && tame.getOwner() instanceof Player) {
                    Player ply = (Player) tame.getOwner();
                    // Teleport the pet to the owner
                    ent.teleport(ply);
                    // Set portal cooldown to prevent the pet from going through the nether portal
                    // instantly
                    ent.setPortalCooldown(300);
                }
            }
        }
    }
}
