package carl.myretail.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration{
    
    @Override
    @Bean
    public MongoClient mongoClient() {
        ConnectionString conString = new ConnectionString("mongodb://localhost:27017/pricingDatabase");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
        .applyConnectionString(conString)
        .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Override
    protected String getDatabaseName() {
        return "pricingDatabase";
    }

}
