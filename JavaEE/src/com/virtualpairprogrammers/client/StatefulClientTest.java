package com.virtualpairprogrammers.client;

import com.virtualpairprogrammers.test.ShoppingCartSession;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;

public class StatefulClientTest {
    public static void main(String[] args) {
        try {
            Context jndi = new InitialContext();

            ShoppingCartSession cart = (ShoppingCartSession)
                    jndi.lookup("java:global/EmployeeManagement/ShoppingCartSessionImplementation");

            cart.addItem("tennis racquet");
            cart.addItem("toaster");
            cart.addItem("some books");

            List<String> items = cart.getAllItems();

            for (String next: items){
                System.out.println(next);
            }

            cart.checkout();

        } catch (NamingException e) {
            System.out.println(e);
        }
    }
}
