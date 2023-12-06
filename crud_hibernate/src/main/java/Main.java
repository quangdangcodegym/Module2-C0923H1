
import java.util.Date;
import java.util.List;

import com.cg.model.User;
import org.hibernate.Session;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        User u = new User();
        u.setUsername("LONG BEDE");
        u.setPassword("123123");

        entityManager.persist(u);
        entityManager.getTransaction().commit();
    }
}