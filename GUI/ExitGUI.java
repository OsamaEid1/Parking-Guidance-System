/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Pl2Project.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohammed
 */
public class ExitGUI extends javax.swing.JFrame {

    /**
     * Creates new form ExitGUI
     */
    public ExitGUI() {
        initComponents();
        jButtonPay.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonPrintTheCost = new javax.swing.JButton();
        jTextFieldCustomerId = new javax.swing.JTextField();
        jButtonPay = new javax.swing.JButton();
        jButtonBackFExitTCustomer = new javax.swing.JButton();
        cost = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Exit");

        jLabel1.setText("Enter Your Id");

        jButtonPrintTheCost.setText("Print The Cost");
        jButtonPrintTheCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintTheCostActionPerformed(evt);
            }
        });

        jTextFieldCustomerId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCustomerIdActionPerformed(evt);
            }
        });

        jButtonPay.setText("pay");
        jButtonPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPayActionPerformed(evt);
            }
        });

        jButtonBackFExitTCustomer.setText("Back");
        jButtonBackFExitTCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackFExitTCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonBackFExitTCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(272, 272, 272)
                                .addComponent(jButtonPrintTheCost))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(jLabel1)
                                .addGap(59, 59, 59)
                                .addComponent(jTextFieldCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(288, 288, 288)
                                .addComponent(jButtonPay, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(272, 272, 272)
                                .addComponent(cost, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 207, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBackFExitTCustomer))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jButtonPrintTheCost, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(cost)
                        .addGap(33, 33, 33)
                        .addComponent(jButtonPay, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                        .addGap(71, 71, 71)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCustomerIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCustomerIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCustomerIdActionPerformed

    private void jButtonBackFExitTCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackFExitTCustomerActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        CustomerGUI c = new CustomerGUI();
        c.setLocation(450,150);
        c.setVisible(true);    
    }//GEN-LAST:event_jButtonBackFExitTCustomerActionPerformed

    private void jButtonPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPayActionPerformed
        // TODO add your handling code here:
//        this.setVisible(false);
//        LoginFrame l = new LoginFrame();
//        l.setLocation(450,150);
//        l.setVisible(true);
     Customer c = new Customer();
     int id = Integer.parseInt(jTextFieldCustomerId.getText());
     c.deleteCustomer(id);
     cost.setText("");
     jTextFieldCustomerId.setText("");
     jButtonPay.setVisible(false);
    }//GEN-LAST:event_jButtonPayActionPerformed

    private void jButtonPrintTheCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintTheCostActionPerformed
        // TODO add your handling code here:
        Customer c = new Customer();
        String x = null;
        if (! jTextFieldCustomerId.getText().equals("")){
        int id = Integer.parseInt(jTextFieldCustomerId.getText());
            try {
                x = c.pay(id);

            } catch (IOException ex) {
                Logger.getLogger(ExitGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        cost.setText(x);
        if (x.equals("ID Not Found"))
            jButtonPay.setVisible(false);
        else
            jButtonPay.setVisible(true);
                 }
         else
            cost.setText("Enter Your ID");
    }//GEN-LAST:event_jButtonPrintTheCostActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExitGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExitGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExitGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExitGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExitGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cost;
    private javax.swing.JButton jButtonBackFExitTCustomer;
    private javax.swing.JButton jButtonPay;
    private javax.swing.JButton jButtonPrintTheCost;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextFieldCustomerId;
    // End of variables declaration//GEN-END:variables
}
