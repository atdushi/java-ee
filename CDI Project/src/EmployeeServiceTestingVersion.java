import javax.enterprise.inject.Alternative;
import java.util.ArrayList;
import java.util.List;

@Alternative
public class EmployeeServiceTestingVersion implements EmployeeManagementService{
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> returnList = new ArrayList<>();
        returnList.add(new Employee("test employee 1"));
        returnList.add(new Employee("test employee 2"));
        return returnList;
    }
}
