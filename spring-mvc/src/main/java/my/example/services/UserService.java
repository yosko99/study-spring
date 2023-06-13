package my.example.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import my.example.entities.User;
import my.example.providers.EntityManagerProvider;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserService {
    private final EntityManager entityManager;

    public UserService(EntityManagerProvider entityManagerProvider) {
        this.entityManager = entityManagerProvider.getEntityManager();
    }

    public void registerUser(String name,int age) {
        User user = new User(name,age);

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    public List<User> getAllUsers() {
        String jpql = "SELECT u FROM User u";
        Query query = entityManager.createQuery(jpql);

        return (List<User>) query.getResultList();
    }
}
