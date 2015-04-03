/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.winter2015.minesweeper.swing;

import cit260.winter2015.minesweeper.exceptions.EndGameException;
import cit260.winter2015.minesweeper.menuControls.LevelSelectionControl;
import static cit260.winter2015.minesweeper.swing.MainFrame.mainPanel;

/**
 *
 * @author knban_000
 */
public class HelpMenu extends javax.swing.JPanel {

    /**
     * Creates new form LevelSelection
     */
    public HelpMenu() {
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

        jpButtonPanel = new javax.swing.JPanel();
        jbBeginner = new javax.swing.JButton();
        jbIntermediate = new javax.swing.JButton();
        jbExpert = new javax.swing.JButton();
        jbPreset = new javax.swing.JButton();
        jbQuitToMain = new javax.swing.JButton();
        jpTextPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jpTitlePanel = new javax.swing.JPanel();
        jlTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 51, 153));
        setPreferredSize(new java.awt.Dimension(500, 400));

        jpButtonPanel.setBackground(new java.awt.Color(0, 51, 153));

        jbBeginner.setText("Beginner");
        jbBeginner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBeginnerActionPerformed(evt);
            }
        });

        jbIntermediate.setText("Intermediate");
        jbIntermediate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIntermediateActionPerformed(evt);
            }
        });

        jbExpert.setText("Expert");
        jbExpert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExpertActionPerformed(evt);
            }
        });

        jbPreset.setText("Preset Beginner");
        jbPreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPresetActionPerformed(evt);
            }
        });

        jbQuitToMain.setText("Quit to Main Menu");
        jbQuitToMain.setToolTipText("");
        jbQuitToMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbQuitToMainActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpButtonPanelLayout = new javax.swing.GroupLayout(jpButtonPanel);
        jpButtonPanel.setLayout(jpButtonPanelLayout);
        jpButtonPanelLayout.setHorizontalGroup(
            jpButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbBeginner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbIntermediate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbExpert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbPreset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbQuitToMain, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
        );
        jpButtonPanelLayout.setVerticalGroup(
            jpButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpButtonPanelLayout.createSequentialGroup()
                .addComponent(jbBeginner)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbIntermediate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbExpert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbPreset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbQuitToMain)
                .addContainerGap(178, Short.MAX_VALUE))
        );

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Double Click on this text to change it to the text that belongs in the help menu.");
        jTextArea1.setToolTipText("");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jpTextPanelLayout = new javax.swing.GroupLayout(jpTextPanel);
        jpTextPanel.setLayout(jpTextPanelLayout);
        jpTextPanelLayout.setHorizontalGroup(
            jpTextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jpTextPanelLayout.setVerticalGroup(
            jpTextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jpTitlePanel.setBackground(new java.awt.Color(0, 51, 153));
        jpTitlePanel.setPreferredSize(new java.awt.Dimension(500, 46));
        jpTitlePanel.setLayout(new java.awt.BorderLayout());

        jlTitle.setFont(new java.awt.Font("Stencil", 0, 36)); // NOI18N
        jlTitle.setForeground(new java.awt.Color(240, 240, 240));
        jlTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitle.setText("Minesweeper");
        jlTitle.setToolTipText("");
        jlTitle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jlTitle.setMaximumSize(new java.awt.Dimension(2000, 37));
        jpTitlePanel.add(jlTitle, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jpTextPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
                .addComponent(jpTitlePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jpTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jpButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(6, 6, 6))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jpTextPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap()))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbBeginnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBeginnerActionPerformed
        try {
            LevelSelectionControl.beginner();
        } catch (EndGameException ex) {
            // Todo
        }
    }//GEN-LAST:event_jbBeginnerActionPerformed

    private void jbIntermediateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIntermediateActionPerformed
        try {
            LevelSelectionControl.intermediate();
        } catch (EndGameException ex) {
            // Todo
        }
    }//GEN-LAST:event_jbIntermediateActionPerformed

    private void jbExpertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExpertActionPerformed
        try {
            LevelSelectionControl.expert();
        } catch (EndGameException ex) {
            // Todo
        }
    }//GEN-LAST:event_jbExpertActionPerformed

    private void jbPresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPresetActionPerformed
        try {
            LevelSelectionControl.beginnerPreset();
        } catch (EndGameException ex) {
            // Todo
        }
    }//GEN-LAST:event_jbPresetActionPerformed

    private void jbQuitToMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbQuitToMainActionPerformed
        MainFrame.card.show(mainPanel, "mainMenu");
    }//GEN-LAST:event_jbQuitToMainActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbBeginner;
    private javax.swing.JButton jbExpert;
    private javax.swing.JButton jbIntermediate;
    private javax.swing.JButton jbPreset;
    private javax.swing.JButton jbQuitToMain;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JPanel jpButtonPanel;
    private javax.swing.JPanel jpTextPanel;
    private javax.swing.JPanel jpTitlePanel;
    // End of variables declaration//GEN-END:variables
}
