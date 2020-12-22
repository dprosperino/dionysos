/* WELCOME TO DIONYSOS */
    
    /*  Dionysos is a project which purpose it is to create a weekly meal plan.
    *   It uses the MySQL database "dionysos" running on this computer and
    *   searches for random meals in it according to the settings of the user.
    *   It then displays them on a separate window and creates a shopping list
    *   if wished.
    *
    *   This is the Week_plan class. By clicking on "Create Food Plan" this
    *   window is opened and it shows the dishes which should be cooked that
    *   week. By clicking on print it also creates a text file on the desktop
    *   containing all the information of this window.
    *
    *   Created by ********
    *   Last modified on 03. October 2018
    */


/* BUG REPORT */

    /*  No program is perfect - neither this one. This is a partial report.
    *   This is the bug thrown in this class.
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

import java.util.*;
import java.io.*;
import javax.swing.JTextArea;

public class Week_plan extends javax.swing.JFrame {
    
    
/* INITIALISING GLOBAL VARIABLES */
    
    private Map[] recipees;
    private int startingDay, endingDay;
    int[] weekdays;
    private List<String> list_of_ingredients = new ArrayList<>();
    private List<Integer> list_of_amount_ingredients = new ArrayList<>();
    
    
/* CONSTRUCTOR */
    
    /*  In this class the constructor does the main job and is very important.
    *   It reads the results of the other objects in its arguments and passes
    *   them on.
    */
    public Week_plan(Map[] recipees, int amount_of_recipees, int startingDay, int endingDay) {
        this.weekdays = new int[7];
        initComponents();   // NetBeans generated code
        setVisible(true);   // Turn visibilty on
        
        // If window is closed, only the current window is closed and not the whole program stopped
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        // Set all panels on non visible, because visibilty is set later on
        Panel_Gericht_1.setVisible(false);
        Panel_Gericht_2.setVisible(false);
        Panel_Gericht_3.setVisible(false);
        Panel_Gericht_4.setVisible(false);
        Panel_Gericht_5.setVisible(false);
        Panel_Gericht_6.setVisible(false);
        Panel_Gericht_7.setVisible(false);
        
        // Set number of visible panels depending on amount of dishes in that week
        this.recipees = recipees;
        this.startingDay = startingDay;
        this.endingDay = endingDay;
        
        // Write weekdays array
        int j = 0;
        for (int i = startingDay; i < (endingDay + 1); i++){
            weekdays[j] = i;
            j++;
        } 

        switch (amount_of_recipees) {
            case 1: {
                Panel_Gericht_1.setVisible(true);
                set_first_panel();
                break;
            }
            case 2: {
                Panel_Gericht_1.setVisible(true);
                Panel_Gericht_2.setVisible(true);
                set_second_panel();
                break;
            }
            case 3: {
                Panel_Gericht_1.setVisible(true);
                Panel_Gericht_2.setVisible(true);
                Panel_Gericht_3.setVisible(true);
                set_third_panel();
                break;
            }
            case 4: {
                Panel_Gericht_1.setVisible(true);
                Panel_Gericht_2.setVisible(true);
                Panel_Gericht_3.setVisible(true);
                Panel_Gericht_4.setVisible(true);
                set_fourth_panel();
                break;
            }
            case 5: {
                Panel_Gericht_1.setVisible(true);
                Panel_Gericht_2.setVisible(true);
                Panel_Gericht_3.setVisible(true);
                Panel_Gericht_4.setVisible(true);
                Panel_Gericht_5.setVisible(true);
                set_fivth_panel();
                break;
            }
            case 6: {
                Panel_Gericht_1.setVisible(true);
                Panel_Gericht_2.setVisible(true);
                Panel_Gericht_3.setVisible(true);
                Panel_Gericht_4.setVisible(true);
                Panel_Gericht_5.setVisible(true);
                Panel_Gericht_6.setVisible(true);
                set_sixth_panel();
                break;
            }
            case 7: {
                Panel_Gericht_1.setVisible(true);
                Panel_Gericht_2.setVisible(true);
                Panel_Gericht_3.setVisible(true);
                Panel_Gericht_4.setVisible(true);
                Panel_Gericht_5.setVisible(true);
                Panel_Gericht_6.setVisible(true);
                Panel_Gericht_7.setVisible(true);
                set_seventh_panel();
                break;
            }
        }
    }

    
