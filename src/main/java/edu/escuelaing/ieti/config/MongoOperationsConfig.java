package edu.escuelaing.ieti.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

@Component
public class MongoOperationsConfig {

    private ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
    private MongoOperations mongoOperation = (org.springframework.data.mongodb.core.MongoOperations) applicationContext.getBean("mongoTemplate");

    public MongoOperations getMongoOperation() {
        return mongoOperation;
    }
}
