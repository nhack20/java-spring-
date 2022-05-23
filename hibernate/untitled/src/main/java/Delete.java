import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class).buildSessionFactory())
        {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee emp = session.get(Employee.class, 6);
            session.delete(emp);

            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("delete Employee where name = 'Oleg' AND salary=700" ).executeUpdate();

            session.getTransaction().commit();
        }
    }
}

