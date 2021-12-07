package day2;

import java.util.ArrayList;

public class Cart {
    private ArrayList<String> cartItems; // = new ArrayList<>();

    public Cart() {
        cartItems = new ArrayList<>();
    }

    public ArrayList<String> getCartItems() {
        return cartItems;
    }
        
    public void cartAdd(String additem) {
        cartItems.add(additem);
        System.out.println("Added " + additem);


/*         if (addlist.indexOf(',') == -1) {
            if (cartItems.contains(addlist)) {
                System.out.println("" + addlist + " is already in the list!");
            } else {
            cartItems.add(addlist.trim());
            System.out.printf(addlist.trim() + " added" + "%n");
            }
        } else {
            String[] arrOfStr = addlist.split(",");
            for (String item: arrOfStr) {
                if (cartItems.contains(item.trim())) {
                    System.out.println("" + item.trim() + " is already in the list!");
                } else {
                cartItems.add(item.trim());
                System.out.printf("" + item.trim() + " added" + "%n");
                }
            }
            
        } */

    }
    public void cartList(ArrayList<String> items) {
        int idx = 1;
        for (String i: items) {
            
            System.out.printf("" + idx + ".  " + i + "%n");
            idx++;
        }

/*         System.out.println(cartItems);
        if (cartItems.size() > 0) {
            for (String i: cartItems) {
            int idx = 1 + cartItems.indexOf(i);
            System.out.printf("" + idx + ".  " + i + "%n");
            }
         } else {
            System.out.println("The list is empty");
        } */        
    }
    public void cartDelete(int d) {
        if (d > cartItems.size() || d <= 0) {
            System.out.println("Incorrect item index");
        } else {
            d--;
            System.out.println("Removing " + cartItems.get(d) + "...");
            cartItems.remove(d);
    
        }
    }
    public int numItems() {
        return cartItems.size();
    }
}
