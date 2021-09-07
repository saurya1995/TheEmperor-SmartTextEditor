package theemperor;
public class Special extends javax.swing.JFrame {

    javax.swing.JTextArea textArea;
    public Special() {
        initComponents();
    }
     
   
    public Special(javax.swing.JTextArea textArea){
    setLocation(350, 350);
    setTitle("Special Character");
    initComponents();
    this.textArea=textArea;   
    setDefaultCloseOperation(Special.DISPOSE_ON_CLOSE);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tF = new javax.swing.JTextField();
        set = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        gamma = new javax.swing.JButton();
        pie = new javax.swing.JButton();
        copy = new javax.swing.JButton();
        omega = new javax.swing.JButton();
        alpha = new javax.swing.JButton();
        rho = new javax.swing.JButton();
        yen = new javax.swing.JButton();
        micro = new javax.swing.JButton();
        lambda = new javax.swing.JButton();
        eta = new javax.swing.JButton();
        beta = new javax.swing.JButton();
        delta = new javax.swing.JButton();
        Male = new javax.swing.JButton();
        female = new javax.swing.JButton();
        infinity = new javax.swing.JButton();
        root = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Symbol");

        set.setText("SET");
        set.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setActionPerformed(evt);
            }
        });

        gamma.setText("Gamma");
        gamma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gammaActionPerformed(evt);
            }
        });

        pie.setText("Pie");
        pie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pieActionPerformed(evt);
            }
        });

        copy.setText("Copyright");
        copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyActionPerformed(evt);
            }
        });

        omega.setText("Omega");
        omega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                omegaActionPerformed(evt);
            }
        });

        alpha.setText("Alpha");
        alpha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alphaActionPerformed(evt);
            }
        });

        rho.setText("Rho");
        rho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rhoActionPerformed(evt);
            }
        });

        yen.setText("Yen");
        yen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yenActionPerformed(evt);
            }
        });

        micro.setText("Micro");
        micro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                microActionPerformed(evt);
            }
        });

        lambda.setText("Lamda");
        lambda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lambdaActionPerformed(evt);
            }
        });

        eta.setText("Eta");
        eta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etaActionPerformed(evt);
            }
        });

        beta.setText("  Beta ");
        beta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                betaActionPerformed(evt);
            }
        });

        delta.setText("Delta");
        delta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deltaActionPerformed(evt);
            }
        });

        Male.setText("Male");
        Male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaleActionPerformed(evt);
            }
        });

        female.setText("Female");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });

        infinity.setText("Infinity");
        infinity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infinityActionPerformed(evt);
            }
        });

        root.setText("Sq Root");
        root.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rootActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lambda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(copy, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(Male, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alpha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(female, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(rho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(beta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(gamma, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eta, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(yen, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(micro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(omega, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(infinity, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(root, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))
                .addGap(71, 71, 71))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lambda)
                    .addComponent(delta)
                    .addComponent(eta)
                    .addComponent(omega))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alpha)
                    .addComponent(beta)
                    .addComponent(gamma)
                    .addComponent(pie))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(copy)
                    .addComponent(rho)
                    .addComponent(yen)
                    .addComponent(micro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Male)
                    .addComponent(female)
                    .addComponent(infinity)
                    .addComponent(root))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(tF, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(set, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(set)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rhoActionPerformed
        // TODO add your handling code here:
        tF.setText("\u03C1");
    }//GEN-LAST:event_rhoActionPerformed

    private void lambdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lambdaActionPerformed
        // TODO add your handling code here:
        tF.setText("\u03BB");
    }//GEN-LAST:event_lambdaActionPerformed

    private void deltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deltaActionPerformed
        // TODO add your handling code here:
        tF.setText("\u03B4");
    }//GEN-LAST:event_deltaActionPerformed

    private void etaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etaActionPerformed
        // TODO add your handling code here:
        tF.setText("\u03B7");
    }//GEN-LAST:event_etaActionPerformed

    private void setActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setActionPerformed
        // TODO add your handling code here:
        String a=tF.getText();
        textArea.append(a);
        this.dispose();
    }//GEN-LAST:event_setActionPerformed

    private void omegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_omegaActionPerformed
        // TODO add your handling code here:
        tF.setText("\u2126");
    }//GEN-LAST:event_omegaActionPerformed

    private void alphaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alphaActionPerformed
        // TODO add your handling code here:
        tF.setText("\u03B1");
    }//GEN-LAST:event_alphaActionPerformed

    private void betaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betaActionPerformed
        // TODO add your handling code here:
        tF.setText("\u03B2");
    }//GEN-LAST:event_betaActionPerformed

    private void gammaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gammaActionPerformed
        // TODO add your handling code here:
        tF.setText("\u03B3");
    }//GEN-LAST:event_gammaActionPerformed

    private void pieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pieActionPerformed
        // TODO add your handling code here:
        tF.setText("\u03A0");
    }//GEN-LAST:event_pieActionPerformed

    private void copyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyActionPerformed
        // TODO add your handling code here:
        tF.setText("\u00A9");
    }//GEN-LAST:event_copyActionPerformed

    private void microActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_microActionPerformed
        // TODO add your handling code here:
        tF.setText("\u00B5");
    }//GEN-LAST:event_microActionPerformed

    private void yenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yenActionPerformed
        // TODO add your handling code here:
        tF.setText("\u03A5");
    }//GEN-LAST:event_yenActionPerformed

    private void MaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleActionPerformed
        // TODO add your handling code here:
        tF.setText("\u2642");
    }//GEN-LAST:event_MaleActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        // TODO add your handling code here:
        tF.setText("\u2640");
    }//GEN-LAST:event_femaleActionPerformed

    private void infinityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infinityActionPerformed
        // TODO add your handling code here:
        tF.setText("\u221E");
    }//GEN-LAST:event_infinityActionPerformed

    private void rootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rootActionPerformed
        // TODO add your handling code here:
        tF.setText("\u221A");
    }//GEN-LAST:event_rootActionPerformed

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
            java.util.logging.Logger.getLogger(Special.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Special.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Special.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Special.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              Special frame =  new Special();
              frame.setVisible(true);
                frame.setDefaultCloseOperation(Special.EXIT_ON_CLOSE);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Male;
    private javax.swing.JButton alpha;
    private javax.swing.JButton beta;
    private javax.swing.JButton copy;
    private javax.swing.JButton delta;
    private javax.swing.JButton eta;
    private javax.swing.JButton female;
    private javax.swing.JButton gamma;
    private javax.swing.JButton infinity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lambda;
    private javax.swing.JButton micro;
    private javax.swing.JButton omega;
    private javax.swing.JButton pie;
    private javax.swing.JButton rho;
    private javax.swing.JButton root;
    private javax.swing.JButton set;
    private javax.swing.JTextField tF;
    private javax.swing.JButton yen;
    // End of variables declaration//GEN-END:variables
}
