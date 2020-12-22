/* WELCOME TO DIONYSOS */
    
    /*  Dionysos is a project which purpose it is to create a weekly meal plan.
    *   It uses the MySQL database "dionysos" running on this computer and
    *   searches for random meals in it according to the settings of the user.
    *   It then displays them on a separate window and creates a shopping list
    *   if wished.
    *
    *   This is the Settings class. It reads and writes the "settings.dat" files
    *   containing the preferred settings of the user.
    *
    *   Created by ********
    *   Last modified on 03. October 2018
    */


/* BUG REPORT */

    /*  No program is perfect - neither this one. This is a partial report.
    *   This is the bug thrown in this class.
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
    */


/* BEGIN OF CLASS */

package com.example;

import java.io.*;

public class Settings extends javax.swing.JFrame {

    
/* CONSTRUCTOR */
    public Settings() {
        initComponents();   // NetBeans generated code
        setVisible(true);   // Turn visibilty on
        
        //Set imposed settings on building of this window
        set_CurrentSettings();
        
        // If window is closed, only the current window is closed and not the whole program stopped
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
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
            java.util.logging.Logger.getLogger(Add_dish.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_dish.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_dish.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_dish.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
        //</editor-fold>
        //</editor-fold>
    }
    
    
/* AUTO GENERATED CODE BY NETBEANS */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BTN_SaveSettings = new javax.swing.JButton();
        LBL_StartingDay = new javax.swing.JLabel();
        COMBox_StartingDay = new javax.swing.JComboBox<>();
        LBL_EndingDay = new javax.swing.JLabel();
        COMBox_EndingDay = new javax.swing.JComboBox<>();
        LBL_Deepfrozen = new javax.swing.JLabel();
        CHKBox_Deepfrozen = new javax.swing.JCheckBox();
        LBL_AmountMeat = new javax.swing.JLabel();
        TXT_AmountMeat = new javax.swing.JTextField();
        LBL_AmountFish = new javax.swing.JLabel();
        TXT_AmountFish = new javax.swing.JTextField();
        LBL_AmountVegetarian = new javax.swing.JLabel();
        TXT_AmountVegetarian = new javax.swing.JTextField();
        LBL_AmountVegan = new javax.swing.JLabel();
        TXT_AmountVegan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Settings [Dionysos]");

        BTN_SaveSettings.setText("Save Settings");
        BTN_SaveSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_SaveSettingsActionPerformed(evt);
            }
        });

        LBL_StartingDay.setText("Starting day of plan");

        COMBox_StartingDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));

        LBL_EndingDay.setText("Ending day of plan");

        COMBox_EndingDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        COMBox_EndingDay.setSelectedIndex(6);

        LBL_Deepfrozen.setText("Deep frozen food?");

        CHKBox_Deepfrozen.setText("Add deep frozen food to plan");

        LBL_AmountMeat.setText("Number of dishes with meat");

        TXT_AmountMeat.setText("3");

        LBL_AmountFish.setText("Number of dishes with fish");

        TXT_AmountFish.setText("1");

        LBL_AmountVegetarian.setText("Number of vegetarian dishes");

        TXT_AmountVegetarian.setText("3");

        LBL_AmountVegan.setText("Amount of vegan dishes");

        TXT_AmountVegan.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTN_SaveSettings)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LBL_StartingDay)
                    .addComponent(COMBox_EndingDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBL_EndingDay)
                    .addComponent(COMBox_StartingDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LBL_AmountVegan)
                    .addComponent(LBL_AmountVegetarian)
                    .addComponent(LBL_AmountFish)
                    .addComponent(LBL_AmountMeat)
                    .addComponent(CHKBox_Deepfrozen)
                    .addComponent(LBL_Deepfrozen)
                    .addComponent(TXT_AmountMeat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_AmountFish, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_AmountVegetarian, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_AmountVegan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_StartingDay)
                    .addComponent(LBL_Deepfrozen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CHKBox_Deepfrozen)
                    .addComponent(COMBox_StartingDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_EndingDay)
                    .addComponent(LBL_AmountMeat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(COMBox_EndingDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_AmountMeat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(LBL_AmountFish)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXT_AmountFish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LBL_AmountVegetarian)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXT_AmountVegetarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LBL_AmountVegan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXT_AmountVegan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(BTN_SaveSettings)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
/* BUTTON DEPENDENT FUNCTION */
    
    // Action if clicked on "Save Settings"
    /*  This function creates a "settings.dat" file which is defined in a very
    *   specific way to work, as described now:
    *   The name of the file is "settings" and its file type is "dat".
    *   It consists of seven lines, where the first line is an integer of the
    *   selected starting day, where 0 represents Monday and 6 is for Sunday.
    *   The second line consists of an integer representing the selected day,
    *   where the same nomenclature as above is used. The third line consists of
    *   a boolean value, which checks if frozen food shall be included or not.
    *   The fourth line is an integer for the amount of meat dishes in that
    *   week. The fifth line is an integer for the amount of fish dishes in
    *   that week. The sixth line is an integer for the amoung of vegetarian
    *   dishes and lastly, the seventh line is an integer for the amount of
    *   vegan dishes.
    *   I know this is not the nice way to do it. A more elegant way would be
    *   to use dictionaries to store them, so one does not have to be too
    *   careful on how to call the settings. However, according to Tom Scott's
    *   video it is better to spend the last twenty percent of polishing an idea
    *   for creating a new idea. I like that philisophy, because one can always
    *   find something to polish. It is important to move on.
    *   So the last polish is not done on this project.
    *   
    *   TL;DR OVERVIEW
    *   settings.dat consists of seven lines with following setup.
    1       int Index_StartingDay
    2       int Index_EndingDay
    3       boolean Include_FrozenFood
    4       int Amount_MeatDishes
    5       int Amount_FishDishes
    6       int Amount_VegetarianDishes
    7       int Amount_VeganDishes
    *
    *   Nb. The line numbering is not included in the file
    */
    private void BTN_SaveSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SaveSettingsActionPerformed
        
        // Defining local variables
        int AmountMeat, AmountFish, AmountVegetarian, AmountVegan;
        
        // Provisional bug avoidance for bug "WEEKDAYS CALCULATION"
        // Look up Starting_view.java BUG REPORT for additonal details
        if (COMBox_StartingDay.getSelectedIndex() > COMBox_EndingDay.getSelectedIndex()) {
            COMBox_StartingDay.setSelectedIndex(0);
            COMBox_EndingDay.setSelectedIndex(6);
        }
        
        /*  Try to read user input
        *   If user put something else than an integer into text field a
        *   "NumberFormatException" is thrown. Such exception is also thrown
        *   if total meatcount is higher than seven - more than seven meals per
        *   week is not possible.
        *   This error is catched by setting default values
        */
        try {
            AmountMeat = Integer.parseInt(TXT_AmountMeat.getText());
            AmountFish = Integer.parseInt(TXT_AmountFish.getText());
            AmountVegetarian = Integer.parseInt(TXT_AmountVegetarian.getText());
            AmountVegan = Integer.parseInt(TXT_AmountVegan.getText());
            
            if (AmountMeat + AmountFish + AmountVegetarian + AmountVegan != 7) {
                throw new NumberFormatException();
            }
            
            System.out.println("Settings set successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input into text fields. Default settings chosen.");
            AmountMeat = 3;
            AmountFish = 1;
            AmountVegetarian = 3;
            AmountVegan = 0;
        }
        
        // Write Settings File
        try {
            BufferedWriter bw = new BufferedWriter (new FileWriter("D:\\Programme\\Eigene Programme\\Java\\Dionysos\\Dionysos\\settings.dat"));
            bw.write(COMBox_StartingDay.getSelectedIndex() + "\n");
            bw.write(COMBox_EndingDay.getSelectedIndex() + "\n");
            bw.write(String.valueOf(CHKBox_Deepfrozen.isSelected()) + "\n");
            bw.write(AmountMeat + "\n");
            bw.write(AmountFish + "\n");
            bw.write(AmountVegetarian + "\n");
            bw.write(AmountVegan + "\n");
            bw.close();
        } catch (IOException e) {
            System.out.println("Error! Settings could not be saved.");
        }
        
    }//GEN-LAST:event_BTN_SaveSettingsActionPerformed

    
