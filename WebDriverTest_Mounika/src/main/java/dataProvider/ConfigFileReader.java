package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath= "/Users/jaydeephansaliya/IdeaProjects/WebDriverTest_Mounika/src/main/resources/configs/Configuration.properties";


    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getBaseUrl(){
        String baseUrl = properties.getProperty("BaseUrl");
        if(baseUrl!= null) return baseUrl;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }
}
