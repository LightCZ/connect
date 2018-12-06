/*
 * Copyright (c) Mirth Corporation. All rights reserved.
 * 
 * http://www.mirthcorp.com
 * 
 * The software in this package is published under the terms of the MPL license a copy of which has
 * been included with this distribution in the LICENSE.txt file.
 */

package com.mirth.connect.client.ui;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.mirth.connect.client.core.ClientException;

public class GlobalScriptsPanel extends javax.swing.JPanel {

    Frame parent;

    /**
     * Creates new form GlobalScriptsPanel
     */
    public GlobalScriptsPanel() {
        parent = PlatformUI.MIRTH_FRAME;
        initComponents();
    }

    public void edit() {
        try {
            scriptPanel.setScripts(parent.mirthClient.getGlobalScripts());
        } catch (ClientException e) {
            parent.alertThrowable(this, e);
        }
    }

    public void validateCurrentScript() {
        scriptPanel.validateCurrentScript();
    }

    public String validateAllScripts() {
        String errors = "";

        Iterator<Entry<String, String>> it = scriptPanel.getScripts().entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, String> entry = it.next();
            String key = entry.getKey();
            String value = entry.getValue();

            String validationMessage = scriptPanel.validateScript(value);
            if (validationMessage != null) {
                errors += "Error in global script \"" + key + "\":\n" + validationMessage + "\n\n";
            }
        }

        if (errors.equals("")) {
            errors = null;
        }

        return errors;
    }

    public void importAllScripts(Map<String, String> scripts) {
        scriptPanel.setScripts(scripts);
        parent.setSaveEnabled(true);
    }

    public Map<String, String> exportAllScripts() {
        return scriptPanel.getScripts();
    }

    public void save() {
        try {
            parent.mirthClient.setGlobalScripts(scriptPanel.getScripts());
        } catch (ClientException e) {
            parent.alertThrowable(this, e);
        }
    }

    // @formatter:off
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scriptPanel = new ScriptPanel(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scriptPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scriptPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // @formatter:on

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mirth.connect.client.ui.ScriptPanel scriptPanel;
    // End of variables declaration//GEN-END:variables
}
