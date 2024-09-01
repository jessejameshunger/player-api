package de.james.mongodb.players;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import de.james.mongodb.database.Database;

public class PlayerController {

    private final MongoCollection mongoCollection = new Database().getMongoCollection();

    public void createNewPlayer(Player player) {
        if(mongoCollection.find(Filters.eq(player.getName())).first() == null || mongoCollection.find(Filters.eq(player.getUuid())).first() == null) {
            player.createPlayerInDatabase();
        }
        System.out.println("Player could not be created. Already existing.");
    }


}
