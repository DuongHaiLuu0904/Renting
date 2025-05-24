package view.car;

import dao.ClientDAO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

import model.Client;
import model.RentalAgent;

public class SearchClientFrm extends javax.swing.JFrame {

    private final ClientDAO clientDAO;

    private ArrayList<Client> listClient;

    private Client selectedClient;
    
    private RentalAgent loggedInAgent;
    
    public SearchClientFrm() {
        initComponents();
        clientDAO = new ClientDAO();
        listClient = new ArrayList<>();
        this.loggedInAgent = null;
        displayClientList(listClient);
    }

    public SearchClientFrm(RentalAgent loggedInAgent) {
        initComponents();
        
        clientDAO = new ClientDAO();
        listClient = new ArrayList<>();
        this.loggedInAgent = loggedInAgent;
        
        displayClientList(listClient);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListClient = new javax.swing.JTable();
        btnNext = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Search Client View");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Tìm kiếm Khách hàng ");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblListClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID ", "Name", "CCCD", "Address", "PhoneNumber", "Email", "Note"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListClientMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListClient);

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        jLabel2.setText("OR");

        btnAdd.setText("Add Client");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel3.setText("Nhập tên: ");

        jLabel4.setText("Nhập CCCD:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(46, 46, 46)
                .addComponent(btnNext)
                .addGap(86, 86, 86))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtName)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(btnSearch)
                                .addGap(16, 16, 16)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(jLabel2)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnAdd))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String nameKey = txtName.getText().trim();
        String cccdKey = txtCCCD.getText().trim();

        if (nameKey.isEmpty() && cccdKey.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên hoặc CCCD để tìm kiếm.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            listClient.clear();
            displayClientList(listClient);
            return;
        }

        String searchKey = nameKey.isEmpty() ? cccdKey : nameKey;

        listClient = clientDAO.searchClient(searchKey);

        displayClientList(listClient);

        if (listClient.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng nào.", "Kết quả tìm kiếm", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (selectedClient != null) {
            System.out.println("Proceeding with selected Client: " + selectedClient.toString());

            try {
                SearchCarFrm searchCarFrm = new SearchCarFrm(selectedClient, loggedInAgent);
                searchCarFrm.setVisible(true);
                this.dispose();
            } catch (Exception e) {
                System.err.println("Error opening SearchCarFrm:");
                JOptionPane.showMessageDialog(this, "Không thể mở giao diện tìm kiếm xe.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }

            System.out.println("TODO: Open SearchCarFrm and pass selected Client.");

        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một khách hàng từ bảng trước khi tiếp tục.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void tblListClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListClientMouseClicked
        int selectedRow = tblListClient.getSelectedRow();
        if (selectedRow >= 0 && selectedRow < listClient.size()) {
            selectedClient = listClient.get(selectedRow);

            System.out.println("Client selected: " + selectedClient.toString());
        } else {
            selectedClient = null;
        }
    }//GEN-LAST:event_tblListClientMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        new AddClientFrm(loggedInAgent).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAddActionPerformed

    private void displayClientList(ArrayList<Client> clients) {
        String[] columnNames = {"ID", "Name", "CCCD", "Address", "PhoneNumber", "Email", "Note"};

        String[][] data = new String[clients.size()][columnNames.length];

        for (int i = 0; i < clients.size(); i++) {
            Client client = clients.get(i);
            data[i][0] = String.valueOf(client.getId()); 
            data[i][1] = client.getName();
            data[i][2] = client.getCccd();
            data[i][3] = client.getAddress();
            data[i][4] = client.getPhoneNumber();
            data[i][5] = client.getEmail();
            data[i][6] = client.getNote();
        }

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblListClient.setModel(tableModel);
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
            java.util.logging.Logger.getLogger(SearchClientFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new SearchClientFrm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListClient;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
