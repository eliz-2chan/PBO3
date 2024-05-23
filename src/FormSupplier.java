import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.sql.SQLException;
import javax.swing.table.TableRowSorter;

import com.stripbandunk.jwidget.JPagination;
import com.stripbandunk.jwidget.model.DefaultPaginationModel;


// Main Form

public class FormSupplier extends JFrame{
//    Main Panel
    private JPanel mainPanel;
    private JTextField searchTextField;
    private JButton searchButton;
    private JTable viewTable;
    private JButton addButton;
    private JButton resetButton;
    private JButton deleteButton;
    private JButton updateButton;

//  Popup Menu
    private JPopupMenu popupMenu;
    private JMenuItem editMenuItem;
    private JMenuItem deleteMenuItem;

//  Filter and Pagination
    private JPagination Halaman;
    private JButton btntampil;
    private JComboBox cbtampil;
    private JComboBox cbkol;
    private JButton btndesc;
    private JButton btnasc;
    private DefaultPaginationModel paginationModel;


//    Not used
//    '''''
    private DefaultTableModel tb = new DefaultTableModel();
//    ^^^^^


    int baris;
    int kol;

//    Order Properties
    String order;
    String ascdes;


    public FormSupplier(){
        ascdes = " ASC";

//        No need to set model Data from here, set from InitTable
//        If set from here, the application wont work correctly
//        viewTable.setModel(tb);

//        Calling the Method to init the Event Listener
        searchSupplier();
        deleteSupplier();
        updateSupplier();
        addSupplier();

//        Reset Button
        resetButton.addActionListener(e -> {
            initTable();
        });

//        Window Listener
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                super.windowActivated(e);
                initTable();
            }
        });

//        Initialize Table and Form
        initTable();
        init();
    }

//    Init Form
    public void init(){
        setContentPane(mainPanel);
        setTitle("Data Supplier");
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

//    Add Button Event Listener
    public void addSupplier(){
        addButton.addActionListener(e -> {
//            Show AddSupplierForm inputFrame
            AddSupplierForm inputFrame = new AddSupplierForm();
            inputFrame.setVisible(true);
        });
    }

//    Search event Listener
    public void searchSupplier()
    {
        searchButton.addActionListener(e -> {
            initTable();
        });
    }

//    Delete Button Event Listener
    public void deleteSupplier()
    {
        deleteButton.addActionListener(e->{
            int selectedRow = viewTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(this, "Mohon pilih salah satu Data untuk Hapus!", "Warning!", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int option = JOptionPane.showConfirmDialog(FormSupplier.this, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                DefaultTableModel model = (DefaultTableModel) viewTable.getModel();
                int modelRow = viewTable.convertRowIndexToModel(selectedRow);
                String id = model.getValueAt(modelRow, 0).toString();
                try {
                    boolean deleted = DatabaseManager.Del(id);
                    if (deleted) {
                        model.removeRow(modelRow);
                        JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
                        initTable();
                    } else {
                        JOptionPane.showMessageDialog(this, "Gagal menghapus data.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

//    Update Button Event Listener
    public void updateSupplier(){
        updateButton.addActionListener(e -> {
            int chosenRow = viewTable.getSelectedRow();
            System.out.println(chosenRow);
            if(chosenRow<0){
                JOptionPane.showMessageDialog(null,
                        "Mohon pilih salah satu Data untuk diupdate!","Warning!",JOptionPane.WARNING_MESSAGE);
                return;
            }

            int modelRow = viewTable.convertRowIndexToModel(chosenRow);

            TableModel tm = viewTable.getModel();

            Global.id = tm.getValueAt(modelRow, 0).toString();
            String nama = tm.getValueAt(modelRow, 1).toString();
            String alamat = tm.getValueAt(modelRow, 2).toString();
            String telp = tm.getValueAt(modelRow, 3).toString();

            UpdateSupplierForm updateFrame = new UpdateSupplierForm(nama,alamat,telp);
            updateFrame.setId(Global.id);
            updateFrame.setVisible(true);
        });
    }

// Init Components and Listener for Pagination and Popup Menu
    public void initComponents(){
        createPopupMenu();

//      viewTable Mouse Listener
        viewTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });

//        Pagination Event Listener
        Halaman.addPaginationListener(new com.stripbandunk.jwidget.listener.PaginationListener() {
              public void onPageChange(com.stripbandunk.jwidget.event.PaginationEvent evt) {
                  HalamanOnPageChange(evt);
              }
        });

//      Total Row Action Listener
        btntampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntampilActionPerformed(evt);
            }
        });

//      Button Desc Action Listener
        btnasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnascActionPerformed(evt);
            }
        });

//        Button Desc Action Listener
        btndesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndescActionPerformed(evt);
            }
        });
    }

