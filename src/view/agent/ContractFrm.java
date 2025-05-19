package view.agent;

import dao.RentingDAO;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Car;
import model.Client;
import model.RentalAgent;
import model.RentedCar;
import model.Renting;

public class ContractFrm extends javax.swing.JFrame {

    private Client selectedClient;
    private ArrayList<Car> selectedCars;
    private Date pickupDate; // Using java.util.Date
    private Date returnDate; // Using java.util.Date

    private RentingDAO rentingDAO;

    private RentalAgent loggedInAgent;

    // 2026-02-02 
    public ContractFrm(Client selectedClient, ArrayList<Car> selectedCars, Date pickupDate, Date returnDate, RentalAgent loggedInAgent) {
        this.selectedClient = selectedClient;
        this.selectedCars = selectedCars;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.loggedInAgent = loggedInAgent;
        rentingDAO = new RentingDAO();

        initComponents();

        displayClientInfo();
        displayCarsInfo();
        displayDates();
        
    }

    public ContractFrm() {
        initComponents();

        this.selectedClient = null;
        this.selectedCars = new ArrayList<>();
        this.pickupDate = null;
        this.returnDate = null;
        this.loggedInAgent = null;
        this.loggedInAgent = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClient = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblListCar = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtPromotion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblCarPickUpDate = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblCarReturnDate = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblRentPrice = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblDeposit = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblTotalAmount = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Contract View");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Hợp đồng tạm");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Khách hàng:");

        tblClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "CCCD", "Address ", "PhoneNumber", "Email", "Note"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblClient);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Xe:");

        tblListCar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID ", "Name ", "Type", "Price ", "Car Line ", "Fuel Condition ", "Type Codition", "Interio Codition "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblListCar);

        jLabel4.setText("Khuyến mãi:");

        txtPromotion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPromotionKeyReleased(evt);
            }
        });

        jLabel5.setText("%");

        jLabel6.setText("Ngày nhận xe:");

        lblCarPickUpDate.setText("jLabel7");

        jLabel8.setText("Ngày trả xe:");

        lblCarReturnDate.setText("jLabel9");

        jLabel10.setText("Giá thuê:");

        lblRentPrice.setText("jLabel11");

        jLabel12.setText("Tiền đặt cọc:");

        lblDeposit.setText("jLabel13");

        jLabel14.setText("Tổng tiền:");

        lblTotalAmount.setText("jLabel15");

        btnConfirm.setText("Xác Nhận");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnCancel.setText("Hủy Bỏ");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPromotion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblCarPickUpDate, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblCarReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(74, 74, 74)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblRentPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(76, 76, 76)
                                        .addComponent(btnConfirm)
                                        .addGap(154, 154, 154)
                                        .addComponent(btnCancel))))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(jLabel1)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPromotion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(lblCarPickUpDate)
                    .addComponent(jLabel8)
                    .addComponent(lblCarReturnDate)
                    .addComponent(jLabel10)
                    .addComponent(lblRentPrice))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblDeposit)
                    .addComponent(jLabel14)
                    .addComponent(lblTotalAmount)
                    .addComponent(btnConfirm)
                    .addComponent(btnCancel))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        try {
            // 1. Validate input
            System.out.println(loggedInAgent);
            if (selectedClient == null || selectedCars == null || selectedCars.isEmpty() || pickupDate == null || returnDate == null || loggedInAgent == null) {
                JOptionPane.showMessageDialog(this,
                        "Không thể tạo hợp đồng. Thiếu thông tin cần thiết.",
                        "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 2. Get promotion value
            String promotionText = txtPromotion.getText().trim();
            String promotion = "0"; 
            if (!promotionText.isEmpty()) {
                promotion = promotionText;
            }

            // 3. Calculate total amount and deposit
            double totalRentPrice = 0;
            long diffTime = returnDate.getTime() - pickupDate.getTime();
            int diffDays = (int) (diffTime / (1000 * 60 * 60 * 24)) + 1; 

            // Calculate total rent price
            for (Car car : selectedCars) {
                totalRentPrice += car.getPrice() * diffDays;
            }

            // Apply promotion discount if any
            double promotionValue = 0;
            try {
                promotionValue = Double.parseDouble(promotion);
            } catch (NumberFormatException e) {
                // If promotion is not a valid number, use 0
            }

            // Calculate deposit (30% of total rent)
            float deposit = (float) (totalRentPrice * 0.3);

            // Apply promotion to total amount
            float totalAmount = (float) (totalRentPrice * (1 - promotionValue / 100) + deposit);

            // 4. Create a new Renting object
            Renting renting = new Renting();
            renting.setPromotion(promotion);
            renting.setTotalAmount((float) totalAmount);
            renting.setDeposit(deposit);
            renting.setClientID(selectedClient.getId());
            renting.setRentalAgentID(loggedInAgent.getId() + 1);

            // 5. Create RentedCar objects for each selected car
            ArrayList<RentedCar> rentedCars = new ArrayList<>();
            for (Car car : selectedCars) {
                RentedCar rentedCar = new RentedCar();

                // Convert java.util.Date to java.sql.Date for database compatibility
                java.sql.Date sqlPickupDate = new java.sql.Date(pickupDate.getTime());
                java.sql.Date sqlReturnDate = new java.sql.Date(returnDate.getTime());

                rentedCar.setCarPickupDate(sqlPickupDate);
                rentedCar.setCarReturnDate(sqlReturnDate);
                rentedCar.setCarID(car.getId());

                // Calculate amount for this specific car
                float carAmount = (float) (car.getPrice() * diffDays);
                rentedCar.setAmount(carAmount);

                rentedCars.add(rentedCar);
            }

            // 6. Set rentedCars to the renting object
            renting.setRentedCars(rentedCars);

            // 7. Save to database using RentingDAO
            boolean success = rentingDAO.addRenting(renting);

            // 8. Handle result
            if (success) {
                JOptionPane.showMessageDialog(this,
                        "Hợp đồng đã được tạo thành công!",
                        "Thành công", JOptionPane.INFORMATION_MESSAGE);
                this.dispose(); // Close the form after successful save
            } else {
                JOptionPane.showMessageDialog(this,
                        "Không thể tạo hợp đồng. Có thể xe đã được thuê trong khoảng thời gian này.",
                        "Lỗi", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this,
                    "Đã xảy ra lỗi khi tạo hợp đồng: " + e.getMessage(),
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        new ViewRentalAgnetFrm(loggedInAgent).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtPromotionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPromotionKeyReleased
        calculateAndDisplayRentPrice();
    }//GEN-LAST:event_txtPromotionKeyReleased

    // Phương thức hiển thị thông tin khách hàng
    private void displayClientInfo() {
        if (selectedClient != null) {
            DefaultTableModel model = (DefaultTableModel) tblClient.getModel();
            // Xóa tất cả các hàng hiện có
            model.setRowCount(0);

            Object[] row = {
                selectedClient.getId(),
                selectedClient.getName(),
                selectedClient.getCccd(),
                selectedClient.getAddress(),
                selectedClient.getPhoneNumber(),
                selectedClient.getEmail(),
                selectedClient.getNote()
            };
            model.addRow(row);
        }
    }

    // Phương thức hiển thị thông tin các xe được chọn
    private void displayCarsInfo() {
        if (selectedCars != null && !selectedCars.isEmpty()) {
            displayCarList(selectedCars);

            // Tính và hiển thị giá thuê
            calculateAndDisplayRentPrice();
        }
    }

    // Phương thức hiển thị danh sách xe
    private void displayCarList(ArrayList<Car> cars) {
        String[] columnNames = {"ID", "Name", "Type", "Price", "Car Line", "Fuel Condition", "Type Condition", "Interior Condition", "Damages"};
        String[][] data = new String[cars.size()][columnNames.length];

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            data[i][0] = String.valueOf(car.getId());
            data[i][1] = car.getName();
            data[i][2] = car.getType();
            data[i][3] = String.valueOf(car.getPrice());
            data[i][4] = car.getCarLine();
            data[i][5] = car.getFuelCondition();
            data[i][6] = car.getTypeCondition();
            data[i][7] = car.getInteriorCondition();
            data[i][8] = car.getDamages();
        }

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Set the model to the table
        tblListCar.setModel(tableModel);
    }

    // Hiển thị thông tin ngày nhận và trả xe
    private void displayDates() {
        if (pickupDate != null) {
            // Định dạng ngày thành chuỗi dễ đọc
            java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
            lblCarPickUpDate.setText(dateFormat.format(pickupDate));
        } else {
            lblCarPickUpDate.setText("");
        }

        if (returnDate != null) {
            java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
            lblCarReturnDate.setText(dateFormat.format(returnDate));
        } else {
            lblCarReturnDate.setText("");
        }
    }

    // Tính và hiển thị giá thuê, tiền đặt cọc và tổng tiền
    private void calculateAndDisplayRentPrice() {
        if (selectedCars != null && !selectedCars.isEmpty() && pickupDate != null && returnDate != null) {
            // Tính số ngày thuê
            long diffTime = returnDate.getTime() - pickupDate.getTime();
            int diffDays = (int) (diffTime / (1000 * 60 * 60 * 24)) + 1; // +1 để tính cả ngày đầu và cuối

            // Tính tổng giá thuê
            double totalRentPrice = 0;
            for (Car car : selectedCars) {
                totalRentPrice += car.getPrice() * diffDays;
            }

            // Lấy giá trị khuyến mãi (nếu có)
            double promotion = 0;
            try {
                String promoText = txtPromotion.getText().trim();
                if (!promoText.isEmpty()) {
                    promotion = Double.parseDouble(promoText);
                }
            } catch (NumberFormatException e) {

            }

            // Tính tiền đặt cọc (ví dụ: 30% tổng tiền)
            float deposit = (float) (totalRentPrice * 0.3);

            // Áp dụng khuyến mãi
            float discountedPrice = (float) (totalRentPrice * (1 - promotion / 100) + deposit);

            // Hiển thị thông tin
            lblRentPrice.setText(String.format("%.2f", totalRentPrice) + "Đ");
            lblDeposit.setText(String.format("%.2f", deposit) + "Đ");
            lblTotalAmount.setText(String.format("%.2f", discountedPrice) + "Đ");
        }
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContractFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            new ContractFrm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel lblCarPickUpDate;
    private javax.swing.JLabel lblCarReturnDate;
    private javax.swing.JLabel lblDeposit;
    private javax.swing.JLabel lblRentPrice;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JTable tblClient;
    private javax.swing.JTable tblListCar;
    private javax.swing.JTextField txtPromotion;
    // End of variables declaration//GEN-END:variables
}
