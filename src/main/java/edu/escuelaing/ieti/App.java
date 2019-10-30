/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.escuelaing.ieti;

import edu.escuelaing.ieti.config.AppConfiguration;
import edu.escuelaing.ieti.config.JwtFilter;
import edu.escuelaing.ieti.config.MongoOperationsConfig;
import edu.escuelaing.ieti.model.Card;
import edu.escuelaing.ieti.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    MongoOperationsConfig mongoOperationsConfig;

    @Bean
    public FilterRegistrationBean jwtFilter()
    {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter( new JwtFilter() );
        registrationBean.addUrlPatterns( "/api/*" );

        return registrationBean;
    }

    @Override
    public void run(String... args) {

        MongoOperations mongoOperation = mongoOperationsConfig.getMongoOperation();

        Query query = new Query();
        query.addCriteria(Criteria.where("dueDate").lt(new Date()));

        List<Card> cards = mongoOperation.find(query, Card.class);
        System.out.println("---------------------Todos that the dueDate has expire---------------------");
        System.out.println(cards);
        System.out.println("---------------------------------------------------------------------------");

        query = new Query();
        query.addCriteria(Criteria.where("user").exists(true).and("priority").gte(5));
        cards = mongoOperation.find(query, Card.class);
        System.out.println("-Todos that are assigned to given user and have priority greater equal to 5-");
        System.out.println(cards);
        System.out.println("---------------------------------------------------------------------------");
    }

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }
}
