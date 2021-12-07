package day2;

import java.util.ArrayList;

public class Cart {
    private ArrayList<String> cartItems; 

    public Cart() {
        cartItems = new ArrayList<>();
    }

    public ArrayList<String> getCartItems() {
        return cartItems;
    }
        
    public void cartAdd(String additem) {
        cartItems.add(additem);
        System.out.println("Added " + additem);

    }
    public void cartList(ArrayList<String> items) {
        int idx = 1;
        for (String i: items) {
            
            System.out.printf("" + idx + ".  " + i + "%n");
            idx++;
        }

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
