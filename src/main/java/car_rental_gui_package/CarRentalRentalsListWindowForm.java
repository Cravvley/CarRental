package car_rental_gui_package;

import car_rental_database_package.CarRepository;
import car_rental_database_package.RentalItemRepository;
import car_rental_database_package.UserRepository;
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
        carTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        carTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Car id", "User id", "Days of rent", "Price", "Date of loan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(carTable);
        if (carTable.getColumnModel().getColumnCount() > 0) {
            carTable.getColumnModel().getColumn(5).setResizable(false);
            carTable.getColumnModel().getColumn(5).setHeaderValue("Date of loan");
        }

        jButton2.setText("jButton2");

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        CarRentalMainWindowForm mainWindow=new CarRentalMainWindowForm();
        dispose();
    }//GEN-LAST:event_backBtnActionPerformed


    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarRentalRentalsListWindowForm().setVisible(true);
            }
        });
    }

    public void showRentals (){
        var rentalList=rentalItemRepository.selectAll();
        DefaultTableModel model = (DefaultTableModel)carTable.getModel();
        model.setRowCount(0);
        Object[]row = new Object[6];
        for(int i=0;i<rentalList.size();++i){
         row[0]=rentalList.get(i).getId();   
         row[1]=rentalList.get(i).getCarId();  
         row[2]=rentalList.get(i).getUserId();  
         row[3]=rentalList.get(i).getDaysOfRent();  
         row[4]=rentalList.get(i).getPrice();
         row[5]=rentalList.get(i).getDateOfLoan();   
         model.addRow(row);
     }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTable carTable;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