/* AUXILIARY FUNCTION */
    
    /*  This function reads the current settings from the settings file, if it
    *   exists. If it does not, this function does anything.
    *   After reading those settings it sets the components on the screen to the
    *   current settings, so the user can see which settings are on right now.
    */
    private void set_CurrentSettings(){
        
        // Define variables
        String[] settings = new String[7];
        String line;
        int counter = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\Programme\\Eigene Programme\\Java\\Dionysos\\Dionysos\\settings.dat"))) {
            
            while ((line = br.readLine()) != null) {
                // This only works if "settings.dat" is created in specific way
                settings[counter] = line;
                counter ++;
            }
            
            // Set values on screen according to settings in "settings.dat" file
            COMBox_StartingDay.setSelectedIndex(Integer.parseInt(settings[0]));
            COMBox_EndingDay.setSelectedIndex(Integer.parseInt(settings[1]));
            CHKBox_Deepfrozen.setSelected(Boolean.parseBoolean(settings[2]));
            TXT_AmountMeat.setText(settings[3]);
            TXT_AmountFish.setText(settings[4]);
            TXT_AmountVegetarian.setText(settings[5]);
            TXT_AmountVegan.setText(settings[6]);          
        } catch (IOException e) {
            // Nothing shall happen if an error is thrown.
        }
    }
    
    
/* AUTOGENERATED CODE BY NETBEANS */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_SaveSettings;
    private javax.swing.JCheckBox CHKBox_Deepfrozen;
    private javax.swing.JComboBox<String> COMBox_EndingDay;
    private javax.swing.JComboBox<String> COMBox_StartingDay;
    private javax.swing.JLabel LBL_AmountFish;
    private javax.swing.JLabel LBL_AmountMeat;
    private javax.swing.JLabel LBL_AmountVegan;
    private javax.swing.JLabel LBL_AmountVegetarian;
    private javax.swing.JLabel LBL_Deepfrozen;
    private javax.swing.JLabel LBL_EndingDay;
    private javax.swing.JLabel LBL_StartingDay;
    private javax.swing.JTextField TXT_AmountFish;
    private javax.swing.JTextField TXT_AmountMeat;
    private javax.swing.JTextField TXT_AmountVegan;
    private javax.swing.JTextField TXT_AmountVegetarian;
    // End of variables declaration//GEN-END:variables
}
