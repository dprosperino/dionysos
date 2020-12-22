/* WELCOME TO DIONYSOS */
    
    /*  Dionysos is a project which purpose it is to create a weekly meal plan.
    *   It uses the MySQL database "dionysos" running on this computer and
    *   searches for random meals in it according to the settings of the user.
    *   It then displays them on a separate window and creates a shopping list
    *   if wished.
    *
    *   This is the Starting_view class. It is the first window the user sees
    *   and it is created by running this program. On this window other windows
    *   for adding a dish to the database or setting the settings can be opened.
    *   It also creates the final result the actual week plan window.
    *   It contains the main method.
    *
    *   Created by ********
    *   Last modified on 03. October 2018
    */


/* BUG REPORT */

    /*  No program is perfect - neither this one. This is the complete report.
    *   Till now two bugs have been found and for one an avoidance was found, so
    *   it cannot occur anymore.
    *   
    *   FIRST BUG: WEEKDAYS CALCULATOR
    *   DESCRIPTION: If the starting day is bigger than the ending day, the
    *   program is not able to calculate the right amount of dishes and to
    *   display the right order of the days. For example if the plan is started
    *   on Saturday and ends on Thursday it is meant that this plan goes from
    *   Saturtday, Sunday, Monday to Thursday and states that four dishes are
    *   needed. However, it does not.
    *   Instead it throws a NegativeArraySizeException with line 195 in current
    *   state and an ArrayIndexOutOfBoundsException if line 195 is changed to
    *   "   desired_amount_of_dishes = abs(EndingDay - StartingDay) + 1;    ".
    *   SOLUTION: I have no solution for it other then avoiding it completly and
    *   only allow settings where the ending day is after the starting day.
    *
    *   SECOND BUG: WEEKPLAN SIZE
    *   DESCRIPTION: The size of the Week_plan window remains constant
    *   regardingless of the number of dishes. When less then seven meals are
    *   chosen, the size of the panel does not change and creates an unpleasent
    *   void by doing so. Trying to set the sizes of the panels in the
    *   set nth panel methods does not work sadly. No exception is thrown.
    *   SOLUTION: No solution so far. Just live with it.
    */


/* BEGIN OF CLASS */

package com.example;

import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Starting_view extends javax.swing.JFrame {
    

/* INITIALISING GLOBAL VARIABLES */   
    
    /*  The coming integers and the boolean value are the values of the
    *   settings which were set by the user. 
    */
    private int StartingDay, EndingDay, AmountMeat_Set, AmountFish_Set, AmountVegetarian_Set, AmountVegan_Set;
    private boolean Deepfrozen;
    
    // The coming integers and the current counters.
    private int AmountMeat_Current, AmountFish_Current, AmountVegetarian_Current, AmountVegan_Current;
    
    // Initialising an empty set for used IDs
    private Set used_ID = new HashSet();
    
    /*  The comuing up string array "settings" containts the information of the
    *   settings in a very specific order! Each entry has a specific meaning
    *   as shown below.
    *   First: Starting day of weekplan (0: Monday, 1: Tuesday, ..., 6: Sunday)
    *   Second: End day of weekplan (nomenclature as above)
    *   Third: If deepfrozen food is selected or not.
    *   Fourth: Amount of meat dishes
    *   Fifth: Amount of fish dishes
    *   Sixth: Amount of vegetarian dishes
    *   Seventh: Amount of vegan dishes
    */
    private String[] settings = {"0", "6", "false", "3", "1", "3", "0"};
    

/* CONSTRUCTOR */  
    public Starting_view() {
        initComponents();       // NetBeans generated code
        ReadSettings(settings); // Setting settings to custom values
    }

    
/* AUTO GENERATED CODE BY NETBEANS */
    // Auto generated code by NetBeans, imporant do not modify
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        BTN_CreateEatPlan = new javax.swing.JButton();
        MenuBar_StartingView = new javax.swing.JMenuBar();
        Menu_Edit = new javax.swing.JMenu();
        MenuItem_AddDish = new javax.swing.JMenuItem();
        Menu_Settings = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Window [Dionysos]");

        BTN_CreateEatPlan.setText("Create Food Plan");
        BTN_CreateEatPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CreateEatPlanActionPerformed(evt);
            }
        });

        Menu_Edit.setText("Edit");

        MenuItem_AddDish.setText("Add Dish to Database...");
        MenuItem_AddDish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItem_AddDishActionPerformed(evt);
            }
        });
        Menu_Edit.add(MenuItem_AddDish);

        MenuBar_StartingView.add(Menu_Edit);

        Menu_Settings.setText("Settings...");
        Menu_Settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu_SettingsMouseClicked(evt);
            }
        });
        MenuBar_StartingView.add(Menu_Settings);

        setJMenuBar(MenuBar_StartingView);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(225, Short.MAX_VALUE)
                .addComponent(BTN_CreateEatPlan)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(BTN_CreateEatPlan)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
