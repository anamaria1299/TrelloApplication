package edu.escuelaing.ieti.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Component;

@Configuration
public class AppConfiguration {

    @Value("${spring.data.mongodb.uri}")
    private String databaseURI;

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {

        System.out.println(databaseURI);

        MongoClientURI uri = new MongoClientURI("mongodb+srv://admin:Admin.123@cluster0-5rpyo.mongodb.net/test?retryWrites=true&w=majority");

        MongoClient mongoClient = new MongoClient(uri);

        return new SimpleMongoDbFactory( mongoClient, "test");

    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

        return mongoTemplate;

    }
}

