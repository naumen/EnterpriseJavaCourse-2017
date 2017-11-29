package ru.naumen.shop;

/**
 * @author pzykov
 * @since 29 нояб. 2017 г.	
 */
public class Item
{
    String name;
    int price;

    /**
     * @param name
     * @param price
     */
    public Item(String name, int price)
    {
        super();
        this.name = name;
        this.price = price;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return the price
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price)
    {
        this.price = price;
    }

}
