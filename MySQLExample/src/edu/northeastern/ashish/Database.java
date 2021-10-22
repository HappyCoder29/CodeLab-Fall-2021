package edu.northeastern.ashish;

import javax.xml.crypto.Data;

public class Database {
    // 1. Make the constructor as private
    // 2. Create a private static instance
    // 3. Create a public getter for the instance
    // 4. Create a new instance inside an if statement which check if the instance is null
    // 5. Create a private static object which will synchronize the entry of only one thread
    // 6. Double lock the synchronized statement (optional)

    private Database(){}// Step 1 default constructor is made private

    private static Database _instance; // Step 2

    private static final Object obj = new Object(); // Step 5

    public static Database get_instance() { // Step 3

        if(_instance == null){ // Step 6
            synchronized (obj){ // Step 5
                if(_instance == null){ // Step 4
                    _instance = new Database();
                }
            }
        }

        return _instance;
    }

    public String getConnection(){
        return "You are connected";
    }
}
