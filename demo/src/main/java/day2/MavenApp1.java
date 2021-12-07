package day2;
import java.io.Console;
import java.io.File;
public class MavenApp1 {

    public static void main(String[] args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        if (args.length == 0) {
            new File(System.getProperty("user.dir") + "\\db").mkdirs();
        } else {
            new File(System.getProperty("user.dir") + "\\" + args).mkdirs();
        }
        
        Cart cart = new Cart();
        System.out.println("Welcome to your shopping cart");
        Console cons = System.console();
        mainloop: while (1 <= 2) {
            String input = cons.readLine("What do you want to do?");

            switch (input.trim().toLowerCase().split(" ")[0]) {
                case "list":
                if (cart.getCartItems().isEmpty()) {
                    System.out.println("The cart is empty");
                } else {
                    cart.cartList(cart.getCartItems());
                }
                break;

                case "add":
                String k = input.split(" ")[0];
                String k2 = input.replaceFirst(k, "").trim();

                if (k2.indexOf(",") == -1) {
                    if (cart.getCartItems().contains(k2)){
                        System.out.println("" + k2 + " is already in the list!");
                    } else {
                        cart.cartAdd(k2);
                    }
                } else {
                    String[] addlist = k2.split(",");
                    for (String i: addlist) {
                        String j = i.trim();
                        if (cart.getCartItems().contains(j)){
                            System.out.println("" + j + " is already in the list!");
                        } else {
                            cart.cartAdd(j);
                        }

                    }

                }
                break;

                case "delete":
                try {
                    int j = Integer.parseInt(input.split(" ")[1]);
                    cart.cartDelete(j);
                } catch (NumberFormatException n) {
                    System.out.println("Please type the number");
                    continue;
                }
                break;

                case "exit":
                break mainloop;
            }
        }
        System.out.println("Program end");
    }
}


