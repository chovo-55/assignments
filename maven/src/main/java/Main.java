import repository.Database;

public class Main {
    public static void main(String[] args) {
        Database service = new Database();
        //service.updateCommon("COMMON",1,"sad",123.3,543.1,null,null,null);
        service.insertIntoCommon("COMMON",6445,"abda",213.231,5634.231,null,null,null);
    }
}