import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    String projectType;
    ProjectService handler = new ProjectService();

    public void menu() {
        System.out.println(" ___________________________________________");
        System.out.println("|              PROJECT RECORDS              |");
        System.out.println(" -------------------------------------------");
        System.out.println("a - Create new project");
        System.out.println("b - Go through projects");
        System.out.println("x - quit");
        System.out.print("\nselect what you want to do: ");

        String selectionMenu = sc.next();
        switch (selectionMenu) {
            case "a":
                createMenu();
                break;
            case "b":
                seeProjectsMenu();
                break;
            case "x":
                return;
            default:
                System.out.println("\nInvalid input!");
                menu();
        }
    }
    public void createMenu() {
        System.out.println("-------------------------------------------");
        System.out.println("a - Custom");
        System.out.println("b - Common");
        System.out.println("c - Interior");
        System.out.println("x - go back");
        System.out.print("\nselect type of the project: ");

        projectType = sc.next();
        switch (projectType) {
            case "a" -> handler.initCustom(projectType);
            case "b" -> handler.initCommon(projectType);
            case "c" -> handler.initInterior(projectType);
            case "x" -> menu();
            default -> {
                System.out.println("\nInvalid input!");
                createMenu();
            }
        }
        menu();
    }
    public void seeProjectsMenu() {
        System.out.println("-------------------------------------------");
        System.out.println("a - Get project by id");
        System.out.println("b - Get project by name");
        System.out.println("c - Get project by price");
        System.out.println("d - Delete project by id");
        System.out.println("e - Update project by id");
        System.out.println("f - Delete all projects");
        System.out.println("x - go back");
        System.out.print("\nselect what you want to do: ");
        String selection = sc.next();
        switch (selection) {
            case ("a") -> handler.getById();
            case ("b") -> handler.getByName();
            case ("c") -> handler.getByPrice();
            case ("d") -> handler.deleteProject();
            case ("e") -> handler.updateProject(selection);
            case ("f") -> handler.deleteAll();
            case "x" -> menu();
            default -> {
                System.out.println("\nInvalid input!");
                seeProjectsMenu();
            }
        }
        menu();
    }
}