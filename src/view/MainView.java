/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.event.WindowEvent;
import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.TableModel;
import presenter.MainPresenter;
import utils.ViewModeUtils;
import presenter.IMainPresenter;

/**
 *
 * @author Luis
 */
public class MainView extends javax.swing.JFrame implements IMainView {

    /**
     * Creates new form MainFrame
     */
    private int xx;
    private int yy;
    private int x;
    private int y;
    private IMainPresenter mainPresenter;
    
    public MainView() {
        initComponents();
        createRowHeader();
        mainPresenter = new MainPresenter(this);
        mainPresenter.setTableModel();
    }

    /**
     * This method is called from within the constructor to initialise the form.
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
        redoButton = new javax.swing.JLabel();
        undoButton = new javax.swing.JLabel();
        recordMacroButton = new javax.swing.JLabel();
        playMacroButton = new javax.swing.JLabel();
        viewModeButton = new javax.swing.JLabel();
        filterButton = new javax.swing.JLabel();
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
        subtitleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        headerPanel.add(subtitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 22, -1, -1));

        titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("The most powerful app out there");
        titleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
                onExitReleased(evt);
            }
        });
        headerPanel.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 0, 35, 30));

        sheetButton.setBackground(new java.awt.Color(0, 150, 62));
        sheetButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sheetButton.setForeground(new java.awt.Color(255, 255, 255));
        sheetButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sheetButton.setText("Sheet");
        sheetButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
        optionsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        optionsButton.setOpaque(true);
        optionsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onOptionsClicked(evt);
            }
        });
        headerPanel.add(optionsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 140, 30));

        redoButton.setBackground(new java.awt.Color(1, 198, 83));
        redoButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        redoButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        redoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Redo_32px.png"))); // NOI18N
        redoButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        redoButton.setOpaque(true);
        redoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onRedoClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                onRedoPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                onRedoReleased(evt);
            }
        });
        headerPanel.add(redoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 150, 30, 30));

        undoButton.setBackground(new java.awt.Color(1, 198, 83));
        undoButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        undoButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        undoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Undo_32px.png"))); // NOI18N
        undoButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        undoButton.setOpaque(true);
        undoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onUndoClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                onUndoPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                onUndoReleased(evt);
            }
        });
        headerPanel.add(undoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 150, 30, 30));

        recordMacroButton.setBackground(new java.awt.Color(1, 198, 83));
        recordMacroButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        recordMacroButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        recordMacroButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Record_32px.png"))); // NOI18N
        recordMacroButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        recordMacroButton.setOpaque(true);
        recordMacroButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onRecordMacroClicked(evt);
            }
        });
        headerPanel.add(recordMacroButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 30, 30));

        playMacroButton.setBackground(new java.awt.Color(1, 198, 83));
        playMacroButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        playMacroButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playMacroButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Circled Play_32px.png"))); // NOI18N
        playMacroButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        playMacroButton.setOpaque(true);
        playMacroButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onPlayMacroClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                onPlayMacroPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                onPlayMacroReleased(evt);
            }
        });
        headerPanel.add(playMacroButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 150, 30, 30));

        viewModeButton.setBackground(new java.awt.Color(1, 198, 83));
        viewModeButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        viewModeButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewModeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/Eye_32px.png"))); // NOI18N
        viewModeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viewModeButton.setOpaque(true);
        viewModeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onViewModeClicked(evt);
            }
        });
        headerPanel.add(viewModeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 30, 30));

        filterButton.setBackground(new java.awt.Color(1, 198, 83));
        filterButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        filterButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        filterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/filter _32px.png"))); // NOI18N
        filterButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        filterButton.setOpaque(true);
        filterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onFilterClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                onFilterPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                onFilterReleased(evt);
            }
        });
        headerPanel.add(filterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 30, 30));

        homePanel.setBackground(new java.awt.Color(255, 255, 255));
        homePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 198, 83), 2));
        homePanel.setLayout(new java.awt.CardLayout());

        sheetPanel.setLayout(new javax.swing.BoxLayout(sheetPanel, javax.swing.BoxLayout.LINE_AXIS));

        table.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        table.setForeground(new java.awt.Color(51, 51, 51));
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
        mainPresenter.onExitClicked();
    }//GEN-LAST:event_onExitClicked

    private void onSheetClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onSheetClicked
        mainPresenter.onSheetClicked();
    }//GEN-LAST:event_onSheetClicked

    private void onOptionsClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onOptionsClicked
        mainPresenter.onOptionsClicked();
    }//GEN-LAST:event_onOptionsClicked

    private void onHeaderPressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onHeaderPressed
        mainPresenter.onHeaderPressed(evt.getX(), evt.getY());
    }//GEN-LAST:event_onHeaderPressed

    private void onHeaderDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onHeaderDragged
        mainPresenter.onHeaderDragged(evt.getXOnScreen(), evt.getYOnScreen());
    }//GEN-LAST:event_onHeaderDragged

    private void onExitPressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onExitPressed
        mainPresenter.onExitPressed();
    }//GEN-LAST:event_onExitPressed

    private void onExitReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onExitReleased
        mainPresenter.onExitReleased();
    }//GEN-LAST:event_onExitReleased

    private void onRedoPressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onRedoPressed
        mainPresenter.onRedoPressed();
    }//GEN-LAST:event_onRedoPressed

    private void onRedoReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onRedoReleased
        mainPresenter.onRedoReleased();
    }//GEN-LAST:event_onRedoReleased

    private void onUndoPressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onUndoPressed
        mainPresenter.onUndoPressed();
    }//GEN-LAST:event_onUndoPressed

    private void onUndoReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onUndoReleased
        mainPresenter.onUndoReleased();
    }//GEN-LAST:event_onUndoReleased

    private void onPlayMacroClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onPlayMacroClicked
        mainPresenter.onPlayMacroClicked();
    }//GEN-LAST:event_onPlayMacroClicked

    private void onRecordMacroClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onRecordMacroClicked
        mainPresenter.onRecordMacroClicked();
    }//GEN-LAST:event_onRecordMacroClicked

    private void onUndoClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onUndoClicked
        mainPresenter.onUndoClicked();
    }//GEN-LAST:event_onUndoClicked

    private void onRedoClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onRedoClicked
        mainPresenter.onRedoClicked();
    }//GEN-LAST:event_onRedoClicked

    private void onViewModeClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onViewModeClicked
        mainPresenter.onViewModeClicked();
    }//GEN-LAST:event_onViewModeClicked

    private void onFilterClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onFilterClicked
        mainPresenter.onFilterClicked(table.getSelectedRow(), 
                table.getSelectedColumn());
    }//GEN-LAST:event_onFilterClicked

    private void onFilterPressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onFilterPressed
        mainPresenter.onFilterPressed();
    }//GEN-LAST:event_onFilterPressed

    private void onFilterReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onFilterReleased
        mainPresenter.onFilterReleased();
    }//GEN-LAST:event_onFilterReleased

    private void onPlayMacroPressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onPlayMacroPressed
        mainPresenter.onPlayMacroPressed();
    }//GEN-LAST:event_onPlayMacroPressed

    private void onPlayMacroReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onPlayMacroReleased
        mainPresenter.onPlayMacroReleased();
    }//GEN-LAST:event_onPlayMacroReleased

    @Override
    public void setTableModel(TableModel tableModel) {
        table.setModel(tableModel);
    }
    
    @Override
    public void setViewModeColor() {
        viewModeButton.setBackground(new Color(0, 150, 62));
    }

    @Override
    public void resetViewModeColor() {
        viewModeButton.setBackground(new Color(1, 198, 83));
    }
    
    @Override
    public void exitSystem() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    @Override
    public void setExitColor() {
        exitButton.setBackground(new Color(0, 150, 62));
    }

    @Override
    public void resetExitColor() {
        exitButton.setBackground(new Color(1, 198, 83));
    }
    
    @Override
    public void setRedoColor() {
        redoButton.setBackground(new Color(0, 150, 62));
    }

    @Override
    public void resetRedoColor() {
        redoButton.setBackground(new Color(1, 198, 83));
    }

    @Override
    public void setUndoColor() {
        undoButton.setBackground(new Color(0, 150, 62));
    }

    @Override
    public void resetUndoColor() {
        undoButton.setBackground(new Color(1, 198, 83));
    }

    @Override
    public void ShowSheetPanel() {
        sheetPanel.setVisible(true);
    }

    @Override
    public void hideSheetPanel() {
        sheetPanel.setVisible(false);
    }

    @Override
    public void setSheetColor() {
        sheetButton.setBackground(new Color(0, 150, 62));
    }

    @Override
    public void resetSheetColor() {
        sheetButton.setBackground(new Color(1, 198, 83));
    }

    @Override
    public void ShowOptionsPanel() {
        optionsPanel.setVisible(true);
    }

    @Override
    public void hideOptionsPanel() {
        optionsPanel.setVisible(false);
    }

    @Override
    public void setOptionsColor() {
        optionsButton.setBackground(new Color(0, 150, 62));
    }

    @Override
    public void resetOptionsColor() {
        optionsButton.setBackground(new Color(1, 198, 83));
    }

    @Override
    public void showFilterWindow(IFilterView filterView) {
        ((JFrame) filterView).setVisible(true);
    }
    
    @Override
    public void setFilterColor() {
        filterButton.setBackground(new Color(0, 150, 62));
    }

    @Override
    public void resetFilterColor() {
        filterButton.setBackground(new Color(1, 198, 83));
    }
    
    @Override
    public void setRecordMacroColor() {
        recordMacroButton.setBackground(new Color(0, 150, 62));
    }

    @Override
    public void resetRecordMacroColor() {
        recordMacroButton.setBackground(new Color(1, 198, 83));
    }
    
    @Override
    public void setPlayMacroColor() {
        playMacroButton.setBackground(new Color(0, 150, 62));
    }

    @Override
    public void resetPlayMacroColor() {
        playMacroButton.setBackground(new Color(1, 198, 83));
    }
    
    @Override
    public void setWindowPressedCoordinates(int x, int y) {
        xx = x;
        yy = y;
    }

    @Override
    public void setWindowDraggedCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setWindowLocation(int x, int y) {
        this.setLocation(x, y);
    }
    
    @Override
    public int getXX() {
        return xx;
    }

    @Override
    public int getYY() {
        return yy;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
    
    @Override
    public void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    private void createRowHeader(){
        
        ListModel lm = new AbstractListModel() {
            String headers[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

            public int getSize() {
              return headers.length;
            }

            @Override
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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exitButton;
    private javax.swing.JLabel filterButton;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel homePanel;
    private javax.swing.JLabel optionsButton;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JLabel playMacroButton;
    private javax.swing.JLabel recordMacroButton;
    private javax.swing.JLabel redoButton;
    private javax.swing.JLabel sheetButton;
    private javax.swing.JPanel sheetPanel;
    private javax.swing.JLabel subtitleLabel;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel undoButton;
    private javax.swing.JLabel viewModeButton;
    // End of variables declaration//GEN-END:variables

    

    

}
