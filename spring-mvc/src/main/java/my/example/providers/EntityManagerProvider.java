package my.example.providers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.stereotype.Component;

@Component
public class EntityManagerProvider {

    private final EntityManager entityManager;

    public EntityManagerProvider() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("practice");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
