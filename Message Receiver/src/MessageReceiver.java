import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.InitialContext;


public class MessageReceiver 
{
	public static void main(String[] args) 
	{
		try
		{
			InitialContext ctx = new InitialContext();

			Queue queue = (Queue)ctx.lookup("jms/EmployeeManagementQueue");

			ConnectionFactory factory = (ConnectionFactory)ctx.lookup("jms/ConnectionFactory");

			Connection connection = factory.createConnection();
			
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			MessageConsumer consumer = session.createConsumer(queue);

			consumer.setMessageListener(new TextMessageListener());

//			consumer.setMessageListener(new MapMessageListener());

			connection.start();

			while (true){}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
