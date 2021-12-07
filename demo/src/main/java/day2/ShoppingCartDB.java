package day2;

import java.io.*;
import java.util.ArrayList;

public class ShoppingCartDB {
    String currDir = System.getProperty("user.dir");
    Boolean isLoggedIn = false;
    String user = "";
   

    public void login(String user) throws IOException {
        this.user = user;
        try {
            try(BufferedReader br = new BufferedReader(new FileReader(currDir + "\\" + user + ".db"))) {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
            
                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                String everything = sb.toString();
                System.out.println(everything);
                isLoggedIn = true;
                System.out.println("Logged in " + user);
            }

        } catch (FileNotFoundException f) {
            File myObj = new File(currDir + "\\" + user + ".db");
        }
    }

    public void save(String[] folder, ArrayList<String> cartItems) throws IOException{
        if (!isLoggedIn) {
            System.out.println("Please login first");
            return;
        }
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(currDir + "\\" + user + ".db"), "utf-8"))) {
            writer.write("" + folder + "/" + user + ".db");
            for (String item: cartItems) {
                writer.write(item);
            }
            
        }

    }

    public void users() {
        File[] files = new File(currDir + "//" + user).listFiles();
        for (File file: files) 
        System.out.println(file);
    }
    
}
