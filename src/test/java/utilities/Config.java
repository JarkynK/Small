package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static Properties pr;

    static {
        String path = "Configuration.properties";
        try {

            FileInputStream file = new FileInputStream(path);
            pr = new Properties();
            pr.load(file);
            file.close();
        } catch (IOException e) {
            System.out.println("File is not found!");
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return pr.getProperty(key);
    }
}