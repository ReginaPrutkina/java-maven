import com.example.District;
import com.example.Schools;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class DistrictDAO {
    public void save(District district) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(district);
        tx1.commit();
        session.close();
    }
    public void update(District district) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(district);
        tx1.commit();
        session.close();
    }
    public District findAddress(String street){
        Query query = HibernateUtils.getSessionFactory().openSession().createQuery("From District where street like  :param");
        query.setParameter("param",street.trim());
        List<District> district = (List<District>) query.getResultList();
        if (district.size() > 0)
            return district.get(0);
        else return null;
    }
}
