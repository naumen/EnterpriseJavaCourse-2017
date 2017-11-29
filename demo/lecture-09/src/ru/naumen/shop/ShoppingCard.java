package ru.naumen.shop;

import java.util.ArrayList;

/**
 * @author pzykov
 * @since 29 нояб. 2017 г.	
 */
public class ShoppingCard
{
    ThreadLocal<ArrayList<Item>> myThreadLocal = ThreadLocal.withInitial(ArrayList::new);

    public void add(Item item)
    {
        myThreadLocal.get().add(item);
    }

    public String getReceipt()
    {
        StringBuilder sb = new StringBuilder();
        myThreadLocal.get().forEach(item -> sb.append(String.format("%s - %d$\n", item.getName(), item.getPrice())));
        return sb.toString();
    }

    public void remove(Item item)
    {
        myThreadLocal.get().add(item);
    }
}
