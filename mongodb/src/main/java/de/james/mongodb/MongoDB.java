package de.james.mongodb;

import de.james.mongodb.database.Database;
import de.james.mongodb.events.PlayerJoinQuit;
import de.james.mongodb.players.Player;
import de.james.mongodb.players.PlayerBuilder;
import de.james.mongodb.players.PlayerController;
import de.james.mongodb.players.PlayerService;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class MongoDB extends JavaPlugin {

    private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Getter
    public static MongoDB mongoDB = new MongoDB();

    @Getter
    public Database database = new Database();

    @Getter
    public Player player;

    @Getter
    public PlayerBuilder playerBuilder = new PlayerBuilder();

    @Getter
    public PlayerController playerController = new PlayerController();

    @Getter
    public PlayerService playerService = new PlayerService();

    @Override
    public void onEnable() {
        logger.fine("mongodb-module was initzialed.");

        if(!new Database().isConnected()) {
            logger.severe("Database is not connected.");
        }

        Bukkit.getPluginManager().registerEvents(new PlayerJoinQuit(), this);
    }

    @Override
    public void onDisable() {
        logger.warning("mongodb-module was deactivated.");
    }

}
