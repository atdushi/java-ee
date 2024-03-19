package com.virtualpairprogrammers.staffmanagement;

import javax.ejb.MessageDriven;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/EmployeeManagementQueue")
public class ExternalPayrollSystem implements MessageListener {
    @Override
    public void onMessage(Message message) {
        MapMessage msg = (MapMessage) message;
        try {
            String name = msg.getString("employeeName");
            System.out.println("Employee has now been added");

            // улетит в DMQ (mq.sys.dmq)
//            throw new NullPointerException();
        } catch (Exception e) {
            throw new RuntimeException("Bad Message" + e);
        }
    }
}
