import javax.persistence.*;

@Entity
@Table (name = "children")
public class Child {
    private int id;
    private String FIO;
    private int schoolNumber;
    private Parent parent;
    Child(){};
   Child(String FIO){
    this.FIO = FIO;

   }
    @ManyToOne
    @JoinColumn(name = "parent_id")
    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    @Id
    @GeneratedValue
            //(strategy = GenerationType.AUTO)
    @Column
            //1(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "schoolNumber", nullable = false, insertable = true, updatable = true)
    public int getSchoolNumber() {
        return schoolNumber;
    }
    public void setSchoolNumber(int schoolID){
       this.schoolNumber = schoolID;
    }

    @Column(name = "FIO", nullable = false, insertable = true, updatable = true)
    public String getFIO() {
        return FIO;
    }
    public void setFIO(String FIO){
        this.FIO = FIO;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", FIO='" + FIO + '\'' +
                ", schoolID=" + schoolNumber +
                ", parent=" + parent.getFio() +
                '}';
    }
}
