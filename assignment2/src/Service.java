import java.util.ArrayList;
import java.util.Scanner;

public class Service {
    Custom custom = new Custom();
    ArrayList<Object> projects = new ArrayList<>();
    protected Scanner sc = new Scanner(System.in);
    protected String name, heatingSource, heatingType, garage;
    protected Long id;
    protected double area, price;

  /*  public void idCheck(String projectType) {
        for (Ob project : projects) {
            if (project.id == id) {
                System.out.println("enter unique id!");
                switch (projectType) {
                    case ("a") -> initCustom(projectType);
                    case ("b") -> initCommon(projectType);
                    case ("c") -> initInterior(projectType);
                    default -> System.out.println("v idCheck");
                }
            }
        }
    }*/

    public void getData(String projectType){
        System.out.print("Enter name of the project: ");
        name = sc.next();
        System.out.print("Enter price: ");
        price = sc.nextDouble();
    }

    public void initCustom(String projectType) {
        System.out.print("Enter project id: ");
        getData(projectType);
        System.out.print("Enter source of heat: ");
        heatingSource = sc.next();
        System.out.print("Enter type of heating: ");
        heatingType = sc.next();
        System.out.print("Enter area: ");
        area = sc.nextDouble();
        System.out.print("Is garage included?: ");
        garage = sc.next();
        createCustom(id, name, heatingSource, heatingType, area, price, garage);
    }

    public void initCustom(String projectType) {
        System.out.print("Enter project id: ");
        getData(projectType);
        System.out.print("Enter source of heat: ");
        heatingSource = sc.next();
        System.out.print("Enter type of heating: ");
        heatingType = sc.next();
        System.out.print("Enter area: ");
        area = sc.nextDouble();
        System.out.print("Is garage included?: ");
        garage = sc.next();
        createCustom(id, name, heatingSource, heatingType, area, price, garage);
    }

    public void initInterior(String projectType) {
        getData( projectType);
        System.out.print("Enter some description of the project: ");
        String description = sc.next();
        createInterior(id, name, description, price);
    }

    public void initCommon(String projectType) {
        getData(projectType);
        System.out.print("Enter area: ");
        area = sc.nextDouble();
        createCommon(id, name, area, price);
    }



    public void createCustom(Long id, String name, String heatingSource, String heatingType, double area, double price, String garage) {
        projects.add(new Custom(id, name, heatingSource, heatingType, area, price, garage));
    }
    public void createCommon(Long id, String name, double area, double price) {
        projects.add(new Common(id, name, area, price));
    }
    public void createInterior(Long id, String name, String description, double price) {
        projects.add(new Interior(id, name, description, price));
    }

    public void updateCustom(int i, String projectType) {
        System.out.print("Enter project id: ");
        getData(projectType);
        System.out.print("Enter source of heat: ");
        heatingSource = sc.next();
        System.out.print("Enter type of heating: ");
        heatingType = sc.next();
        System.out.print("Enter area: ");
        area = sc.nextDouble();
        System.out.print("Is garage included?: ");
        garage = sc.next();
        projects.set(i,(new Custom(id, name, heatingSource, heatingType, area, price, garage )));
    }

    public void updateCommon(int i,String projectType) {
        getData(projectType);
        System.out.print("Enter area: ");
        area = sc.nextDouble();
        projects.set(i,(new Common(id, name, area, price)));
    }
    public void updateInterior(int i, String projectType) {
        getData(projectType);
        System.out.print("Enter some description of the project: ");
        String description = sc.next();
        projects.set(i,(new Interior(id, name, description, price)));
    }

    public void updateProject(String projectType){
        System.out.print("Enter id of project you want to update: ");
        int id = sc.nextInt();
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i). == id) {
                updateCustom(i, projectType);
                return;
            }
        }
    }
}