/*
 * Copyright (c) Mirth Corporation. All rights reserved.
 * 
 * http://www.mirthcorp.com
 * 
 * The software in this package is published under the terms of the MPL license a copy of which has
 * been included with this distribution in the LICENSE.txt file.
 */

package com.mirth.connect.client.ui;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.UIManager;

/** Creates the error dialog. */
public class CustomErrorDialog extends MirthDialog {

    private Frame parent;
    public static final String ERROR_SAVING_CHANNEL = "There was an error in the validation of your channel.  It has been DISABLED and saved.  Before you can deploy you must fix the following error(s):";
    public static final String ERROR_VALIDATING_CONNECTOR = "There was an error in the validation of your connector.  Please fix the following error(s):";
    public static final String ERROR_ENABLING_CHANNEL = "The channel was not configured properly.  Please fix the following problem(s) in the channel before trying to enable it again:";
    public static final String ERROR_VALIDATING_GLOBAL_SCRIPTS = "There was an error in the validation of your global scripts.  Please fix the following error(s):";

    public CustomErrorDialog(java.awt.Frame owner, String errorMessage, String errorQuestion) {
        super(owner);
        initialize(errorMessage, errorQuestion);
    }

    public CustomErrorDialog(java.awt.Dialog owner, String errorMessage, String errorQuestion) {
        super(owner);
        initialize(errorMessage, errorQuestion);
    }

    private void initialize(String errorMessage, String errorQuestion) {
        this.parent = PlatformUI.MIRTH_FRAME;
        initComponents();

        question.setText(errorQuestion);

        question.setBackground(UIManager.getColor("Control"));
        errorContent.setBackground(UIManager.getColor("Control"));
        image.setIcon((Icon) UIManager.get("OptionPane.errorIcon"));
        questionPane.setBorder(null);
        errorContent.setText(errorMessage);
        errorContent.setCaretPosition(0);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        pack();
        Dimension dlgSize = getPreferredSize();
        Dimension frmSize = parent.getSize();
        Point loc = parent.getLocation();

        if ((frmSize.width == 0 && frmSize.height == 0) || (loc.x == 0 && loc.y == 0)) {
            setLocationRelativeTo(null);
        } else {
            setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
        }

        cancel.requestFocusInWindow();
        setVisible(true);
    }

    // @formatter:off
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code
    // <editor-fold defaultstate="collapsed" desc=" Generated Code
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        questionPane = new javax.swing.JScrollPane();
        question = new javax.swing.JTextPane();
        image = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        errorContent = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Error(s)");

        questionPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        question.setBackground(new java.awt.Color(224, 223, 227));
        question.setBorder(null);
        question.setEditable(false);
        question.setFocusable(false);
        questionPane.setViewportView(question);

        cancel.setText("Close");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        errorContent.setBackground(new java.awt.Color(224, 223, 227));
        errorContent.setEditable(false);
        jScrollPane1.setViewportView(errorContent);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancel)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(image)
                        .addGap(20, 20, 20)
                        .addComponent(questionPane, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(image, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(questionPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // @formatter:on

    private void cancelActionPerformed(java.awt.event.ActionEvent evt)// GEN-FIRST:event_cancelActionPerformed
    {// GEN-HEADEREND:event_cancelActionPerformed
        this.dispose();
    }// GEN-LAST:event_cancelActionPerformed
     // Variables declaration - do not modify//GEN-BEGIN:variables

    private javax.swing.JButton cancel;
    private javax.swing.JTextPane errorContent;
    private javax.swing.JLabel image;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane question;
    private javax.swing.JScrollPane questionPane;
    // End of variables declaration//GEN-END:variables
}
