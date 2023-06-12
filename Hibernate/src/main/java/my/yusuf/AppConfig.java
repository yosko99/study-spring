package my.yusuf;

import my.yusuf.beans.Dog;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class AppConfig {
    private static Name getExampleName() {
        Name name = new Name();

        name.setfName("Azis");
        name.setsName("Azizov");
        name.setlName("Azizov");

        return name;
    }

    public static void main(String[] args) {

        Configuration con = new Configuration().configure().addAnnotatedClass(Dog.class).addAnnotatedClass(Person.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                con.getProperties()).build();
        SessionFactory sessionFactory = con.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();

        Person yosko = new Person();
        yosko.setName(getExampleName());
        yosko.setPid(1);

        Dog dog = new Dog();
        dog.setId(1);
        dog.setName("Bobcho");
        dog.setAge(2);

        yosko.getDog().add(dog);
        dog.setPerson(yosko);

        Transaction transaction = session.beginTransaction();

        session.persist(dog);
        session.persist(yosko);
        transaction.commit();

        Person test = session.get(Person.class,1);
        System.out.println(test);


        session.close();

    }
}