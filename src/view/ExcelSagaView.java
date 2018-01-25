/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListModel;

/**
 *
 * @author Luis
 */
public class ExcelSagaView extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    
    private int xx;
    private int yy;
    
    public ExcelSagaView() {
        initComponents();
        
        ListModel lm = new AbstractListModel() {
            String headers[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

            public int getSize() {
              return headers.length;
            }

            public Object getElementAt(int index) {
              return headers[index];
            }
          };
        
        JList rowHeader = new JList(lm);
        rowHeader.setFixedCellWidth(50);
        rowHeader.setFixedCellHeight(table.getRowHeight());
        rowHeader.setCellRenderer(new RowHeaderRenderer(table));
        rowHeader.setBackground(new Color(255, 255, 255));
        rowHeader.setOpaque(true);
        tableScrollPane.setRowHeaderView(rowHeader);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        subtitleLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        exitButton = new javax.swing.JLabel();
        sheetButton = new javax.swing.JLabel();
        optionsButton = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        homePanel = new javax.swing.JPanel();
        sheetPanel = new javax.swing.JPanel();
        tableScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        optionsPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setUndecorated(true);

        headerPanel.setBackground(new java.awt.Color(1, 198, 83));
        headerPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                onHeaderDragged(evt);
            }
        });
        headerPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                onHeaderPressed(evt);
            }
        });
        headerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        subtitleLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        subtitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        subtitleLabel.setText("ExcelSaga");
        headerPanel.add(subtitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 22, -1, -1));

        titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("The most powerful app out there");
        headerPanel.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 77, -1, -1));

        exitButton.setBackground(new java.awt.Color(1, 198, 83));
        exitButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        exitButton.setForeground(new java.awt.Color(255, 255, 255));
        exitButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitButton.setText("X");
        exitButton.setOpaque(true);
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onExitClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                onExitPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                onExitRelease(evt);
            }
        });
        headerPanel.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 0, 37, -1));

        sheetButton.setBackground(new java.awt.Color(0, 150, 62));
        sheetButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sheetButton.setForeground(new java.awt.Color(255, 255, 255));
        sheetButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sheetButton.setText("Sheet");
        sheetButton.setMaximumSize(new java.awt.Dimension(49, 20));
        sheetButton.setMinimumSize(new java.awt.Dimension(49, 20));
        sheetButton.setOpaque(true);
        sheetButton.setPreferredSize(new java.awt.Dimension(49, 20));
        sheetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onSheetClicked(evt);
            }
        });
        headerPanel.add(sheetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 149, 140, 30));

        optionsButton.setBackground(new java.awt.Color(1, 198, 83));
        optionsButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        optionsButton.setForeground(new java.awt.Color(255, 255, 255));
        optionsButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        optionsButton.setText("Options");
        optionsButton.setOpaque(true);
        optionsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onOptionsClicked(evt);
            }
        });
        headerPanel.add(optionsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 140, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luis\\AppData\\Local\\Temp\\icons8_Redo_30px.png")); // NOI18N
        headerPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 150, 30, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luis\\AppData\\Local\\Temp\\icons8_Circled_Play_30px.png")); // NOI18N
        headerPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 150, 30, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luis\\AppData\\Local\\Temp\\icons8_Undo_30px_1.png")); // NOI18N
        headerPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 150, 30, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Luis\\AppData\\Local\\Temp\\icons8_Record_36px.png")); // NOI18N
        headerPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, 30, 30));

        homePanel.setBackground(new java.awt.Color(255, 255, 255));
        homePanel.setLayout(new java.awt.CardLayout());

        sheetPanel.setLayout(new javax.swing.BoxLayout(sheetPanel, javax.swing.BoxLayout.LINE_AXIS));

        table.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        table.setForeground(new java.awt.Color(51, 51, 51));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "A", "B", "C", "D", "E", "F", "G", "H"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.setCellSelectionEnabled(true);
        table.setName(""); // NOI18N
        table.setRowHeight(28);
        table.setSelectionBackground(new java.awt.Color(51, 153, 255));
        table.getTableHeader().setReorderingAllowed(false);
        tableScrollPane.setViewportView(table);

        sheetPanel.add(tableScrollPane);

        homePanel.add(sheetPanel, "card2");

        javax.swing.GroupLayout optionsPanelLayout = new javax.swing.GroupLayout(optionsPanel);
        optionsPanel.setLayout(optionsPanelLayout);
        optionsPanelLayout.setHorizontalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        optionsPanelLayout.setVerticalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        homePanel.add(optionsPanel, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(homePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onExitClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onExitClicked
        System.exit(0);
    }//GEN-LAST:event_onExitClicked

    private void onSheetClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onSheetClicked
        setLabelColor(sheetButton);
        resetLabelColor(optionsButton);
        sheetPanel.setVisible(true);
        optionsPanel.setVisible(false);
    }//GEN-LAST:event_onSheetClicked

    private void onOptionsClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onOptionsClicked
        setLabelColor(optionsButton);
        resetLabelColor(sheetButton);
        sheetPanel.setVisible(false);
        optionsPanel.setVisible(true);
    }//GEN-LAST:event_onOptionsClicked

    private void onHeaderPressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onHeaderPressed
        xx = evt.getX();
        yy = evt.getY();
    }//GEN-LAST:event_onHeaderPressed

    private void onHeaderDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onHeaderDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - yy);
    }//GEN-LAST:event_onHeaderDragged

    private void onExitPressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onExitPressed
        exitButton.setBackground(new Color(0, 150, 62));
    }//GEN-LAST:event_onExitPressed

    private void onExitRelease(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onExitRelease
        exitButton.setBackground(new Color(1, 198, 83));
    }//GEN-LAST:event_onExitRelease

    public void setLabelColor(JLabel label){
        label.setBackground(new Color(0, 150, 62));
    }
    
    public void resetLabelColor(JLabel label){
        label.setBackground(new Color(1, 198, 83));
    }
    
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExcelSagaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExcelSagaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExcelSagaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExcelSagaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExcelSagaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exitButton;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel homePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel optionsButton;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JLabel sheetButton;
    private javax.swing.JPanel sheetPanel;
    private javax.swing.JLabel subtitleLabel;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}