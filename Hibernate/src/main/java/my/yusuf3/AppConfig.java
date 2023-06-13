package my.yusuf3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import my.yusuf2.entities.Laptop;

// JPA
public class AppConfig {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Laptop laptop = new Laptop(101, "test");
        entityManager.getTransaction().begin();
        entityManager.persist(laptop);
        entityManager.getTransaction().commit();

        System.out.println(entityManager.find(Laptop.class, 101));
    }

}
