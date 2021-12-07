package day2;
import java.io.Console;
import java.io.File;
import java.io.IOException;
public class MavenApp1 {

    public static void main(String[] args) throws IOException {
        String saveDir = "";
        Cart cart = new Cart();
        ShoppingCartDB scdb = new ShoppingCartDB();

        // create db directory 
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        if (args.length == 0) {
            saveDir = System.getProperty("user.dir") + "\\db";
        } else {
            saveDir = System.getProperty("user.dir") + "\\" + args;
        }
        System.out.println("Save Directory = " + saveDir);
        new File(saveDir).mkdirs();
        
        // welcome message and main working loop
        System.out.println("Welcome to your shopping cart");
        Console cons = System.console();
        mainloop: while (1 <= 2) {
            String input = cons.readLine("What do you want to do? ");

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

                case "login":
                if (input.split(" ").length <= 1) {
                    System.out.println("No username");
                    break;
                }
                String[] li = scdb.login(input.split(" ")[1], saveDir);
                cart.clearCart();
                for (int i = 1; i < li.length; i++) {
                    cart.cartAdd(li[i]);
                }
                System.out.println("" + input.split(" ")[1] + ", your list contains the following items:");
                cart.cartList(cart.getCartItems());
                break;

                case "save":
                scdb.save(cart.getCartItems(), saveDir, args);
                break;

                case "users":
                scdb.users(saveDir);
                break;

                case "exit":
                break mainloop;

                case "quit":
                break mainloop;

                default:
                System.out.println("Invalid Input. Try again. Available commands:");
                System.out.println("login <user>");
                System.out.println("add <item1>, <item2>, <item3>, <etc>");
                System.out.println("list");
                System.out.println("delete <item index>");
                System.out.println("save");
                System.out.println("users");
                System.out.println("exit");
                break;
            }
        }
        System.out.println("Program end");
    }
}


