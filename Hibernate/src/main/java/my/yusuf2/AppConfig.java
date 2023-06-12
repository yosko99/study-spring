package my.yusuf2;

import my.yusuf2.entities.Laptop;
import my.yusuf2.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

// HQL Example
public class AppConfig {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                con.getProperties()).build();
        SessionFactory sessionFactory = con.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();


//        session.beginTransaction();
//
//        for (int i = 0; i < 50; i++) {
//            Laptop laptop = new Laptop(i, "Huawei" + i);
//            Student student = new Student(i, "Yosko" + i);
//
//            student.getLaptops().add(laptop);
//            laptop.setStudent(student);
//
//            session.persist(student);
//            session.persist(laptop);
//        }
//
//
//
//        session.getTransaction().commit();

        int id = 10;
        Query<Student> query = session.createQuery("from Student where id = :id", Student.class);

        query.setParameter("id", id);

        Student student = query.uniqueResult(); // Only one

//        List<Student> studentList = query.list(); // Multiple

        System.out.println(student);

    }
}
