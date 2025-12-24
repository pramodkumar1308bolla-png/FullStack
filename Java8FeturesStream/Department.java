package Java8FeturesStream;
import java.util.*;
import java.util.stream.Collectors;

class Main {
    String deptName;
    List<String> employees;

    Main(String deptName, List<String> employees) {
        this.deptName = deptName;
        this.employees = employees;
    }

    List<String> getEmployees() {
        return employees;
    }
}

public class Department {
    public static void main(String[] args) {

        List<Main> departments = Arrays.asList(
            new Main("IT", Arrays.asList("Ram", "Shyam")),
            new Main("HR", Arrays.asList("Sita", "Gita")),
            new Main("Finance", Arrays.asList("Ravi", "Kiran")),
            new Main("Finance", Arrays.asList("Ravi", "Kiran"))
            
        );

//        List<String> allEmployees =departments.stream().flatMap(d -> d.getEmployees().stream()).collect(Collectors.toList());
        List<String> allEmployees =departments.stream().flatMap(d -> d.getEmployees().stream()).distinct().collect(Collectors.toList());
        System.out.println(allEmployees);
    }
}

