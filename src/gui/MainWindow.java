/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ItemEvent;
import java.util.prefs.Preferences;
import javax.swing.UIManager;
import tabsy.UserPreferences;
import validators.YearValidator;

/**
 *
 * @author alien
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        setUINames();
        setFromPreferences();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textFieldYearStart = new javax.swing.JTextField();
        labelYearStart = new javax.swing.JLabel();
        textFieldYearEnd = new javax.swing.JTextField();
        labelYearEnd = new javax.swing.JLabel();
        checkBoxAllYears = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textFieldYearStart.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldYearStartKeyReleased(evt);
            }
        });

        labelYearStart.setText("rok początkowy");

        textFieldYearEnd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldYearEndKeyReleased(evt);
            }
        });

        labelYearEnd.setText("rok końcowy");

        checkBoxAllYears.setText("wszystkie dostępne lata");
        checkBoxAllYears.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkBoxAllYearsItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxAllYears)
                    .addComponent(labelYearEnd)
                    .addComponent(textFieldYearEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelYearStart)
                    .addComponent(textFieldYearStart, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(486, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(labelYearStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldYearStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(labelYearEnd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldYearEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(checkBoxAllYears)
                .addContainerGap(261, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldYearStartKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldYearStartKeyReleased
        if( YearValidator.validate(textFieldYearStart.getText()) || textFieldYearStart.getText().equals("") ){
            UserPreferences.getInstance().getPrefs().put(textFieldYearStart.getName(), textFieldYearStart.getText());
        }
    }//GEN-LAST:event_textFieldYearStartKeyReleased

    private void textFieldYearEndKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldYearEndKeyReleased
        if( YearValidator.validate(textFieldYearEnd.getText()) || textFieldYearEnd.getText().equals("") ){
            UserPreferences.getInstance().getPrefs().put(textFieldYearEnd.getName(), textFieldYearEnd.getText());
        }
    }//GEN-LAST:event_textFieldYearEndKeyReleased

    private void checkBoxAllYearsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkBoxAllYearsItemStateChanged
        boolean isSelected = evt.getStateChange()==ItemEvent.SELECTED;
        if( evt.getItemSelectable() == checkBoxAllYears){
            checkBoxAllYearsStateChanged(isSelected);
        }
    }//GEN-LAST:event_checkBoxAllYearsItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            /*for( javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels() ) {
                if( "Nimbus".equals(info.getName()) ){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }*/
        } catch( ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex ) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainWindow().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkBoxAllYears;
    private javax.swing.JLabel labelYearEnd;
    private javax.swing.JLabel labelYearStart;
    private javax.swing.JTextField textFieldYearEnd;
    private javax.swing.JTextField textFieldYearStart;
    // End of variables declaration//GEN-END:variables
    
    private void setUINames() {
        textFieldYearStart.setName("textFieldYearStart");
        textFieldYearEnd.setName("textFieldYearEnd");
        checkBoxAllYears.setName("checkBoxAllYears");
    }

    private void setFromPreferences() {
        Preferences p = UserPreferences.getInstance().getPrefs();

        textFieldYearStart.setText(p.get(textFieldYearStart.getName(), ""));
        textFieldYearEnd.setText(p.get(textFieldYearEnd.getName(), ""));
        checkBoxAllYears.setSelected(p.getBoolean(checkBoxAllYears.getName(), false));
    }

    /**
     * 
     * @param selected true - checkbox selected, false - checkbox unselected
     */
    private void checkBoxAllYearsStateChanged(boolean selected) {
        textFieldYearStart.setEnabled(!selected);
        textFieldYearEnd.setEnabled(!selected);
        
        UserPreferences.getInstance().getPrefs().putBoolean(checkBoxAllYears.getName(), selected);
    }

}