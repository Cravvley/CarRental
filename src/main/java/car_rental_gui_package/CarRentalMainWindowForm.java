package car_rental_gui_package;

public class CarRentalMainWindowForm extends javax.swing.JFrame {

    public CarRentalMainWindowForm() {
        
        setVisible(true);
        setSize(500,500);
        setLocation(650,350);
        setResizable(false);
        setTitle("CarRental");
        
        initComponents();    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userListBtn = new javax.swing.JButton();
        carListBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userListBtn.setText("User list");
        userListBtn.setToolTipText("");
        userListBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userListBtnActionPerformed(evt);
            }
        });

        carListBtn.setText("Car list");
        carListBtn.setToolTipText("");
        carListBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carListBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(587, Short.MAX_VALUE)
                .addComponent(carListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(userListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userListBtn)
                    .addComponent(carListBtn))
                .addContainerGap(670, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userListBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userListBtnActionPerformed
       CarRentalUserListWindowForm userListWindow=new CarRentalUserListWindowForm();
    }//GEN-LAST:event_userListBtnActionPerformed

    private void carListBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carListBtnActionPerformed
          CarRentalCarListWindowForm carListWindow=new CarRentalCarListWindowForm();
    }//GEN-LAST:event_carListBtnActionPerformed

    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarRentalMainWindowForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton carListBtn;
    private javax.swing.JButton userListBtn;
    // End of variables declaration//GEN-END:variables
}