/* AUXILIARY, PANEL FUNCTIONS */
    
    /*  The following seven functions set the panels of this window. Hereby
    *   the n-th panel calls the (n-1)th panel creating a cascading effect.
    *   They read the right position from the recipee array and set their own
    *   labels correctly.
    */
    
    private void set_first_panel() {
        String[] dish_name_array = (String[]) recipees[0].get("name");
        String dish_name = dish_name_array[0];
        
        String[] ingredients = (String[]) recipees[0].get("ingredients");
        
        for (int i = 0; i < ingredients.length; i++) {
            TXT_Ingredients_1.append(ingredients[i] + "\n");
        }
        
        LBL_Weekday_1.setText(int_to_weekday(weekdays[0]));
        LBL_DishName_1.setText(dish_name);  
    }
    
    private void set_second_panel() {
        set_first_panel();
        
        String[] dish_name_array = (String[]) recipees[1].get("name");
        String dish_name = dish_name_array[0];
        
        String[] ingredients = (String[]) recipees[1].get("ingredients");
        
        for (int i = 0; i < ingredients.length; i++) {
            TXT_Ingredients_2.append(ingredients[i] + "\n");
        }
        
        LBL_Weekday_2.setText(int_to_weekday(weekdays[1]));
        LBL_DishName_2.setText(dish_name);     
    }
    
    private void set_third_panel() {
        set_second_panel();
        
        String[] dish_name_array = (String[]) recipees[2].get("name");
        String dish_name = dish_name_array[0];
        
        String[] ingredients = (String[]) recipees[2].get("ingredients");
        
        for (int i = 0; i < ingredients.length; i++) {
            TXT_Ingredients_3.append(ingredients[i] + "\n");
        }
        
        LBL_Weekday_3.setText(int_to_weekday(weekdays[2]));
        LBL_DishName_3.setText(dish_name);
    }
    
    private void set_fourth_panel() {
        set_third_panel();
        
        String[] dish_name_array = (String[]) recipees[3].get("name");
        String dish_name = dish_name_array[0];
        
        String[] ingredients = (String[]) recipees[3].get("ingredients");
        
        for (int i = 0; i < ingredients.length; i++) {
            TXT_Ingredients_4.append(ingredients[i] + "\n");
        }
        
        LBL_Weekday_4.setText(int_to_weekday(weekdays[3]));
        LBL_DishName_4.setText(dish_name);
    }
    
    private void set_fivth_panel() {
        set_fourth_panel();
        
        String[] dish_name_array = (String[]) recipees[4].get("name");
        String dish_name = dish_name_array[0];
        
        String[] ingredients = (String[]) recipees[4].get("ingredients");
        
        for (int i = 0; i < ingredients.length; i++) {
            TXT_Ingredients_5.append(ingredients[i] + "\n");
        }
        
        LBL_Weekday_5.setText(int_to_weekday(weekdays[4]));
        LBL_DishName_5.setText(dish_name);
    }
    
    private void set_sixth_panel() {
        set_fivth_panel();
        
        String[] dish_name_array = (String[]) recipees[5].get("name");
        String dish_name = dish_name_array[0];
        
        String[] ingredients = (String[]) recipees[5].get("ingredients");
        
        for (int i = 0; i < ingredients.length; i++) {
            TXT_Ingredients_6.append(ingredients[i] + "\n");
        }
        
        LBL_Weekday_6.setText(int_to_weekday(weekdays[5]));
        LBL_DishName_6.setText(dish_name);
    }
    
    private void set_seventh_panel() {
        set_sixth_panel();
        
        String[] dish_name_array = (String[]) recipees[6].get("name");
        String dish_name = dish_name_array[0];
        
        String[] ingredients = (String[]) recipees[6].get("ingredients");
        
        for (int i = 0; i < ingredients.length; i++) {
            TXT_Ingredients_7.append(ingredients[i] + "\n");
        }
        
        LBL_Weekday_7.setText(int_to_weekday(weekdays[6]));
        LBL_DishName_7.setText(dish_name);
    }
    
    
