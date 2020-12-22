/* WELCOME TO DIONYSOS */
    
    /*  Dionysos is a project which purpose it is to create a weekly meal plan.
    *   It uses the MySQL database "dionysos" running on this computer and
    *   searches for random meals in it according to the settings of the user.
    *   It then displays them on a separate window and creates a shopping list
    *   if wished.
    *
    *   This is the Add_dish class. It appears if clicked on "Edit" ->
    *   "Add Dish to Database...". It reads the user input in the text areas and
    *   sends that input to the right tables of the database "dionysos".
    *
    *   Created by ********
    *   Last modified on 03. October 2018
    */


/* BEGIN OF CLASS */

package com.example;

public class Add_dish extends javax.swing.JFrame {

    
/* CONSTRUCTOR */
    public Add_dish() {
        initComponents();   // NetBeans generated code
        setVisible(true);   // Turn visibilty on
        
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

        BTNGRP_Type = new javax.swing.ButtonGroup();
        LBL_NameDish = new javax.swing.JLabel();
        TXT_Name = new javax.swing.JTextField();
        LBL_Ingredients = new javax.swing.JLabel();
        ScrollPane_Ingredients = new javax.swing.JScrollPane();
        TXT_Ingredients = new javax.swing.JTextArea();
        LBL_Preparation = new javax.swing.JLabel();
        ScrollPane_Preparation = new javax.swing.JScrollPane();
        TXT_Preparation = new javax.swing.JTextArea();
        BTN_AddDish = new javax.swing.JButton();
        Panel_Type = new javax.swing.JPanel();
        RadBTN_fleischhaltig = new javax.swing.JRadioButton();
        RadBTN_fischhaltig = new javax.swing.JRadioButton();
        RadBTN_vegetarisch = new javax.swing.JRadioButton();
        RadBTN_vegan = new javax.swing.JRadioButton();
        LBL_Type = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add a Dish to Database [Dionysos]");

        LBL_NameDish.setText("Name of the dish");

        LBL_Ingredients.setText("Ingredients");

        TXT_Ingredients.setColumns(20);
        TXT_Ingredients.setRows(5);
        ScrollPane_Ingredients.setViewportView(TXT_Ingredients);

        LBL_Preparation.setText("Preparation");

        TXT_Preparation.setColumns(20);
        TXT_Preparation.setRows(5);
        ScrollPane_Preparation.setViewportView(TXT_Preparation);

        BTN_AddDish.setText("Add Dish");
        BTN_AddDish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AddDishActionPerformed(evt);
            }
        });

        BTNGRP_Type.add(RadBTN_fleischhaltig);
        RadBTN_fleischhaltig.setText("fleischhaltig");

        BTNGRP_Type.add(RadBTN_fischhaltig);
        RadBTN_fischhaltig.setText("fischhaltig");

        BTNGRP_Type.add(RadBTN_vegetarisch);
        RadBTN_vegetarisch.setText("vegetarisch");

        BTNGRP_Type.add(RadBTN_vegan);
        RadBTN_vegan.setText("vegan");

        LBL_Type.setText("Type");

        javax.swing.GroupLayout Panel_TypeLayout = new javax.swing.GroupLayout(Panel_Type);
        Panel_Type.setLayout(Panel_TypeLayout);
        Panel_TypeLayout.setHorizontalGroup(
            Panel_TypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_TypeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_TypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RadBTN_fischhaltig)
                    .addComponent(RadBTN_vegetarisch)
                    .addComponent(RadBTN_vegan)
                    .addComponent(RadBTN_fleischhaltig)
                    .addComponent(LBL_Type))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        Panel_TypeLayout.setVerticalGroup(
            Panel_TypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_TypeLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(LBL_Type)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RadBTN_fleischhaltig)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RadBTN_fischhaltig)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RadBTN_vegetarisch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RadBTN_vegan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LBL_NameDish)
                    .addComponent(LBL_Ingredients)
                    .addComponent(LBL_Preparation)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Panel_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BTN_AddDish))
                        .addComponent(ScrollPane_Preparation, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TXT_Name, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ScrollPane_Ingredients, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(LBL_NameDish)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXT_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LBL_Ingredients)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPane_Ingredients, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LBL_Preparation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPane_Preparation, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Panel_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTN_AddDish)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


/* BUTTON DEPENDENT FUNCTION */
    
    // Action if clicked on "Add Dish"
    private void BTN_AddDishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AddDishActionPerformed
        
        // Get information from user input 
        String dish_title = TXT_Name.getText();
        String preparation = TXT_Preparation.getText();  
        String[] ingredients = TXT_Ingredients.getText().split("\\n");
        String type = get_type();
        
        // Insert complete dish into database
        // All functionality is basically outsourced to Connector.java instance
        Connector connector = new Connector();
        connector.insert_entry(dish_title, ingredients, preparation, type);
    }//GEN-LAST:event_BTN_AddDishActionPerformed


/* AUXILIARY FUNCTION */

    /*  This function checks which radio button is selected and returns the
    *   fitting type of selected radio button.
    *   Outsourced from action function because of its bulkiness.
    *
    *   @return Returns String according to selected radio button
    */
    private String get_type() {
        String type = "";
        
        if (RadBTN_fleischhaltig.isSelected() == true) {
            type = "fleischhaltig";
        }
        
        if (RadBTN_fischhaltig.isSelected() == true) {
            type = "fischhaltig";
        }
        
        if (RadBTN_vegetarisch.isSelected() == true) {
            type = "vegetarisch";
        }
        
        if (RadBTN_vegan.isSelected() == true) {
            type = "vegan";
        }
        
        return type;
    }

    
/* AUTO GENERATED CODE BY NETBEANS */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BTNGRP_Type;
    private javax.swing.JButton BTN_AddDish;
    private javax.swing.JLabel LBL_Ingredients;
    private javax.swing.JLabel LBL_NameDish;
    private javax.swing.JLabel LBL_Preparation;
    private javax.swing.JLabel LBL_Type;
    private javax.swing.JPanel Panel_Type;
    private javax.swing.JRadioButton RadBTN_fischhaltig;
    private javax.swing.JRadioButton RadBTN_fleischhaltig;
    private javax.swing.JRadioButton RadBTN_vegan;
    private javax.swing.JRadioButton RadBTN_vegetarisch;
    private javax.swing.JScrollPane ScrollPane_Ingredients;
    private javax.swing.JScrollPane ScrollPane_Preparation;
    private javax.swing.JTextArea TXT_Ingredients;
    private javax.swing.JTextField TXT_Name;
    private javax.swing.JTextArea TXT_Preparation;
    // End of variables declaration//GEN-END:variables
}
