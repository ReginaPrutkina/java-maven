import com.example.District;
import com.example.Parent;
import com.example.Schools;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class SchoolsDAO {
    public void save(Schools school) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(school);
        tx1.commit();
        session.close();
    }
    public void update(Schools school) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(school);
        tx1.commit();
        session.close();
    }
    public List<Schools> findAll(int district_id) {
        Query query = HibernateUtils.getSessionFactory().openSession().createQuery("From Schools where district_id = :param");
        query.setParameter("param",district_id);
        List<Schools> schools = (List<Schools>) query.getResultList();
        return schools;
    }
}
