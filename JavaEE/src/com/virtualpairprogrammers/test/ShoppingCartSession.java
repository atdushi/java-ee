package com.virtualpairprogrammers.test;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ShoppingCartSession {
    void addItem(String item);

    List<String> getAllItems();

    void checkout();
}
