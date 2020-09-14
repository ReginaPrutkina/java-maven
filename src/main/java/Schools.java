import javax.persistence.*;

@Entity
@Table (name = "schools")
public class Schools {
    @Id
    public int schoolNumber;
    @Column
    public String schoolAddress;

    @ManyToOne
    @JoinColumn(name = "districtID")
    private District district;

    public Schools(){};
    public Schools(int schoolNumber, District district, String schoolAddress){
        this.schoolNumber = schoolNumber;
        this.schoolAddress = district.getDistrictName()+ " " + schoolAddress;
        this.district = district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public District getDistrict() {
        return district;
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

   @Override
    public String toString() {
        return "Schools{" +
                "schoolNumber=" + schoolNumber +
                ", schoolAddress='" + schoolAddress + '\'' +
                '}';
    }
}
