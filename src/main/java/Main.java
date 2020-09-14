public class Main {
    public static void main(String[] args) {

        ParentDAO parentDAO = new ParentDAO();
        Parent parent = new Parent("Parent 1", 1);
        parentDAO.save(parent);
        Child child = new Child("Child 2_1");
        parent.addChild(child);
        child = new Child("Child 2_2");
        parent.addChild(child);
        System.out.println(parent);
        for (Child ch: parent.getChildren()) {
            System.out.println(ch);
        }
        parentDAO.update(parent);
        System.out.println("Чтение из базы");
        for (Parent par: parentDAO.findAll()) {
            System.out.println(par);
            for (Child ch: par.getChildren()) {
                System.out.println(ch);
            }
        }
    }
}
