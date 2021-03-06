package car_rental_gui_package;

import car_rental_database_package.CarRepository;
import car_rental_database_package.RentalItemRepository;
import car_rental_database_package.UserRepository;
import car_rental_entities_package.RentalItem;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import javax.swing.table.DefaultTableModel;

public class CarRentalMainWindowForm extends javax.swing.JFrame {

    RentalItemRepository rentalItemRepository;
    
    public CarRentalMainWindowForm() {

        rentalItemRepository= new RentalItemRepository();
        
        setVisible(true);
        setSize(500,500);
        setLocation(650,350);
        setResizable(false);
        setTitle("CarRental");
        
        initComponents();    
        
        showUsers(); 
        showCars(false,false);        
    }
    
     public void showUsers(){
        var userList=UserRepository.selectAll();
        DefaultTableModel model = (DefaultTableModel)userTable.getModel();
        model.setRowCount(0);
        Object[]row = new Object[4];
        for(int i=0;i<userList.size();++i){
         row[0]=userList.get(i).getId();   
         row[1]=userList.get(i).getFirstName();  
         row[2]=userList.get(i).getLastName();  
         row[3]=userList.get(i).getEmail();  
         model.addRow(row);
        }
    }
    
     public void showCars(boolean all,boolean rent){
        var userList=CarRepository.selectAll(all,rent);
        DefaultTableModel model = (DefaultTableModel)carTable.getModel();
        model.setRowCount(0);
        Object[]row = new Object[7];
        for(int i=0;i<userList.size();++i){
         row[0]=userList.get(i).getId();   
         row[1]=userList.get(i).getBrand();  
         row[2]=userList.get(i).getModel();  
         row[3]=userList.get(i).getFuelType();  
         row[4]=userList.get(i).getYearOfProduction();     
         row[5]=userList.get(i).getRentalPricePerDay();
         row[6]=userList.get(i).getIsRent(); 
         model.addRow(row);
     }
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userListBtn = new javax.swing.JButton();
        carListBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        carTable = new javax.swing.JTable();
        carRentBtn = new javax.swing.JButton();
        daysOfRentLabel = new javax.swing.JLabel();
        daysOfRentField = new javax.swing.JTextField();
        rentListBtn1 = new javax.swing.JButton();

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

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "FirstName", "LastName", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userTable);

        carTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Brand", "Model", "Fuel type", "Year of production", "Rental price per day", "Is rent"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(carTable);

        carRentBtn.setText("Rent car");
        carRentBtn.setToolTipText("");
        carRentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carRentBtnActionPerformed(evt);
            }
        });

        daysOfRentLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        daysOfRentLabel.setText("Days of rent :");

        daysOfRentField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        daysOfRentField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daysOfRentFieldActionPerformed(evt);
            }
        });
        daysOfRentField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                daysOfRentFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                daysOfRentFieldKeyTyped(evt);
            }
        });

        rentListBtn1.setText("Rent list");
        rentListBtn1.setToolTipText("");
        rentListBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentListBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rentListBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(carListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(userListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 967, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(carRentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 1582, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(daysOfRentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(daysOfRentField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rentListBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(daysOfRentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(daysOfRentField, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addComponent(carRentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userListBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userListBtnActionPerformed
       CarRentalUserListWindowForm userListWindow=new CarRentalUserListWindowForm();
       dispose();
    }//GEN-LAST:event_userListBtnActionPerformed

    private void carListBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carListBtnActionPerformed
          CarRentalCarListWindowForm carListWindow=new CarRentalCarListWindowForm();
          dispose();
    }//GEN-LAST:event_carListBtnActionPerformed

    private void carRentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carRentBtnActionPerformed
        int userRow = userTable.getSelectedRow();
        int carRow = carTable.getSelectedRow();
        
        int userIdValue = Integer.parseInt(userTable.getModel().
                getValueAt(userRow, 0).toString());
        int carIdValue = Integer.parseInt(carTable.getModel().
                getValueAt(userRow, 0).toString());
        float pricePerDay = Float.parseFloat(carTable.getModel().
                getValueAt(userRow,5).toString());
        int daysOfRent=Integer.parseInt(daysOfRentField.getText());
      
        var rentalItem=new RentalItem(0,carIdValue,userIdValue,daysOfRent,
                daysOfRent*pricePerDay);  
        rentalItemRepository.addRentalItem(rentalItem);
        
        var carItem=CarRepository.getCar(carIdValue);
        carItem.setIsRent(true);
        CarRepository.updateCar(carItem);
     
        daysOfRentField.setText("");
        showCars(false,false);   
    }//GEN-LAST:event_carRentBtnActionPerformed

    private void rentListBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentListBtn1ActionPerformed
        CarRentalRentalsListWindowForm rentalsListWindow=new CarRentalRentalsListWindowForm();
        dispose();
    }//GEN-LAST:event_rentListBtn1ActionPerformed

    private void daysOfRentFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daysOfRentFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_daysOfRentFieldActionPerformed

    private void daysOfRentFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_daysOfRentFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_daysOfRentFieldKeyTyped

    private void daysOfRentFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_daysOfRentFieldKeyPressed
        String value = daysOfRentField.getText();
            int l = value.length();
            if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9' ||
                    evt.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
               daysOfRentField.setEditable(true);
            } else {
               daysOfRentField.setEditable(false);
            }
    }//GEN-LAST:event_daysOfRentFieldKeyPressed

    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarRentalMainWindowForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton carListBtn;
    private javax.swing.JButton carRentBtn;
    private javax.swing.JTable carTable;
    private javax.swing.JTextField daysOfRentField;
    private javax.swing.JLabel daysOfRentLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton rentListBtn1;
    private javax.swing.JButton userListBtn;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