//    Init Table and Fill it with Data
    public void initTable(){
        try {
//            Init Default Table Model
            String[] header = {"Id", "Nama", "Alamat", "Telp"};
            DefaultTableModel dtm = new DefaultTableModel(header, 0) {
                public boolean isCellEditable(int row, int column) {
                    return false; // All cells non-editable
                }
            };
//            Setting the viewTable with model Table
            viewTable.setModel(dtm);
            viewTable.getColumnModel().getColumn(0).setMaxWidth(64);
            viewTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            dtm.addTableModelListener(e -> {
                viewTable.revalidate();
                viewTable.repaint();
            });

            String tampil = (String) cbtampil.getSelectedItem();
            String f = (String) cbkol.getSelectedItem();
            if (f == "Waktu Pembuatan"){
                f = "id";
            }
            order = " ORDER BY " + f + ascdes ;
            Global.sql="Select * FROM r_supplier WHERE id <> '' ";
            emptyTable(dtm);
            String cari = searchTextField.getText();
            String sql = Global.sql;
            if (!cari.isEmpty()) {
                sql = sql + " AND id like '%" + cari + "%' ";
                sql = sql + " OR nama like '%" + cari + "%' ";
                sql = sql + " OR alamat like '%" + cari + "%' ";
                sql = sql + " OR telp like '%" + cari + "%' ";
            }

//            Query Print for Checking
//            System.out.println(sql);

            Global.sql = sql + order;

            paginationModel = new DefaultPaginationModel();

            //Count Total Row
            paginationModel.setTotalItem(Global.JmlRec(Global.sql));

            //Setting Row for one page
            int n = Integer.parseInt(tampil);
            paginationModel.setPageSize(n);
            Halaman.setModel(paginationModel);
            sql = Global.sql + " limit " + n;

//            Read Data
            DatabaseManager.baca_data(dtm,sql);

//            Checking sql Query
//            System.out.println(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    Empty Table Method
    private void emptyTable(DefaultTableModel dtm){
        int rowCount = dtm.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
    }


//    Table on right click mouse Event to show Popup Menu
    private void TableMouseClicked(java.awt.event.MouseEvent evt) {
        int row = viewTable.rowAtPoint(evt.getPoint());
        if (evt.getButton() == MouseEvent.BUTTON3 && row != -1) {
            viewTable.setRowSelectionInterval(row, row);
            popupMenu.show(viewTable, evt.getX(), evt.getY());
        }
    }

    // Create Popup Menu
    public void createPopupMenu() {
        popupMenu = new JPopupMenu();
        editMenuItem = new JMenuItem("Update");
        deleteMenuItem = new JMenuItem("Delete");

//      Edit menu Popup Action Listener
        editMenuItem.addActionListener(e -> {
            int selectedRow = viewTable.getSelectedRow();
            if (selectedRow != -1) {
                int chosenRow = viewTable.getSelectedRow();
                if(chosenRow<0){
                    JOptionPane.showMessageDialog(null,
                            "Mohon pilih salah satu Data untuk diupdate!","Warning!",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int modelRow = viewTable.convertRowIndexToModel(chosenRow);

                TableModel tm = viewTable.getModel();
                Global.id = tm.getValueAt(modelRow, 0).toString();
                String nama = tm.getValueAt(modelRow, 1).toString();
                String alamat = tm.getValueAt(modelRow, 2).toString();
                String telp = tm.getValueAt(modelRow, 3).toString();

                UpdateSupplierForm updateFrame = new UpdateSupplierForm(nama,alamat,telp);
                updateFrame.setId(Global.id);
                updateFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Mohon pilih salah satu Data untuk diupdate!", "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        });

//      Delete Menu popup Action Listener
        deleteMenuItem.addActionListener(e -> {
            int selectedRow = viewTable.getSelectedRow();
            if (selectedRow != -1) {
                if (selectedRow < 0) {
                    JOptionPane.showMessageDialog(this, "Mohon pilih salah satu Data untuk Hapus!", "Warning!", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int option = JOptionPane.showConfirmDialog(FormSupplier.this, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    DefaultTableModel model = (DefaultTableModel) viewTable.getModel();
                    int modelRow = viewTable.convertRowIndexToModel(selectedRow);
                    String id = model.getValueAt(modelRow, 0).toString();
                    try {
                        boolean deleted = DatabaseManager.Del(id);
                        if (deleted) {
                            model.removeRow(modelRow);
                            JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
                        } else {
                            JOptionPane.showMessageDialog(this, "Gagal menghapus data.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        popupMenu.add(editMenuItem);
        popupMenu.add(deleteMenuItem);
    }


//    Pagination Event Listener
    private void HalamanOnPageChange(com.stripbandunk.jwidget.event.PaginationEvent evt) {
        DefaultTableModel dtm = (DefaultTableModel) viewTable.getModel();
        // Set Limit Query DB
        int limit = (evt.getCurrentPage() - 1) * evt.getPageSize();

        // Query Example
        String sql = Global.sql + " Limit " + limit + ", " + evt.getPageSize();
        System.out.println(sql);

        try {
            emptyTable(dtm);
            DatabaseManager.baca_data(dtm,sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

//    Total Row Method on Click
    private void btntampilActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            initTable();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

//    Ascending Method on Click
    private void btnascActionPerformed(java.awt.event.ActionEvent evt)
    {
        ascdes = " ASC";
        try {
            initTable();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
//    Descending Method on Click
    private void btndescActionPerformed(java.awt.event.ActionEvent evt)
    {
        ascdes = " DESC";
        try {
            initTable();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