/* BUTTON DEPENDENT FUNCTIONS */
    
    // Action if clicked on "Create Food Plan!"
    private void BTN_CreateEatPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CreateEatPlanActionPerformed
        
        // Defining internal variables
        int highest_id;
        int random_int;
        int desired_amount_of_dishes, current_amount_of_dishes;
        
        // Initialastion
        used_ID.clear();        // Empty used_ID set with every creation of plan
        NullCurrentAmounts();   // Set all current counters to zero
        
        // Firstly, read current settings. This functions updates the global variables!
        ReadSettings(settings);
        
        // Create new connection to database
        Connector connector = new Connector();
        
        // Get highest ID from database
        highest_id = connector.get_highest_dishID();
        
        // Set amount of dishes
            // Causes bug "WEEKDAYS CALCULATION"
            // Look up Starting_view.java BUG REPORT for additonal details
            desired_amount_of_dishes = EndingDay - StartingDay + 1;
            current_amount_of_dishes = 0;
        
        // Initialise result set
        Map[] result = new Map[desired_amount_of_dishes];
        
        // While loop is repeated till amount of valid dishes equals desired amount of dishes
        while (current_amount_of_dishes != desired_amount_of_dishes) {
            
            random_int = ThreadLocalRandom.current().nextInt(1, highest_id + 1);
            Map current_dish = get_dish(random_int);
            
            // Check if dish is valid, if so add it to result array
            if (is_dish_valid(current_dish, random_int)) {
                result[current_amount_of_dishes] = current_dish;
                current_amount_of_dishes ++;
                used_ID.add(random_int);    //And add used ID to used_ID set
            }
        }
        
        // Now we got the result array!
        
        // Include frozen food by overwriting a random dish in result array
        if (Deepfrozen) {
            Map frozenDish = get_deepfrozenDish();
            random_int = ThreadLocalRandom.current().nextInt(0, desired_amount_of_dishes);
            result[random_int] = frozenDish;
        }

        new Week_plan(result, desired_amount_of_dishes, StartingDay, EndingDay);
    }//GEN-LAST:event_BTN_CreateEatPlanActionPerformed

    // Action if clicked on "Edit" -> "Add Dish to Database..."
    private void MenuItem_AddDishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItem_AddDishActionPerformed
        new Add_dish();     // Creates new JFrame add_dish.java and opens it up
    }//GEN-LAST:event_MenuItem_AddDishActionPerformed

    // Action if clicked on "Settings..."
    private void Menu_SettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu_SettingsMouseClicked
        new Settings();     // Creates new JFrame settings.java and opens it up
    }//GEN-LAST:event_Menu_SettingsMouseClicked
    
    
