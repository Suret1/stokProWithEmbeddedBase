/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frame;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import java.util.HashSet;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.barcodescanner.BarcodeScanner;
import com.query.Base_Operations;
import static com.frame.CounterFrame.count_table;
import static com.frame.CounterFrame.model;

/**
 *
 * @author suret
 */
public class CounterFrame extends javax.swing.JFrame {

    protected static DefaultTableModel model;

    Thread t1 = new Thread(new CountBarcode()); //Classdan thread yaradildi

    /**
     * Creates new form CountFrame
     */
    public CounterFrame() {
        initComponents();
        model = (DefaultTableModel) count_table.getModel();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        delete_item = new javax.swing.JMenuItem();
        delete_pane = new javax.swing.JOptionPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        count_table = new javax.swing.JTable();
        start_btn = new javax.swing.JButton();
        refresh_btn = new javax.swing.JButton();
        export_btn = new javax.swing.JButton();
        start_text = new javax.swing.JLabel();
        refresh_txt = new javax.swing.JLabel();
        excel_txt = new javax.swing.JLabel();
        background_photo = new javax.swing.JLabel();

        delete_item.setText("Delete");
        delete_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_itemActionPerformed(evt);
            }
        });
        popupMenu.add(delete_item);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Counter Mode");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        count_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Count", "Database", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        count_table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        count_table.setFocusable(false);
        count_table.setOpaque(false);
        count_table.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        count_table.setSurrendersFocusOnKeystroke(true);
        count_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                count_tableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(count_table);
        count_table.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        count_table.setFocusable(false);

        count_table.setGridColor(new java.awt.Color(0, 0, 0));

        count_table.setIntercellSpacing(new java.awt.Dimension(0, 0));

        count_table.setOpaque(false);

        count_table.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        count_table.setSurrendersFocusOnKeystroke(true);
        //count_table.addMouseListener(new java.awt.event.MouseAdapter() {
            //    public void mouseReleased(java.awt.event.MouseEvent evt) {
                //       count_tableMouseReleased(evt);
                //    }
            //});

    getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 690, 340));

    start_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icons/start-up - Copy.png"))); // NOI18N
    start_btn.setBorder(null);
    start_btn.setContentAreaFilled(false);
    start_btn.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            start_btnMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            start_btnMouseExited(evt);
        }
    });
    start_btn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            start_btnActionPerformed(evt);
        }
    });
    getContentPane().add(start_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));

    refresh_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icons/refresh - Copy.png"))); // NOI18N
    refresh_btn.setBorder(null);
    refresh_btn.setContentAreaFilled(false);
    refresh_btn.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            refresh_btnMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            refresh_btnMouseExited(evt);
        }
    });
    refresh_btn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            refresh_btnActionPerformed(evt);
        }
    });
    getContentPane().add(refresh_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 61, -1, 40));

    export_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icons/excel - Copy.png"))); // NOI18N
    export_btn.setBorder(null);
    export_btn.setContentAreaFilled(false);
    export_btn.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            export_btnMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            export_btnMouseExited(evt);
        }
    });
    export_btn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            export_btnActionPerformed(evt);
        }
    });
    getContentPane().add(export_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 61, -1, 40));

    start_text.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
    start_text.setText("Start");
    getContentPane().add(start_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 50, 30));
    start_text.setVisible(false);

    refresh_txt.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
    refresh_txt.setText("Refresh");
    getContentPane().add(refresh_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 44, -1, 20));
    refresh_txt.setVisible(false);

    excel_txt.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
    excel_txt.setText("Export to Excel");
    getContentPane().add(excel_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 110, 30));
    excel_txt.setVisible(false);

    background_photo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icons/Rectangle 1.png"))); // NOI18N
    getContentPane().add(background_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 110));

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void start_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start_btnActionPerformed
        try {
            CounterFrame cf = new CounterFrame();
            cf.setVisible(true);
            this.dispose();
            t1.start();//thread ise basladi

        } catch (Exception e) {

        }
    }//GEN-LAST:event_start_btnActionPerformed

    private void count_tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_count_tableMouseReleased
        if (evt.isPopupTrigger()) {
            popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_count_tableMouseReleased

    private void delete_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_itemActionPerformed
        int[] rows = count_table.getSelectedRows();
        int response = delete_pane.showConfirmDialog(this, "Do you really want to delete this?", "Warning", delete_pane.YES_NO_OPTION);
        for (int i = rows.length - 1; i >= 0; i--) {
            model.removeRow(rows[i]);
        }
    }//GEN-LAST:event_delete_itemActionPerformed

    private void refresh_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_btnActionPerformed
        CountBarcode barco = new CountBarcode();
        barco.productCheck(); //mehsul yeniden bazadan sorgu edilir
    }//GEN-LAST:event_refresh_btnActionPerformed

    private void export_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_export_btnActionPerformed
        FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExporter = null;
        if (model.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(this, "Table is currently empty", "Warning", JOptionPane.ERROR_MESSAGE);
        } else {
            JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\SNAP-PC\\Desktop");
            excelFileChooser.setDialogTitle("Save as");

            FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("EXCEL", "xls", "xlsx", "xlsm");
            excelFileChooser.setFileFilter(extensionFilter);
            int excelChooser = excelFileChooser.showSaveDialog(null);

            if (excelChooser == JFileChooser.APPROVE_OPTION) {
                try {
                    excelJTableExporter = new XSSFWorkbook();
                    XSSFSheet excelSheet = excelJTableExporter.createSheet("Sayım_Hesabat");

                    for (int i = 0; i < model.getRowCount(); i++) {
                        XSSFRow excelRow = excelSheet.createRow(i);
                        for (int j = 0; j < model.getColumnCount(); j++) {
                            XSSFCell excelCell = excelRow.createCell(j);

                            excelCell.setCellValue(model.getValueAt(i, j).toString());

                        }
                    }
                    excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                    excelBOU = new BufferedOutputStream(excelFOU);
                    excelJTableExporter.write(excelBOU);
                    JOptionPane.showMessageDialog(null, "Exported Succesfully..");

                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();

                } catch (IOException ex) {
                    ex.printStackTrace();

                } finally {
                    try {
                        if (excelBOU != null) {
                            excelBOU.close();
                        }
                        if (excelFOU != null) {
                            excelFOU.close();
                        }
                        if (excelJTableExporter != null) {
                            excelJTableExporter.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                }
            }
        }
    }//GEN-LAST:event_export_btnActionPerformed

    private void start_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_start_btnMouseEntered
        start_text.setVisible(true);
    }//GEN-LAST:event_start_btnMouseEntered

    private void start_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_start_btnMouseExited
        start_text.setVisible(false);
    }//GEN-LAST:event_start_btnMouseExited

    private void refresh_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refresh_btnMouseEntered
        refresh_txt.setVisible(true);
    }//GEN-LAST:event_refresh_btnMouseEntered

    private void refresh_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refresh_btnMouseExited
        refresh_txt.setVisible(false);
    }//GEN-LAST:event_refresh_btnMouseExited

    private void export_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_export_btnMouseEntered
        excel_txt.setVisible(true);
    }//GEN-LAST:event_export_btnMouseEntered

    private void export_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_export_btnMouseExited
        excel_txt.setVisible(false);
    }//GEN-LAST:event_export_btnMouseExited

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
            java.util.logging.Logger.getLogger(CounterFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CounterFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CounterFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CounterFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CounterFrame().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background_photo;
    public static javax.swing.JTable count_table;
    private javax.swing.JMenuItem delete_item;
    private javax.swing.JOptionPane delete_pane;
    private javax.swing.JLabel excel_txt;
    private javax.swing.JButton export_btn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JButton refresh_btn;
    private javax.swing.JLabel refresh_txt;
    private javax.swing.JButton start_btn;
    private javax.swing.JLabel start_text;
    // End of variables declaration//GEN-END:variables
}

