package com.virtualpairprogrammers.test;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class ShoppingCartSessionImplementation implements ShoppingCartSession {
    private List<String> items;

    public ShoppingCartSessionImplementation() {
        items = new ArrayList<>();
    }

    @Override
    public void addItem(String item){
        items.add(item);
    }

    @Override
    public List<String> getAllItems(){
        return items;
    }

    @Override
    @Remove
    public void checkout(){
        // smth with database
    }
}
