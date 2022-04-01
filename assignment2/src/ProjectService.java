import java.util.ArrayList;
import java.util.Scanner;

public class ProjectService {
    ArrayList<Custom> customs = new ArrayList<>();
    ArrayList<Common> commons = new ArrayList<>();
    ArrayList<Interior> interiors = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int id;
    String name, heatingSource, heatingType, garage;
    double area, price;

    //--------------------------------------------------------------------//
    //check if id is unique
    public void idCheck(String projectType) {
        for (Custom custom : customs) {
            if (custom.id == id) {
                System.out.println("enter unique id!");
                switch (projectType) {
                    case ("a") -> initCustom(projectType);
                    case ("b") -> initCommon(projectType);
                    case ("c") -> initInterior(projectType);
                    default -> System.out.println("v idCheck");
                }
            }
        }
    }
    //method for getting date,
    public void getData(String projectType){
        System.out.print("Enter project id: ");
        int id = sc.nextInt();
        idCheck(projectType);
        System.out.print("Enter name of the project: ");
        name = sc.next();
        System.out.print("Enter price: ");
        price = sc.nextDouble();
    }
    public void custom(){
        System.out.print("Enter source of heat: ");
        heatingSource = sc.next();
        System.out.print("Enter type of heating: ");
        heatingType = sc.next();
        System.out.print("Enter area: ");
        area = sc.nextDouble();
        System.out.print("Is garage included?: ");
        garage = sc.next();
    }

    //init of projects
    public void initCustom(String projectType) {
        getData(projectType);
        custom();
        createCustom(id, name, heatingSource, heatingType, area, price, garage);
    }
    public void initCommon(String projectType) {
        getData(projectType);
        System.out.print("Enter area: ");
        area = sc.nextDouble();
        createCommon(id, name, area, price);
    }
    public void initInterior(String projectType) {
        getData( projectType);
        System.out.print("Enter some description of the project: ");
        String description = sc.next();
        createInterior(id, name, description, price);
    }

    //update of projects
    public void updateCustom(int i, String projectType) {
        getData(projectType);
        custom();
        customs.set(i,(new Custom(id, name, heatingSource, heatingType, area, price, garage )));
    }
    public void updateCommon(int i,String projectType) {
        getData(projectType);
        System.out.print("Enter area: ");
        area = sc.nextDouble();
        commons.set(i,(new Common(id, name, area, price)));
    }
    public void updateInterior(int i, String projectType) {
        getData(projectType);
        System.out.print("Enter some description of the project: ");
        String description = sc.next();
        interiors.set(i,(new Interior(id, name, description, price)));
    }

    //creating projects
    public void createCustom(int id, String name, String heatingSource, String heatingType, double area, double price, String garage) {

        customs.add(new Custom(id, name, heatingSource, heatingType, area, price, garage));
        System.out.println(customs.get(0).id);
    }
    public void createCommon(int id, String name, double area, double price) {
        commons.add(new Common(id, name, area, price));
        System.out.println(commons.get(0).id);
    }
    public void createInterior(int id, String name, String description, double price) {
        interiors.add(new Interior(id, name, description, price));
        System.out.println(interiors.get(0).id);
    }
//--------------------------------------------------------------------//
    //required methods

    public void getById() {
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        for (int i = 0; i < customs.size() ; i++) {
            if (customs.get(i).id == id) {
                System.out.println(customs.get(i).toString());
                return;
            }
        }
        for (int i = 0; i < commons.size() ; i++) {
            if (commons.get(i).id == id) {
                System.out.println(commons.get(i).toString()); return;
            }
        }
        for (int i = 0; i < interiors.size() ; i++) {
            if (interiors.get(i).id == id) {
                System.out.println(interiors.get(i).toString());
                return;
            }
        }
    }
    public void getByName() {
        System.out.print("Enter name: ");
        String name = sc.next();
        for (int i = 0; i < customs.size() ; i++) {
            if (customs.get(i).name.equals(name)) {
                System.out.println(customs.get(i).toString());
                return;
            }
        }
        for (int i = 0; i < commons.size() ; i++) {
            if (commons.get(i).name.equals(name)) {
                System.out.println(commons.get(i).toString());
                return;
            }
        }
        for (int i = 0; i < interiors.size() ; i++) {
            if (interiors.get(i).name.equals(name)) {
                System.out.println(interiors.get(i).toString());
                return;
            }
        }
    }
    public void getByPrice() {
        System.out.print("Enter price: ");
        int price = sc.nextInt();
        for (int i = 0; i < customs.size() ; i++) {
            if (customs.get(i).price == price) {
                System.out.println(customs.get(i).toString());
                return;
            }
        }
        for (int i = 0; i < commons.size() ; i++) {
            if (commons.get(i).price == price) {
                System.out.println(commons.get(i).toString());
                return;
            }
        }
        for (int i = 0; i < interiors.size() ; i++) {
            if (interiors.get(i).price == price) {
                System.out.println(interiors.get(i).toString());
                return;
            }
        }
    }

    public void deleteProject() {
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        for (int i = 0; i < customs.size(); i++) {
            if (customs.get(i).id == id) {
                customs.remove(i);
                System.out.println("Project with id "+id+" was deleted.");
                return;
            }
        }
        for (int i = 0; i < commons.size(); i++) {
            if (commons.get(i).id == id) {
                commons.remove(i);
                System.out.println("Project with id "+id+" was deleted.");
                return;
            }
        }
        for (int i = 0; i < interiors.size(); i++) {
            if (interiors.get(i).id == id) {
                interiors.remove(i);
                System.out.println("Project with id "+id+" was deleted.");
                return;
            }
        }
    }
    public void updateProject(String projectType){
        System.out.print("Enter id of project you want to update: ");
        int id = sc.nextInt();
        for (int i = 0; i < customs.size(); i++) {
            if (customs.get(i).id == id) {
                updateCustom(i, projectType);
                return;
            }
        }
        for (int i = 0; i < commons.size(); i++) {
            if (commons.get(i).id == id) {
                updateCommon(i, projectType);
                return;
            }
        }
        for (int i = 0; i < interiors.size(); i++) {
            if (interiors.get(i).id == id) {
                updateInterior(i, projectType);
                return;
            }
        }
    }
    public void deleteAll(){
        customs.clear();
        commons.clear();
        interiors.clear();
        System.out.println("All projects were deleted!");
    }
}