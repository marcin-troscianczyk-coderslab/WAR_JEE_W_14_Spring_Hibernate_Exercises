package pl.coderslab.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main1 {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = null;

        try {
             entityManagerFactory =
                Persistence.createEntityManagerFactory("springHibernatePersistenceUnit");

            EntityManager entityManager = null;

            try {

                entityManager = entityManagerFactory.createEntityManager();
                System.out.println("EntityManager: " + entityManager);

            } finally {
                if (entityManager != null) {
                    entityManager.close();
                }
            }

        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }
}
