import javax.persistence.*;

@Entity
@Table (name = "schools")
public class Schools {
    @Id
    public int schoolNumber;

    public String schoolAddress;
    @Id
    @Column
    public int district_id;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    public Schools(){};
    public Schools(int schoolNumber, int district_id, String schoolAddress){
        this.schoolNumber = schoolNumber;
        this.schoolAddress = schoolAddress;
        this.district_id = district_id;
    }

    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
    }

    public int getDistrict_id() {
        return district_id;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolNumber(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public int getSchoolNumber() {
        return schoolNumber;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Schools{" +
                "schoolNumber=" + schoolNumber +
                ", district_id=" + district_id +
                ", schoolAddress='" + schoolAddress + '\'' +
                '}';
    }
}
