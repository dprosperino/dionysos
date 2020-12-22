/* WELCOME TO DIONYSOS */
    
    /*  Dionysos is a project which purpose it is to create a weekly meal plan.
    *   It uses the MySQL database "dionysos" running on this computer and
    *   searches for random meals in it according to the settings of the user.
    *   It then displays them on a separate window and creates a shopping list
    *   if wished.
    *
    *   This is the Connector class. This class is the class which actually
    *   connects to the database and inserts and reads entries. It then passes
    *   them to other classes by instantiating this class in other objects and
    *   calling the right functions.
    *
    *   Created by ********
    *   Last modified on 03. October 2018
    */


/* BEGIN OF CLASS */

package com.example;

import java.sql.*;
import java.util.*;

public class Connector {

    
/* CONSTRUCTOR */
    
    //No constructor needed for this class. Default constructor is enough.
    /*  One could think of establishing the connection in the constructor and
    *   set the statement and result variables as global variables and then
    *   close the connection after each call of an essential function.
    *   But this are thoughts which should be made when details really matter.
    *   For now, this works.
    */   
    
    
/* INITIALISING GLOBAL VARIABLES */ 
    
    /*  Defining login data for the database dionysos on this local machine.
    *   As stated in Settings.java hardcoding this data is not the nice way,
    *   however it works and the time for polishing this project is better spent
    *   somewhere else. Cheerio.
    */
    private final String URL = "jdbc:mysql://localhost:3306/dionysos?useSSL=false";
    private final String USERNAME = "root";
    private final String PASSWORD = "password";

    
/* ESSENTIAL FUNCTIONS */
    
