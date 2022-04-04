package Service;

import Units.Project;
import java.util.Map;
import java.util.TreeMap;

public class ProjectService {
    protected Map<Long, Project> dataStorage = new TreeMap<>();

    public void saveProject(Long id, Project values){
        dataStorage.put(id,values);
    }

    public void printProjectById(Long index){
        System.out.println(dataStorage.get(index));
    }

    public void printProjectByName(String name){
        for (Map.Entry<Long,Project> entry : dataStorage.entrySet()){
            if (entry.getValue().getName().equals(name)){
                System.out.println(entry.getValue());
            }
        }
    }

    public void printProjectByName(Double price){
        for (Map.Entry<Long,Project> entry : dataStorage.entrySet()){
            if (entry.getValue().getPrice().equals(price)){
                System.out.println(entry.getValue());
            }
        }
    }


}
