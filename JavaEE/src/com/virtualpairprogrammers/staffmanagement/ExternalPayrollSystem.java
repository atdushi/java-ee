package com.virtualpairprogrammers.staffmanagement;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/EmployeeManagementQueue",
        messageListenerInterface = MessageListener.class,
        activationConfig = {
                @ActivationConfigProperty(propertyName = "endpointExceptionRedeliveryAttempts",
                        propertyValue = "10")

                // add in more properties here if desired.
        })
public class ExternalPayrollSystem {
    // This method is called automatically when a message is received on the queue.
    public void onMessage(Message originalMessage) throws SystemUnavailableException {
        try {
            MapMessage message = (MapMessage) originalMessage;

            String name = message.getString("employeeName");
            String jobRole = message.getString("employeeJobRole");
            int salary = message.getInt("employeeSalary");

            // улетит в DMQ (mq.sys.dmq)
            // throw new NullPointerException();

            // connect to our legacy system and send the employee details across.
            if (Math.random() < 0.7) {
                throw new SystemUnavailableException();
            }

            System.out.println("Employee has now been added with the name of " + name + "and job role of " + jobRole);
        } catch (JMSException e) {
            System.out.println("Bad message received!!!!");
            throw new RuntimeException(e);
        }
    }

}