    /*  This is the other very important method of this whole project.
    *   This is what actually IS the project, the rest is more or less just
    *   decoration.
    *   This function creates an entry of a dish in the database dionysos.
    *   It connects to the database, inserts the name of the dish and the
    *   preparation of said into the "gerichte" table. It inserts all
    *   ingredients into the "zutaten" table, if they are not already in it.
    *   If they are already in it, it gets their ID. Lastly it connects the
    *   dishes with the attendant ingredients in the "gerichtexzutaten" table.
    *
    *   @param name Name of dish which gets insert into database
    *   @param ingredients Array of ingredients which belong to the dish
    *   @param preparation Long string on how to prepare the meal
    *   @param type Defines the type of that dish
    */
    public void insert_entry (String name, String[] ingredients, String preparation, String type) {
        
        // Initialising local variables
        int gericht_id = 0;
        int zutat_id = 0;
        
        try {
            // Connect to database
            Connection connection = connect_database();
            Statement statement = connection.createStatement();
            ResultSet result;
            
            // Insert dish into gerichte table
            statement.executeUpdate(create_insert_dish_command(name, preparation, type));
            
            // Retrieve dish ID needed for gerichtexzutaten
            result = statement.executeQuery("SELECT gericht_id FROM gerichte WHERE gericht_name = '" + name + "';");
            while (result.next()) {
                gericht_id = result.getInt("gericht_id");
            }
            
            // Insert ingredients into zutaten table and at the same time with gericht_id into gerichtexzutaten
            // Loop for each ingredient in array
            for (String ingredient : ingredients) {
                
                // TRY to insert ingredient into database (ingredient may already be existing)
                try {
                    statement.executeUpdate(create_insert_ingredient_command(ingredient));
                    result = statement.executeQuery("SELECT zutat_id FROM zutaten WHERE zutat_name = '" + ingredient + "';");
                    while(result.next()){
                        zutat_id = result.getInt("zutat_id");
                    }
                    // Add zutat_id and gericht_id into gerichtexzutaten
                    statement.executeUpdate(create_insert_gerichtexzutaten_command(gericht_id, zutat_id));
                } catch (SQLException e) {
                    //If ingredient already exsits
                    if (e instanceof SQLIntegrityConstraintViolationException) {
                        result = statement.executeQuery("SELECT zutat_id FROM zutaten WHERE zutat_name = '" + ingredient + "';");
                        while(result.next()) {
                            zutat_id = result.getInt("zutat_id");
                        }
                        // Add zutat_id and gericht_id into gerichtexzutaten
                        statement.executeUpdate(create_insert_gerichtexzutaten_command(gericht_id, zutat_id));
                    } else {
                        System.out.println(e);
                    }
                }
            }
            
            // Close connection at the end
            connection.close();
            
            System.out.println("Dish added successfully to database.");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    /*  This is one of the most important methods in this whole project.
    *   It is one of the key features of this project: retrieving dishes from
    *   the database. It takes the ID of the searched dish and gets name,
    *   preparation and type of dish belonging to that ID. Then it gets all
    *   "zutat_id" from "gerichtexzutaten" which are ascribed to given dish ID.
    *   Lastly it gets the name of that "zutat_id" from the table "zutaten".
    *   It then packs all the information into a map (dictionary) and returns
    *   this map, which contains all teh information of the dish.
    *
    *   @param ID ID of the dish which wishes to be returned
    *   @return Returns map of that dish with keys: "name", "preparation", "ingredients", "type".
    *           All values are stored as arrays of strings, where name, ingredients and type contain only one value.
    */
    public Map get_dish(int ID) {
        
        // Initialising local variables
        String[] dish_name = new String[1];
        String[] preparation = new String[1];
        String[] type = new String[1];
        int number_ingredients = 0;
        
        try {
            // Connect to database
            Connection connection = connect_database();
            Statement statement = connection.createStatement();
            ResultSet result;
            
            // Get name of dish
            result = statement.executeQuery("SELECT gericht_name FROM gerichte WHERE gericht_id = " + ID + ";");
            while(result.next()){
                dish_name[0] = result.getString("gericht_name");
            }
            
            // Get preparation of dish
            result = statement.executeQuery("SELECT gericht_zubereitung FROM gerichte WHERE gericht_id = " + ID + ";");
            while(result.next()){
                preparation[0] = result.getString("gericht_zubereitung");
            }
            
            // Get type of dish
            result = statement.executeQuery("SELECT gericht_typ FROM gerichte WHERE gericht_id = " + ID + ";");
            while(result.next()){
                type[0] = result.getString("gericht_typ");
            }
            
            // Get number of ingredients
            result = statement.executeQuery("SELECT COUNT(zutat_id) FROM gerichtexzutaten WHERE gericht_id = " + ID + ";");
            while(result.next()){
                number_ingredients = result.getInt("COUNT(zutat_id)");
            }
            
            // Define array containg all intredients
            int ingredients_id[] = new int[number_ingredients];
            
            // Get all ingredients
            result = statement.executeQuery("SELECT zutat_id FROM gerichtexzutaten WHERE gericht_id = " + ID + ";");
            
            int i = 0;
            while(result.next()){                
                ingredients_id[i] = result.getInt("zutat_id");
                i++;
            }
            String ingredients[] = new String[number_ingredients];
            
            // Now we have all zutaten id in nice neat array
            // Now we get the name of that zutat_ID from the zutaten table
            for (int j = 0; j < number_ingredients; j++){
                result = statement.executeQuery("SELECT zutat_name FROM zutaten WHERE zutat_id = " + ingredients_id[j] + ";");
                while(result.next()){
                    ingredients[j] = result.getString("zutat_name");
                }
            }
            
            // Creating map
            Map<String, String[]> recipe = new HashMap<String, String[]>();
            
            // Adding key value pairs to that map
            recipe.put("name", dish_name);
            recipe.put("preparation", preparation);
            recipe.put("type", type);
            recipe.put("ingredients", ingredients);
            
            // Close connection
            connection.close();
            
            return recipe;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    } 
    
    /*  Searches for the highest "gericht_ID" from the table "gerichte".
    *   This function is needed, in order for creating a random integer from 1
    *   to that highest ID, to get random dishes.
    *
    *   @return Returns highest ID from table "gerichte"
    */
    public int get_highest_dishID() {
        // Initialising local variables
        int ID = 0;
        
        // Connect to database
        try {
            Connection connection = connect_database();
            Statement statement = connection.createStatement();
            ResultSet result;
            
            // Get highest ID
            result = statement.executeQuery("SELECT gericht_id FROM gerichte WHERE gericht_id=(SELECT max(gericht_id) FROM gerichte);");
            
            while(result.next()){
                ID = result.getInt("gericht_id");
            }
            
            connection.close();
            return ID;
        } catch (Exception e) {
            System.out.println(e);
            return 1;
        }
    }
    
    
/* AUXILIARY FUNCTIONS */
    
    /*  This function creates a connection to the database "dionysos" using
    *   the hardcoded login information. 
    *   It returns this connection as a class type Connection. It also prints
    *   its current state on the console.
    *
    *   @return Returns class type "Connection" to database "dionysos"
    */
    private Connection connect_database() {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            return connection;
        } catch (com.mysql.jdbc.exceptions.jdbc4.CommunicationsException e) {
            System.out.println("Connection to database failed.");
            System.out.println("Cannot communicate to database. Check if database is running.");
            
            System.exit(0);
            return null;
        } catch (SQLException e) {
            System.out.println("Database error!");
            System.out.println("Following error is thrown:");
            System.out.println(e);
            return null;
        }
    }
    
    /*  Returns string which is a ready-to-use SQL command in order to insert
    *   a dish into the "gerichte" table in the "dionysos" database. It uses the
    *   specific nomenclature of the dionysos database and the "gerichte" table.
    *   
    *   @return Returns SQL command, which inserts dish into table
    */
    private String create_insert_dish_command(String name, String preparation, String type){
        return "INSERT INTO gerichte SET gericht_name = '" + name + "', " + 
                "gericht_zubereitung = '" + preparation + "', gericht_typ = '" + type + "';";
    }
    
    /*  Returns string which is a ready-to-use SQL command in order to insert
    *   a single ingredient into the "zutaten" table in the "dionysos" database.
    *   It uses the specific nomenclature of the "dionysos" database and the
    *   "zutaten" table.
    *   
    *   @return Returns SQL command, which inserts an ingredient into table
    */
    private String create_insert_ingredient_command(String ingredient){
        return "INSERT INTO zutaten SET zutat_name = '" + ingredient + "';";
    }
    
    /*  Returns string which is a ready-to-use SQL command in order to insert
    *   an entry into the "gerichtexzutaten" table in the "dionysos" database.
    *   It uses the specific nomenclature of the "dionysos" database and the
    *   "gerichtexzutaten" table.
    *   
    *   @return Returns SQL command, which inserts dish into table
    */
    private String create_insert_gerichtexzutaten_command(int gericht_id, int zutat_id) {
        return "INSERT INTO gerichtexzutaten SET gericht_id = '" + gericht_id 
                + "', zutat_id = '" + zutat_id + "';";
    }  
}
