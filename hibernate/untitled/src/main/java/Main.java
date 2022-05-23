import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
       SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
               .addAnnotatedClass(Employee.class).buildSessionFactory();
    try {
        Employee emp = new Employee("Dastan", "Tassynov", "IT", 1000);
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        session.save(emp);
        session.getTransaction().commit();
        System.out.println("DONE");
        System.out.println(emp);

    }finally {
        factory.close();
    }


    }
}

