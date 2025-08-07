package com.maxxenergy.edap;

import com.maxxenergy.edap.model.SolarData;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class SolarDataService {

    public SolarData getPublicData() {
        String uri = "mongodb://localhost:27017";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("maxxenergy");
            MongoCollection<Document> collection = database.getCollection("solar_plants");

            Document publicPlant = collection.find(new Document("isPublic", true)).first();

            if (publicPlant != null) {
                return new SolarData(
                        publicPlant.getString("plantName"),
                        publicPlant.getDouble("generation"),
                        publicPlant.getDouble("revenue")
                );
            }
        } catch (Exception e) {
            System.err.println("Error fetching data from MongoDB: " + e.getMessage());
        }

        return new SolarData("No Data Available", 0.0, 0.0);
    }
}
