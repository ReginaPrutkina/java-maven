public class MainRest {
    public static void main(String[] args) {
        ParentDAO parentDAO = new ParentDAO();
        FirstRest firstRest = new FirstRest();
        firstRest.setParentDAO(parentDAO);
        System.out.println(firstRest.getAllUser());
    }
}