/* MISCELLANEOUS AUXILIARY FUNCTIONS */
    
    /*  It returns a ready to print string of the preparation of said meal
    *   if the according checkbox was ticked accordingly.
    *
    *   @param position Is the position of the dish from 1 to 7
    *   @return Returns string of preparation of the meal at given position
    */
    private String get_preparation(int position){
            String[] preparation_array = (String[]) recipees[position - 1].get("preparation");
           
            return preparation_array[0] + "\n" + "\n";      
    }
    
    
    /*  Returns a string of the weekday to the according integer.
    *   
    *   @param weekday_int Integer of the weekday which the name is needed
    *   @return Returns name of weekday according to given integer
    */
    private String int_to_weekday(int weekday_int) {
        switch (weekday_int) {
            case 0: return "Monday";
            case 1: return "Tuesday";
            case 2: return "Wednesday";
            case 3: return "Thursday";
            case 4: return "Friday";
            case 5: return "Saturday";
            case 6: return "Sunday";
            default: return "Someday";
        }
    }
    
    
    /*  This function reads the text areas of given JTextArea and creates a 
    *   string array out of it. Then it checks if each array entry is in the
    *   ingredients list. If yes, it increases the amount by one. If not it 
    *   adds said ingredient to that list and adds "1" to the amount list.
    *   
    *   @param TXT_Ingredients The JTextArea from which the lines shall be read
    */
    private void read_textAreas_and_add_to_lists(JTextArea TXT_Ingredients) {
        
        // Defining local variables
        int position;
        
        // Converting the text field of given JTextArea into array
        // Splitting at "\\n" is essential! Splitting only at "\n" will not work
        String[] array_of_ingredients = TXT_Ingredients.getText().split("\\n");
        
        // Going through each entry of array and checking wether it is in the list of ingredients or not
        for (int i = 0; i < array_of_ingredients.length; i ++) {
            
            if (list_of_ingredients.contains(array_of_ingredients[i])) {
                // If it is in list, it gets position, in which it is
                position = list_of_ingredients.indexOf(array_of_ingredients[i]);
                // Increases amount by one in list of amounts
                list_of_amount_ingredients.set(position, list_of_amount_ingredients.get(position) + 1);
            } else
                // If it is not in list, it adds it to the list and adds an amount 1 simultaneously
                list_of_ingredients.add(array_of_ingredients[i]);
                list_of_amount_ingredients.add(1);
        }
    }


