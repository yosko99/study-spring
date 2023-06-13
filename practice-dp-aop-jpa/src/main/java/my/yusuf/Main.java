package my.yusuf;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import my.yusuf.embeddables.Name;
import my.yusuf.entities.Laptop;
import my.yusuf.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.List;

@Configuration
@ComponentScan("my.yusuf")
@EnableAspectJAutoProxy
public class Main {
    private static void jpa() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("practice");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Student student = new Student();
        Name studentName = new Name("Test", "Test2", "Test3");
        student.setName(studentName);

        Laptop laptop = new Laptop();
        laptop.setBrand("Huawei");
        laptop.setSpeed(2);
        laptop.setStudent(student);

        student.getLaptopList().add(laptop);

        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.persist(laptop);
        entityManager.getTransaction().commit();

//        One way of finding
        Student studentFromDB = entityManager.find(Student.class, 1);

//        Query
        String jpqlQuery = "SELECT student FROM Student student WHERE student.id = :id";
        Query query = entityManager.createQuery(jpqlQuery);
        query.setParameter("id", 1);
        Student student1 = (Student) query.getSingleResult();
        System.out.println(student1);
    }

    public static void main(String[] args) {
        jpa();
//        dependencyInjectionWithAOP();
    }

    private static void dependencyInjectionWithAOP() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        MyClient myClient = context.getBean(MyClient.class);

        myClient.showSpeed();
    }
}
