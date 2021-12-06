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
        while (1 <= 2) {
            String input = cons.readLine("What do you want to do?");
            if (input.equals("list")) {
                cart.cartList();
            } else if (input.startsWith("add ")) {
                String k = input.split(" ")[0];
                String k2 = input.replaceFirst(k, "");
                cart.cartAdd(k2);
            } else if (input.startsWith("delete ")) {
                try {
                    int j = Integer.parseInt(input.split(" ")[1]);
                    cart.cartDelete(j);
                } catch (NumberFormatException n) {
                    System.out.println("Please type the number");
                    continue;
                }
            } else if (input.split(" ")[0].contains("exit")) {
                break;
            } else {
                System.out.println("Please try again. (List / Add <item 1, item 2, etc> / Delete <item number> / Exit)");

            }
        }
        System.out.println("Program end");
    }
}


