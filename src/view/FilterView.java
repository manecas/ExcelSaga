/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import presenter.IFilterPresenter;

/**
 *
 * @author Luis
 */
public class FilterView extends javax.swing.JFrame implements IFilterView {

    /**
     * Creates new form FilterView
     */
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
        subtitleLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        inferiorRadioButton = new javax.swing.JRadioButton();
        upperRadioButton = new javax.swing.JRadioButton();
        positiveRadioButton = new javax.swing.JRadioButton();
        negativeRadioButton = new javax.swing.JRadioButton();
        superiorRadioButton = new javax.swing.JRadioButton();
        equalRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerPanel.setBackground(new java.awt.Color(1, 198, 83));
        headerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        subtitleLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        subtitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        subtitleLabel.setText("Filter Chooser");
        subtitleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        headerPanel.add(subtitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        mainPanel.setBackground(new java.awt.Color(250, 250, 250));
        mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 198, 83), 2));
        mainPanel.setForeground(new java.awt.Color(255, 255, 255));

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

        upperRadioButton.setBackground(new java.awt.Color(250, 250, 250));
        upperRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        upperRadioButton.setText("Upper");
        upperRadioButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        upperRadioButton.setIconTextGap(10);

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

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(upperRadioButton)
                    .addComponent(positiveRadioButton)
                    .addComponent(superiorRadioButton))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(equalRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(inferiorRadioButton))
                    .addComponent(negativeRadioButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(upperRadioButton)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(positiveRadioButton)
                    .addComponent(negativeRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(superiorRadioButton)
                    .addComponent(equalRadioButton)
                    .addComponent(inferiorRadioButton))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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

    @Override
    public void setPresenter(IFilterPresenter filterPresenter) {
        this.filterPresenter = filterPresenter;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup comparisonRadioButtonGroup;
    private javax.swing.JRadioButton equalRadioButton;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JRadioButton inferiorRadioButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JRadioButton negativeRadioButton;
    private javax.swing.JRadioButton positiveRadioButton;
    private javax.swing.ButtonGroup signalRadioButtonGroup;
    private javax.swing.JLabel subtitleLabel;
    private javax.swing.JRadioButton superiorRadioButton;
    private javax.swing.JRadioButton upperRadioButton;
    // End of variables declaration//GEN-END:variables
}
