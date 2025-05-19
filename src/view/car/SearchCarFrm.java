package view.car;

import dao.CarDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Car;
import model.Client;
import model.RentalAgent;
import view.agent.ContractFrm;

public class SearchCarFrm extends javax.swing.JFrame {

    private CarDAO carDAO;

    private ArrayList<Car> listCar;

    private Client selectedClient; 

    private ArrayList<Car> selectedCars;
    
    private RentalAgent loggedInAgent;

    public SearchCarFrm() {
        initComponents();
        carDAO = new CarDAO();
        listCar = new ArrayList<>();
        selectedCars = new ArrayList<>();
        displayCarList(listCar);
        this.selectedClient = null;
        this.loggedInAgent = null;
    }

    public SearchCarFrm(Client selectedClient, RentalAgent loggedInAgent) {
        this.selectedClient = selectedClient;
        this.loggedInAgent = loggedInAgent;
        
        initComponents();

        carDAO = new CarDAO();

        listCar = new ArrayList<>();

        selectedCars = new ArrayList<>();

        displayCarList(listCar);

        if (this.selectedClient != null) {
            System.out.println("SearchCarFrm opened for Client: " + this.selectedClient.getName());
            // You could set a label text here, e.g.:
            lblClientInfo.setText("Khách hàng: " + this.selectedClient.getName());
        } else {
            System.out.println("SearchCarFrm opened without a selected client.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTypeCar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCarPickUpDate = new javax.swing.JTextField();
        txtCarReturnDate = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        bthSearchCarPartner = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListCar = new javax.swing.JTable();
        btnNext = new javax.swing.JButton();
        lblClientInfo = new javax.swing.JLabel();

        jLabel4.setText("Dòng xe:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Search Car ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Tìm Kiếm Xe trống");

        jLabel2.setText("Ngày nhận xe:");

        jLabel3.setText("Ngày trả xe:");

        btnSearch.setText("Search Car");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        bthSearchCarPartner.setText("Search Car Partner");
        bthSearchCarPartner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthSearchCarPartnerActionPerformed(evt);
            }
        });

