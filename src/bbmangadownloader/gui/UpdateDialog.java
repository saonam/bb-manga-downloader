/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbmangadownloader.gui;

import bbmangadownloader.UpdateService;
import bbmangadownloader.UpdateService.Version;
import bbmangadownloader.manager.ConfigManager;
import bbmangadownloader.ult.GUIUtilities;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Bach
 */
public class UpdateDialog extends javax.swing.JDialog {

    private Version version;
    private boolean isUpdateOnStartUp = true;

    /**
     * Creates new form UpdateDialog
     *
     * @param parent
     * @param modal
     */
    public UpdateDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("Update");
        initComponents();
        isUpdateOnStartUp = ConfigManager.getCurrentInstance().isCheckUpdateOnStartUp();
        cbxUpdate.setSelected(isUpdateOnStartUp);
        lblCurrentVersion.setText("<html>Current version: <b>"
                + bbmangadownloader.BBMangaDownloader.getCurrentVersion()
                + "</b></html>");
        doUpdate();
    }

    private void doUpdate() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                btnCheck.setEnabled(false);
                lblStatus.setText("Checking...");
                try {
                    version = UpdateService.getNewestVersion();
                    if (version.isNewestVersion()) {
                        lblStatus.setText(
                                "<html>" + bbmangadownloader.BBMangaDownloader.APPLICATION_NAME
                                + " is <b>up-to-date</b></html>");
                    } else {
                        lblStatus.setText(
                                "<html>" + bbmangadownloader.BBMangaDownloader.APPLICATION_NAME
                                + " is <b>out-of-date</b></html>");
                    }
                    btnUpdate.setEnabled(!version.isNewestVersion());
                } catch (Exception ex) {
                    Logger.getLogger(UpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
                    lblStatus.setText("Error while getting newest version!");
                }
                btnCheck.setEnabled(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        lblCurrentVersion = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnCheck = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        lblIcon = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cbxUpdate = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                onWindowsClosing(evt);
            }
        });

        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus.setText("Status");

        lblCurrentVersion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCurrentVersion.setText("Current Version:");

        btnCheck.setText("Re-check");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });
        jPanel1.add(btnCheck);

        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblCurrentVersion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCurrentVersion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bbmangadownloader/resources/icon/icon-128.png"))); // NOI18N

        cbxUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbxUpdate.setText("Check for update on start-up");
        cbxUpdate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxUpdateItemStateChanged(evt);
            }
        });
        cbxUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxUpdateActionPerformed(evt);
            }
        });
        jPanel4.add(cbxUpdate);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcon)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        GUIUtilities.openLink(version.getUpdateUrl());
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        doUpdate();
    }//GEN-LAST:event_btnCheckActionPerformed

    private void cbxUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxUpdateActionPerformed
        setUpdateOnStartUp();
    }//GEN-LAST:event_cbxUpdateActionPerformed

    private void cbxUpdateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxUpdateItemStateChanged
        setUpdateOnStartUp();
    }//GEN-LAST:event_cbxUpdateItemStateChanged

    private void onWindowsClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_onWindowsClosing
        try {
            ConfigManager.getCurrentInstance().save();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_onWindowsClosing
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox cbxUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblCurrentVersion;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration//GEN-END:variables

    private void setUpdateOnStartUp() {
        if (cbxUpdate.isSelected() != isUpdateOnStartUp) {
            isUpdateOnStartUp = cbxUpdate.isSelected();
            ConfigManager.getCurrentInstance().setCheckUpdateOnStartUp(isUpdateOnStartUp);
        }
    }
}
