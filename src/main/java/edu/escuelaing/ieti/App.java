/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.escuelaing.ieti;

import edu.escuelaing.ieti.config.AppConfiguration;
import edu.escuelaing.ieti.config.JwtFilter;
import edu.escuelaing.ieti.model.User;
import edu.escuelaing.ieti.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.UUID;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public FilterRegistrationBean jwtFilter()
    {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter( new JwtFilter() );
        registrationBean.addUrlPatterns( "/boards/*" );

        return registrationBean;
    }

    @Override
    public void run(String... args) throws Exception {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");

        userRepository.deleteAll();

        userRepository.save(new User(UUID.randomUUID(), "Ana Rincon", "user123", "anamaria@mail.com"));
        userRepository.save(new User(UUID.randomUUID(),"Andres Rincon", "user123", "andres@mail.com"));
        userRepository.save(new User(UUID.randomUUID(), "Carlos Castaneda", "user123", "carlos@mail.com"));
        userRepository.save(new User(UUID.randomUUID(), "Alejandra Rincon", "user123", "alejandra@mail.com"));
        userRepository.save(new User(UUID.randomUUID(), "John Ibanez", "user123", "john@mail.com"));

        Query query = new Query();
        query.addCriteria(Criteria.where("email").is("anamaria@mail.com"));

        User user = mongoOperation.findOne(query, User.class);

        System.out.println(user);
        System.out.println();

    }

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }
}