/* AUTO GENERATED CODE BY NETBEANS */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollPane_Main = new javax.swing.JScrollPane();
        Panel = new javax.swing.JPanel();
        Panel_Gericht_1 = new javax.swing.JPanel();
        LBL_Weekday_1 = new javax.swing.JLabel();
        LBL_DishName_1 = new javax.swing.JLabel();
        ScrollPane_1 = new javax.swing.JScrollPane();
        TXT_Ingredients_1 = new javax.swing.JTextArea();
        CHKBox_1 = new javax.swing.JCheckBox();
        Panel_Gericht_2 = new javax.swing.JPanel();
        LBL_Weekday_2 = new javax.swing.JLabel();
        LBL_DishName_2 = new javax.swing.JLabel();
        ScrollPane_2 = new javax.swing.JScrollPane();
        TXT_Ingredients_2 = new javax.swing.JTextArea();
        CHKBox_2 = new javax.swing.JCheckBox();
        Panel_Gericht_3 = new javax.swing.JPanel();
        LBL_Weekday_3 = new javax.swing.JLabel();
        LBL_DishName_3 = new javax.swing.JLabel();
        ScrollPane_3 = new javax.swing.JScrollPane();
        TXT_Ingredients_3 = new javax.swing.JTextArea();
        CHKBox_3 = new javax.swing.JCheckBox();
        Panel_Gericht_4 = new javax.swing.JPanel();
        LBL_Weekday_4 = new javax.swing.JLabel();
        LBL_DishName_4 = new javax.swing.JLabel();
        ScrollPane_4 = new javax.swing.JScrollPane();
        TXT_Ingredients_4 = new javax.swing.JTextArea();
        CHKBox_4 = new javax.swing.JCheckBox();
        Panel_Gericht_5 = new javax.swing.JPanel();
        LBL_Weekday_5 = new javax.swing.JLabel();
        LBL_DishName_5 = new javax.swing.JLabel();
        ScrollPane_5 = new javax.swing.JScrollPane();
        TXT_Ingredients_5 = new javax.swing.JTextArea();
        CHKBox_5 = new javax.swing.JCheckBox();
        Panel_Gericht_6 = new javax.swing.JPanel();
        LBL_Weekday_6 = new javax.swing.JLabel();
        LBL_DishName_6 = new javax.swing.JLabel();
        ScrollPane_6 = new javax.swing.JScrollPane();
        TXT_Ingredients_6 = new javax.swing.JTextArea();
        CHKBox_6 = new javax.swing.JCheckBox();
        Panel_Gericht_7 = new javax.swing.JPanel();
        LBL_Weekday_7 = new javax.swing.JLabel();
        LBL_DishName_7 = new javax.swing.JLabel();
        ScrollPane_7 = new javax.swing.JScrollPane();
        TXT_Ingredients_7 = new javax.swing.JTextArea();
        CHKBox_7 = new javax.swing.JCheckBox();
        BTN_Print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Week plan [Dionysos]");
        setPreferredSize(new java.awt.Dimension(800, 790));

        ScrollPane_Main.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPane_Main.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ScrollPane_Main.setPreferredSize(new java.awt.Dimension(780, 1382));

        Panel.setPreferredSize(new java.awt.Dimension(20000, 1380));

        Panel_Gericht_1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Panel_Gericht_1.setMaximumSize(new java.awt.Dimension(710, 181));
        Panel_Gericht_1.setPreferredSize(new java.awt.Dimension(710, 181));

        LBL_DishName_1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        TXT_Ingredients_1.setEditable(false);
        TXT_Ingredients_1.setBackground(new java.awt.Color(240, 240, 240));
        TXT_Ingredients_1.setColumns(20);
        TXT_Ingredients_1.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        TXT_Ingredients_1.setRows(5);
        ScrollPane_1.setViewportView(TXT_Ingredients_1);

        CHKBox_1.setText("Print preparation");

        javax.swing.GroupLayout Panel_Gericht_1Layout = new javax.swing.GroupLayout(Panel_Gericht_1);
        Panel_Gericht_1.setLayout(Panel_Gericht_1Layout);
        Panel_Gericht_1Layout.setHorizontalGroup(
            Panel_Gericht_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Gericht_1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_Gericht_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPane_1)
                    .addGroup(Panel_Gericht_1Layout.createSequentialGroup()
                        .addComponent(LBL_Weekday_1)
                        .addGap(28, 28, 28)
                        .addComponent(LBL_DishName_1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CHKBox_1)))
                .addContainerGap())
        );
        Panel_Gericht_1Layout.setVerticalGroup(
            Panel_Gericht_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Gericht_1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_Gericht_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_DishName_1)
                    .addComponent(LBL_Weekday_1)
                    .addComponent(CHKBox_1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ScrollPane_1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );

        Panel_Gericht_2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Panel_Gericht_2.setPreferredSize(new java.awt.Dimension(710, 181));

        LBL_DishName_2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        TXT_Ingredients_2.setEditable(false);
        TXT_Ingredients_2.setBackground(new java.awt.Color(240, 240, 240));
        TXT_Ingredients_2.setColumns(20);
        TXT_Ingredients_2.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        TXT_Ingredients_2.setRows(5);
        ScrollPane_2.setViewportView(TXT_Ingredients_2);

        CHKBox_2.setText("Print preparation");

        javax.swing.GroupLayout Panel_Gericht_2Layout = new javax.swing.GroupLayout(Panel_Gericht_2);
        Panel_Gericht_2.setLayout(Panel_Gericht_2Layout);
        Panel_Gericht_2Layout.setHorizontalGroup(
            Panel_Gericht_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Gericht_2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_Gericht_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPane_2)
                    .addGroup(Panel_Gericht_2Layout.createSequentialGroup()
                        .addComponent(LBL_Weekday_2)
                        .addGap(28, 28, 28)
                        .addComponent(LBL_DishName_2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CHKBox_2)))
                .addContainerGap())
        );
        Panel_Gericht_2Layout.setVerticalGroup(
            Panel_Gericht_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Gericht_2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_Gericht_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_DishName_2)
                    .addComponent(LBL_Weekday_2)
                    .addComponent(CHKBox_2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ScrollPane_2, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );

        Panel_Gericht_3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Panel_Gericht_3.setPreferredSize(new java.awt.Dimension(710, 181));

        LBL_DishName_3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        TXT_Ingredients_3.setEditable(false);
        TXT_Ingredients_3.setBackground(new java.awt.Color(240, 240, 240));
        TXT_Ingredients_3.setColumns(20);
        TXT_Ingredients_3.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        TXT_Ingredients_3.setRows(5);
        ScrollPane_3.setViewportView(TXT_Ingredients_3);

        CHKBox_3.setText("Print preparation");

        javax.swing.GroupLayout Panel_Gericht_3Layout = new javax.swing.GroupLayout(Panel_Gericht_3);
        Panel_Gericht_3.setLayout(Panel_Gericht_3Layout);
        Panel_Gericht_3Layout.setHorizontalGroup(
            Panel_Gericht_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Gericht_3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_Gericht_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPane_3)
                    .addGroup(Panel_Gericht_3Layout.createSequentialGroup()
                        .addComponent(LBL_Weekday_3)
                        .addGap(28, 28, 28)
                        .addComponent(LBL_DishName_3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CHKBox_3)))
                .addContainerGap())
        );
        Panel_Gericht_3Layout.setVerticalGroup(
            Panel_Gericht_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Gericht_3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_Gericht_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_DishName_3)
                    .addComponent(LBL_Weekday_3)
                    .addComponent(CHKBox_3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ScrollPane_3, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );

        Panel_Gericht_4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Panel_Gericht_4.setPreferredSize(new java.awt.Dimension(710, 180));

        LBL_DishName_4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        TXT_Ingredients_4.setEditable(false);
        TXT_Ingredients_4.setBackground(new java.awt.Color(240, 240, 240));
        TXT_Ingredients_4.setColumns(20);
        TXT_Ingredients_4.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        TXT_Ingredients_4.setRows(5);
        ScrollPane_4.setViewportView(TXT_Ingredients_4);

        CHKBox_4.setText("Print preparation");

        javax.swing.GroupLayout Panel_Gericht_4Layout = new javax.swing.GroupLayout(Panel_Gericht_4);
        Panel_Gericht_4.setLayout(Panel_Gericht_4Layout);
        Panel_Gericht_4Layout.setHorizontalGroup(
            Panel_Gericht_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Gericht_4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_Gericht_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPane_4)
                    .addGroup(Panel_Gericht_4Layout.createSequentialGroup()
                        .addComponent(LBL_Weekday_4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LBL_DishName_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CHKBox_4)))
                .addContainerGap())
        );
        Panel_Gericht_4Layout.setVerticalGroup(
            Panel_Gericht_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Gericht_4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_Gericht_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_Weekday_4)
                    .addComponent(CHKBox_4)
                    .addComponent(LBL_DishName_4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ScrollPane_4, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
        );

        Panel_Gericht_5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Panel_Gericht_5.setPreferredSize(new java.awt.Dimension(710, 181));

        LBL_Weekday_5.setText(" ");

        LBL_DishName_5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        TXT_Ingredients_5.setEditable(false);
        TXT_Ingredients_5.setBackground(new java.awt.Color(240, 240, 240));
        TXT_Ingredients_5.setColumns(20);
        TXT_Ingredients_5.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        TXT_Ingredients_5.setRows(5);
        ScrollPane_5.setViewportView(TXT_Ingredients_5);

        CHKBox_5.setText("Print preparation");

        javax.swing.GroupLayout Panel_Gericht_5Layout = new javax.swing.GroupLayout(Panel_Gericht_5);
        Panel_Gericht_5.setLayout(Panel_Gericht_5Layout);
        Panel_Gericht_5Layout.setHorizontalGroup(
            Panel_Gericht_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Gericht_5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_Gericht_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPane_5)
                    .addGroup(Panel_Gericht_5Layout.createSequentialGroup()
                        .addComponent(LBL_Weekday_5)
                        .addGap(28, 28, 28)
                        .addComponent(LBL_DishName_5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 548, Short.MAX_VALUE)
                        .addComponent(CHKBox_5)))
                .addContainerGap())
        );
        Panel_Gericht_5Layout.setVerticalGroup(
            Panel_Gericht_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Gericht_5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_Gericht_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_DishName_5)
                    .addComponent(LBL_Weekday_5)
                    .addComponent(CHKBox_5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPane_5, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        Panel_Gericht_6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        LBL_DishName_6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        TXT_Ingredients_6.setEditable(false);
        TXT_Ingredients_6.setBackground(new java.awt.Color(240, 240, 240));
        TXT_Ingredients_6.setColumns(20);
        TXT_Ingredients_6.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        TXT_Ingredients_6.setRows(5);
        ScrollPane_6.setViewportView(TXT_Ingredients_6);

        CHKBox_6.setText("Print preparation");

        javax.swing.GroupLayout Panel_Gericht_6Layout = new javax.swing.GroupLayout(Panel_Gericht_6);
        Panel_Gericht_6.setLayout(Panel_Gericht_6Layout);
        Panel_Gericht_6Layout.setHorizontalGroup(
            Panel_Gericht_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Gericht_6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_Gericht_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPane_6)
                    .addGroup(Panel_Gericht_6Layout.createSequentialGroup()
                        .addComponent(LBL_Weekday_6)
                        .addGap(28, 28, 28)
                        .addComponent(LBL_DishName_6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CHKBox_6)))
                .addContainerGap())
        );
        Panel_Gericht_6Layout.setVerticalGroup(
            Panel_Gericht_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Gericht_6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_Gericht_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_DishName_6)
                    .addComponent(LBL_Weekday_6)
                    .addComponent(CHKBox_6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ScrollPane_6, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );

        Panel_Gericht_7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        LBL_DishName_7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        TXT_Ingredients_7.setEditable(false);
        TXT_Ingredients_7.setBackground(new java.awt.Color(240, 240, 240));
        TXT_Ingredients_7.setColumns(20);
        TXT_Ingredients_7.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        TXT_Ingredients_7.setRows(5);
        ScrollPane_7.setViewportView(TXT_Ingredients_7);

        CHKBox_7.setText("Print preparation");

        javax.swing.GroupLayout Panel_Gericht_7Layout = new javax.swing.GroupLayout(Panel_Gericht_7);
        Panel_Gericht_7.setLayout(Panel_Gericht_7Layout);
        Panel_Gericht_7Layout.setHorizontalGroup(
            Panel_Gericht_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Gericht_7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_Gericht_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPane_7)
                    .addGroup(Panel_Gericht_7Layout.createSequentialGroup()
                        .addComponent(LBL_Weekday_7)
                        .addGap(28, 28, 28)
                        .addComponent(LBL_DishName_7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CHKBox_7)))
                .addContainerGap())
        );
        Panel_Gericht_7Layout.setVerticalGroup(
            Panel_Gericht_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Gericht_7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_Gericht_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_DishName_7)
                    .addComponent(LBL_Weekday_7)
                    .addComponent(CHKBox_7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ScrollPane_7, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Panel_Gericht_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel_Gericht_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel_Gericht_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel_Gericht_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel_Gericht_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel_Gericht_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel_Gericht_7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19280, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel_Gericht_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Panel_Gericht_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Panel_Gericht_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Panel_Gericht_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Panel_Gericht_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Panel_Gericht_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Panel_Gericht_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ScrollPane_Main.setViewportView(Panel);

        BTN_Print.setText("Print");
        BTN_Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_PrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTN_Print))
                    .addComponent(ScrollPane_Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_Print)
                .addGap(18, 18, 18)
                .addComponent(ScrollPane_Main, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
/* BUTTON DEPENDENT FUNCTION */
    
    // Action if clicked on "Print"
    private void BTN_PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_PrintActionPerformed
        
        // Clears all lists
        list_of_ingredients.clear();
        list_of_amount_ingredients.clear();
        
        // Reading of the textareas and adding its content to the lists
        read_textAreas_and_add_to_lists(TXT_Ingredients_1);
        read_textAreas_and_add_to_lists(TXT_Ingredients_2);
        read_textAreas_and_add_to_lists(TXT_Ingredients_3);
        read_textAreas_and_add_to_lists(TXT_Ingredients_4);
        read_textAreas_and_add_to_lists(TXT_Ingredients_5);
        read_textAreas_and_add_to_lists(TXT_Ingredients_6);
        read_textAreas_and_add_to_lists(TXT_Ingredients_7);
        
        // Writing mealplan on desktop
        try (BufferedWriter bw = new BufferedWriter (new FileWriter("C:\\Users\\Davide\\Desktop\\mealplan.txt"))) {
            
            // Writes header of file
            bw.write("WEEKPLAN");
            bw.newLine();
            bw.newLine();
            bw.newLine();
            
            // Writes all dishes
            bw.write("DISHES");
            bw.newLine();
            bw.newLine();
            bw.write(LBL_Weekday_1.getText() + ": " + LBL_DishName_1.getText().toUpperCase());
            bw.newLine();
            bw.write(LBL_Weekday_2.getText() + ": " + LBL_DishName_2.getText().toUpperCase());
            bw.newLine();
            bw.write(LBL_Weekday_3.getText() + ": " + LBL_DishName_3.getText().toUpperCase());
            bw.newLine();
            bw.write(LBL_Weekday_4.getText() + ": " + LBL_DishName_4.getText().toUpperCase());
            bw.newLine();
            bw.write(LBL_Weekday_5.getText() + ": " + LBL_DishName_5.getText().toUpperCase());
            bw.newLine();
            bw.write(LBL_Weekday_6.getText() + ": " + LBL_DishName_6.getText().toUpperCase());
            bw.newLine();
            bw.write(LBL_Weekday_7.getText() + ": " + LBL_DishName_7.getText().toUpperCase());
            bw.newLine();
            bw.newLine();
            
            // Writes all ingredients of both lists
            bw.write("INGREDIENTS");
            bw.newLine();
            bw.newLine();
            
            for (int i=0; i < list_of_ingredients.size(); i++) {
                bw.write(list_of_amount_ingredients.get(i) + "x " + list_of_ingredients.get(i));
                bw.newLine();
            }
            
            bw.newLine();
            
            // Writes preparations if seleced
            /*  This is very bulky and unnice. A better solution to that would
            *   be defining two arrays, one containing all check boxes and one
            *   containing all lables and then just loop through the arrays once
            *   and safe six copies of the same code by doing so.
            */
            bw.write("PREPARATION");
            bw.newLine();
            if (CHKBox_1.isSelected()) {
                bw.newLine();
                bw.write(LBL_DishName_1.getText().toUpperCase());
                bw.newLine();
                bw.write(get_preparation(1));
                bw.newLine();
            }

            if (CHKBox_2.isSelected()) {
                bw.newLine();
                bw.write(LBL_DishName_2.getText().toUpperCase());
                bw.newLine();
                bw.write(get_preparation(2));
                bw.newLine();
            }

            if (CHKBox_3.isSelected()) {
                bw.newLine();
                bw.write(LBL_DishName_3.getText().toUpperCase());
                bw.newLine();
                bw.write(get_preparation(3));
                bw.newLine();
            }

            if (CHKBox_4.isSelected()) {
                bw.newLine();
                bw.write(LBL_DishName_4.getText().toUpperCase());
                bw.newLine();
                bw.write(get_preparation(4));
                bw.newLine();
            }

            if (CHKBox_5.isSelected()) {
                bw.newLine();
                bw.write(LBL_DishName_5.getText().toUpperCase());
                bw.newLine();
                bw.write(get_preparation(5));
                bw.newLine();
            }
            if (CHKBox_6.isSelected()) {
                bw.newLine();
                bw.write(LBL_DishName_6.getText().toUpperCase());
                bw.newLine();
                bw.write(get_preparation(6));
                bw.newLine();
            }
            if (CHKBox_7.isSelected()) {
                bw.newLine();
                bw.write(LBL_DishName_7.getText().toUpperCase());
                bw.newLine();
                bw.write(get_preparation(7));
                bw.newLine();
            }
            } catch (IOException e) {
                System.out.println("Error! Mealplan text file could not be created.");
            }
        
        
    }//GEN-LAST:event_BTN_PrintActionPerformed

    
