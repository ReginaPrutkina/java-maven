import com.example.District;
import com.example.Schools;

public class FillTables {
        public FillTables(){
        DistrictDAO districtDAO = new DistrictDAO();
        District district = new District(1,"Кировский","Малышева");
        districtDAO.save(district);
        district = new District(1,"Кировский","Ленина");
        districtDAO.save(district);
        district = new District(2,"Железнодорожный","Азина");
        districtDAO.save(district);
        district = new District(2,"Железнодорожный","Луначарского");
        districtDAO.save(district);
        district = new District(2,"Железнодорожный","Шевченко");
        districtDAO.save(district);
        SchoolsDAO schoolsDAO = new SchoolsDAO();
        Schools schools = new Schools(11,1,"ул. Малышева, д 3");
        schoolsDAO.save(schools);
        schools = new Schools(12,1,"ул. Ленина, д 53");
        schoolsDAO.save(schools);
        schools = new Schools(21,2,"ул. Луначарского, д 53");
        schoolsDAO.save(schools);
        schools = new Schools(22,2,"ул. Азина, д 44");
        schoolsDAO.save(schools);
        schools = new Schools(23,2,"ул. Шевченко, д 253");
        schoolsDAO.save(schools);
    }

}
