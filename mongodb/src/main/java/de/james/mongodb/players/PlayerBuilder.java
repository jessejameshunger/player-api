package de.james.mongodb.players;

public class PlayerBuilder {

    private String name;
    private String displayName;
    private String uuid;
    private String rank;
    private String banReason;
    private String permissions;
    private String ipAddress;
    private int coins;
    private int playTime;
    private boolean isBanned;

    public PlayerBuilder setName(String playerName) {
        this.name = playerName;
        return this;
    }

    public PlayerBuilder setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public PlayerBuilder setUUID(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public PlayerBuilder setRank(String rank) {
        this.rank = rank;
        return this;
    }

    public PlayerBuilder setBanReason(String banReason) {
        this.banReason = banReason;
        return this;
    }

    public PlayerBuilder setPermissions(String permissions) {
        this.permissions = permissions;
        return this;
    }

    public PlayerBuilder setCoins(int coins) {
        this.coins = coins;
        return this;
    }

    public PlayerBuilder setPlayTime(int playTime) {
        this.playTime = playTime;
        return this;
    }

    public PlayerBuilder setIsBanned(boolean isBanned) {
        this.isBanned = isBanned;
        return this;
    }

    public PlayerBuilder setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public Player build() {
        return new Player(this);
    }

}
