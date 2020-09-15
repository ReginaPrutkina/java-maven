import com.example.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParentDAO parentDAO = new ParentDAO();
        Parent parent;
        Child child;

        parent = new Parent();
        System.out.println("Введите Имя родителя: ");
        parent.setFio(scanner.nextLine());
        System.out.println("Введите Адрес (улица): ");
        parent.setStreet(scanner.nextLine());
        DistrictDAO districtDAO = new DistrictDAO();
        District district = districtDAO.findAddress(parent.getStreet());
        if ( district==null) {
            System.out.println(" Вы проживаете не в нашем городе.");
            System.out.println(" Запись ребенка в школу возможна только по месту проживания родителя.");
            System.exit(1);
        }

        while (true) {
            child = new Child();
            System.out.println("Введите имя ребенка:");
            child.setFIO(scanner.nextLine());
            System.out.println("Школы в Вашем районе:");
            showSchools(district.getDistrictId());
            parent.addChild(child);
            System.out.println("Продолжить запись Ваших детей? Да - 1, Нет - 0");
            if (!scanner.nextLine().equals("1")) break;
        }
        parentDAO.save(parent);
        //показать всех родителей и детей из БД
        showAll(parentDAO);

    }

    public static void showSchools(int district_id){
        System.out.println("Выберите школу в Вашем районе" );
        SchoolsDAO schoolsDAO = new SchoolsDAO();
        for (Schools school: schoolsDAO.findAll(district_id) ) {
            System.out.println(school);
        }

    }
    public static void showAll(ParentDAO parentDAO){
        System.out.println("Чтение из базы");
        for (Parent par: parentDAO.findAll()) {
            System.out.println(par);
            for (Child ch: par.getChildren()) {
                System.out.println(ch);
            }
        }
    }

}
