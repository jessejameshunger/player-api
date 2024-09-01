package de.james.mongodb.players;

import java.util.HashMap;

public class PlayerService {
    private final HashMap<String, Player> players;

    public PlayerService() {
        this.players = new HashMap<>();
    }

    public Player getPlayer(String uuid) {
        if (!players.containsKey(uuid)) {
            throw new IllegalArgumentException("Player not found");
        }
        return players.get(uuid);
    }

    public void addPlayer(Player player) {
        if (this.getPlayer(player.getUuid()) != null) {
            throw new IllegalArgumentException("Player already exists");
        }
        players.put(player.getUuid(), player);
    }

    public void removePlayer(Player player) {
        if (this.getPlayer(player.getUuid()) != null) {
            throw new IllegalArgumentException("Player already exists");
        }
        players.remove(player.getUuid());
    }


    public void createNewPlayerByBukkitPlayer(org.bukkit.entity.Player player) {
        Player bukkitPlayer = new Player(new PlayerBuilder()
                .setName(player.getName())
                .setUUID(player.getUniqueId().toString())
                .setIpAddress(player.getAddress().toString())
                .setDisplayName(player.getDisplayName()));
        addPlayer(bukkitPlayer);
    }
}
