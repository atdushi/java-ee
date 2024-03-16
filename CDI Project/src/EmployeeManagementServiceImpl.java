import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.util.List;

@Default
public class EmployeeManagementServiceImpl implements EmployeeManagementService {
	@Inject
	private EmployeeDAO dao;
	public List<Employee> getAllEmployees()
	{
		return dao.findAll();
	}
}
