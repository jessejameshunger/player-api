package de.james.mongodb.players;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import de.james.mongodb.database.Database;
import lombok.Getter;
import lombok.NonNull;
import org.bson.Document;

@NonNull
@Getter
public class Player {

    private String name;
    private String displayName;
    private String uuid;
    private String rank;
    private String banReason;
    private String permissions;
    private int coins;
    private int playTime;
    private boolean isBanned;
    private double ipAddress;

    private final MongoCollection mongoCollection = new Database().getMongoCollection();

    public Player(PlayerBuilder playerBuilder) {
        this.name = playerBuilder.build().getName();
        this.uuid = playerBuilder.build().getUuid();
        this.displayName = playerBuilder.build().getDisplayName();
        this.rank = playerBuilder.build().getRank();
        this.banReason = playerBuilder.build().getBanReason();
        this.permissions = playerBuilder.build().getPermissions();
        this.coins = playerBuilder.build().getCoins();
        this.playTime = playerBuilder.build().getPlayTime();
        this.isBanned = playerBuilder.build().isBanned();
        this.ipAddress = playerBuilder.build().getIpAddress();
    }


    public void saveOneCredential(Player player, String key, Object value) {
        Document newPlayer = new Document("uuid", player.getUuid());
        assert newPlayer != null;
            newPlayer.append(key, value);
        mongoCollection.insertOne(newPlayer);
    }

    public void createPlayerInDatabase() {
        Document newPlayer = (Document) mongoCollection.find(Filters.eq("uuid", getUuid())).first();

        assert newPlayer == null;
                newPlayer
                    .append("name", name)
                    .append("uuid", uuid)
                    .append("displayName", displayName)
                    .append("rank", rank)
                    .append("banReason", banReason)
                    .append("permissions", permissions)
                    .append("coins", coins)
                    .append("playTime", playTime)
                    .append("isBanned", isBanned)
                    .append("ipAddress", ipAddress);
            mongoCollection.insertOne(newPlayer);
    }

    public Player returnPlayerOutOfDatabase(String playerUUID) {
        Document getPlayerOutOfDatabase = (Document) mongoCollection.find(Filters.eq("uuid", playerUUID)).first();

        assert getPlayerOutOfDatabase != null;
        PlayerBuilder playerBuilder = new PlayerBuilder()
                .setName(getPlayerOutOfDatabase.getString("name"))
                .setUUID(getPlayerOutOfDatabase.getString("uuid"))
                .setDisplayName(getPlayerOutOfDatabase.getString("displayName"))
                .setRank(getPlayerOutOfDatabase.getString("rank"))
                .setBanReason(getPlayerOutOfDatabase.getString("banReason"))
                .setPermissions(getPlayerOutOfDatabase.getString("permissions"))
                .setCoins(getPlayerOutOfDatabase.getInteger("coins"))
                .setPlayTime(getPlayerOutOfDatabase.getInteger("playTime"))
                .setIsBanned(getPlayerOutOfDatabase.getBoolean("isBanned"))
                .setIpAddress(getPlayerOutOfDatabase.getString("ipAddress"));
        return new Player(playerBuilder);
    }

    public void setName(Player player, String key, int value) {
        this.coins = value;
        this.saveOneCredential(player, key, value);
        new PlayerService().addPlayer(player);
    }

    public void setDisplayName(Player player, String key, String value) {
        this.displayName = value;
        this.saveOneCredential(player, key, value);
        new PlayerService().addPlayer(player);
    }

    public void setUuid(Player player, String key, String value) {
        this.uuid = value;
        this.saveOneCredential(player, key, value);
        new PlayerService().addPlayer(player);
    }

    public void setRank(Player player, String key, String value) {
        this.rank = value;
        this.saveOneCredential(player, key, value);
        new PlayerService().addPlayer(player);
    }

    public void setBanReason(Player player, String key, String value) {
        this.banReason = value;
        this.saveOneCredential(player, key, value);
        new PlayerService().addPlayer(player);
    }

    public void setPermissions(Player player, String key, String value) {
        this.permissions = value;
        this.saveOneCredential(player, key, value);
        new PlayerService().addPlayer(player);
    }

    public void setCoins(Player player, String key, int value) {
        this.coins = value;
        this.saveOneCredential(player, key, value);
        new PlayerService().addPlayer(player);
    }

    public void setPlayTime(Player player, String key, int value) {
        this.playTime = value;
        this.saveOneCredential(player, key, value);
        new PlayerService().addPlayer(player);
    }

    public void setIsBanned(Player player, String key, boolean value) {
        this.isBanned = value;
        this.saveOneCredential(player, key, value);
        new PlayerService().addPlayer(player);
    }

    public void setIpAddress(Player player, String key, double value) {
        this.ipAddress = value;
        this.saveOneCredential(player, key, value);
        new PlayerService().addPlayer(player);
    }

}

