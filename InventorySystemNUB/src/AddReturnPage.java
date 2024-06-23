/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jiand
 */
public class AddReturnPage extends javax.swing.JFrame {
    private static final String dbUsername = "root";
    private static final String dbPassword = "";
    private static final String dataConn = "jdbc:mysql://localhost/equipmentinventorynubdb";
    private static final String dbname = "itemlist";
    private static final String dbname02 = "reservation";
    private static final String dbname03 = "itemlist_audit";
    private Connection sqlConn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private int q, i, id, deleteItem;
    private int rowIndex;

    /**
     * Creates new form AddReturnPage
     */
    public AddReturnPage() {
        initComponents();
        connectToDatabase();
        setResizable(false);
        // Add a list selection listener to the table
        ItemTab.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Get the selected row index
                    int rowIndex = ItemTab.getSelectedRow();
                    if (rowIndex != -1) { // Check if a row is selected
                        // Retrieve the data from the selected row
                        DefaultTableModel model = (DefaultTableModel) ItemTab.getModel();
                        String item = model.getValueAt(rowIndex, 1).toString();
                        String stock = model.getValueAt(rowIndex, 2).toString();
                        
                        // Display the data in the text fields
                        stock1.setText(stock);
                        item1.setText(item);
                    }
                }
            }
        });

        // Display table data
        displayUserData();
        displayReservationData();
        
    }

    private void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error initializing database connection: " + ex.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dataConn, dbUsername, dbPassword);
    }

    public void displayUserData() {
     try (Connection sqlConn = getConnection()) {
            PreparedStatement pst = sqlConn.prepareStatement("SELECT * FROM " + dbname);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            int q = stData.getColumnCount();

            DefaultTableModel dt = (DefaultTableModel) ItemTab.getModel();
            dt.setRowCount(0);

            while (rs.next()) {
                Vector<Object> columnData = new Vector<>();

                for (int i = 1; i <= q; i++) {
                    columnData.add(rs.getObject(i)); // Add each column to the vector
                }
                dt.addRow(columnData); // Add the vector as a row to the table model
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error displaying data: " + ex.getMessage());
        }
    }
    
    public void displayReservationData() {
     try (Connection sqlConn = getConnection()) {
            PreparedStatement pst = sqlConn.prepareStatement("SELECT * FROM " + dbname02);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            int q = stData.getColumnCount();

            DefaultTableModel dt = (DefaultTableModel) TransactionTab.getModel();
            dt.setRowCount(0);

            while (rs.next()) {
                Vector<Object> columnData = new Vector<>();

                for (int i = 1; i <= q; i++) {
                    columnData.add(rs.getObject(i)); // Add each column to the vector
                }
                dt.addRow(columnData); // Add the vector as a row to the table model
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error displaying data: " + ex.getMessage());
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Update = new javax.swing.JButton();
        HomePage = new javax.swing.JButton();
        AddReturn = new javax.swing.JButton();
        Delete1 = new javax.swing.JButton();
        stock1 = new javax.swing.JTextField();
        item1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TransactionTab = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ItemTab = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        HomePage1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/NUB LOGO.png"))); // NOI18N
        jLabel9.setText("jLabel8");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 87, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NATIONAL UNIVERSITY ( ITEM INVENTORY PAGE )");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, 46));

        Update.setBackground(new java.awt.Color(255, 204, 51));
        Update.setText("Update Item Name/Stock");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        jPanel1.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 170, 37));

        HomePage.setBackground(new java.awt.Color(255, 204, 51));
        HomePage.setText("View Item Inventory Activities");
        HomePage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomePageActionPerformed(evt);
            }
        });
        jPanel1.add(HomePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 510, 200, 37));

        AddReturn.setBackground(new java.awt.Color(255, 204, 51));
        AddReturn.setText("Add New Item");
        AddReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddReturnActionPerformed(evt);
            }
        });
        jPanel1.add(AddReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 120, 37));

        Delete1.setBackground(new java.awt.Color(255, 204, 51));
        Delete1.setText("Delete Item");
        Delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete1ActionPerformed(evt);
            }
        });
        jPanel1.add(Delete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 130, 37));
        jPanel1.add(stock1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 260, -1));
        jPanel1.add(item1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 260, -1));

        TransactionTab.setBackground(new java.awt.Color(255, 204, 51));
        TransactionTab.setForeground(new java.awt.Color(0, 51, 51));
        TransactionTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Reservation ID", "Course Code", "Section", "Date", "Time", "Instructor ", "Item ID", "Item Name", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TransactionTab);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 750, 150));

        jLabel11.setText("Currently Reserved Items");
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 220, -1));

        ItemTab.setBackground(new java.awt.Color(255, 204, 51));
        ItemTab.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ItemTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Item ID", "Item Name", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(ItemTab);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 470, 170));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Item Name");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Stock of Item");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Item List");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, -1, -1));

        HomePage1.setBackground(new java.awt.Color(255, 204, 51));
        HomePage1.setText("Back to Menu");
        HomePage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomePage1ActionPerformed(evt);
            }
        });
        jPanel1.add(HomePage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, 110, 37));

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomePageActionPerformed
        // TODO add your handling code here:
            this.dispose(); // Close current frame
    new ItemInventoryRecords().setVisible(true); // Open the FirstFrame
    }//GEN-LAST:event_HomePageActionPerformed

    private void AddReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddReturnActionPerformed
         try (Connection sqlConn = getConnection()) {
        String item = item1.getText().trim();
        String stock = stock1.getText().trim();
        
        // Input validation
        if (item.isEmpty() || stock.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        // Check if item already exists
        if (itemExists(sqlConn, item)) {
            JOptionPane.showMessageDialog(this, "Item already exists. Please choose a different one.");
            return;
        }

        // Generate custom ID
        String customId = ItemManager.generateItemId(sqlConn);

        // Insert item into itemlist table
        try (PreparedStatement pst = sqlConn.prepareStatement("INSERT INTO itemlist (custom_id, item, stock) VALUES (?, ?, ?)")) {
            pst.setString(1, customId);
            pst.setString(2, item);
            pst.setInt(3, Integer.parseInt(stock));
            pst.executeUpdate();
        }

        // Log the action in the audit table
        try (PreparedStatement pstAudit = sqlConn.prepareStatement("INSERT INTO itemlist_audit (custom_id, item, stock, action) VALUES (?, ?, ?, ?)")) {
            pstAudit.setString(1, customId);
            pstAudit.setString(2, item);
            pstAudit.setInt(3, Integer.parseInt(stock));
            pstAudit.setString(4, "ADD");
            pstAudit.executeUpdate();
        }

        JOptionPane.showMessageDialog(this, "Item Added! Custom ID: " + customId);
        item1.setText("");
        stock1.setText("");
        displayUserData(); // Refresh UI
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage());
        ex.printStackTrace();
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Please enter a valid number for stock.");
    }
    }//GEN-LAST:event_AddReturnActionPerformed
