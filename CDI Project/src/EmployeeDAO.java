import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	public List<Employee> findAll()
	{
		List<Employee> results = new ArrayList<Employee>();
		
		results.add(new Employee("a"));
		results.add(new Employee("b"));
		
		return results;
	}
}
