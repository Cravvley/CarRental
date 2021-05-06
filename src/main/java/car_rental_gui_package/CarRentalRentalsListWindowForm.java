package car_rental_gui_package;

import car_rental_database_package.CarRepository;
import car_rental_database_package.RentalItemRepository;
import car_rental_database_package.UserRepository;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CarRentalRentalsListWindowForm extends javax.swing.JFrame {

    
    UserRepository userRepository;
    CarRepository carRepository;
    RentalItemRepository rentalItemRepository;
    
    public CarRentalRentalsListWindowForm() { 
        userRepository=new UserRepository();
        carRepository=new CarRepository();
        rentalItemRepository= new RentalItemRepository();
        
        setSize(400,400);
        setLocation(600,300);
        setVisible(true);
        setResizable(false);
        setTitle("CarRental");
        
        initComponents(); 
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        showRentals();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        rentalItemsTable = new javax.swing.JTable();
        deleteRentalBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        carTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rentalItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Car id", "User id", "Days of rent", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rentalItemsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rentalItemsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(rentalItemsTable);

        deleteRentalBtn.setText("Delete rental");
        deleteRentalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRentalBtnActionPerformed(evt);
            }
        });

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
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
        jScrollPane2.setViewportView(userTable);

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
        jScrollPane3.setViewportView(carTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(deleteRentalBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(deleteRentalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        CarRentalMainWindowForm mainWindow=new CarRentalMainWindowForm();
        dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void rentalItemsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rentalItemsTableMouseClicked
        int selectRow = rentalItemsTable.getSelectedRow();
       
        int carIdValue = Integer.parseInt(rentalItemsTable.getModel().
                getValueAt(selectRow, 1).toString());
        int userIdValue = Integer.parseInt(rentalItemsTable.getModel().
                getValueAt(selectRow, 2).toString());
   
      showSelectRentalCarAndUser(userIdValue,carIdValue);
    }//GEN-LAST:event_rentalItemsTableMouseClicked

    private void deleteRentalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRentalBtnActionPerformed
        int selectRow = rentalItemsTable.getSelectedRow();
        
        int rentalItemId=Integer.parseInt(rentalItemsTable.getModel().
                getValueAt(selectRow, 0).toString());
        int carIdValue = Integer.parseInt(rentalItemsTable.getModel().
                getValueAt(selectRow, 1).toString());
        
        var carItem=carRepository.getCar(carIdValue);
        carItem.setIsRent(false);
        carRepository.updateCar(carItem);
        
        rentalItemRepository.removeRentalItem(rentalItemId);
        
        DefaultTableModel carTableModel = (DefaultTableModel)carTable.getModel();
        carTableModel.setRowCount(0);
        
        DefaultTableModel userTableModel = (DefaultTableModel)userTable.getModel();
        userTableModel.setRowCount(0);
        
        showRentals();
    }//GEN-LAST:event_deleteRentalBtnActionPerformed


    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarRentalRentalsListWindowForm().setVisible(true);
            }
        });
    }

    public void showRentals (){
        var rentalList=rentalItemRepository.selectAll();
        DefaultTableModel model = (DefaultTableModel)rentalItemsTable.getModel();
        model.setRowCount(0);
        Object[]row = new Object[5];
        for(int i=0;i<rentalList.size();++i){
         row[0]=rentalList.get(i).getId();   
         row[1]=rentalList.get(i).getCarId();  
         row[2]=rentalList.get(i).getUserId();  
         row[3]=rentalList.get(i).getDaysOfRent();  
         row[4]=rentalList.get(i).getPrice();
         model.addRow(row);
     }
    }
    
    public void showSelectRentalCarAndUser(int userIdValue,int carIdValue){
        var userItem=userRepository.getUser(userIdValue);
        var carItem=carRepository.getCar(carIdValue);
        
        
        DefaultTableModel userTableModel = (DefaultTableModel)userTable.getModel();
        userTableModel.setRowCount(0);
        Object[]userTableRow = new Object[4];
        userTableRow[0]=userItem.getId();   
        userTableRow[1]=userItem.getFirstName();  
        userTableRow[2]=userItem.getLastName();  
        userTableRow[3]=userItem.getEmail();  
        userTableModel.addRow(userTableRow);
        
        DefaultTableModel carTableModel = (DefaultTableModel)carTable.getModel();
        carTableModel.setRowCount(0);
        Object[]carTableRow = new Object[7];
        carTableRow[0]=carItem.getId();   
        carTableRow[1]=carItem.getBrand();  
        carTableRow[2]=carItem.getModel();  
        carTableRow[3]=carItem.getFuelType();  
        carTableRow[4]=carItem.getYearOfProduction();     
        carTableRow[5]=carItem.getRentalPricePerDay();
        carTableRow[6]=carItem.getIsRent(); 
        carTableModel.addRow(carTableRow);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTable carTable;
    private javax.swing.JButton deleteRentalBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable rentalItemsTable;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
