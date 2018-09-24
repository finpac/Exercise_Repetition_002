/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheaterData;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author asus
 */
public class WheaterValueGUI extends javax.swing.JFrame {

    private Wheatermodel wheater = new Wheatermodel();
    private int temp = 15;
    private int air = 50;

    public WheaterValueGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        tempLabel = new javax.swing.JLabel();
        tempSlider = new javax.swing.JSlider();
        humidityLabel = new javax.swing.JLabel();
        humiditySlider = new javax.swing.JSlider();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        wheaterList = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 2));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Input"));
        jPanel2.setLayout(new java.awt.GridLayout(5, 0));

        tempLabel.setText("Temp: 15°C");
        jPanel2.add(tempLabel);

        tempSlider.setMajorTickSpacing(10);
        tempSlider.setMaximum(40);
        tempSlider.setMinimum(-20);
        tempSlider.setMinorTickSpacing(5);
        tempSlider.setPaintLabels(true);
        tempSlider.setPaintTicks(true);
        tempSlider.setValue(15);
        tempSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                onTempChange(evt);
            }
        });
        jPanel2.add(tempSlider);

        humidityLabel.setText("Humidity: 50%");
        humidityLabel.setToolTipText("");
        jPanel2.add(humidityLabel);

        humiditySlider.setMajorTickSpacing(20);
        humiditySlider.setMinorTickSpacing(10);
        humiditySlider.setPaintLabels(true);
        humiditySlider.setPaintTicks(true);
        humiditySlider.setToolTipText("");
        humiditySlider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        humiditySlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                onLuftChanged(evt);
            }
        });
        jPanel2.add(humiditySlider);

        jButton1.setText("Add Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onAdd(evt);
            }
        });
        jPanel2.add(jButton1);

        getContentPane().add(jPanel2);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Display"));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jScrollPane2.setViewportView(wheaterList);

        jPanel1.add(jScrollPane2);

        getContentPane().add(jPanel1);

        jMenu1.setText("Datei");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Save");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSave(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Load");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onLoad(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClose(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onClose(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClose
        dispose();
    }//GEN-LAST:event_onClose

    private void onLoad(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onLoad
        JFileChooser fc = new JFileChooser();
        int ok = fc.showOpenDialog(this);
        if (ok == APPROVE_OPTION) {
            File sel = fc.getSelectedFile();
            try {
                wheater.load(sel);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex, "SAVE/ERROR", ERROR_MESSAGE);
            }
        } else {
            System.out.println("File not found!");
        }
        wheaterList.setListData(wheater.getListe());
    }//GEN-LAST:event_onLoad

    private void onSave(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSave
        try {
            JFileChooser fc = new JFileChooser();
            int ok = fc.showSaveDialog(this);
            if (ok == APPROVE_OPTION) {
                System.out.println("Ok");
                File sel = fc.getSelectedFile();
                wheater.save(sel);
            } else {
                System.out.println("Cancel");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex, "SAVE/ERROR", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_onSave

    private void onAdd(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onAdd
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd - HH:mm:ss");
        String formatDateTime = now.format(formatter);
        try {
            WheaterValue w = new WheaterValue(temp, air, formatDateTime);
            wheater.add(w);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex, "SAVE/ERROR", ERROR_MESSAGE);
        }
        wheaterList.setListData(wheater.getListe());
    }//GEN-LAST:event_onAdd

    private void onLuftChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_onLuftChanged
        air = humiditySlider.getValue();
        humidityLabel.setText("Humidity: " + air + "%");
    }//GEN-LAST:event_onLuftChanged

    private void onTempChange(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_onTempChange
        temp = tempSlider.getValue();
        tempLabel.setText("Temp: " + temp + "°C");
    }//GEN-LAST:event_onTempChange

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
            java.util.logging.Logger.getLogger(WheaterValueGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WheaterValueGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WheaterValueGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WheaterValueGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WheaterValueGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel humidityLabel;
    private javax.swing.JSlider humiditySlider;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel tempLabel;
    private javax.swing.JSlider tempSlider;
    private javax.swing.JList<String> wheaterList;
    // End of variables declaration//GEN-END:variables
}
