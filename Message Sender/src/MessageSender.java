import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Date;

public class MessageSender {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Context ctx = new InitialContext();

            Queue queue = (Queue) ctx.lookup("jms/EmployeeManagementQueue");

            ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/ConnectionFactory");

            connection = cf.createConnection();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE /*излишний параметр*/);

            MessageProducer messageProducer = session.createProducer(queue);

            TextMessage message = session.createTextMessage("The time is now" + new Date());

//			MapMessage message = session.createMapMessage();
//
//			message.setString("employeeName", "Josh Bloch");
//			message.setString("employeeJobRole", "Chief Engineer");
//			message.setDouble("employeeSalary", 1000000);

            messageProducer.send(message);

//            MessageConsumer messageConsumer = session.createConsumer(queue);
//            connection.start(); //to start delivery of the message
//            message = (TextMessage) messageConsumer.receive();
//            System.out.println(message.getText());

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    System.out.println(e);
                }
            }
            System.exit(0);
        }
    }
}
