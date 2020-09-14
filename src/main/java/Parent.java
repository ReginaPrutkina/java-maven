import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@Entity
@Table (name = "parents")
public class Parent implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column (name = "FIO")
    private  String fio;
    @Column
    private int district_id;
    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Child> children = new HashSet<Child>();
 //   @OneToMany(mappedBy = "parents",cascade = CascadeType.ALL)
    @Transient
    private Set<Schools> schools = new HashSet<Schools>();

    Parent(){};
    Parent(String fio,int district_id){
        this.fio = fio;
        this.district_id = district_id;
    }

    public Set<Child> getChildren() {
        return this.children;
    }
    public int getId() {
        return id;
    }



    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getDistrict_id(){
        return district_id;
    }

    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
    }

    public void addChild(Child child) {
        Scanner scanner = new Scanner(System.in);
        int schoolNumber = 0;
        child.setParent(this);
        System.out.println("Выберите школу  для " + child.getFIO() + ":");
     //   showSchools();
        try {
            schoolNumber = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        child.setSchoolNumber(schoolNumber);
        children.add(child);
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

    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                ", FIO='" + fio + '\'' +
                ", district_id=" + district_id +

                '}';
    }
}