/* AUXILIARY FUNCTIONS */
    
    /*  This function returns a dish (Map) of a deepfrozen recipe. Note that the
    *   name and preparation are stored as an array, even though they should be
    *   strings. So the entry at the 0th position of that entry is the desired
    *   value.
    *
    *   @return Returns Map (dictionary) containg arrays of string as desired information
    */
    private Map get_deepfrozenDish() {
        
        // Definition of internal variables
        Map<String, String[]> frozen_dish = new HashMap<String, String[]>();
        
        String[] name_array = new String[1];
        String[] preparation_array = new String[1];
        String[] ingredients_array = new String[1];
        
        // Writing default information in first entry of array
        name_array[0] = "Frozen sauce from freezer";
        preparation_array[0] = "Do not forget to defrost the sauce";
        ingredients_array[0] = "Frozen sauce";
        
        // Add array to said map (dictionary)
        frozen_dish.put("name", name_array);
        frozen_dish.put("preparation", preparation_array);
        frozen_dish.put("ingredients", ingredients_array);
        
        // Finally, return that dish (dictionary, map)
        return frozen_dish;
    }
    
    
    /*  Despite its shortness, this function is essential. It takes an ID as an
    *   input and gets all information stored in the database 'dionysos' to that
    *   ID (called 'gericht_ID' in 'dionysos'). It does this by creating a new
    *   connection to the database and basically outsourcing all work to the
    *   Connector.java class. It returns a dish in form of a map (dictionary).
    *   This map has keys in form of strings and values as arrays of strings.
    *   Its keys are "name", "preparation", "type", "ingredients" and its values
    *   arrays of strings. For the first three keys the desired information is
    *   stored in the first entry of that value array.
    *
    *   @param ID The ID which is searched for in the database 'dionysos'
    *   @return Returns Map (dictionary) of dish belonging to given ID
    */
    private Map get_dish(int ID) {
        Connector connector = new Connector();
        return connector.get_dish(ID);
    }
    
    
    /*  This function checks wether a dish in form of a map is valid and should
    *   be stored in the result array or wether it should be thrown away and
    *   ignored. It checks for a valid name of the dish, where everything except
    *   null is considered valid. It checks wether the passed ID (attempting_ID)
    *   has already been used for this plan - no one wants to eat the same dish
    *   twice in a week. And lastly it checks if the type of the testing dish
    *   is compatible with user's settings.
    *   Ps. I know this function is bulky and unelegant but sadly I could not
    *   figure out how to make it better. Sorry. But at least it works!
    *
    *   @param dish Map of the tested dish
    *   @param attempting_ID ID of that tested dish
    *   @return true if dish meets requirements, false if it does not
    */
    private boolean is_dish_valid(Map dish, int attempting_ID){
        
        try {
            // Get name of passed dish
            String[] name_array = (String[]) dish.get("name");
            String name_dish = name_array[0];

            // Get type of passed dish
            String[] type_array = (String[]) dish.get("type");
            String type_dish = type_array[0];

            // Check if ID has already been tried
            if (used_ID.contains(attempting_ID)) {
                return false;
            }

            // Check if title is null, therefore that ID does not exist in database
            if (name_dish == null) {
                return false;
            }
            else {
                // Now we know ID does exist in database!

                // Check if type is available. If type was not stored, dish is always valid.
                if (type_dish != null) {

                    /*  If type was passed check which type it was and if there is
                    *   enough space for that type of dish in weekplan. If requirements
                    *   do fit return true! Return false if already enough types of
                    *   meal.
                    */

                    if (type_dish.equals("fleischhaltig")) {
                        if (AmountMeat_Current < AmountMeat_Set) {
                            AmountMeat_Current ++;
                            return true;
                        } else {
                            return false;
                        }
                    }

                    if (type_dish.equals("fischhaltig")) {
                        if (AmountFish_Current < AmountFish_Set) {
                            AmountFish_Current ++;
                            return true;
                        } else {
                            return false;}
                    }

                    if (type_dish.equals("vegetarisch")) {
                        if (AmountVegetarian_Current < AmountVegetarian_Set) {
                            AmountVegetarian_Current ++;
                            return true;
                        } else {
                            return false;}
                    }

                    if (type_dish.equals("vegan")) {
                        if (AmountVegan_Current < AmountVegan_Set) {
                            AmountVegan_Current ++;
                            return true;
                        } else {
                            return false;}
                    }
                } 
                else {
                    return true; }      
            }

            /*  Technically this statement should never be met, because every
            *   possible combination should have been catched by the ugly,
            *   interleaved if-functions. However, the compailer complains if this
            *   statement is missing and in doubt the dish should be accepted.
            */
            System.out.println("Just, hooow?!");
            return true;
        } catch (NullPointerException e){
            return true;
        }
    }
    
    
    /*  This functions sets all counters, which count the type of food used in
    *   the result set, to zero, in order for them being initialised.
    */
    private void NullCurrentAmounts() {
        AmountMeat_Current = 0;
        AmountFish_Current = 0;
        AmountVegetarian_Current = 0;
        AmountVegan_Current = 0;
    }
    
    
    /*  This function sets all global variables, settings, to their desired
    *   value. It takes the current settings as an argument and overwrites them.
    *   However, I know think the argument is unnecessary and could be left out.
    *   But, at this time all control mechanisms have been already deleted, so
    *   following the "never touch a running system" principle we do not touch
    *   this running system.
    *   "settings.dat" has to have a very specific form in order for this to
    *   work properly. This form can be seen in the settings.java class.
    *
    *   @param Array of string containing the current settings
    */
    private void ReadSettings(String [] settings) {
        
        // Initialising line counter
        int counter = 0;
        
        // Initialising file reader
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\Programme\\Eigene Programme\\Java\\Dionysos\\Dionysos\\settings.dat"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // This only works if "settings.dat" is created in specific way
                settings[counter] = line;
                counter ++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error! Could not find setting file 'settings.dat'.");
        } catch (IOException e) {
            System.out.println("Error! Could not read settings.");
        }
        
        // Set global settings according to specific entry of array
        StartingDay = Integer.parseInt(settings[0]);
        EndingDay = Integer.parseInt(settings[1]);
        Deepfrozen = Boolean.parseBoolean(settings[2]);
        AmountMeat_Set = Integer.parseInt(settings[3]);
        AmountFish_Set = Integer.parseInt(settings[4]);
        AmountVegetarian_Set = Integer.parseInt(settings[5]);
        AmountVegan_Set = Integer.parseInt(settings[6]);
    }
    
   
/* MAIN FUNCTION */  
    public static void main(String args[]) {
        
        // Set the Windows95 look and feel
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows95".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Starting_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Starting_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Starting_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Starting_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
                
        // Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Starting_view().setVisible(true);
            }
        });
    }

    
/* AUTO GENERATED CODE BY NETBEANS */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_CreateEatPlan;
    private javax.swing.JMenuBar MenuBar_StartingView;
    private javax.swing.JMenuItem MenuItem_AddDish;
    private javax.swing.JMenu Menu_Edit;
    private javax.swing.JMenu Menu_Settings;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