final class CountBarcode implements Runnable {

    Base_Operations operations = new Base_Operations();

    HashSet<String> hashSet = new HashSet<>();

    @Override
    public void run() {
        try {
            while (true) {

                Thread.sleep(1000);

                if (BarcodeScanner.barcode.length() > 0) { //barcode oxunubsa hashSet elave edilir

                    hashSet.add(BarcodeScanner.barcode);

                    for (String s : hashSet) { //barcode hashSet-dena alinir

                        if (count_table.getRowCount() <= 0) { //table-da row yoxdursa yeni row elave edilir
                            Object[] data = new Object[]{s, 1};
                            model.addRow(data);
                            productCheck();

                        } else if (barcodeCheck(s) == false) { //eger false olarsa yeni row elave edilir; true halda count artirilir
                            Object[] data = new Object[]{s, 1};
                            model.addRow(data);
                            productCheck();
                        }
                        hashSet.clear();
                        BarcodeScanner.barcode = ""; //Barcode 0-lanir
                    }
                }
            }

        } catch (Exception e) {
        }
    }

    public boolean barcodeCheck(String s) {

        for (int i = 0; i < model.getRowCount(); i++) { //table butun setirleri oxunur

            String value = model.getValueAt(i, 0).toString();//barcode alinir
            String count = model.getValueAt(i, 1).toString();//say alinir 

            int j = Integer.parseInt(count);//say int-e casting edilir

            if (s.equals(value)) { //daxil olan barcode eger table-da olarsa
                j++;//say artilir

                model.setValueAt(j, i, 1);//yeni say yazilir
                productCheck();//barcode bazada olub-olmamasi yoxlanilir
                return true; //if odense true qayidir
            }
            j = 0;//say 0-lanmalidir
        }
        return false;//barcode table-da olmasa false qaytarilsin ve addRow edilsin
    }

    public void productCheck() {

        for (int i = 0; i < model.getRowCount(); i++) { //table butun setirleri oxunur

            String value = model.getValueAt(i, 0).toString();//barcode alinir
            String count = model.getValueAt(i, 1).toString();//say alinir 

            int j = Integer.parseInt(count); //say int-e casting edilir

            HashMap<String, String> hashMap = operations.productsCount(value);//alinan barcode bazaya yollanir

            if (hashMap != null) { //eger barcode varsa
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {//barcode hashmap oxunur

                    String pro = entry.getValue();//mehsulun adi alinir
                    String cou = entry.getKey();//mehsulun sayi alinir

                    model.setValueAt(pro + " " + cou + " - ədəd", i, 2);//table mehsul haqqinda melumat yazilir

                    int c = j - (Integer.parseInt(cou));//mehsulun sayindan - bazadaki say cixilir

                    if (c == 0) {
                        model.setValueAt("Məhsul tamdır", i, 3);
                    } else if (c <= -1) {
                        model.setValueAt(c + "-ədəd məhsul çatışmır", i, 3);
                    } else {
                        model.setValueAt(c + "-ədəd məhsul artıqdır", i, 3);
                    }

                }

            } else {
                model.setValueAt("Məhsul yoxdur", i, 2);//eger null olarsa
                model.setValueAt("0", i, 3);
            }
        }
    }
}
