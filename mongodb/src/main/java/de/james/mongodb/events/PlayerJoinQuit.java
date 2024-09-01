package de.james.mongodb.events;

import de.james.mongodb.MongoDB;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinQuit implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        MongoDB.getMongoDB().getPlayerService().createNewPlayerByBukkitPlayer(player);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        MongoDB.getMongoDB().getPlayerService().removePlayer(MongoDB.getMongoDB().getPlayerService().getPlayer(player.getUniqueId().toString()));
    }

}
