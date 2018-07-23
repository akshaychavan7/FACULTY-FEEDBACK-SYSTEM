/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedback.system;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author akshay
 */
public class Teacher_WIndow extends javax.swing.JFrame {

    /**
     * Creates new form Teacher_WIndow
     */
    public int getPoints(String s){
        /*jb[0].setText("Excellent");
                        jb[1].setText("Very Good");
                        jb[2].setText("Good");
                        jb[3].setText("Average");
                        jb[4].setText("Below Average");*/
        
        if(s.equals("Excellent"))
            return 5;
        if(s.equals("Very Good"))
            return 4;
        if(s.equals("Good"))
            return 3;
        if(s.equals("Average"))
            return 2;
        if(s.equals("Below Average"))
            return 1;
        return 0;
    }
    public Teacher_WIndow() {
        initComponents();
        
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:/home/akshay/NetBeansProjects/Feedback System/feedback.sqlite");
            String nm1="";
                   switch(Login.year){
                       case 1:nm1="first_";
                                break;
                       case 2: nm1="second_";
                                break;
                       case 3: nm1="third_";
                                break;
                       case 4: nm1="forth_";
                                break;
                   }
                   nm1=nm1+Login.division+"_";                 
                   switch(Login.SubjectCode){
                       case 1:nm1=nm1+"1";
                                break;
                       case 2:nm1=nm1+"2";
                                break;
                       case 3:nm1=nm1+"3";
                                break;
                       case 4:nm1=nm1+"4";
                                break;
                       case 5:nm1=nm1+"5";
                                break;
                   }
            Statement stmt=conn.createStatement();  
            ResultSet rs1;
            boolean flag2=false;
            rs1=conn.getMetaData().getTables(null,null,nm1,null);
            while(rs1.next()){
                       String catalogs=rs1.getString(3);
                       if(nm1.equals(catalogs)){
                            flag2=true;
                             ResultSet rs=stmt.executeQuery("select * from "+nm1);  
                            // JOptionPane.showMessageDialog(null, rs.getString(1));
                             DefaultTableModel model1=(DefaultTableModel)again.getModel();
                             DefaultTableModel model2=(DefaultTableModel)solve.getModel();
                             DefaultTableModel model3=(DefaultTableModel)comments.getModel();
                             float q1=0,q2=0,q3=0,q4=0,q5=0,q6=0,q7=0,q8=0;
                             int count=0;
                             while(rs.next()){
                                 count++;
                                 String rev1=rs.getString(1);
                                 String rev2=rs.getString(2);
                                 String rev3=rs.getString(3);
                                 String rev4=rs.getString(4);
                                 String rev5=rs.getString(5);
                                 String rev6=rs.getString(6);
                                 String rev7=rs.getString(7);
                                 String rev8=rs.getString(8);
                                 q1=q1+getPoints(rev1);
                                 q2=q2+getPoints(rev2);
                                 q3=q3+getPoints(rev3);
                                 q4=q4+getPoints(rev4);
                                 q5=q5+getPoints(rev5);
                                 q6=q6+getPoints(rev6);
                                 q7=q7+getPoints(rev7);
                                 q8=q8+getPoints(rev8);
                                 if(!rs.getString(9).equals("")){
                                     Object[] row1=new Object[]{rs.getString(9)};
                                     model1.addRow(row1);
                                 }
                                 if(!rs.getString(10).equals("")){
                                     Object[] row2=new Object[]{rs.getString(10)};
                                     model2.addRow(row2);
                                 }
                                 if(!rs.getString(11).equals("")){
                                     Object[] row3=new Object[]{rs.getString(11)};
                                     model3.addRow(row3);
                                 }

                             }
                             question1.setText(String.valueOf(q1/count));
                             question2.setText(String.valueOf(q2/count));
                             question3.setText(String.valueOf(q3/count));
                             question4.setText(String.valueOf(q4/count));
                             question5.setText(String.valueOf(q5/count));
                             question6.setText(String.valueOf(q6/count));
                             question7.setText(String.valueOf(q7/count));
                             question8.setText(String.valueOf(q8/count));
                            break;
                       }
                       
                   }
                   if(!flag2){ 
                       
                      JOptionPane.showMessageDialog(this, "No feedbacks given"); 
                      System.exit(0);
                   }
           
        } catch (SQLException ex) {
            Logger.getLogger(Teacher_WIndow.class.getName()).log(Level.SEVERE, null, ex);
        }
        question1.setEditable(false);
        question2.setEditable(false);
        question3.setEditable(false);
        question4.setEditable(false);
        question5.setEditable(false);
        question6.setEditable(false);
        question7.setEditable(false);
        question8.setEditable(false); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        question8 = new javax.swing.JTextField();
        question1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        question6 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        comments = new javax.swing.JTable();
        question5 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        again = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        question2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        question3 = new javax.swing.JTextField();
        question4 = new javax.swing.JTextField();
        question7 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        solve = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(226, 202, 28));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reports", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Bookman L", 1, 36), new java.awt.Color(18, 35, 234))); // NOI18N

        question8.setText("jTextField1");
        question8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                question8ActionPerformed(evt);
            }
        });

        question1.setText("jTextField1");
        question1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                question1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Ques 5.");

        jLabel1.setText("Ques 1.");

        question6.setText("jTextField1");
        question6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                question6ActionPerformed(evt);
            }
        });

        comments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Comments"
            }
        ));
        jScrollPane2.setViewportView(comments);
        if (comments.getColumnModel().getColumnCount() > 0) {
            comments.getColumnModel().getColumn(0).setResizable(false);
        }

        question5.setText("jTextField1");
        question5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                question5ActionPerformed(evt);
            }
        });

        jLabel3.setText("Ques 3.");

        again.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Teach again"
            }
        ));
        jScrollPane1.setViewportView(again);
        if (again.getColumnModel().getColumnCount() > 0) {
            again.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel7.setText("Ques 8.");

        question2.setText("jTextField1");
        question2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                question2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Ques 2.");

        jLabel8.setText("Ques 6.");

        question3.setText("jTextField1");
        question3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                question3ActionPerformed(evt);
            }
        });

        question4.setText("jTextField1");
        question4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                question4ActionPerformed(evt);
            }
        });

        question7.setText("jTextField1");
        question7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                question7ActionPerformed(evt);
            }
        });

        solve.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Solves Questions"
            }
        ));
        jScrollPane3.setViewportView(solve);
        if (solve.getColumnModel().getColumnCount() > 0) {
            solve.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel4.setText("Ques 4.");

        jLabel6.setText("Ques 7.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(question3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(question2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(question1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(question8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(question7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(question6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(question5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(question4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(question1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(question2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(question3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(question4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(question5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(question6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(question7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(question8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void question1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_question1ActionPerformed
        
        // TODO add your handling code here:
    }//GEN-LAST:event_question1ActionPerformed

    private void question2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_question2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_question2ActionPerformed

    private void question3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_question3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_question3ActionPerformed

    private void question4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_question4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_question4ActionPerformed

    private void question5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_question5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_question5ActionPerformed

    private void question6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_question6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_question6ActionPerformed

    private void question7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_question7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_question7ActionPerformed

    private void question8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_question8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_question8ActionPerformed

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
            java.util.logging.Logger.getLogger(Teacher_WIndow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teacher_WIndow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teacher_WIndow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teacher_WIndow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Teacher_WIndow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable again;
    private javax.swing.JTable comments;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField question1;
    private javax.swing.JTextField question2;
    private javax.swing.JTextField question3;
    private javax.swing.JTextField question4;
    private javax.swing.JTextField question5;
    private javax.swing.JTextField question6;
    private javax.swing.JTextField question7;
    private javax.swing.JTextField question8;
    private javax.swing.JTable solve;
    // End of variables declaration//GEN-END:variables
}
