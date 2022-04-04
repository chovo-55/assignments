import Service.ProjectService;
import Units.Common;
import Units.Custom;
import Units.Interior;
/*import Units.Custom;*/

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        ProjectService service = new ProjectService();

        Common common = new Common(156422L,"common", 1241233.4, 312.3, date);
        Custom custom = new Custom(128763L, "custom", 12321.3, 563.4, date, "yes", "fire", "fire");
        Interior interior = new Interior(2343L, "interior",213D, date , "description");


        service.saveProject(custom.getId(),custom);
        service.saveProject(common.getId(),common);
        service.saveProject(interior.getId(),interior);

        service.printProjectById(156422L);
        service.printProjectByName("custom");
    }
}