private boolean itemExists(Connection sqlConn, String item) throws SQLException {
        PreparedStatement pst = sqlConn.prepareStatement("SELECT * FROM itemlist WHERE item = ?");
        pst.setString(1, item);
        ResultSet rs = pst.executeQuery();
        return rs.next();
    }
    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        int rowIndex = ItemTab.getSelectedRow();

if (rowIndex != -1) { // Check if a row is selected
    try (Connection sqlConn = getConnection()) {
        DefaultTableModel model = (DefaultTableModel) ItemTab.getModel();
        String customId = model.getValueAt(rowIndex, 0).toString(); // Get custom_id as a string

        String item = item1.getText().trim();
        String stock = stock1.getText().trim();

        // Validate stock input
        int stockValue;
        try {
            stockValue = Integer.parseInt(stock);
            if (stockValue < 0) {
                JOptionPane.showMessageDialog(this, "Stock value cannot be negative.");
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid stock value.");
            return;
        }

        // Update the item in itemlist table
        PreparedStatement pst = sqlConn.prepareStatement("UPDATE itemlist SET item=?, stock=? WHERE custom_id=?");
        pst.setString(1, item);
        pst.setInt(2, stockValue);
        pst.setString(3, customId);
        pst.executeUpdate();

        // Insert into itemlist_audit table
        try (PreparedStatement pstAudit = sqlConn.prepareStatement("INSERT INTO itemlist_audit (custom_id, item, stock, action) VALUES (?, ?, ?, ?)")) {
            pstAudit.setString(1, customId);
            pstAudit.setString(2, item);
            pstAudit.setInt(3, stockValue);
            pstAudit.setString(4, "UPDATE");
            pstAudit.executeUpdate();
        }

        // Update the table model
        model.setValueAt(item, rowIndex, 1); // Assuming item is the second column
        model.setValueAt(stock, rowIndex, 2); // Assuming stock is the third column

        JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
        item1.setText("");
        stock1.setText("");
        displayUserData();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error updating data: " + ex.getMessage());
        ex.printStackTrace();
    }
} else {
    JOptionPane.showMessageDialog(null, "Please select a row from the Item List first.");
}

  
    }//GEN-LAST:event_UpdateActionPerformed

    private void Delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete1ActionPerformed
        try (Connection sqlConn = getConnection()) {
        String item = item1.getText().trim();

        if (item.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the item to delete.");
            return; // Exit the method if the item field is empty
        }

        // Check if the item exists
        if (!itemExists(sqlConn, item)) {
            JOptionPane.showMessageDialog(this, "Item does not exist.");
            return; // Exit the method if the item does not exist
        }

        // Fetch the custom_id and stock value before deletion
        String customId = "";
        int stock = 0;
        try (PreparedStatement pst = sqlConn.prepareStatement("SELECT custom_id, stock FROM itemlist WHERE item = ?")) {
            pst.setString(1, item);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    customId = rs.getString("custom_id");
                    stock = rs.getInt("stock");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to retrieve item details.");
                    return; // Exit if item details retrieval fails
                }
            }
        }

        // Delete the item from itemlist table
        try (PreparedStatement pst = sqlConn.prepareStatement("DELETE FROM itemlist WHERE item = ?")) {
            pst.setString(1, item);
            pst.executeUpdate();
        }

        // Log the action in the audit table
        try (PreparedStatement pstAudit = sqlConn.prepareStatement("INSERT INTO itemlist_audit (custom_id, item, stock, action) VALUES (?, ?, ?, ?)")) {
            pstAudit.setString(1, customId);
            pstAudit.setString(2, item);
            pstAudit.setInt(3, stock);
            pstAudit.setString(4, "DELETE");
            pstAudit.executeUpdate();
        }

        JOptionPane.showMessageDialog(this, "Item Deleted!");
      
        item1.setText("");
        stock1.setText("");
        displayUserData(); // Refresh UI
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        ex.printStackTrace();
    }
    }//GEN-LAST:event_Delete1ActionPerformed

    private void HomePage1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomePage1ActionPerformed
      this.dispose(); // Close current frame
    new FirstFrame().setVisible(true); // Open the FirstFrame
        
    }//GEN-LAST:event_HomePage1ActionPerformed

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
            java.util.logging.Logger.getLogger(AddReturnPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddReturnPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddReturnPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddReturnPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddReturnPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddReturn;
    private javax.swing.JButton Delete1;
    private javax.swing.JButton HomePage;
    private javax.swing.JButton HomePage1;
    private javax.swing.JTable ItemTab;
    private javax.swing.JTable TransactionTab;
    private javax.swing.JButton Update;
    private javax.swing.JTextField item1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField stock1;
    // End of variables declaration//GEN-END:variables
}