/* AUTO GENERATED CODE BY NETBEANS */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Print;
    private javax.swing.JCheckBox CHKBox_1;
    private javax.swing.JCheckBox CHKBox_2;
    private javax.swing.JCheckBox CHKBox_3;
    private javax.swing.JCheckBox CHKBox_4;
    private javax.swing.JCheckBox CHKBox_5;
    private javax.swing.JCheckBox CHKBox_6;
    private javax.swing.JCheckBox CHKBox_7;
    private javax.swing.JLabel LBL_DishName_1;
    private javax.swing.JLabel LBL_DishName_2;
    private javax.swing.JLabel LBL_DishName_3;
    private javax.swing.JLabel LBL_DishName_4;
    private javax.swing.JLabel LBL_DishName_5;
    private javax.swing.JLabel LBL_DishName_6;
    private javax.swing.JLabel LBL_DishName_7;
    private javax.swing.JLabel LBL_Weekday_1;
    private javax.swing.JLabel LBL_Weekday_2;
    private javax.swing.JLabel LBL_Weekday_3;
    private javax.swing.JLabel LBL_Weekday_4;
    private javax.swing.JLabel LBL_Weekday_5;
    private javax.swing.JLabel LBL_Weekday_6;
    private javax.swing.JLabel LBL_Weekday_7;
    private javax.swing.JPanel Panel;
    private javax.swing.JPanel Panel_Gericht_1;
    private javax.swing.JPanel Panel_Gericht_2;
    private javax.swing.JPanel Panel_Gericht_3;
    private javax.swing.JPanel Panel_Gericht_4;
    private javax.swing.JPanel Panel_Gericht_5;
    private javax.swing.JPanel Panel_Gericht_6;
    private javax.swing.JPanel Panel_Gericht_7;
    private javax.swing.JScrollPane ScrollPane_1;
    private javax.swing.JScrollPane ScrollPane_2;
    private javax.swing.JScrollPane ScrollPane_3;
    private javax.swing.JScrollPane ScrollPane_4;
    private javax.swing.JScrollPane ScrollPane_5;
    private javax.swing.JScrollPane ScrollPane_6;
    private javax.swing.JScrollPane ScrollPane_7;
    private javax.swing.JScrollPane ScrollPane_Main;
    private javax.swing.JTextArea TXT_Ingredients_1;
    private javax.swing.JTextArea TXT_Ingredients_2;
    private javax.swing.JTextArea TXT_Ingredients_3;
    private javax.swing.JTextArea TXT_Ingredients_4;
    private javax.swing.JTextArea TXT_Ingredients_5;
    private javax.swing.JTextArea TXT_Ingredients_6;
    private javax.swing.JTextArea TXT_Ingredients_7;
    // End of variables declaration//GEN-END:variables
}
