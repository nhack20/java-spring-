import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Update {

        public static void main(String[] args) {
            //Создали объект SessionFactory

            try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                    addAnnotatedClass(Employee.class).buildSessionFactory())
            {
                Session session = factory.getCurrentSession();
                session.beginTransaction();


                Employee emp = session.get(Employee.class, 7);
                emp.setSalary(1500);


                session.getTransaction().commit();


                session = factory.getCurrentSession();
                session.beginTransaction();

                session.createQuery("update Employee set salary = 2000 WHERE name = 'Dauren'").executeUpdate();

                session.getTransaction().commit();
            }
        }
    }
