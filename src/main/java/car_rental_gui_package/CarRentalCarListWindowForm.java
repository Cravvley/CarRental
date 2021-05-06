package car_rental_gui_package;

import car_rental_database_package.CarRepository;
import car_rental_entities_package.Car;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CarRentalCarListWindowForm extends javax.swing.JFrame {

    CarRepository carRepository;
    
    public CarRentalCarListWindowForm() {
        carRepository=new CarRepository();
        
        setSize(400,400);
        setLocation(600,300);
        setVisible(true);
        setResizable(false);
        setTitle("CarRental");
        
        initComponents(); 
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        showCars(true,false);              
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

        addCarBtn = new javax.swing.JButton();
        deleteCarBtn = new javax.swing.JButton();
        brandLabel = new javax.swing.JLabel();
        modelLabel = new javax.swing.JLabel();
        fuelTypeLabel = new javax.swing.JLabel();
        brandField = new javax.swing.JTextField();
        modelField = new javax.swing.JTextField();
        fuelTypeField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        carTable = new javax.swing.JTable();
        yearOfProductionlLabel = new javax.swing.JLabel();
        yearOfProductionField = new javax.swing.JTextField();
        updateCarBtn = new javax.swing.JButton();
        yearOfProductionlLabel1 = new javax.swing.JLabel();
        rentalPricePerDayLabel = new javax.swing.JLabel();
        rentalPricePerDayField = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addCarBtn.setText("Add Car");
        addCarBtn.setPreferredSize(new java.awt.Dimension(80, 25));
        addCarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCarBtnActionPerformed(evt);
            }
        });

        deleteCarBtn.setText("Remove Car");
        deleteCarBtn.setPreferredSize(new java.awt.Dimension(80, 25));
        deleteCarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCarBtnActionPerformed(evt);
            }
        });

        brandLabel.setText("Brand:");

        modelLabel.setText("Model:");

        fuelTypeLabel.setText("Fuel type:");

        brandField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandFieldActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(carTable);

        yearOfProductionlLabel.setText("Year of production:");

        yearOfProductionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearOfProductionFieldActionPerformed(evt);
            }
        });
        yearOfProductionField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                yearOfProductionFieldKeyPressed(evt);
            }
        });

        updateCarBtn.setText("Update Car");
        updateCarBtn.setPreferredSize(new java.awt.Dimension(80, 25));
        updateCarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCarBtnActionPerformed(evt);
            }
        });

        yearOfProductionlLabel1.setText("Year of production:");

        rentalPricePerDayLabel.setText("Rental price per day:");

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(yearOfProductionlLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                    .addComponent(brandLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(modelLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fuelTypeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rentalPricePerDayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(modelField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                    .addComponent(fuelTypeField)
                                    .addComponent(brandField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(yearOfProductionField)
                                    .addComponent(rentalPricePerDayField, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(addCarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 6, Short.MAX_VALUE)
                                .addComponent(updateCarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)
                                .addComponent(deleteCarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
                            .addComponent(jScrollPane1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(yearOfProductionlLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(brandField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(brandLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modelLabel)
                            .addComponent(modelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fuelTypeLabel)
                            .addComponent(fuelTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yearOfProductionlLabel)
                            .addComponent(yearOfProductionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rentalPricePerDayLabel)
                            .addComponent(rentalPricePerDayField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addComponent(addCarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteCarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateCarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(yearOfProductionlLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addCarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCarBtnActionPerformed
        
        String regex = "-?(\\d*\\.)?\\d+([eE][+\\-]?\\d+)?|[nN]a[nN]|[iI]nf(inity)?";
        Pattern pattern = Pattern.compile(regex);

        String brand=brandField.getText();
        String model=modelField.getText();
        String fuelType=fuelTypeField.getText();
        String yearOfProductionString=yearOfProductionField.getText();
        
        Matcher matcher=pattern.matcher(rentalPricePerDayField.getText());
       
        if(brand.isBlank()||model.isBlank()||fuelType.isBlank()||
                yearOfProductionString.isBlank()||!matcher.matches()){   
                 JOptionPane.showMessageDialog(null,"Type correct data");
        }else{
            float rentalPricePerDay=Float.parseFloat(rentalPricePerDayField.getText());
            int yearOfProduction=Integer.parseInt(yearOfProductionField.getText());
            carRepository.addCar(new Car(0,brand,model,fuelType,yearOfProduction
                    ,rentalPricePerDay,false));

            brandField.setText("");
            modelField.setText("");
            fuelTypeField.setText("");
            yearOfProductionField.setText("");
            rentalPricePerDayField.setText("");
            showCars(true,false);
        }
    }//GEN-LAST:event_addCarBtnActionPerformed

    private void deleteCarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCarBtnActionPerformed
 
        int row = carTable.getSelectedRow();
        
        boolean isRent=Boolean.parseBoolean(carTable.getModel()
                .getValueAt(row, 6).toString());
        
        if(isRent){
            JOptionPane.showMessageDialog(null,"The car is rented you cannot delete it");
        }else{
            int value = Integer.parseInt(carTable.getModel().
            getValueAt(row, 0).toString());
            
            carRepository.removeCar(value);
            showCars(true,false);
        }
    }//GEN-LAST:event_deleteCarBtnActionPerformed

    private void brandFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brandFieldActionPerformed

    private void updateCarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCarBtnActionPerformed
        
        int row = carTable.getSelectedRow();
        
        boolean isRent=Boolean.parseBoolean(carTable.getModel()
              .getValueAt(row, 6).toString());
        
        if(isRent){
            JOptionPane.showMessageDialog(null,"The car is rented you cannot modify it");
        }else{
           int id = Integer.parseInt(carTable.getModel().
           getValueAt(row, 0).toString());
           String brand = carTable.getModel().
           getValueAt(row, 1).toString();
           String model = carTable.getModel().
           getValueAt(row, 2).toString();
           String fuelType = carTable.getModel().
           getValueAt(row, 3).toString();
           int yearOfProduction = Integer.parseInt(carTable.getModel().
           getValueAt(row, 4).toString());
           float rentalPricePerDay = Float.parseFloat(carTable.getModel().
           getValueAt(row, 5).toString());
           boolean isRentFromTable=Boolean.parseBoolean(carTable.getModel().
                   getValueAt(row,6).toString());

           carRepository.updateCar(new Car(id,brand,model,fuelType,yearOfProduction
           ,rentalPricePerDay,isRentFromTable));

           showCars(true,false);
        } 
    }//GEN-LAST:event_updateCarBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        CarRentalMainWindowForm mainWindow=new CarRentalMainWindowForm();
        dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void yearOfProductionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearOfProductionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearOfProductionFieldActionPerformed

    private void yearOfProductionFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearOfProductionFieldKeyPressed
            String value = yearOfProductionField.getText();
            int l = value.length();
            if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9' ||
                    evt.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
               yearOfProductionField.setEditable(true);
            } else {
               yearOfProductionField.setEditable(false);
            }       
    }//GEN-LAST:event_yearOfProductionFieldKeyPressed

    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CarRentalCarListWindowForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarRentalCarListWindowForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarRentalCarListWindowForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarRentalCarListWindowForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarRentalCarListWindowForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCarBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField brandField;
    private javax.swing.JLabel brandLabel;
    private javax.swing.JTable carTable;
    private javax.swing.JButton deleteCarBtn;
    private javax.swing.JTextField fuelTypeField;
    private javax.swing.JLabel fuelTypeLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField modelField;
    private javax.swing.JLabel modelLabel;
    private javax.swing.JTextField rentalPricePerDayField;
    private javax.swing.JLabel rentalPricePerDayLabel;
    private javax.swing.JButton updateCarBtn;
    private javax.swing.JTextField yearOfProductionField;
    private javax.swing.JLabel yearOfProductionlLabel;
    private javax.swing.JLabel yearOfProductionlLabel1;
    // End of variables declaration//GEN-END:variables
}
