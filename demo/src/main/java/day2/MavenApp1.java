package day2;
import java.util.ArrayList;
import java.io.Console;
public class MavenApp1 {
    
    public static void Addd(String addlist, ArrayList<String> shopcard) {
        if (addlist.indexOf(',') == -1) {
            if (shopcard.contains(addlist)) {
                System.out.println("" + addlist + " is already in the list!");
            } else {
            shopcard.add(addlist);
            System.out.printf(addlist + " added" + "%n");
            }
        } else {
            String[] arrOfStr = addlist.split(",");
            for (String item: arrOfStr) {
                if (shopcard.contains(item.trim())) {
                    System.out.println("" + item.trim() + " is already in the list!");
                } else {
                shopcard.add(item.trim());
                System.out.printf("" + item.trim() + " added" + "%n");
                }
            }
            
        }

    }
    public static void list(ArrayList<String> shopcard) {
        if (shopcard.size() > 0) {
            for (String i: shopcard) {
            int idx = 1 + shopcard.indexOf(i);
            System.out.printf("" + idx + ".  " + i + "%n");
            }
         } else {
            System.out.println("The list is empty");
        }        
    }
    public static void delete(int d, ArrayList<String> shopcard) {
        if (d > shopcard.size() || d <= 0) {
            System.out.println("Incorrect item index");
        } else {
            d--;
            System.out.println("Removing " + shopcard.get(d) + "...");
            shopcard.remove(d);
        }
    }
    public static void main(String[] args) {
        ArrayList<String> shopcard = new ArrayList<>();
        System.out.println("Welcome to your shopping cart");
        Console cons = System.console();
        while (1 <= 2) {
            String input = cons.readLine("What do you want to do?");
            if (input.split(" ")[0].contains("list")) {
                list(shopcard);
            } else if (input.split(" ")[0].contains("add")) {
                String k = input.split(" ")[0];
                String k2 = input.replaceFirst(k, "");
                Addd(k2, shopcard);
            } else if (input.split(" ")[0].contains("delete")) {
                try {
                    int j = Integer.parseInt(input.split(" ")[1]);
                    delete(j, shopcard);
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
