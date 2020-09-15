import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory sessionFactory;
    static {
    try{
                Configuration configuration = new Configuration().configure();
              //  configuration.addAnnotatedClass(com.example.Parent.class);
              //  configuration.addAnnotatedClass(com.example.Child.class);
                 sessionFactory = configuration.buildSessionFactory();

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
