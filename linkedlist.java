import java.util.*;

class Item {
    int itemNo;
    String itemName;
    double price;

    public Item(int itemNo, String itemName, double price) {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.price = price;
    }

    public void display() {
        System.out.println("itemNo=" + itemNo +
                ", itemName='" + itemName + '\'' +
                ", price=" + price);
    }

}

public class linkedlist {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int itmno = 3;
        String str;
        Double price;
        // Generate a list of items using LinkedList
        LinkedList<Item> items = new LinkedList<>();
        items.add(new Item(1, "Item1", 10.99));
        items.add(new Item(2, "Item2", 5.99));
        items.add(new Item(3, "Item3", 7.99));

        System.out.println("enter the name of item and price to add");
        str = scr.next();
        price = scr.nextDouble();
        items.add(new Item(++itmno, str, price));
        // Display the list of items
        System.out.println("List of Items: ");
        for (Item item : items) {
            item.display();
        }
        Comparator<Item> compareByPrice = (Item i1, Item i2) -> Double.compare(i1.price, i2.price);
        items.sort(compareByPrice);
        System.out.println("\nSorted List of Items: ");
        for (Item item : items) {
            item.display();
        }
        System.out.println("enter the name of item to remove");
        String rm;
        rm = scr.next();
        int i = 0;
        for (Item item : items) {
            if (rm.equals(item.itemName)) {
                items.remove(i);
                break;
            } else {
                i++;
            }
        }
        System.out.println("\nList of Items after removal: ");
        for (Item item : items) {
            item.display();
        }
    }
}