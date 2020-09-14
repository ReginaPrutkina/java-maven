import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "districts")
public class District {
    @Id
    @Column (name = "district_id")
    private int districtId;
    private String districtName;
    @OneToMany(mappedBy = "districtID",cascade = CascadeType.ALL)
    private Set<Schools> schools = new HashSet<Schools>();

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getDistrictId() {
        return districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

   public void setSchools(Set<Schools> schools) {
        this.schools = schools;
    }

    public Set<Schools> getSchools() {
        return schools;
    }

    public void showSchools(){
        System.out.println("Список школ в Вашем районе");
        for (Schools school:schools  ) {
            System.out.println(school);
        }
    }

}
