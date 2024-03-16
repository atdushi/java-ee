import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;


public class CDIClient 
{
	public static void main(String[] args)
	{
		WeldContainer factory = new Weld().initialize();
		
		EmployeeManagementService ems = factory.instance().select(EmployeeManagementService.class).get();
		
		for (Employee next: ems.getAllEmployees())
		{
			System.out.println(next);
		}
	}
}
