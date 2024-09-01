package de.james.mongodb.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;

import java.util.logging.Logger;

@Getter
public class Database {

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private MongoCollection mongoCollection;

    private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private boolean isConnected;

    public void connectToDatabase(String connectionURL, String mongoDatabase, String mongoCollection) {
        this.mongoClient = MongoClients.create(connectionURL);
        this.mongoDatabase = this.mongoClient.getDatabase(mongoDatabase);
        this.mongoCollection = this.mongoDatabase.getCollection(mongoDatabase);
        isConnected = true;
    }

    public void disconnectFromDatabase() {
        mongoClient.close();
    }

    public boolean isDatabaseConnected() {
        return isConnected;
    }

}
