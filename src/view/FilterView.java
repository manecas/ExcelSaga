/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.event.WindowEvent;
import presenter.IFilterPresenter;

/**
 *
 * @author Luis
 */
public class FilterView extends javax.swing.JFrame implements IFilterView {

    /**
     * Creates new form FilterView
     */
    private int xx;
    private int yy;
    private int x;
    private int y;
    private IFilterPresenter filterPresenter;
    
    public FilterView() {
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

        signalRadioButtonGroup = new javax.swing.ButtonGroup();
        comparisonRadioButtonGroup = new javax.swing.ButtonGroup();
        headerPanel = new javax.swing.JPanel();
        exitButton = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        upperRadioButton = new javax.swing.JRadioButton();
        midPanel = new javax.swing.JPanel();
        positiveRadioButton = new javax.swing.JRadioButton();
        negativeRadioButton = new javax.swing.JRadioButton();
        bottomPanel = new javax.swing.JPanel();
        equalRadioButton = new javax.swing.JRadioButton();
        superiorRadioButton = new javax.swing.JRadioButton();
        inferiorRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        exitButton.setBackground(new java.awt.Color(1, 198, 83));
        exitButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        exitButton.setForeground(new java.awt.Color(255, 255, 255));
        exitButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitButton.setText("X");
        exitButton.setOpaque(true);
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtononExitClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitButtononExitPressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exitButtononExitReleased(evt);
            }
        });
        headerPanel.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 40, 30));

        titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Filter Chooser");
        titleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        headerPanel.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        mainPanel.setBackground(new java.awt.Color(250, 250, 250));
        mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 198, 83), 2));
        mainPanel.setForeground(new java.awt.Color(255, 255, 255));

        topPanel.setBackground(new java.awt.Color(250, 250, 250));
        topPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 198, 83)));

        upperRadioButton.setBackground(new java.awt.Color(250, 250, 250));
        upperRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        upperRadioButton.setText("Upper");
        upperRadioButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        upperRadioButton.setIconTextGap(10);

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(upperRadioButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(upperRadioButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        midPanel.setBackground(new java.awt.Color(250, 250, 250));
        midPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 198, 83)));

        positiveRadioButton.setBackground(new java.awt.Color(250, 250, 250));
        signalRadioButtonGroup.add(positiveRadioButton);
        positiveRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        positiveRadioButton.setText("Positive");
        positiveRadioButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        positiveRadioButton.setIconTextGap(10);
        positiveRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positiveRadioButtonActionPerformed(evt);
            }
        });

        negativeRadioButton.setBackground(new java.awt.Color(250, 250, 250));
        signalRadioButtonGroup.add(negativeRadioButton);
        negativeRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        negativeRadioButton.setText("Negative");
        negativeRadioButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        negativeRadioButton.setIconTextGap(10);
        negativeRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negativeRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout midPanelLayout = new javax.swing.GroupLayout(midPanel);
        midPanel.setLayout(midPanelLayout);
        midPanelLayout.setHorizontalGroup(
            midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(midPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(positiveRadioButton)
                .addGap(10, 10, 10)
                .addComponent(negativeRadioButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        midPanelLayout.setVerticalGroup(
            midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(midPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(midPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(positiveRadioButton)
                    .addComponent(negativeRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bottomPanel.setBackground(new java.awt.Color(250, 250, 250));
        bottomPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 198, 83)));

        equalRadioButton.setBackground(new java.awt.Color(250, 250, 250));
        comparisonRadioButtonGroup.add(equalRadioButton);
        equalRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        equalRadioButton.setText("Equal");
        equalRadioButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        equalRadioButton.setIconTextGap(10);
        equalRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equalRadioButtonActionPerformed(evt);
            }
        });

        superiorRadioButton.setBackground(new java.awt.Color(250, 250, 250));
        comparisonRadioButtonGroup.add(superiorRadioButton);
        superiorRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        superiorRadioButton.setText("Superior");
        superiorRadioButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        superiorRadioButton.setIconTextGap(10);
        superiorRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                superiorRadioButtonActionPerformed(evt);
            }
        });

        inferiorRadioButton.setBackground(new java.awt.Color(250, 250, 250));
        comparisonRadioButtonGroup.add(inferiorRadioButton);
        inferiorRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        inferiorRadioButton.setText("Inferior");
        inferiorRadioButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        inferiorRadioButton.setIconTextGap(10);
        inferiorRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inferiorRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(superiorRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(equalRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inferiorRadioButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(superiorRadioButton)
                    .addComponent(equalRadioButton)
                    .addComponent(inferiorRadioButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(midPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(midPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inferiorRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inferiorRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inferiorRadioButtonActionPerformed

    private void positiveRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positiveRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_positiveRadioButtonActionPerformed

    private void negativeRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negativeRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_negativeRadioButtonActionPerformed

    private void superiorRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_superiorRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_superiorRadioButtonActionPerformed

    private void equalRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equalRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_equalRadioButtonActionPerformed

    private void exitButtononExitClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtononExitClicked
        filterPresenter.onExitClicked();
    }//GEN-LAST:event_exitButtononExitClicked

    private void exitButtononExitPressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtononExitPressed
        filterPresenter.onExitPressed();
    }//GEN-LAST:event_exitButtononExitPressed

    private void exitButtononExitReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtononExitReleased
        filterPresenter.onExitReleased();
    }//GEN-LAST:event_exitButtononExitReleased

    private void onHeaderPressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onHeaderPressed
        filterPresenter.onHeaderPressed(evt.getX(), evt.getY());
    }//GEN-LAST:event_onHeaderPressed

    private void onHeaderDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onHeaderDragged
        filterPresenter.onHeaderDragged(evt.getXOnScreen(), evt.getYOnScreen());
    }//GEN-LAST:event_onHeaderDragged

    @Override
    public void setPresenter(IFilterPresenter filterPresenter) {
        this.filterPresenter = filterPresenter;
    }

    @Override
    public void closeWindow() {
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.ButtonGroup comparisonRadioButtonGroup;
    private javax.swing.JRadioButton equalRadioButton;
    private javax.swing.JLabel exitButton;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JRadioButton inferiorRadioButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel midPanel;
    private javax.swing.JRadioButton negativeRadioButton;
    private javax.swing.JRadioButton positiveRadioButton;
    private javax.swing.ButtonGroup signalRadioButtonGroup;
    private javax.swing.JRadioButton superiorRadioButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel topPanel;
    private javax.swing.JRadioButton upperRadioButton;
    // End of variables declaration//GEN-END:variables
}
