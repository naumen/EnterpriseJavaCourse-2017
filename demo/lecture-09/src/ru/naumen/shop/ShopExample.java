package ru.naumen.shop;

/**
 * @author pzykov
 * @since 29 нояб. 2017 г.	
 */
public class ShopExample
{

    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException
    {
        ShoppingCard shoppingCard = new ShoppingCard();

        Thread customer1 = new Thread(() -> {
            shoppingCard.add(new Item("Banana", 1));
            shoppingCard.add(new Item("Beer", 5));
            System.out.format("Receipt for customer1 :\n%s\n", shoppingCard.getReceipt());
        });

        Thread customer2 = new Thread(() -> {
            shoppingCard.add(new Item("Cola", 2));
            shoppingCard.add(new Item("Bread", 1));
            System.out.format("Receipt for customer2 :\n%s\n", shoppingCard.getReceipt());
        });

        customer1.start();
        customer2.start();
        customer1.join();
        customer2.join();

    }

}
