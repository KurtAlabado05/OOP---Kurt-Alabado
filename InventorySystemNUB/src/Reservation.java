
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author jiand
 */
public class Reservation extends javax.swing.JFrame {
    //for database
    private static final String dbUsername = "root";
    private static final String dbPassword = "";
    private static final String dataConn = "jdbc:mysql://localhost/equipmentinventorynubdb";
    private static final String dbname = "itemlist";
    private static final String dbname02 = "reservation";
     private static final String dbname03 = "history";
    private Connection sqlConn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private int q, i, id, deleteItem;
    private int rowIndex;

    
    /**
     * Creates new form Reservation
     */
    public Reservation() {
        initComponents();
        connectToDatabase();
        
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
                        String itemid = model.getValueAt(rowIndex, 0).toString();
                        String item = model.getValueAt(rowIndex, 1).toString();
                        String stock = model.getValueAt(rowIndex, 2).toString();
                        
                        // Display the data in the text fields
                        
                        item1.setText(item);
                        id1.setText(itemid);
                    }
                }
            }
        }            
        
        );

        // Display user data
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

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        coursecode1 = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        section1 = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        name1 = new javax.swing.JTextPane();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TransactionTab = new javax.swing.JTable();
        Back = new javax.swing.JButton();
        Reserve = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ItemTab = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        datePicker1 = new com.github.lgooddatepicker.components.DatePicker();
        timePicker1 = new com.github.lgooddatepicker.components.TimePicker();
        item1 = new javax.swing.JLabel();
        id1 = new javax.swing.JLabel();
        stock1 = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        jLabel3.setText("NATIONAL UNIVERSITY ( RESERVATION PAGE )");
        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/NUB LOGO.png"))); // NOI18N
        jLabel9.setText("jLabel8");

        jLabel1.setText("1. Laboratory Course Code ( e.g. CEHYDR1L)");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setViewportView(coursecode1);

        jScrollPane4.setViewportView(section1);

        jLabel6.setText("2. Section");
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("3. Date of Activity/Experiment");
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("4. Time of the Activity/Experiment ");
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));

        jScrollPane7.setViewportView(name1);

        jLabel12.setText("5. Instructor's Name");
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));

        jLabel13.setText("6. Item and Quantity");
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));

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
        TransactionTab.setBackground(new java.awt.Color(255, 204, 51));
        TransactionTab.setForeground(new java.awt.Color(0, 51, 51));
        jScrollPane2.setViewportView(TransactionTab);

        Back.setText("Back to Menu");
        Back.setBackground(new java.awt.Color(255, 204, 51));
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        Reserve.setText("Reserve Item");
        Reserve.setBackground(new java.awt.Color(255, 204, 51));
        Reserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReserveActionPerformed(evt);
            }
        });

        Delete.setText("Return Item");
        Delete.setBackground(new java.awt.Color(255, 204, 51));
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        jLabel10.setText("Item List ");
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));

        ItemTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ItemTab.setBackground(new java.awt.Color(255, 204, 51));
        jScrollPane3.setViewportView(ItemTab);

        jLabel11.setText("Reservation Tab");
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));

        item1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        item1.setForeground(new java.awt.Color(255, 255, 255));
        item1.setText("from Item List");

        id1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        id1.setForeground(new java.awt.Color(255, 255, 255));
        id1.setText("Select");

        stock1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane4)
                            .addComponent(datePicker1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                            .addComponent(timePicker1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addComponent(jLabel13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(id1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(item1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stock1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Reserve, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(348, 348, 348))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Back)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(24, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(316, 316, 316))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(item1)
                            .addComponent(id1)
                            .addComponent(stock1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Reserve, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        this.dispose(); // Close current frame
    new FirstFrame().setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_BackActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
       int rowIndex = TransactionTab.getSelectedRow();

    if (rowIndex != -1) { // Check if a row is selected
        try (Connection sqlConn = getConnection()) {
            // Get the values of the selected reservation
            DefaultTableModel model = (DefaultTableModel) TransactionTab.getModel();
            String reservationId = model.getValueAt(rowIndex, 0).toString();
            String courseCode = model.getValueAt(rowIndex, 1).toString();
            String section = model.getValueAt(rowIndex, 2).toString();
            String date = model.getValueAt(rowIndex, 3).toString();
            String time = model.getValueAt(rowIndex, 4).toString();
            String instructor = model.getValueAt(rowIndex, 5).toString();
            String itemId = model.getValueAt(rowIndex, 6).toString();  // Assuming itemid is in the 7th column
            String itemName = model.getValueAt(rowIndex, 7).toString();
            String quantityStr = model.getValueAt(rowIndex, 8).toString();

            // Check if quantityStr is a valid integer
            if (!quantityStr.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Invalid quantity value: " + quantityStr);
                return;
            }

            int quantity = Integer.parseInt(quantityStr);

            // Fetch current stock value for the selected item using itemId
            PreparedStatement pst = sqlConn.prepareStatement("SELECT stock FROM itemlist WHERE custom_id = ?");
            pst.setString(1, itemId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int currentStock = rs.getInt("stock");

                // Update the stock value in the database
                int newStock = currentStock + quantity;
                pst = sqlConn.prepareStatement("UPDATE itemlist SET stock = ? WHERE custom_id = ?");
                pst.setInt(1, newStock);
                pst.setString(2, itemId);
                pst.executeUpdate();

                // Insert the reservation data into equipmentinventorynubdb
                try (Connection sqlConn03 = DriverManager.getConnection("jdbc:mysql://localhost:3306/equipmentinventorynubdb", "username", "password")) {
                    PreparedStatement pst03 = sqlConn03.prepareStatement(
                        "INSERT INTO history (coursecode, section, date, time, name, itemid, item, quantity) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
                    );
                    
                    pst03.setString(1, courseCode);
                    pst03.setString(2, section);
                    pst03.setString(3, date);
                    pst03.setString(4, time);
                    pst03.setString(5, instructor);
                    pst03.setString(6, itemId);
                    pst03.setString(7, itemName);
                    pst03.setInt(8, quantity);
                    pst03.executeUpdate();
                }

                // Remove the reservation from the database
                pst = sqlConn.prepareStatement("DELETE FROM reservation WHERE reservation_id = ?");
                pst.setString(1, reservationId);
                pst.executeUpdate();

                // Remove the item from the table model
                model.removeRow(rowIndex);

                JOptionPane.showMessageDialog(this, "Items Returned Successfully!");

                // Refresh the tables
                displayUserData();
                displayReservationData();
            } else {
                JOptionPane.showMessageDialog(this, "Item not found.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error deleting reservation: " + ex.getMessage());
            ex.printStackTrace();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error parsing quantity: " + ex.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row from the reservation tab first.");
    }
    }//GEN-LAST:event_DeleteActionPerformed

    private void ReserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReserveActionPerformed
         try (Connection sqlConn = getConnection()) {
        // Get input values from UI components
        String item = item1.getText().trim();
        int quanti = (Integer) stock1.getValue();  // Changed from JTextField to JSpinner
        String idStr = id1.getText().trim();
        String coursecode = coursecode1.getText().trim();
        String section = section1.getText().trim();
        String date = datePicker1.getText().trim();
        String time = timePicker1.getText().trim();
        String name = name1.getText().trim();

        // Validate inputs
        if (item.isEmpty() || coursecode.isEmpty() || section.isEmpty() || date.isEmpty() || time.isEmpty() || name.isEmpty() || idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return; // Exit the method if any field is empty
        }
        if (quanti <= 0) {
            JOptionPane.showMessageDialog(this, "Quantity must be greater than zero.");
            return; // Exit the method if quantity is zero or negative
        }

        // Fetch current stock value for the selected item
        try (PreparedStatement pst = sqlConn.prepareStatement("SELECT stock FROM itemlist WHERE custom_id = ?")) {
            pst.setString(1, idStr);  // Use itemid as a string
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int currentStock = rs.getInt("stock");

                    // Check if there is sufficient stock
                    if (currentStock < quanti) {
                        JOptionPane.showMessageDialog(this, "Insufficient stock available.");
                        return; // Exit the method if there is insufficient stock
                    }

                    // Update stock after reservation
                    int newStock = currentStock - quanti;
                    try (PreparedStatement updatePst = sqlConn.prepareStatement("UPDATE itemlist SET stock = ? WHERE custom_id = ?")) {
                        updatePst.setInt(1, newStock);
                        updatePst.setString(2, idStr);  // Use itemid as a string
                        updatePst.executeUpdate();
                    }

                    // Generate reservation ID
                    String reservationId = ItemManager.generateReservationId(sqlConn);

                    // Insert reservation into database
                    try (PreparedStatement insertPst = sqlConn.prepareStatement("INSERT INTO reservation (reservation_id, coursecode, section, date, time, name, itemid, item, quantity) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
                        insertPst.setString(1, reservationId);
                        insertPst.setString(2, coursecode);
                        insertPst.setString(3, section);
                        insertPst.setString(4, date);
                        insertPst.setString(5, time);
                        insertPst.setString(6, name);
                        insertPst.setString(7, idStr);  // Use itemid as a string
                        insertPst.setString(8, item);
                        insertPst.setInt(9, quanti);
                        insertPst.executeUpdate();
                    }

                    // Save the reservation to file
                    saveReservationToFile(new Object[]{reservationId, coursecode, section, date, time, name, idStr, item, quanti});

                    JOptionPane.showMessageDialog(this, "Reservation Added!");

                    // Ask if the user wants to add another reservation
                    int option = JOptionPane.showConfirmDialog(this, "Do you want to reserve another item for " + name + "?", "Add More", JOptionPane.YES_NO_OPTION);

                    if (option == JOptionPane.YES_OPTION) {
                        // Clear specific input fields
                        item1.setText("");
                        stock1.setValue(0);
                        id1.setText("");
                    } else {
                        // Reset to default input fields
                        item1.setText("From Item List");
                        id1.setText("Select");
                        name1.setText("");
                        coursecode1.setText("");
                        datePicker1.setText("");
                        timePicker1.setText("");
                        section1.setText("");
                        stock1.setValue(0);
                    }

                    // Refresh the tables
                    displayUserData();
                    displayReservationData();
                } else {
                    JOptionPane.showMessageDialog(this, "Item not found.");
                }
            }
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        ex.printStackTrace();
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Please enter a valid quantity.");
    }
    }//GEN-LAST:event_ReserveActionPerformed
    private void saveReservationToFile(Object[] reservation) {
    try (FileOutputStream fos = new FileOutputStream("reservations.ser", true);
         ObjectOutputStream oos = new ObjectOutputStream(fos)) {
        oos.writeObject(reservation);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

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
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Delete;
    private javax.swing.JTable ItemTab;
    private javax.swing.JButton Reserve;
    private javax.swing.JTable TransactionTab;
    private javax.swing.JTextPane coursecode1;
    private com.github.lgooddatepicker.components.DatePicker datePicker1;
    private javax.swing.JLabel id1;
    private javax.swing.JLabel item1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextPane name1;
    private javax.swing.JTextPane section1;
    private javax.swing.JSpinner stock1;
    private com.github.lgooddatepicker.components.TimePicker timePicker1;
    // End of variables declaration//GEN-END:variables
}
