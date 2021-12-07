package day2;

import java.io.*;
import java.util.ArrayList;

public class ShoppingCartDB {
    private Boolean isLoggedIn = false;
    String user = "";
    
   

    public String[] login(String user, String dir) throws IOException {
        this.user = user;
        String userDir = dir + "\\" + user + ".db";
        try {
            try(BufferedReader br = new BufferedReader(new FileReader(userDir))) {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
            
                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                String everything = sb.toString();
                String[] lines = everything.split("\\r?\\n");
                isLoggedIn = true;
                System.out.println("Logged in " + user + ", loading saved shopping list...");
                return lines;
            }

        } catch (FileNotFoundException f) {
            File myObj = new File(dir + "\\" + user + ".db");
            myObj.createNewFile();
            isLoggedIn = true;
            System.out.println("New user " + user + " created");
            String[] lines = new String[0];
            return lines;
        }
    }

    public void save(ArrayList<String> cartItems, String dir, String[] usr) throws IOException{
        if (!isLoggedIn) {
            System.out.println("Please login first");
            return;
        }
        System.out.println("User is " + user);
        System.out.println("Saving to " + dir + "\\" + user + ".db");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dir + "\\" + user + ".db"))) {
            String[] fldr = dir.split("\\\\");
            writer.write("" + fldr[fldr.length -1] + "/" + user + ".db");
            writer.newLine();
            for (String item: cartItems) {
                writer.write(item);
                writer.newLine();
            }
        }

    }

    public void users(String dir) {
        File[] files = new File(dir).listFiles();
        System.out.println("User list:");
        for (File file: files) {
            String fname = file.getName(); 
            String f2 = fname.replaceFirst("[.][^.]+$", "");
            System.out.println(f2);


        
        }

    }
    
}
