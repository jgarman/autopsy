/*
 * Autopsy Forensic Browser
 *
 * Copyright 2011 - 2013 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.hashdatabase;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import org.sleuthkit.autopsy.coreutils.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.sleuthkit.autopsy.hashdatabase.HashDb.KnownFilesType;
import org.sleuthkit.datamodel.TskCoreException;
import org.apache.commons.io.FilenameUtils;

/**
 * Instances of this class allow a user to select a hash database for import.
 */
final class HashDbImportDatabaseDialog extends javax.swing.JDialog {
    private JFileChooser fileChooser = new JFileChooser();
    private HashDb selectedHashDb;

    HashDbImportDatabaseDialog() {
        super(new javax.swing.JFrame(), "Import Hash Database", true);
        setResizable(false);
        initComponents();
        customizeComponents();
    }
    
    void customizeComponents() {
        fileChooser.setDragEnabled(false);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        String[] EXTENSION = new String[] { "txt", "kdb", "idx", "hash", "Hash", "hsh"};
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Hash Database File", EXTENSION);
        fileChooser.setFileFilter(filter);
        fileChooser.setMultiSelectionEnabled(false);
    }
    
    HashDb doDialog() {
        selectedHashDb =  null;
        
        // Center and display the dialog.
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenDimension.width - getSize().width) / 2, (screenDimension.height - getSize().height) / 2);
        this.setVisible(true);
        
        return selectedHashDb;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        databasePathTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        nsrlRadioButton = new javax.swing.JRadioButton();
        knownBadRadioButton = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        databaseNameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        useForIngestCheckbox = new javax.swing.JCheckBox();
        sendInboxMessagesCheckbox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        org.openide.awt.Mnemonics.setLocalizedText(okButton, org.openide.util.NbBundle.getMessage(HashDbImportDatabaseDialog.class, "HashDbImportDatabaseDialog.okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cancelButton, org.openide.util.NbBundle.getMessage(HashDbImportDatabaseDialog.class, "HashDbImportDatabaseDialog.cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        databasePathTextField.setText(org.openide.util.NbBundle.getMessage(HashDbImportDatabaseDialog.class, "HashDbImportDatabaseDialog.databasePathTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(browseButton, org.openide.util.NbBundle.getMessage(HashDbImportDatabaseDialog.class, "HashDbImportDatabaseDialog.browseButton.text")); // NOI18N
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(nsrlRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(nsrlRadioButton, org.openide.util.NbBundle.getMessage(HashDbImportDatabaseDialog.class, "HashDbImportDatabaseDialog.nsrlRadioButton.text")); // NOI18N
        nsrlRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nsrlRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(knownBadRadioButton);
        knownBadRadioButton.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(knownBadRadioButton, org.openide.util.NbBundle.getMessage(HashDbImportDatabaseDialog.class, "HashDbImportDatabaseDialog.knownBadRadioButton.text")); // NOI18N
        knownBadRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knownBadRadioButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(HashDbImportDatabaseDialog.class, "HashDbImportDatabaseDialog.jLabel1.text")); // NOI18N

        databaseNameTextField.setText(org.openide.util.NbBundle.getMessage(HashDbImportDatabaseDialog.class, "HashDbImportDatabaseDialog.databaseNameTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(HashDbImportDatabaseDialog.class, "HashDbImportDatabaseDialog.jLabel2.text")); // NOI18N

        useForIngestCheckbox.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(useForIngestCheckbox, org.openide.util.NbBundle.getMessage(HashDbImportDatabaseDialog.class, "HashDbImportDatabaseDialog.useForIngestCheckbox.text")); // NOI18N
        useForIngestCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useForIngestCheckboxActionPerformed(evt);
            }
        });

        sendInboxMessagesCheckbox.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(sendInboxMessagesCheckbox, org.openide.util.NbBundle.getMessage(HashDbImportDatabaseDialog.class, "HashDbImportDatabaseDialog.sendInboxMessagesCheckbox.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(okButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(databasePathTextField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(browseButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(databaseNameTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(knownBadRadioButton)
                            .addComponent(nsrlRadioButton))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(useForIngestCheckbox)
                            .addComponent(sendInboxMessagesCheckbox))
                        .addGap(0, 135, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(databasePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(databaseNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nsrlRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(knownBadRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(useForIngestCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendInboxMessagesCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File databaseFile = fileChooser.getSelectedFile();
            try {
                databasePathTextField.setText(databaseFile.getCanonicalPath());
                databaseNameTextField.setText(FilenameUtils.removeExtension(databaseFile.getName()));
            } 
            catch (IOException ex) {
                Logger.getLogger(HashDbImportDatabaseDialog.class.getName()).log(Level.SEVERE, "Failed to get path of selected database", ex);
            } 
        }
    }//GEN-LAST:event_browseButtonActionPerformed

    private void nsrlRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nsrlRadioButtonActionPerformed
        sendInboxMessagesCheckbox.setSelected(false);
        sendInboxMessagesCheckbox.setEnabled(false);
    }//GEN-LAST:event_nsrlRadioButtonActionPerformed

    private void knownBadRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knownBadRadioButtonActionPerformed
        sendInboxMessagesCheckbox.setSelected(true);
        sendInboxMessagesCheckbox.setEnabled(true);
    }//GEN-LAST:event_knownBadRadioButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        if(databasePathTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Database path cannot be empty.");
            return;
        }
        
        if(databaseNameTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Database display name cannot be empty.");
            return;
        }
        
        File file = new File(databasePathTextField.getText());
        if (!file.exists()) {
            JOptionPane.showMessageDialog(this, "Selected database does not exist.");
            return;
        }
                
        String filePath;
        try {
            filePath = file.getCanonicalPath();
        } 
        catch (IOException ex) {
            Logger.getLogger(HashDbImportDatabaseDialog.class.getName()).log(Level.SEVERE, "Failed to get path of selected database", ex);
            JOptionPane.showMessageDialog(this, "Failed to get path of selected database.");
            return;
        }
        
        KnownFilesType type;
        if (nsrlRadioButton.isSelected()) {
            type = KnownFilesType.NSRL;
        } 
        else {
            type = KnownFilesType.KNOWN_BAD;
        }
        
        try {
            selectedHashDb = HashDb.openHashDatabase(databaseNameTextField.getText(), filePath, useForIngestCheckbox.isSelected(), sendInboxMessagesCheckbox.isSelected(), type);
            
            
//            if (!selectedHashDb.hasTextLookupIndexOnly())
            
        } 
        catch (TskCoreException ex) {
            Logger.getLogger(HashDbImportDatabaseDialog.class.getName()).log(Level.WARNING, "Failed to open hash database at " + filePath, ex);
            JOptionPane.showMessageDialog(this, "Failed to import selected database.\nPlease verify that the selected file is a hash database.");
            return;
        }        
        
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void useForIngestCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useForIngestCheckboxActionPerformed
    }//GEN-LAST:event_useForIngestCheckboxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField databaseNameTextField;
    private javax.swing.JTextField databasePathTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton knownBadRadioButton;
    private javax.swing.JRadioButton nsrlRadioButton;
    private javax.swing.JButton okButton;
    private javax.swing.JCheckBox sendInboxMessagesCheckbox;
    private javax.swing.JCheckBox useForIngestCheckbox;
    // End of variables declaration//GEN-END:variables
}