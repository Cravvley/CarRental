package car_rental_gui_package;

import car_rental_database_package.CarRepository;
import car_rental_database_package.UserRepository;
import javax.swing.table.DefaultTableModel;

public class CarRentalMainWindowForm extends javax.swing.JFrame {

    UserRepository userRepository;
    CarRepository carRepository;
    
    public CarRentalMainWindowForm() {
        
        userRepository=new UserRepository();
        carRepository=new CarRepository();
        
        setVisible(true);
        setSize(500,500);
        setLocation(650,350);
        setResizable(false);
        setTitle("CarRental");
        
        initComponents();    
        
        showUsers(); 
        showCars(true,false);    
        
    }
    
     public void showUsers(){
        var userList=userRepository.selectAll();
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
        var userList=carRepository.selectAll(all,rent);
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
        rentListBtn = new javax.swing.JButton();

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
                false, false, false, true
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
                false, false, false, true, false, true, false
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

        rentListBtn.setText("Car list");
        rentListBtn.setToolTipText("");
        rentListBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentListBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(rentListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(carListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(userListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(carRentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 1582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rentListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(carRentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userListBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userListBtnActionPerformed
       CarRentalUserListWindowForm userListWindow=new CarRentalUserListWindowForm();
    }//GEN-LAST:event_userListBtnActionPerformed

    private void carListBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carListBtnActionPerformed
          CarRentalCarListWindowForm carListWindow=new CarRentalCarListWindowForm();
    }//GEN-LAST:event_carListBtnActionPerformed

    private void carRentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carRentBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carRentBtnActionPerformed

    private void rentListBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentListBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rentListBtnActionPerformed

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton rentListBtn;
    private javax.swing.JButton userListBtn;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
