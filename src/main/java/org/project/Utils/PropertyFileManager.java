package org.project.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * A class to manage property files.
 */
public class PropertyFileManager {
    public Properties prop;

    /**
     * Retrieves the properties from the specified file.
     *
     * @return the properties loaded from the file
     * @throws RuntimeException if an IOException occurs while loading the properties
     */
    public Properties getProp() {
        prop = new Properties(); // Initialize a new Properties object
        FileInputStream fis = null; // Declare a FileInputStream variable
        try {
            fis = new FileInputStream("Resources/data.properties"); // Create a new FileInputStream for the specified file
            prop.load(fis); // Load the properties from the FileInputStream
        } catch (IOException e) {
            throw new RuntimeException(e); // Throw a RuntimeException if an IOException occurs
        }
        return prop; // Return the loaded properties
    }
}