        tblListCar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên", "Kiểu xe", "Giá Thuê ", "Đã chọn "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblListCar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListCarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListCar);

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        lblClientInfo.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCarPickUpDate, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCarReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(lblClientInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(bthSearchCarPartner)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNext)
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblClientInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtCarPickUpDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCarReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bthSearchCarPartner)
                    .addComponent(btnNext))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void displayCarList(ArrayList<Car> cars) {
        
        String[] columnNames = {"ID", "Tên", "Kiểu xe", "Giá Thuê", "Dòng xe", "Đã chọn"}; 

        String[][] data = new String[cars.size()][columnNames.length];

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            data[i][0] = String.valueOf(car.getId());
            data[i][1] = car.getName();
            data[i][2] = car.getType();
            data[i][3] = String.valueOf(car.getPrice());
            data[i][4] = car.getCarLine();
            
            // Kiểm tra xem xe có trong danh sách đã chọn không
            boolean isSelected = false;
            for (Car selectedCar : selectedCars) {
                if (selectedCar.getId() == car.getId()) {
                    isSelected = true;
                    break;
                }
            }
            data[i][5] = isSelected ? "☑" : "☐";
        }

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblListCar.setModel(tableModel);
    }

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String pickupDateStr = txtCarPickUpDate.getText().trim();
        String returnDateStr = txtCarReturnDate.getText().trim();
        String carType = txtTypeCar.getText().trim(); 

        if (pickupDateStr.isEmpty() || returnDateStr.isEmpty() || pickupDateStr.equals("yyyy-MM-dd") || returnDateStr.equals("yyyy-MM-dd")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ Ngày nhận xe và Ngày trả xe.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            listCar.clear();
            displayCarList(listCar);
            return;
        }

        // Parse date strings to java.sql.Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date pickupDate = null;
        Date returnDate = null;

        try {
            java.util.Date utilPickupDate = sdf.parse(pickupDateStr);
            java.util.Date utilReturnDate = sdf.parse(returnDateStr);
            pickupDate = new java.sql.Date(utilPickupDate.getTime());
            returnDate = new java.sql.Date(utilReturnDate.getTime());

            // Optional: Add a check to ensure return date is after pickup date
            if (returnDate.before(pickupDate)) {
                JOptionPane.showMessageDialog(this, "Ngày trả xe phải sau Ngày nhận xe.", "Lỗi ngày tháng", JOptionPane.WARNING_MESSAGE);
                listCar.clear();
                displayCarList(listCar);
                return;
            }

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Định dạng ngày tháng không hợp lệ. Vui lòng sử dụng định dạng yyyy-MM-dd.", "Lỗi định dạng", JOptionPane.WARNING_MESSAGE);
            listCar.clear();
            displayCarList(listCar);
            return;
        }

        listCar = carDAO.searchCar(pickupDate, returnDate);

        if (!carType.isEmpty()) {
            ArrayList<Car> filteredList = new ArrayList<>();
            for (Car car : listCar) {
                // Assuming Car model has getCarLine() or getType() for filtering
                if (car.getCarLine() != null && car.getCarLine().toLowerCase().contains(carType.toLowerCase())) {
                    filteredList.add(car);
                }
                // Or filter by type:
                // if (car.getType() != null && car.getType().toLowerCase().contains(carType.toLowerCase())) {
                //    filteredList.add(car);
                // }
            }
            listCar = filteredList; // Use the filtered list
        }

        displayCarList(listCar);
        
        // Clear selected cars when performing a new search
        selectedCars.clear();

        if (listCar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy xe trống nào phù hợp.", "Kết quả tìm kiếm", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        
        // Check if any cars are selected
        if (selectedCars.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ít nhất một xe trước khi tiếp tục.",
                    "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Get the pickup and return dates
        String pickupDateStr = txtCarPickUpDate.getText().trim();
        String returnDateStr = txtCarReturnDate.getText().trim();

        if (pickupDateStr.isEmpty() || returnDateStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày nhận và trả xe.",
                    "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date pickupDate = sdf.parse(pickupDateStr);
            java.util.Date returnDate = sdf.parse(returnDateStr);

            // Create and show the ContractFrm with selected client, cars, and dates
            ContractFrm contractFrm = new ContractFrm(
                    selectedClient,
                    selectedCars,
                    new java.sql.Date(pickupDate.getTime()),
                    new java.sql.Date(returnDate.getTime()),
                    loggedInAgent
            );
            contractFrm.setVisible(true);
            this.dispose(); // Close the current form

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Định dạng ngày tháng không hợp lệ.",
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void bthSearchCarPartnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthSearchCarPartnerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bthSearchCarPartnerActionPerformed

    private void tblListCarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListCarMouseClicked
        int selectedRow = tblListCar.getSelectedRow();
        if (selectedRow != -1) {
            // Get car ID from the selected row
            int carId = Integer.parseInt(tblListCar.getValueAt(selectedRow, 0).toString());
            
            // Find the car in the list
            Car selectedCar = null;
            for (Car car : listCar) {
                if (car.getId() == carId) {
                    selectedCar = car;
                    break;
                }
            }
            
            if (selectedCar != null) {
                // Check if the car is already selected
                boolean isAlreadySelected = false;
                for (Car car : selectedCars) {
                    if (car.getId() == carId) {
                        // Remove from selection if already selected (toggle selection)
                        selectedCars.remove(car);
                        isAlreadySelected = true;
                        break;
                    }
                }
                
                if (!isAlreadySelected) {
                    // Add to selection if not already selected
                    selectedCars.add(selectedCar);
                }
                
                // Cập nhật bảng để hiển thị trạng thái đã chọn mới
                displayCarList(listCar);
                
                // Optional: print selected cars for debugging
                System.out.println("Những xe đã chọn hiện tại:");
                for (Car car : selectedCars) {
                    System.out.println("- " + car.getId() + ": " + car.getName());
                }
            }
        }
    }//GEN-LAST:event_tblListCarMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchCarFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new SearchCarFrm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bthSearchCarPartner;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClientInfo;
    private javax.swing.JTable tblListCar;
    private javax.swing.JTextField txtCarPickUpDate;
    private javax.swing.JTextField txtCarReturnDate;
    private javax.swing.JTextField txtTypeCar;
    // End of variables declaration//GEN-END:variables
}
