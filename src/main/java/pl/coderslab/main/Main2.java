package pl.coderslab.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.conf.AppConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main2 {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class)) {

            EntityManagerFactory entityManagerFactory =
                    context.getBean("entityManagerFactory", EntityManagerFactory.class);

            EntityManager entityManager =
                    entityManagerFactory.createEntityManager();

        }
    }
}
