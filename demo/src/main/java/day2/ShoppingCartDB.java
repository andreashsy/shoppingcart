package day2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDB {
    Boolean isLoggedIn = false;
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
                for (String l: lines)
                System.out.println(l);
                isLoggedIn = true;
                System.out.println("Logged in " + user);
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
        System.out.println("dir is " + dir);
        System.out.println("Saving to " + dir + "\\" + user + ".db");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dir + "\\" + user + ".db"))) {
            //int l = (String[]) dir.split('\\')
            String[] fldr = dir.split("\\\\");
            System.out.println(fldr.length);
            writer.write("" + dir.split("\\\\")[fldr.length -1] + "/" + user + ".db");
            writer.newLine();
            for (String item: cartItems) {
                writer.write(item);
                writer.newLine();
            }
            
        }

    }

    public void users(String dir) {
        File[] files = new File(dir).listFiles();
        for (File file: files) 
        System.out.println(file);
    }
    
}
